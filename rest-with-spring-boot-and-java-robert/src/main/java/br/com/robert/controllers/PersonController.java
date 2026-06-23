package br.com.robert.controllers;

import br.com.robert.model.PersonModel;
import br.com.robert.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

//Aqui é onde vamos realizar as operações para receber as requisições HTTP

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired //permite a injeção de dependencia da classe service
    private PersonService personService;

    //http://localhost:8080/person
    @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonModel> findAll(){
        return personService.findAll();
    }

    //http://localhost:8080/person/1
    @RequestMapping(value="/{id}", method = RequestMethod.GET,
            produces= MediaType.APPLICATION_JSON_VALUE
    )
    public PersonModel findById(@PathVariable String id){
        return personService.findById(id);
    }

    //http://localhost:8080/person
    @RequestMapping( method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    public PersonModel create(@RequestBody PersonModel personModel){
        return personService.create(personModel);
    }

    //http://localhost:8080/person
    @RequestMapping( method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonModel update(@RequestBody PersonModel personModel){
        return personService.update(personModel);
    }

    //http://localhost:8080/person
    @RequestMapping(value= "/{id}",
            method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") String id){
        personService.delete(id);
    }







}
