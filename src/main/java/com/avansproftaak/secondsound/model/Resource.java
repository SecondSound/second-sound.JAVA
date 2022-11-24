package com.avansproftaak.secondsound.model;

import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filePath;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Advertisement advertisement;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(nullable = false)
    private SubCategory subCategory;
}
