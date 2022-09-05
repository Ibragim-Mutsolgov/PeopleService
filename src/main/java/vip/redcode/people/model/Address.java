package vip.redcode.people.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressToPeople> address_to_people;

    private String country; // Страна

    private String region; // Регион

    private String locality; // Район

    private String city; // Город

    private String neighborhood; // Микрорайон

    private String street; // Улица

    private String house; // Дом

    private String structure; // Строение

    private String entrance; // Подъезд

    private String floor; // Этаж

    private String flat; // Квартира

    public Address(List<AddressToPeople> address_to_people, String country, String region, String locality, String city, String neighborhood, String street, String house, String structure, String entrance, String floor, String flat) {
        this.address_to_people = address_to_people;
        this.country = country;
        this.region = region;
        this.locality = locality;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.house = house;
        this.structure = structure;
        this.entrance = entrance;
        this.floor = floor;
        this.flat = flat;
    }
}
