package com.avansproftaak.secondsound.service;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.dto.SellerDto;
import com.avansproftaak.secondsound.dto.UserDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.ConfirmationToken;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.*;
import com.avansproftaak.secondsound.validation.EmailValidator;
import com.avansproftaak.secondsound.validation.UserValidator;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ResourceRepository resourceRepository;
    private final AdvertisementRepository advertisementRepository;
    private final SubCategoryRepository subCategoryRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    private final ModelMapper modelMapper;
    private final EmailValidator emailValidator;
    private final UserValidator userValidator;

    private final RatingService ratingService;

    @Override
    public UserDetails loadUserByUsername(String email) throws ResponseStatusException {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "User with e-mail address " + email +
                        " could not be found."));
    }

    public UUID registerUser(User user) {
        boolean userExists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (userExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists.");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        // Create confirmation token
        UUID token = UUID.randomUUID();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(60),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public void enableUser(String email) {
        userRepository.enableUser(email);
    }

    public User getAuthenticatedUser() {
        String email = SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal().toString();

        return userRepository.findByEmail(email).stream().findFirst().orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with e-mail address " + email +
                        " could not be found."));
    }

    public UserDto updateUser(User user, User updatedUser) {
        String email = updatedUser.getEmail();
        boolean isValidEmail = emailValidator.test(email);

        if (!isValidEmail) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "E-mail adres " + email + " is invalid.");
        }

        String firstName = updatedUser.getFirstName();
        String lastName = updatedUser.getLastName();
        String street = updatedUser.getStreet();
        String houseNumber = updatedUser.getHouseNumber();
        String city = updatedUser.getCity();
        String country = updatedUser.getCountry();
        String phoneNumber = updatedUser.getPhoneNumber();
        String iban = updatedUser.getIban();
        String postalCode = updatedUser.getPostalCode();

        if (firstName.isEmpty() || lastName.isEmpty() || street.isEmpty() || houseNumber.isEmpty() || city.isEmpty() ||
                country.isEmpty() || phoneNumber.isEmpty() || email.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please fill out all required fields.");
        }

        userValidator.validateUser(firstName, lastName, street, houseNumber, city, country, phoneNumber, iban);
        String anonimyzedIban = anonimyzeIban(iban);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setStreet(street);
        user.setHouseNumber(houseNumber);
        user.setCity(city);
        user.setCountry(country);
        user.setPhoneNumber(phoneNumber);
        user.setIban(anonimyzedIban);
        user.setEmail(email);
        user.setPostalCode(postalCode);

        return modelMapper.map(userRepository.save(user), UserDto.class);
    }

    public UserDto getUser() {
        return modelMapper.map(getAuthenticatedUser(), UserDto.class);
    }

    public SellerDto getSellerOrBidder(Long sellerId) {

        var user = userRepository.findById(sellerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User unknown"));
        boolean isActive = true;
        var activeAdvertisements = advertisementRepository.findAllBySellerId(sellerId, isActive);
        ArrayList<AdvertisementDto> activeAdvertisementDtoList = new ArrayList<>();

        for (Advertisement advertisement : activeAdvertisements) {

            var subcategory = subCategoryRepository.findById(advertisement.getSubCategory().getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subcategory unknown"));

            var advertisementDto = new AdvertisementDto(
                    advertisement.getId(),
                    advertisement.getTitle(),
                    advertisement.getDescription(),
                    advertisement.getPrice(),
                    resourceRepository.findImagesByAdvertisementId(advertisement.getId()),
                    subcategory);

            activeAdvertisementDtoList.add(advertisementDto);
        }

        return new SellerDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getStreet(),
                user.getCity(),
                user.getPhoneNumber(),
                user.getEmail(),
                ratingService.getSellerRating(user),
                activeAdvertisementDtoList);
    }

    private String anonimyzeIban(String iban) {
        String start = iban.substring(0,4);
        String end = iban.substring(iban.length() - 2);

        return start + "***********" + end;
    }
}
