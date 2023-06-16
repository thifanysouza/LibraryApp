package com.example.libraryapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String isbn, @NotNull BigDecimal price, Boolean sale) {

}
