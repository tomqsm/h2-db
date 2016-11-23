package biz.letsweb.h2.hibernate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author tomasz
 */
@Entity
@Table(name = "user")
@NoArgsConstructor @Getter @Setter @ToString
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 50)
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
