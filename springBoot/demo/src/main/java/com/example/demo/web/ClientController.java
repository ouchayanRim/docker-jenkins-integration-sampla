package com.example.demo.web;

import com.example.demo.entities.Client;
import com.example.demo.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/add")
    public Client ajouter(@RequestBody Client client){
        return clientService.add(client);
    }

    @PostMapping("/update/{id}")
    public Client modification(@PathVariable Long id, @RequestBody Client client){
        return clientService.updateClient(id,client);
    }

    @DeleteMapping(".delete/{id}")
    public void suppression(@PathVariable Long id){
        clientService.deletClient(id);
    }
    @GetMapping("/findbyname/{str}")
    public List<Client> rechercheParNom(@PathVariable String str){
        return clientService.searchByName(str);
    }
}