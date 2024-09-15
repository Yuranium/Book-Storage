package com.example.bookstorage;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer pageCount;

    @Enumerated(value = EnumType.STRING)
    private BookGenre genre;

    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "id_author")
    private Author author;
}