package vip.redcode.people.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class People {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String first_name; // Фамилия

    private String last_name; // Имя

    private String middle_name; // Отчество

    @Temporal(TemporalType.DATE)
    private Date birth_date; // Дата рождения

    private Integer gender; // Пол

    private Integer height; // Вес

    private Integer weight; // Рост

    private Integer cloth_size; // Размер одежды

    private Integer foot_size; // Размер ноги

    private Timestamp added; // Дата добавления

    private String inn; // ИНН

    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Passport> passport; // Список паспортов

    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Policy> policy; // Список полюсов

    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Snils> snils;

    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressToPeople> address_to_people; // Список адресов

    public People(String first_name, String last_name, String middle_name, Date birth_date, Integer gender, Integer height, Integer weight, Integer cloth_size, Integer foot_size, Timestamp added, String inn, List<Passport> passport, List<Policy> policy, List<Snils> snils, List<AddressToPeople> address_to_people) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.cloth_size = cloth_size;
        this.foot_size = foot_size;
        this.added = added;
        this.inn = inn;
        this.passport = passport;
        this.policy = policy;
        this.snils = snils;
        this.address_to_people = address_to_people;
    }
}
