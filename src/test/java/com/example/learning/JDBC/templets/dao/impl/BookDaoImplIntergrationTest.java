package com.example.learning.JDBC.templets.dao.impl;

import com.example.learning.JDBC.templets.TestDataUtil;
import com.example.learning.JDBC.templets.domain.Author;
import com.example.learning.JDBC.templets.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ExtendWith(SpringExtension.class)

public class BookDaoImplIntergrationTest {

    private BookDaoImpl underTest;
    private AuthorDaoImpl authorDao;

    @Autowired
    public BookDaoImplIntergrationTest(BookDaoImpl underTest, AuthorDaoImpl authorDao) {

        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {

        Author author = TestDataUtil.createTestAuthor();
        authorDao.create(author);

        Book book = TestDataUtil.createTestBook();
        book.setAuthorId(author.getId());
        underTest.create(book);

        Optional<Book> result = underTest.find(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testMultipleBooksCanBeCreatedAndRecalled() {

        Author author = TestDataUtil.createTestAuthorA();
        authorDao.create(author);
        Author authorB = TestDataUtil.createTestAuthorB();
        authorDao.create(authorB);
        Author authorC = TestDataUtil.createTestAuthorC();
        authorDao.create(authorC);

        Book bookA = TestDataUtil.createTestBookA();
        underTest.create(bookA);
        Book bookB = TestDataUtil.createTestBookB();
        underTest.create(bookB);
        Book bookC = TestDataUtil.createTestBookC();
        underTest.create(bookC);

        List<Book> result = underTest.findMany();
        assertThat(result)
                .hasSize(3).
                containsExactly(bookA,bookB,bookC);
    }

}
