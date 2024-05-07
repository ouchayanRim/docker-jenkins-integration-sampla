package com.example.demo.services;

import com.example.demo.entities.Client;

import java.util.List;

public interface ClientService {

    Client add(Client client);

    List<Client> getAllClients();
    Client updateClient(long id, Client client);
    void deletClient(Long id);

    List<Client>searchByName(String str);
}
