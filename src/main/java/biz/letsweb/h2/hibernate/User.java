package biz.letsweb.h2.hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author tomasz
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    
    @Column(length = 50)
    private String name;
    
    @Column(length = 50)
    private String surname;

    public User() {
    }
    
    public User(String name, String surname) {
       this.name = name;
       this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + '}';
    }
    
    
}
