package com.library.library.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate rentalDate;

    @Column
    private LocalDate returnDate;

    @Column
    private int status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "copy_id")
    @JsonBackReference
    private CopyOfBook copyOfBook;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reader_id")
    @JsonBackReference
    private Reader reader;
}
