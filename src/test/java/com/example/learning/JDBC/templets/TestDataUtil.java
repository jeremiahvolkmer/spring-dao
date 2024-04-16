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

    public static Book createTestBook() {
        Book book = Book.builder()
                        .isbn("978-1-2345-6789-0")
                        .title("The Shadow in the Attic")
                        .authorId(1L)
                        .build();
        return book;
    }
}

