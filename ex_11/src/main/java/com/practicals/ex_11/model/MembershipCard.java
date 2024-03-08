package com.practicals.ex_11.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class MembershipCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cardNumber;
    private LocalDate expirationDate;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public MembershipCard(int id, String cardNumber, LocalDate expirationDate, Member member) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.member = member;
    }

    // Getters and setters
}
