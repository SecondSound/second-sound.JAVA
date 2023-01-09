package com.avansproftaak.secondsound.service;

import com.avansproftaak.secondsound.dto.AdvertisementData;
import com.avansproftaak.secondsound.dto.AdvertisementDto;
import com.avansproftaak.secondsound.model.Advertisement;
import com.avansproftaak.secondsound.model.User;
import com.avansproftaak.secondsound.repository.AdvertisementRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AdvertisementServiceTest {

    @Autowired
    AdvertisementService sut;

    @Autowired
    UserService userService;

    @Autowired
    AdvertisementRepository advertisementRepository;

    private AdvertisementData advertisement;

    @BeforeEach
    void setUp() {
        Authentication authentication = Mockito.mock(Authentication.class);
        when(authentication.getPrincipal()).thenReturn("john.doe@gmail.com");
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);

        advertisement = new AdvertisementData(
                "Gretsch G5422TG Guitar",
                "Beautiful Gretsch guitar in Walnut Stain color.",
                "450",
                46,
                true
        );
    }

    @AfterEach
    void tearDown() {
        advertisementRepository.delete(advertisementRepository.getReferenceById(12L));
    }

    @Test
    void add_advertisement_creates_new_advertisement() {
        AdvertisementDto advertisementDto = sut.addAdvertisement(advertisement);

        assertNotNull(advertisementDto);
        assertEquals(advertisement.getTitle(), advertisementDto.getTitle());
    }

    @Test
    void add_advertisement_incorrect_sub_category_throws_exception() {
        advertisement.setSubCategoryId(999);

        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> sut.addAdvertisement(advertisement));
        assertTrue(Objects.requireNonNull(exception.getMessage()).contains("Subcategory unknown"));
    }

    @Test
    void add_advertisement_adds_authenticated_user_as_seller() {
        sut.addAdvertisement(advertisement);

        List<AdvertisementDto> advertisementsByUser = sut.getAllAdvertisementsUser();
        assertTrue(advertisementsByUser.stream().anyMatch(o -> advertisement.getTitle().equals(o.getTitle())));
    }

    @Test
    void save_advertisement_adds_ad_to_user_saved_advertisements() {
        Advertisement ad = advertisementRepository.getReferenceById(1L);
        User user = userService.getAuthenticatedUser();

        assertTrue(sut.addSavedAdvertisement(ad, user));
    }

}
