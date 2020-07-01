package SCHULMANJOHN.controller;


import SCHULMANJOHN.model.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import SCHULMANJOHN.service.TacheService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TacheController {
    @Autowired
    private TacheService tacheService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Tache create(@Valid @RequestBody Tache tache){
        tacheService.add(tache);
        System.out.println(tache);
        return tache;
    }
//("/taches?effectuee=true"
    @GetMapping
    public List<Tache> getAll(@RequestParam(required = false,name = "effectuee") String effectuee){
        List<Tache> validTaches = tacheService.getAllTaches();
        // afficher toutes les reservations qui sont effectuees
         if(effectuee != null && effectuee.equalsIgnoreCase("true"))
            validTaches = tacheService.getValidTaches();
        // afficher toutes les reservations qui ne sont pas effectuees
        if(effectuee != null && effectuee.equalsIgnoreCase("false"))
            validTaches = tacheService.getNotValidTaches();

        validTaches.forEach(System.out::println);
        return validTaches;
    }

    @GetMapping("/{id}")
    public Tache get(@PathVariable("id") int id){
        Tache tache = tacheService.getTache(id);
        System.out.println(tache);
        return tache;
    }
  @DeleteMapping("/{id}")
    public void remove(@PathVariable("id") int id){
        tacheService.removeTache(id);
       // return Response.status(Status.NO_CONTENT).build();
        //return Response.status(Status.getStatus((Terminal) tache).build();
    }
}
