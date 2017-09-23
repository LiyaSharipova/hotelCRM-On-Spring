package ru.kpfu.itis.sharipova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.sharipova.model.Credentials;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {

    Credentials findOneByLogin(String login);

    Credentials findOneByEmail(String email);
}
