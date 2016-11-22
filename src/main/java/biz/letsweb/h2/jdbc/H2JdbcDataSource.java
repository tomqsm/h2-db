package biz.letsweb.h2.jdbc;

import org.h2.jdbcx.JdbcDataSource;

/**
 *
 * @author toks
 */
public class H2JdbcDataSource {

    private H2JdbcDataSource() {
    }

    public static JdbcDataSource makeDataSource(String url, String username, String password) {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
