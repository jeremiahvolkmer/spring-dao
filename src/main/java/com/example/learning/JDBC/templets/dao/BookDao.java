package com.example.learning.JDBC.templets.dao;

import com.example.learning.JDBC.templets.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    void create(Book book);
    Optional<Book> find(String s);

    List<Book> findMany();
}
