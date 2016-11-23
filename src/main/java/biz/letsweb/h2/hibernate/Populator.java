package biz.letsweb.h2.hibernate;

import com.github.javafaker.ChuckNorris;
import com.github.javafaker.Faker;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.fastnate.data.AbstractDataProvider;
import org.fluttercode.datafactory.impl.DataFactory;

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
     *
     * @throws java.io.IOException
     */
    @Override
    public void buildEntities() throws IOException {
        DataFactory df = new DataFactory();
        Faker faker = new Faker();
        log.info("testing XXX");
        for (int i = 0; i < 100; i++) {
            this.entities.add(new User(faker.name().firstName(), faker.name().lastName()));
        }
    }

}
