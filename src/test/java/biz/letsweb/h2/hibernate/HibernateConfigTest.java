package biz.letsweb.h2.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tomasz
 */
public class HibernateConfigTest {
    
    public HibernateConfigTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSomeMethod() {
        final SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.getTransaction();
        transaction.begin();
        User user = new User("tomasz", "kusmierczyk");
        session.save(user);
        
        final Query query = session.createQuery("from User u where u.name='tomasz'");
        User foundUser = (User) query.uniqueResult();
        System.out.println("found: " + foundUser);
        
        transaction.commit();
    }
    
}
