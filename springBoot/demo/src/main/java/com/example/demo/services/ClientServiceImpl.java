package com.example.demo.services;


import com.example.demo.entities.Client;
import com.example.demo.entities.Commande;
import com.example.demo.repositories.ClientRepo;
import com.example.demo.repositories.CommandeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepo clientRepo;

    @Autowired
    CommandeRepo commandeRepo;
    @Override
    public Client add(Client client) {
        return clientRepo.save(client);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client updateClient(long id, Client newClient) {
        Optional<Client> optionalClient = clientRepo.findById(id);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();
            client.setNom(newClient.getNom());
            client.setAdress(newClient.getAdress());
            return clientRepo.save(client);
        }else{
            throw new EntityNotFoundException("Il n'ya pad de Client avec cet ID"+id);
        }
    }

    @Override
    public void deletClient(Long id) {
        Optional<Client> optionalClient = clientRepo.findById(id);
        if(optionalClient.isPresent()){
            Client client = optionalClient.get();


            List<Commande> commandes = commandeRepo.findCommandeByClient(client);

            if (commandes.size() > 0){
                for(Commande commande : commandes){
                    commandeRepo.delete(commande);
                }
            }


            clientRepo.delete(client);
        }else{
            throw new EntityNotFoundException("Client with id="+id+"dosen't exist!");
        }
    }


    @Override
    public List<Client> searchByName(String str) {
        return clientRepo.findClientsByNomContaining(str);
    }
}