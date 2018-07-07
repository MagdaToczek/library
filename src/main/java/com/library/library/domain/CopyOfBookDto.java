package com.library.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CopyOfBookDto {
    private long id;
    private int status;
    private Book book;
    private List<Rental> rentalsList;
}
