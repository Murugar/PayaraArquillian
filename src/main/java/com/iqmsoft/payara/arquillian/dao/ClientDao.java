
package com.iqmsoft.payara.arquillian.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.iqmsoft.payara.arquillian.domain.Client;

import java.util.List;


@Stateless
public class ClientDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Client> getAll() {
        return entityManager.createNamedQuery("Client.getAll", Client.class).getResultList();
    }
}
