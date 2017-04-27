/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Person;
import java.util.ArrayList;

/**
 *
 * @author alsvid
 */
public class FriendListInMemory {
    private ArrayList<Person> flist = new ArrayList<>();
    
    public FriendListInMemory() {
        
    }
    
    public void addFriend(Person p) {
        if (p == null) {
            throw new DbException("Person is null, cannot add to friendlist");
        }
        flist.add(p);
    }
    
    public void removeFriend(Person p) {
        if (p == null) {
            throw new DbException("Person is null, cannot remove to friendlist");
        }
        flist.remove(p);
    }
    
    public Person findFriend(String s) {
        Person out = null;
        if (s == null || s.trim().isEmpty()) {
            throw new DbException("String is empty, cannot find person");
        }
        for (Person p : flist) {
            if (p.getUserid().equals(s)) {
                out = p;
            }
        }
        return out;
    }
    
    public ArrayList<Person> getFriendlist() {
        return this.flist;
    }
}
