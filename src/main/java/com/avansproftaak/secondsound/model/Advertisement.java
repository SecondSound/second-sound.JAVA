package com.avansproftaak.secondsound.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(nullable = false)
    private SubCategory subCategory;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    boolean isActive = false;

    public Advertisement(String title, String description, BigDecimal price, SubCategory subCategory, User user, boolean isActive) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.user = user;
        this.subCategory = subCategory;
        this.isActive = isActive;
    }

    public Advertisement(String title, String description, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

}
