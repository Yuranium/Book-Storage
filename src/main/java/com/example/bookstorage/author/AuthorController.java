package com.example.bookstorage.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class AuthorController
{
    private final AuthorRepository repository;

    @Autowired
    public AuthorController(AuthorRepository repository)
    {
        this.repository = repository;
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public Iterable<Author> authors()
    {
       return repository.findAll();
    }

    @QueryMapping
    @Transactional(readOnly = true)
    public Author authorById(@Argument Long id)
    {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @MutationMapping
    @Transactional
    public Author addAuthor(@Argument(name = "author") AuthorInput authorInput) throws ParseException
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(authorInput.birthdayDate);
        Author author = new Author();
        author.setName(authorInput.name);
        author.setSurname(authorInput.surname);
        author.setMiddleName(authorInput.middleName);
        author.setBirthdayDate(date);
        return repository.save(author);
    }

   record AuthorInput(String name, String surname, String middleName, String birthdayDate) {}
}