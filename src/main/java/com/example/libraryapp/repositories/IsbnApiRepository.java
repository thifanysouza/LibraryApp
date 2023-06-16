package com.example.libraryapp.repositories;

import com.example.libraryapp.models.IsbnApi;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.UUID;
@Repository
@FeignClient(url="https://brasilapi.com.br/api/isbn/v1", name="isbnapi")
public interface IsbnApiRepository{
    @GetMapping("/{isbn}")
    IsbnApi buscarIsbn(@PathVariable("isbn") String isbn);


}
