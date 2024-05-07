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
public class CommandeServiceImpl implements CommandeService{

    @Autowired
    CommandeRepo commandeRepo;
    @Autowired
    ClientRepo clientRepo;

    @Override
    public Commande add(Commande commande) {
        return commandeRepo.save(commande);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepo.findAll();
    }

    @Override
    public Commande updateCommande(Long idCommande, long idClient, Commande commande) {
        Optional<Commande> optionalCommande = commandeRepo.findById(idCommande);
        Optional<Client> optionalClient = clientRepo.findById(idClient);
        if(optionalClient.isPresent() && optionalCommande.isPresent()){
            Commande updateCommande = optionalCommande.get();
            Client client = optionalClient.get();
            updateCommande.setDateCommande(commande.getDateCommande());
            updateCommande.setMontant(commande.getMontant());
            updateCommande.setClient(client);
            return commandeRepo.save(updateCommande);
        }else{
            throw new EntityNotFoundException("Commande ou Client n'exist pas");
        }
    }




    @Override
    public void deletCommande(Long id) {
        Optional<Commande> optionalCommande = commandeRepo.findById(id);
        if(optionalCommande.isPresent()){
            Commande commande = optionalCommande.get();
            commandeRepo.delete(commande);
        }else{
            throw new EntityNotFoundException(" Commande n'exist pas id="+id);

        }
    }


}


