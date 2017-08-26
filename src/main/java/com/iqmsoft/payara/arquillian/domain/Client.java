
package com.iqmsoft.payara.arquillian.domain;

import javax.persistence.*;

@Entity
@NamedQueries(
        @NamedQuery(name = "Client.getAll", query = "select p from Client p")
)
public class Client {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String lastName;

    public Client() {
    }

    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
