package vip.redcode.people.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "people_id")
    private People people;

    @Temporal(TemporalType.DATE)
    private Date date; // Дата рождения

    private int gender; // Пол

    private String place_birth; // Место рождения

    private Long passport_series; // Паспорт - серия

    private Long passport_number; // Паспорт - номер

    private String passport_issue; // Паспорт выдан

    @Temporal(TemporalType.DATE)
    private Date date_issue; // Дата выдачи

    private String department_code; // Код подразделения

    public Passport(People people, Date date, int gender, String place_birth, Long passport_series, Long passport_number, String passport_issue, Date date_issue, String department_code) {
        this.people = people;
        this.date = date;
        this.gender = gender;
        this.place_birth = place_birth;
        this.passport_series = passport_series;
        this.passport_number = passport_number;
        this.passport_issue = passport_issue;
        this.date_issue = date_issue;
        this.department_code = department_code;
    }
}
