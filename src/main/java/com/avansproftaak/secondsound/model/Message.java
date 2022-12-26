package com.avansproftaak.secondsound.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Getter
@Setter
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long chatId;

    @NotNull
    private String message;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(nullable = true)
    private User receiver;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Message(Long chatId,String message, User sender, User receiver) {
        this.chatId = chatId;
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
    }
}
