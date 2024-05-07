package com.example.demo.services;




import com.example.demo.entities.Commande;

import java.util.List;

public interface CommandeService {

    Commande add(Commande commande);

    List<Commande> getAllCommandes();

    Commande updateCommande(Long idCommande, long idClient,Commande commande);

    void deletCommande(Long id);


}