package vip.redcode.people.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AddressToPeople {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private Integer address_type;

    public AddressToPeople(People people, Address address, Integer address_type) {
        this.people = people;
        this.address = address;
        this.address_type = address_type;
    }
}
