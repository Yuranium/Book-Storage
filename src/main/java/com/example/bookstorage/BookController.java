package com.example.bookstorage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping
public class BookController
{
    private final BookRepository repository;

    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository repository, AuthorRepository authorRepository)
    {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public Iterable<Book> books()
    {
        return repository.findAll();
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public Book bookById(@Argument Long id)
    {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @MutationMapping
    @Transactional
    public Book addBook(@Argument(name = "book") BookInput bookInput)
    {
        Author author = authorRepository.findById(bookInput.authorId).orElseThrow(RuntimeException::new);
        Book book = new Book();
        book.setName(bookInput.name);
        book.setPageCount(bookInput.pageCount);
        book.setGenre(bookInput.genre);
        book.setAuthor(author);
        return repository.save(book);
    }

    record BookInput(String name,Integer pageCount, BookGenre genre, Long authorId) {}
}