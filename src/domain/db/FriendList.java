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
public interface FriendList {
    public void addFriend(Person p);
    public void removeFriend(Person p);
    public Person findFriend(String s);
    public ArrayList<Person> getFriendlist();
}
