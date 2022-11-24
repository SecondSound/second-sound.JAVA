package com.avansproftaak.secondsound.model;

import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User bidder;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Advertisement advertisement;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
