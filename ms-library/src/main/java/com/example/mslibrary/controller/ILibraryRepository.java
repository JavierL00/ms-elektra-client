package com.example.mslibrary.controller;

import com.example.mslibrary.model.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILibraryRepository extends JpaRepository<LibraryEntity, Long> {
    @Query(value = "select\n" +
            "    l.id as id,\n" +
            "    l.name as name,\n" +
            "    l.editorial as editorial,\n" +
            "    l.publication_date as publication_date,\n" +
            "    c.id as author_id,\n" +
            "    c.name as author_name,\n" +
            "    c.first_surname as author_first_surname,\n" +
            "    c.second_surname as author_second_surname,\n" +
            "    c.gender as author_gender,\n" +
            "    c.birth_date as author_birth_date,\n" +
            "    c.phone as author_phone,\n" +
            "    c.email as author_email\n" +
            "from library l inner join client c on l.author_client_id = c.id where l.id = ?1", nativeQuery = true)
    List<Object[]> getLibraryById(Long id);
}
