package com.example.libraryapp.controllers;

import com.example.libraryapp.models.IsbnApi;
import com.example.libraryapp.repositories.IsbnApiRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class IsbnController {
    @Autowired
    private IsbnApiRepository isbnApiRepository;

    @GetMapping("/acervo/{isbn}")
    public ResponseEntity<IsbnApi> getIsbn(@PathVariable String isbn) {
        IsbnApi isbnApi = isbnApiRepository.buscarIsbn(isbn);
        return isbnApi != null ? ResponseEntity.ok().body(isbnApi) : ResponseEntity.notFound().build();
    }
}
