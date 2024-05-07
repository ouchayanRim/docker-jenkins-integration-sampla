package com.example.demo.web;


import com.example.demo.entities.Commande;
import com.example.demo.services.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.List;


@RestController
@RequestMapping("/api/commande")

public class CommandeController {
    @Autowired
    CommandeService commandeService;

    @PostMapping("/add")
    public Commande ajouter(@RequestBody Commande commande){
        return commandeService.add(commande);
    }

    @GetMapping("/commandes")
    public List<Commande> all(){
        return commandeService.getAllCommandes();
    }



    @PostMapping("/update/{idcommande}/{idclient}")
    public Commande modif(@PathVariable Long idcommande, @PathVariable Long idclient, @RequestBody Commande commande){
        return commandeService.updateCommande(idcommande,idclient,commande);
    }

    @DeleteMapping("/deletecommande/{id}")
    public void suppression(@PathVariable Long id){
        commandeService.deletCommande(id);
    }

}