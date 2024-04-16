package com.example.learning.JDBC.templets;

import com.example.learning.JDBC.templets.domain.Author;
import com.example.learning.JDBC.templets.domain.Book;

public final class TestDataUtil {

    private TestDataUtil() {
    }

    public static Author createTestAuthor() {

        Author author = Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(32)
                .build();

        return author;
    }

    public static Author createTestAuthorA() {

        Author author = Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(32)
                .build();

        return author;
    }

    public static Author createTestAuthorB() {

        Author author = Author.builder()
                .id(2L)
                .name("Tomas Cronin")
                .age(23)
                .build();

        return author;
    }

    public static Author createTestAuthorC() {

        Author author = Author.builder()
                .id(3L)
                .name("Jesse A Casey")
                .age(45)
                .build();

        return author;
    }

    public static Book createTestBook() {

        Book book = Book.builder()
                        .isbn("978-1-2345-6789-0")
                        .title("The Shadow in the Attic")
                        .authorId(1L)
                        .build();

        return book;
    }

    public static Book createTestBookA() {

        Book book = Book.builder()
                .isbn("222-1-2345-6789-0")
                .title("Mars Attacks")
                .authorId(1L)
                .build();

        return book;
    }

    public static Book createTestBookB() {

        Book book = Book.builder()
                .isbn("111-1-2345-6789-0")
                .title("Little Red Wagon")
                .authorId(2L)
                .build();

        return book;
    }

    public static Book createTestBookC() {

        Book book = Book.builder()
                .isbn("666-1-2345-6789-0")
                .title("Built for Speed")
                .authorId(3L)
                .build();

        return book;
    }
}

