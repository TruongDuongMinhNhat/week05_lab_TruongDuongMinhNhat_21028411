package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table
@Getter @Setter @NoArgsConstructor
public class Company {
    @Id
    @Column(name = "comp_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "comp_name", nullable = false)
    private String companyName;

    @Column(nullable = false, unique = true)
    private String phone;
    @Column(nullable = false, unique = true)
    private String email;
    private String webURL;

    @Column(length = 2000)
    private String about;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Job> jobs;

    public Company(String companyName, String phone, String email, String webURL, String about, String password, Address address) {
        this.companyName = companyName;
        this.phone = phone;
        this.email = email;
        this.webURL = webURL;
        this.about = about;
        this.password = password;
        this.address = address;
    }
}
