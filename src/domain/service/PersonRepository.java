/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.service;

import domain.model.*;
import java.util.List;

/**
 *
 * @author Alsvid
 */
public interface PersonRepository {
    
    public void addPerson(Person p);
    public void removePerson(String userid);
    public Person findPerson(String userid);
    public List<Person> getPersonlist();
    public void updatePerson(Person person);
    public Person findAuthenticatedPerson(String userid, String password);
    public boolean checkUseridAvailable(String userid);
}
