package biz.letsweb.h2.hibernate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.fastnate.data.AbstractDataProvider;

/**
 *
 * @author tomasz
 */
@Slf4j
public class Populator extends AbstractDataProvider {

    /**
     * A list that contains all the created data.
     */
    @Getter
    private final List<User> entities = new ArrayList<>();

    /**
     * Create the entities.
     * @throws java.io.IOException
     */
    @Override
    public void buildEntities() throws IOException {
        log.info("testing XXX");
        this.entities.add(new User("Example Entity", "yyy"));

        User entity2 = new User("Example Entity 2", "ccc");
        this.entities.add(entity2);
    }

}
