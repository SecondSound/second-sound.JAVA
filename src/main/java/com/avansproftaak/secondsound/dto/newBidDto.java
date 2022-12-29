package com.avansproftaak.secondsound.dto;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class newBidDto {

    private Long userId;
    private String amount;
    private Long advertisementId;

}