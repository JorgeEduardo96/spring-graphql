package br.com.jeduardo.springgraphql.api.controller;

import br.com.jeduardo.springgraphql.domain.dao.AuthorDao;
import br.com.jeduardo.springgraphql.domain.dao.PostDao;
import br.com.jeduardo.springgraphql.domain.model.Author;
import br.com.jeduardo.springgraphql.domain.model.Post;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AuthorController {

    private final PostDao postDao;
    private final AuthorDao authorDao;

    public AuthorController(PostDao postDao, AuthorDao authorDao) {
        this.postDao = postDao;
        this.authorDao = authorDao;
    }

    @SchemaMapping
    public List<Post> posts(Author author) {
        return postDao.getAuthorPosts(author.getId());
    }

    @QueryMapping
    public List<Author> authors() { return authorDao.authors(); }
}
