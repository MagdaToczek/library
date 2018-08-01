package com.library.library.controller;

import com.library.library.domain.BookDto;
import com.library.library.domain.CopyOfBookDto;
import com.library.library.mapper.Mapper;
import com.library.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@CrossOrigin(origins = "*")
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
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return mapper.mapToBookDto(dbService.saveBook(mapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "books")
    public List<BookDto> getBooksByAuthor(@RequestParam String author) { return mapper.mapToBookDtoList(dbService.getBooksByAuthor(author));}

    @RequestMapping(method = RequestMethod.GET, value = "books")
    public List<BookDto> getBooksByTitle(@RequestParam String title) { return mapper.mapToBookDtoList(dbService.getBooksByTitle(title));}

    @RequestMapping(method = RequestMethod.POST, value = "copyOfBook", consumes = APPLICATION_JSON_VALUE)
    public void createCopyOfBook(@RequestBody CopyOfBookDto copyOfBookDto) { dbService.saveCopyOfBook(mapper.mapToCopyOfBook(copyOfBookDto));}

    @RequestMapping(method = RequestMethod.DELETE, value = "copyOfBook/{id}")
    public void deleteCopyOfBook(@PathVariable Long id) { dbService.deleteCopyOfBook(id);}

    @RequestMapping(method = RequestMethod.PUT, value = "copyOfBook")
    public CopyOfBookDto updateCopyOfBook(@RequestBody CopyOfBookDto copyOfBookDto) {
        return mapper.mapToCopyOfBookDto(dbService.saveCopyOfBook(mapper.mapToCopyOfBook(copyOfBookDto)));
    }
}
