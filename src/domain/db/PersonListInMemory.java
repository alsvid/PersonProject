/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.*;
import domain.model.Person.ROLE;
import domain.model.Person.STATUS;
import java.util.ArrayList;
import java.util.List;
import domain.service.PersonRepository;

/**
 *
 * @author Alsvid
 */
public class PersonListInMemory implements PersonRepository{
    
    private List<Person> personlist = new ArrayList<Person>();
    
    public PersonListInMemory() {
        Person p = new Person("Jessica", "Nigri", "Nije", "notapassword",ROLE.ADMINISTRATOR, STATUS.OFFLINE);
        Person q = new Person("Jessica1", "Nigri1", "Nije1", "notapassword",ROLE.ADMINISTRATOR, STATUS.AWAY);
        Person r = new Person("Jessica2", "Nigri2", "Nije2", "notapassword",ROLE.ADMINISTRATOR, STATUS.ONLINE);
        personlist.add(p);
        personlist.add(q);
        personlist.add(r);
        p.getArrayFriendList().add(q);
        p.getArrayFriendList().add(r);
    }
    @Override
    public void addPerson(Person p) {
        if (p == null) throw new DbException("Person is null - can not add");
        personlist.add(p);
    }
    @Override
    public void removePerson(String userid) {
        if (userid == null || userid.trim().isEmpty()) throw new DbException("Given userid is not valid - cannnot find");
        for (Person p : personlist) {
            if (p.getUserid().equals(userid)) {
                personlist.remove(p);
            }
        }
    }
    @Override
    public Person findPerson(String userid) {
        Person out = null;
        if (userid == null || userid.trim().isEmpty()) throw new DbException("Userid not okay - cannot find person");
        for (Person p : personlist) {
            if (p.getUserid().equals(userid)) {
                out = p;
            }
        }
        return out;
    }

    @Override
    public List<Person> getPersonlist() {
        return this.personlist;
    }

    @Override
    public void updatePerson(Person person) {
        if (person == null) throw new DbException("Person is null");
        personlist.add(person);
    }

    @Override
    public Person findAuthenticatedPerson(String userid, String password) {
       Person out = null;
       for (Person p : personlist) {
           if (p.getUserid().equals(userid) && p.getPassword().equals(password)) {
               out = p;
           }
       }
       return out;
    }

    @Override
    public boolean checkUseridAvailable(String userid) {
        boolean out = true;
        for (Person p : personlist) {
            if (p.getUserid().equals(userid)) {
                out = false;
            }
        }
        return out;
    }
    
}
