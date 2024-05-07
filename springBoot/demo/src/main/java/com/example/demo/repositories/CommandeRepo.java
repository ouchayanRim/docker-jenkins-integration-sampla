package com.example.demo.repositories;


import com.example.demo.entities.Client;
import com.example.demo.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande,Long> {

    List<Commande> findCommandeByClient(Client client);



}