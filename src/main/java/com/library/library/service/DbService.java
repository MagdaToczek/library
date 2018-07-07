package com.library.library.service;

import com.library.library.domain.Book;
import com.library.library.domain.CopyOfBook;
import com.library.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DbService {
    @Autowired
    private LibraryRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book saveBook(final Book book) {
        return repository.save(book);
    }

    public void deleteBook(final Long id) {
        repository.deleteById(id);
    }

    public List<Book> getBooksByAuthor(final String author) { return repository.findBookByAuthorIsContaining(author);}

    public List<Book> getBooksByTitle(final String title) { return repository.findBookByTitleContaining(title);}

    public CopyOfBook saveCopyOfBook(final CopyOfBook copyOfBook) { return repository.save(copyOfBook);}

    public void deleteCopyOfBook(final Long id) {
        repository.deleteById(id);
    }
}
