package com.practicals.ex_11.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practicals.ex_11.model.Member;
import com.practicals.ex_11.model.MembershipCard;
import com.practicals.ex_11.repository.MemberRepo;
import com.practicals.ex_11.repository.MembershipCardRepo;

@RestController
@RequestMapping("/api")
public class LibraryMembershipController {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private MembershipCardRepo membershipCardRepo;

    @PostMapping("/members") // http://localhost:8080/api/members
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return new ResponseEntity<>(memberRepo.save(member), HttpStatus.CREATED);
    }
    // {
    // "name": "John Doe",
    // "email": "johndoe@example.com"
    // }

    @GetMapping("/members/{id}") // http://localhost:8080/api/members/2
    public ResponseEntity<Member> getMemberById(@PathVariable int id) {
        return ResponseEntity.ok(memberRepo.findById(id).orElse(null));
    }

    @PutMapping("/members/{id}") // http://localhost:8080/api/members/2
    public ResponseEntity<Member> updateMember(@PathVariable int id, @RequestBody Member member) {
        Optional<Member> existingMember = memberRepo.findById(id);

        if (!existingMember.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Member updatedMember = existingMember.get();

        updatedMember.setName(member.getName());
        updatedMember.setEmail(member.getEmail());
        memberRepo.save(updatedMember);

        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/members/{id}") // http://localhost:8080/api/members/2
    public ResponseEntity<Void> deleteMember(@PathVariable int id) {
        memberRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/membership-cards") // http://localhost:8080/api/membership-cards
    public ResponseEntity<MembershipCard> createMembershipCard(@RequestBody MembershipCard membershipCard) {
        MembershipCard createdCard = membershipCardRepo.save(membershipCard);
        return new ResponseEntity<>(createdCard, HttpStatus.CREATED);
    }
    // {
    // "cardNumber": "12345909999",
    // "expirationDate": "2024-12-31",
    // "member": {
    // "id": 4
    // }
    // }

    @GetMapping("/membership-cards/{id}") // http://localhost:8080/api/membership-cards/3
    public ResponseEntity<MembershipCard> getMembershipCardById(@PathVariable int id) {
        MembershipCard card = membershipCardRepo.findById(id).orElse(null);
        return ResponseEntity.ok().body(card);
    }

    @PutMapping("/membership-cards/{id}") // http://localhost:8080/api/membership-cards/3
    public ResponseEntity<MembershipCard> updateMembershipCard(@PathVariable int id,
            @RequestBody MembershipCard membershipCard) {
        Optional<MembershipCard> existingCard = membershipCardRepo.findById(id);

        if (!existingCard.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        MembershipCard updatedCard = existingCard.get();
        updatedCard.setCardNumber(membershipCard.getCardNumber());
        updatedCard.setExpirationDate(membershipCard.getExpirationDate());
        membershipCardRepo.save(updatedCard);

        return ResponseEntity.ok(updatedCard);
    }

    @DeleteMapping("/membership-cards/{id}") // http://localhost:8080/api/membership-cards/3
    public ResponseEntity<Void> deleteMembershipCard(@PathVariable int id) {
        membershipCardRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
