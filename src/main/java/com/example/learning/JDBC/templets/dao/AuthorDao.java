package com.example.learning.JDBC.templets.dao;

import com.example.learning.JDBC.templets.domain.Author;

import java.util.Optional;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long author);
}
