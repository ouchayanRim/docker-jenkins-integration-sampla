package com.example.demo.repositories;

import com.example.demo.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepo extends JpaRepository<Client,Long> {
    List<Client> findClientsByNomContaining(String str);
    List<Client> findClientsByMailContaining(String str);
    List<Client> findClientsByAdressContaining(String str);
    
}