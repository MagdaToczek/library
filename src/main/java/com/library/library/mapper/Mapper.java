package com.library.library.mapper;

import com.library.library.domain.Book;
import com.library.library.domain.BookDto;
import com.library.library.domain.CopyOfBook;
import com.library.library.domain.CopyOfBookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getAuthor(), bookDto.getTitle(), bookDto.getPublicationYear(), bookDto.getAllCopiesOfBook());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getId(), book.getAuthor(), book.getTitle(), book.getPublicationYear(), book.getAllCopiesOfBook());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(b -> new BookDto(b.getId(), b.getAuthor(), b.getTitle(), b.getPublicationYear(), b.getAllCopiesOfBook()))
                .collect(Collectors.toList());
    }

    public CopyOfBook mapToCopyOfBook(final CopyOfBookDto copyOfBookDto) {
        return new CopyOfBook(copyOfBookDto.getId(), copyOfBookDto.getStatus(), copyOfBookDto.getBook(), copyOfBookDto.getRentalsList());
    }

    public CopyOfBookDto mapToCopyOfBookDto(final CopyOfBook copyOfBook) {
        return new CopyOfBookDto(copyOfBook.getId(), copyOfBook.getStatus(), copyOfBook.getBook(), copyOfBook.getRentalsList());
    }
}
