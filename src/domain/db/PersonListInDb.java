/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.db;

import domain.model.Person;
import domain.model.Person.ROLE;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import domain.service.PersonRepository;

/**
 *
 * @author Alsvid
 */
public class PersonListInDb  {
    
   /* private Properties properties;
    private String url;
    private Connection connection;
    private PreparedStatement statement;
    
    public PersonListInDb() throws DbException {
		properties = new Properties();
		url = "jdbc:postgresql://gegevensbanken.khleuven.be:51516/1TX32";
		properties.setProperty("user", "r0576497");
		properties.setProperty("password", "Bht23161407");
		properties.setProperty("ssl", "true");
		properties.setProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");

		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(url, properties);
		} catch (SQLException e) {
			throw new DbException("SQLException occured!");
		} catch (ClassNotFoundException e) {
			throw new DbException("Class not found exception!");

		}
	}

    @Override
    public void addPerson(Person p) {
        if (p == null) throw new DbException("Person is null - cannot add");
        String sql = "INSERT INTO ip_something.person(userid,firstname,lastname,password,likes) "
                + "VALUES (?, ?, ?, ?, ?);";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,p.getUserid().trim());
            statement.setString(2,p.getFirstname().trim());
            statement.setString(3, p.getLastname().trim());
            statement.setString(4, p.getPassword().trim());
            statement.setString(5, p.getRoleString());
            statement.execute();
        }
        catch(SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public void removePerson(String userid) {
        if (userid == null || userid.trim().isEmpty()) throw new DbException("userid is nog valid");
        String sql = "DELETE FROM ip_something.person WHERE userid=?;";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, userid.trim());
            statement.execute();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Person findPerson(String userid) {
        if (userid == null) throw new DbException("Userid not valid");
        try {
            String sql = "SELECT * FROM ip_something.person WHERE userid = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userid.trim());
            ResultSet result = statement.executeQuery();
            result.next();
            String firstname = result.getString("firstname").trim();
            String lastname = result.getString("lastname").trim();
            String userid1 = result.getString("userid").trim();
            String password = result.getString("password").trim();
            String role = result.getString("role");
            switch (role) {
                case "ADMINISTRATOR":
                    return new Person(firstname, lastname, userid1, password, ROLE.ADMINISTRATOR);
                default:
                    return new Person(firstname, lastname, userid1, password, ROLE.CLIENT);
            }
            
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<Person> getPersonlist() {
        List<Person> list = new ArrayList<Person>();
	try {
            String sql = "SELECT * FROM ip_something.person";
            statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
		while (result.next()) {
			String userid = result.getString("userid").trim();
			String firstname = result.getString("firstname").trim();
			String lastname = result.getString("lastname").trim();
			String password = result.getString("password").trim();
                        String role = result.getString("role");
                        switch (role) {
                case "ADMINISTRATOR":
                    list.add(new Person(firstname,lastname,userid,password,ROLE.ADMINISTRATOR));
                    break;
                default:
                    list.add(new Person(firstname,lastname,userid,password,ROLE.CLIENT));
            }
		}
	} catch (SQLException e) {
		throw new DbException(e.getMessage());
	}
    return list;
    }

    @Override
    public void updatePerson(Person person) {
        if (person == null) throw new DbException("Person cannot be null");
        String sql = "UPDATE ip_something.person SET firstname=?, lastname=?, userid=?, password=?, likes=?;";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,person.getFirstname().trim());
            statement.setString(2,person.getLastname().trim());
            statement.setString(3, person.getUserid().trim());
            statement.setString(4, person.getPassword());
            statement.setString(5, person.getRoleString());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Person findAuthenticatedPerson(String userid, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean checkUseridAvailable(String userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } */
}
