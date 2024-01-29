package com.najot.oy5dars5;

import com.najot.oy5dars5.entity.Author;
import com.najot.oy5dars5.entity.Book;
import com.najot.oy5dars5.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
class Oy5dars5ApplicationTests {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    @Transactional
//    void testFindByAuthorFirstName(){
//        Author author = Author.builder()
//                        .firstName("Xasan")
//                                .lastName("Tuychobev")
//                                        .tugilganYili(LocalDate.now())
//                .build();
//
//
//        authorRepository.save(author);
//
//        List<Author> authorList = authorRepository.findByFirstNameContaining("Xasan");
//
//        Assert.isTrue(!authorList.isEmpty()," yes empty !!! ");
//        System.out.println("1 casedan  o'tdi! ");
//
//        Assert.notEmpty(authorList,"empty !!!");
//
//    }

    @Test
    @Transactional
    void testFindByFirstNameOrLastNameContainingIgnoreCase(){


        Author author = Author.builder()
                .firstName("Xasan")
                .lastName("Tuychobev")
                .tugilganYili(LocalDate.now())
                .build();

        Book book1 = Book.builder()
                .title("Java1")
                .build();

        Book book2 = Book.builder()
                .title("Java2")
                .build();

        Set<Book> bookSet = new HashSet<>();
        bookSet.add(book1);
        bookSet.add(book2);


        author.setBooks(bookSet);

        author = authorRepository.save(author);

        System.out.println(" saved  !!!! ");

        Author authorWithBooks = authorRepository
                .findAuthorWithBooks(1L);

        authorWithBooks.getBooks().forEach(System.out::println);

        Assert.isTrue(!authorWithBooks.getBooks().isEmpty()," no books!");




    }


}
