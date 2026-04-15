package br.com.github.renato28.springdatajpa.repositories;

import br.com.github.renato28.springdatajpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
