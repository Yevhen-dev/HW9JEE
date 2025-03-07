package org.example.hw9bank.repositories;

import org.example.hw9bank.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
