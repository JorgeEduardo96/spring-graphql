package br.com.jeduardo.springgraphql.domain.dao;

import br.com.jeduardo.springgraphql.domain.model.Author;

import java.util.List;

public class AuthorDao {
    private final List<Author> authors;

    public AuthorDao(List<Author> authors) {
        this.authors = authors;
    }

    public Author getAuthor(String id) {
        return authors.stream()
                .filter(author -> id.equals(author.getId()))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public List<Author> authors() {
        return this.authors;
    }

}
