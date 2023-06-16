package com.example.libraryapp.controllers;

import com.example.libraryapp.dtos.ProductRecordDto;
import com.example.libraryapp.models.IsbnApi;
import com.example.libraryapp.models.ProductModel;
import com.example.libraryapp.repositories.IsbnApiRepository;
import com.example.libraryapp.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.beans.BeanUtils.*;

@RestController
public class ProductController{
    @Autowired
    ProductRepository productRepository;

    @PostMapping("/books")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }
    @GetMapping("/books")
    public ResponseEntity<List<ProductModel>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id")UUID id){
        Optional<ProductModel> book = productRepository.findById(id);
        if(book.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }return ResponseEntity.status(HttpStatus.OK).body(book.get());
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id")UUID id, @RequestBody @Valid ProductRecordDto productRecordDto){
        Optional<ProductModel> book = productRepository.findById(id);
        if(book.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        var productModel = book.get();
        copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id")UUID id){
        Optional<ProductModel> book = productRepository.findById(id);
        if(book.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        productRepository.delete(book.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted sucessfully");
    }


}
