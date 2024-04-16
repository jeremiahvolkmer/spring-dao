package com.example.learning.JDBC.templets.dao.impl;

import com.example.learning.JDBC.templets.TestDataUtil;
import com.example.learning.JDBC.templets.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;


import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDaoImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDaoImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {
        Book book = TestDataUtil.createTestBook();
        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES (?, ?, ?)"),
                eq("978-1-2345-6789-0"),
                eq("The Shadow in the Attic"),
                eq(1L)
        );
    }

    @Test
    public void testThatFindOneGeneratesTheCorrectSql() {
        underTest.find("The Shadow in the Attic");
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, authorId FROM books WHERE title = ? LIMIT 1"),
                ArgumentMatchers.<BookDaoImpl.BookRowMapper>any(),
                eq("The Shadow in the Attic")
        );
    }
}
