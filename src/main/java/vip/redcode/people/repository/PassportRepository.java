package vip.redcode.people.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vip.redcode.people.model.Passport;

import java.util.UUID;

@Repository
public interface PassportRepository extends JpaRepository<Passport, UUID> {
}
