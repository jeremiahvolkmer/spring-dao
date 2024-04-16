package com.example.learning.JDBC.templets;

import com.example.learning.JDBC.templets.domain.Author;

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
}

