/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.model;

import domain.db.FriendList;
import domain.db.FriendListInMemory;
import java.util.ArrayList;

/**
 *
 * @author Alsvid
 */
public class Person {
    
    private String firstname;
    private String lastname;
    private String userid;
    private String password;
    public ROLE role;
    private FriendListInMemory friendlist = new FriendListInMemory();

   
    public ROLE getRole() {
        return this.role;
    }
    
    public void setRole(ROLE role) {
        this.role = role;
    }
    
    public void setRoleString(String role) {
        switch(role.toLowerCase()) {
            case "client":
                setRole(ROLE.CLIENT);
                break;
            case "administrator":
                setRole(ROLE.ADMINISTRATOR);
                break;
            default:
                throw new IllegalArgumentException("Wrong role, please type administrator or client");
        }
    }
    
    public String getRoleString() {
        if (this.role == ROLE.ADMINISTRATOR) {
            return "administrator";
        }
        else {
            return "client";
        }
    }
    
    public enum ROLE{
        CLIENT,ADMINISTRATOR
    }
    
    public Person() {
        
    }
    
    public Person(String firstname, String lastname, String userid, String password, ROLE role) {
        this.role = role;
        setFirstname(firstname);
        setLastname(lastname);
        setUserid(userid);
        setPassword(password);
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public void setUserid(String userid) {
        this.userid = userid;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
  
    
    public String getFirstname() {
        return this.firstname;
    }
    
    public String getLastname() {
        return this.lastname; 
    }
    
    public String getUserid() {
        return this.userid;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public ArrayList<Person> getArrayFriendList() {
        return this.friendlist.getFriendlist();
    }
    
    public FriendListInMemory getFriendList() {
        return this.friendlist;
    }

}
