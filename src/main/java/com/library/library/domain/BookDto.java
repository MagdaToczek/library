package com.library.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDto {
    private Long id;
    private String author;
    private String title;
    private int publicationYear;
    private int status;
}
