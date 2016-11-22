package biz.letsweb.h2.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class H2ConnectionPoolTest {
    
   public static final Logger LOG = LoggerFactory.getLogger(H2ConnectionPoolTest.class);
    public static JdbcConnectionPool CONNECTION_POOL;

    @BeforeClass
    public static void setUpClass() {
        final String url = ProjectConfiguration.getConfiguration(ProjectConfiguration.ForObject.H2).getString("h2.url");
        final JdbcDataSource dataSource = H2JdbcDataSource.makeDataSource(url, "sa", "");
        CONNECTION_POOL = new H2ConnectionPool(dataSource).makeDefaultSizeConnectionPool();
    }

    @AfterClass
    public static void tearDownClass() {
        CONNECTION_POOL.dispose();
        CONNECTION_POOL = null;
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of makeDataSource method, of class H2ConnectionPool.
     */
    @Test
    public void testMakeDataSource() {
        LOG.info("makeDataSource");
        try (Connection conn = CONNECTION_POOL.getConnection();) {
            conn.prepareStatement("");
        } catch (SQLException ex) {
            LOG.error("Error during getting a connection. {}", ex);
        }

    }
    
}
