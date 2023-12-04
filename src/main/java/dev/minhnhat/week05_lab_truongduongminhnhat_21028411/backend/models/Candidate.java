package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity @Table(name = "candidate")
@Getter @Setter @NoArgsConstructor
public class Candidate {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    private LocalDate dob;

    @Column(length = 15, nullable = false, unique = true)
    private String phone;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "address", nullable = false)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "candidateSkillID.candidate")
    private List<CandidateSkill> candidateSkills;

    public Candidate(String fullName, LocalDate dob, String phone, String email, String password, Address address) {
        this.fullName = fullName;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
