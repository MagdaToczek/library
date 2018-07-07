package com.library.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String author;

    @Column
    private String title;

    @Column(name = "publication_year")
    private int publicationYear;

    private List<CopyOfBook> allCopiesOfBook = new ArrayList<>();

    @OneToMany(
            targetEntity = CopyOfBook.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<CopyOfBook> getAllCopiesOfBook() {
        return allCopiesOfBook;
    }

    public void setAllCopiesOfBook(List<CopyOfBook> allCopiesOfBook) {
        this.allCopiesOfBook = allCopiesOfBook;
    }
}
