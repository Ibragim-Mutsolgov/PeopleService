package vip.redcode.people.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Polis {
    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    private String number_ambulant_card;

    private String policy;

    private String type_policy;
}
