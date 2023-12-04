package dev.minhnhat.week05_lab_truongduongminhnhat_21028411.backend.models;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity @Table(name = "address")
@Getter @Setter @NoArgsConstructor
public class Address {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150, nullable = false)
    private String street;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 6, columnDefinition = "SMALLINT(6)", nullable = false)
    private short country;

    @Column(length = 20, nullable = false)
    private String number;

    @Column(length = 7, nullable = false)
    private String zipCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<Candidate> candidates;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<Company> companies;

    public Address(String street, String city, short country, String number, String zipCode) {
        this.street = street;
        this.city = city;
        this.country = country;
        this.number = number;
        this.zipCode = zipCode;
    }
}
