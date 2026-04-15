package br.com.github.renato28.springdatajpa.services;

import br.com.github.renato28.springdatajpa.dtos.BookRecordDto;
import br.com.github.renato28.springdatajpa.models.BookModel;
import br.com.github.renato28.springdatajpa.models.ReviewModel;
import br.com.github.renato28.springdatajpa.repositories.AuthorRepository;
import br.com.github.renato28.springdatajpa.repositories.BookRepository;
import br.com.github.renato28.springdatajpa.repositories.PublisherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository,
                       AuthorRepository authorRepository,
                       PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(bookRecordDto.title());
        bookModel.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get());
        bookModel.setAuthors(new HashSet<>(authorRepository.findAllById(bookRecordDto.authorIds())));

        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(bookModel);
        bookModel.setReview(reviewModel);

        return bookRepository.save(bookModel);
    }

    @Transactional
    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }
}
