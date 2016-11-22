package biz.letsweb.h2;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.MapModificationListener;

/**
 *
 * @author toks
 */
public class TestMapDb {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of makeDataSource method, of class H2ConnectionPool.
     * https://github.com/jankotek/mapdb/issues/525 see executorService example.
     */
    @Test
    public void testMakeDataSource() throws IOException {
        
        final DB db = DBMaker.fileDB("map.dbf")
                .closeOnJvmShutdown()
                .make();
        
        
        HTreeMap<String, String> people = (HTreeMap<String, String>) db.hashMap("people").createOrOpen();
        HTreeMap<String, String> peopleInv = (HTreeMap<String, String>) db.hashMap("peopleInv").createOrOpen();
        
        people.put("tomasz", "kuśmierczyk");
        peopleInv.put("kuśmierczyk", "tomasz");
        
        System.out.println(people.get("tomasz"));
        System.out.println("hmm" + peopleInv.get("kuśmierczyk"));

        
        MapModificationListener listener = new MapModificationListener() {
            @Override
            public void modify(Object arg0, Object arg1, Object arg2, boolean arg3) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        
        

    }
}
