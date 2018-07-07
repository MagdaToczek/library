package com.library.library.repository;

import com.library.library.domain.Book;
import com.library.library.domain.CopyOfBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LibraryRepository extends CrudRepository<Book, Long> {
    @Override
    List<Book> findAll();

    @Override
    Book save(Book book);

    @Override
    void deleteById(Long id);

    CopyOfBook save(CopyOfBook copyOfBook);

    List<Book> findBookByAuthorIsContaining(String author);

    List<Book> findBookByTitleContaining(String title);
}
