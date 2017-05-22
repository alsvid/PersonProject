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
    public STATUS status;
    private FriendListInMemory friendlist = new FriendListInMemory();

   
    public ROLE getRole() {
        return this.role;
    }
    
    public void setRole(ROLE role) {
        this.role = role;
    }
    
    public void setStatus(STATUS status) {
        this.status = status;
    }
    
    public void setStatusString(String status) {
        switch (status.toLowerCase()) {
            case "online":
                setStatus(STATUS.ONLINE);
                break;
            case "offline":
                setStatus(STATUS.OFFLINE);
                break;
            case "away":
                setStatus(STATUS.AWAY);
                break;
            default:
                throw new IllegalArgumentException("Wrong status, please choose between offline, online or away");
        }
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
    
   public String getStatusString() {
    if (this.status == STATUS.OFFLINE) {
        return "offline";
    }
    else if (this.status == STATUS.ONLINE) {
        return "online";
    }
    else {
        return "away";
    }
}
    
    public enum ROLE{
        CLIENT,ADMINISTRATOR
    }
    
    public enum STATUS{
        ONLINE,OFFLINE,AWAY
    }
    
    public Person() {
        
    }
    
    public Person(String firstname, String lastname, String userid, String password, ROLE role, STATUS status) {
        this.role = role;
        this.status = status;
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
