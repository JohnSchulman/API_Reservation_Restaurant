package SCHULMANJOHN.service;

import SCHULMANJOHN.exception.NotFoundException;
import SCHULMANJOHN.model.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class TacheService {

    // pas besoin d'un @autowired car c'est un propriété
    private List<Tache> taches = new ArrayList<>();

    @Autowired
    private Random random;

    // faut une constructeur même s'il est vide
    public TacheService() {
    }
    @PostConstruct
    public void init() {
        Tache tache1 = new Tache(123456789, "Reserver", "La personne réserve une table", true);
        Tache tache2 = new Tache(346657945, "Annuler", "La personne annule une réservation une table", false);
        Tache tache3 = new Tache(459772198, "Confirmer", "La personne confirme une table", true);
        taches.add(tache1);
        taches.add(tache2);
        taches.add(tache3);
    }

    // Concerne mon  Post
    public void add(Tache tache) {
        tache.setId(random.nextInt(Integer.MAX_VALUE));
        tache.setName("Tache test");
        tache.setDescription("Ceci est une tache de teste");
        tache.setValidated(true);
        taches.add(tache);
    }

    public List<Tache> getAllTaches(){
        return taches.stream().collect(Collectors.toList());
    }

    public List<Tache> getValidTaches() {
        return taches.stream().filter(Tache::isValidated).collect(Collectors.toList());
    }
    public List<Tache> getNotValidTaches() {
        return taches.stream().filter(Predicate.not(Tache::isValidated)).collect(Collectors.toList());
    }

    public Tache getTache(int id) {
        return taches.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(NotFoundException::new);
    }

    public void removeTache(int id) {
        //return taches.stream().filter(u -> u.getId() == id).findFirst().
        taches.removeIf(u -> u.getId() == id);
    }


}
