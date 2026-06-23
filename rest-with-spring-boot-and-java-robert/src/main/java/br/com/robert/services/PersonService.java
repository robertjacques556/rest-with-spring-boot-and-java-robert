package br.com.robert.services;

import br.com.robert.model.PersonModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    //Regras de negocios: Aqui vai ter as operações que a gente vai fazer para cadastrar uma pessoa

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());
    public List<PersonModel> findAll(){
        logger.info("Finding All People! ");
        List<PersonModel> persons = new ArrayList<PersonModel>();
        for(int i=0; i<8; i++){
            PersonModel person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public PersonModel findById(String id){
        logger.info("Finding Person one Person! ");
        PersonModel personModel = new PersonModel();
        personModel.setId(counter.incrementAndGet());
        personModel.setFirstName("Leandro");
        personModel.setLastName("Costa");
        personModel.setAddress("Uberlândia - Minas gerais - Brasil ");
        personModel.setGender("Male");
        return personModel;
    }

    public PersonModel create(PersonModel personModel){
        logger.info("Creating Person! ");
        return personModel;
    }

    public PersonModel update(PersonModel personModel){
        logger.info("Updating Person! ");
        return personModel;
    }
    public void delete(String id){
        logger.info("Deleting Person! ");
    }
    private PersonModel mockPerson(int i) {
        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName" + i);
        person.setLastName("LastName" + i);
        person.setAddress("Some Addres in Brasil ");
        person.setGender("Male");
        return person;
    }


}
