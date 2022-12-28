package com.avansproftaak.secondsound.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class BidDto {

    private Long id;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private SellerDto bidder;

}
