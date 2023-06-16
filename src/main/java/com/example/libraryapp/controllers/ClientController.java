package com.example.libraryapp.controllers;

import com.example.libraryapp.dtos.ClientDto;
import com.example.libraryapp.models.ClientModel;
import com.example.libraryapp.repositories.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.beans.BeanUtils.copyProperties;
@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;





    @PostMapping("/client")
    public ResponseEntity<ClientModel> saveClient(@RequestBody @Valid ClientDto clientDto){
        var clientModel = new ClientModel();
        copyProperties(clientDto, clientModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientRepository.save(clientModel));
    }
    @GetMapping("/client")
    public ResponseEntity<List<ClientModel>> getAllClients(){
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.findAll());
    }
    @GetMapping("/client/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id){
        Optional<ClientModel> client = clientRepository.findById(id);
        if(client.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }return ResponseEntity.status(HttpStatus.OK).body(client.get());
    }
    @PutMapping("/client/{id}")
    public ResponseEntity<Object> updateClient(@PathVariable(value="id")UUID id, @RequestBody @Valid ClientDto clientDto){
        Optional<ClientModel> client = clientRepository.findById(id);
        if(client.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        var clientModel = client.get();
        copyProperties(clientDto, clientModel);
        return ResponseEntity.status(HttpStatus.OK).body(clientRepository.save(clientModel));
    }
    @DeleteMapping("/client/{id}")
    public ResponseEntity<Object> deleteClient(@PathVariable(value="id")UUID id){
        Optional<ClientModel> client = clientRepository.findById(id);
        if(client.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client not found");
        }
        clientRepository.delete(client.get());
        return ResponseEntity.status(HttpStatus.OK).body("Client deleted sucessfully");
    }


}
