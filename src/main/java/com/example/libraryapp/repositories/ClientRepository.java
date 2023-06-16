package com.example.libraryapp.repositories;

import com.example.libraryapp.models.ClientModel;
import com.example.libraryapp.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
}
