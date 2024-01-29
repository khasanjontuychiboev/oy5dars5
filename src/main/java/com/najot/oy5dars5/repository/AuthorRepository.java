package com.najot.oy5dars5.repository;

import com.najot.oy5dars5.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByFirstNameContaining(String name);
    List<Author> findByFirstNameOrLastNameContainingIgnoreCase(String firstName, String lastName);
    List<Author> findByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCaseOrderByFirstNameDesc(String firstName, String lastName);

    @Query(value = "SELECT a from Author a join fetch a.books where a.Id =:id")
    Author findAuthorWithBooks(@Param("id") Long id);

}
