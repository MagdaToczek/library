package com.library.library.controller;

import com.library.library.domain.Book;
import com.library.library.domain.BookDto;
import com.library.library.mapper.Mapper;
import com.library.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1")
public class LibraryController {
    @Autowired
    private Mapper mapper;

    @Autowired
    private DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "books")
    public List<BookDto> getBooks() {
        return mapper.mapToBookDtoList(dbService.getBooks());
    }

    @RequestMapping(method = RequestMethod.POST, value = "books", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        dbService.saveBook(mapper.mapToBook(bookDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        dbService.deleteBook(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "books")
    public BookDto updateBookStatus(@RequestBody BookDto bookDto) {
        return mapper.mapToBookDto(dbService.saveBook(mapper.mapToBook(bookDto)));
    }
}
