package br.com.github.renato28.springdatajpa.repositories;

import br.com.github.renato28.springdatajpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {
}
