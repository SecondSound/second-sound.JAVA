package com.avansproftaak.secondsound.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Advertisement advertisement;

    @OneToOne
    @JoinColumn(nullable = true)
    private User sender;

    @OneToOne
    @JoinColumn(nullable = true)
    private User receiver;

//    @OneToMany
//    @JoinColumn(nullable = false)
//    private List<Message> message;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Chat(Advertisement advertisement, User sender, User receiver) {
        this.advertisement = advertisement;
        this.sender = sender;
        this.receiver = receiver;
    }


}