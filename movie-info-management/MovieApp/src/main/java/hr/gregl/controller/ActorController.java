/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hr.gregl.controller;

import hr.gregl.dal.ActorRepository;
import hr.gregl.dal.RepositoryFactory;
import hr.gregl.model.Actor;
import java.util.List;

/**
 *
 * @author albert
 */
public class ActorController {

    private ActorRepository actorRepository;

    public ActorController() {
        this.actorRepository = RepositoryFactory.getActorRepository();

    }

    public void createActor(Actor actor) {
        this.actorRepository.add(actor);
    }

    public void deleteActor(int actorId) {
        this.actorRepository.delete(actorId);
    }

    public void updateActor(Actor actor) {
        this.actorRepository.update(actor);
    }

    public List<Actor> getAllActors() {
        return this.actorRepository.selectAll();
    }

    public Actor getActorById(int actorId) {
        return this.actorRepository.selectById(actorId);
    }
    

}
