package biz.letsweb.h2.jdbc;

import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author toks
 */
public class H2ConnectionPool {

    public static final Logger LOG = LoggerFactory.getLogger(H2ConnectionPool.class);

    public static final int DEFAULT_SIZE = 10;
    private final JdbcDataSource dataSource;
    private JdbcConnectionPool pool = null;

    public H2ConnectionPool(final JdbcDataSource dataSource) {
        this.dataSource = dataSource;
        disposeOnJvmExit();
    }
    
    public JdbcConnectionPool makeOrGetConnectionPool(int poolSize) {
        if (pool == null) {
            pool = JdbcConnectionPool.create(dataSource);
        }
        pool.setMaxConnections(poolSize);
        LOG.info("Created pool with max connections of: {}", pool.getMaxConnections());
        return pool;
    }

    /**
     * Default size is 10.
     *
     * @return
     */
    public JdbcConnectionPool makeDefaultSizeConnectionPool() {
        if (pool == null) {
            pool = JdbcConnectionPool.create(dataSource);
        }
        LOG.info("Created pool with max connections of: {}", pool.getMaxConnections());
        return pool;
    }

    private void disposeOnJvmExit() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                if (pool != null) {
                    LOG.debug("Disposing of connection pool.");
                    pool.dispose();
                }
            }
        });
    }

}
