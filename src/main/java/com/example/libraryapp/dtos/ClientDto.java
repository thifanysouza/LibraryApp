package com.example.libraryapp.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record ClientDto(@NotBlank String lastName, String genre, List<String> subjects) {
}

