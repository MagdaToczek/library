package com.library.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookDto {
    private Long id;
    private String author;
    private String title;
    private Integer publicationYear;
    private List<CopyOfBook> allCopiesOfBook;
}
