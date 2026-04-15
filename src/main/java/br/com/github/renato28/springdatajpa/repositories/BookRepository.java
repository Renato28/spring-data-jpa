package br.com.github.renato28.springdatajpa.repositories;

import br.com.github.renato28.springdatajpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<BookModel, UUID> {

}
