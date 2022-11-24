package com.avansproftaak.secondsound.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class AdvertisementProperty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String propertyName;
    private String propertyValue;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Advertisement advertisement;
}
