package com.example.libraryapp.dtos;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record BooksDto(@NotBlank String title, List<String>authors, String publisher, String synopsis, Integer year, List<String> subjects) {
}
