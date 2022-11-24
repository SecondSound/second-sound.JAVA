package com.avansproftaak.secondsound.model;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class PropertyValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Value;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Property property;
}
