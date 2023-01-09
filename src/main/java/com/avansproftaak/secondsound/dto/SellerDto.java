package com.avansproftaak.secondsound.dto;

import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class SellerDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String phoneNumber;
    private String email;
    private List<AdvertisementDto> advertisements;
}
