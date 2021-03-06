
package com.iqmsoft.payara.arquillian.dao;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.iqmsoft.payara.arquillian.dao.ClientDao;
import com.iqmsoft.payara.arquillian.domain.Client;

import javax.ejb.EJB;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;


@RunWith(Arquillian.class)
public class ClientDaoTest {

    @EJB
    private ClientDao personDao;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "PayaraArquillian.war")
                .addClass(Client.class)
                .addClass(ClientDao.class)
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml");
    }

    @Test
    @UsingDataSet("datasets/client.yml")
    public void shouldReturnAllPerson() throws Exception {
        List<Client> personList = personDao.getAll();

        assertNotNull(personList);
        assertThat(personList.size(), is(1));
        assertThat(personList.get(0).getName(), is("Test1"));
        assertThat(personList.get(0).getLastName(), is("Test2"));
    }
}
