package com.example.mslibrary.controller;

import com.example.mslibrary.model.LibraryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryRepository extends JpaRepository<LibraryEntity, Long> {
}
