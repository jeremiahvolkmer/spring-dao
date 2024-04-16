package com.example.learning.JDBC.templets.dao;

import com.example.learning.JDBC.templets.domain.Author;

import java.util.*;

public interface AuthorDao {
    void create(Author author);

    Optional<Author> findOne(long author);

    List<Author> find();
}
