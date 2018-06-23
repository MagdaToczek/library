package com.library.library.mapper;

import com.library.library.domain.Book;
import com.library.library.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getId(), bookDto.getAuthor(), bookDto.getTitle(), bookDto.getPublicationYear(), bookDto.getStatus());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getId(), book.getAuthor(), book.getTitle(), book.getPublicationYear(), book.getStatus());
    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(b -> new BookDto(b.getId(), b.getAuthor(), b.getTitle(), b.getPublicationYear(), b.getStatus()))
                .collect(Collectors.toList());
    }
}
