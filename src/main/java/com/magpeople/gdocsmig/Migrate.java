package com.magpeople.gdocsmig;

import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.docs.DocumentList;
import sample.docs.DocumentListException;

/**
 * Hello world!
 *
 */
public class Migrate {

    public static final Logger log = Logger.getLogger(Migrate.class.getName());
    private static final String APPLICATION_NAME = "JavaGDataClientSampleAppV3.0";

    public static void main(String[] args) {
        Migrate m = new Migrate();
        Users u = new Users(Migrate.class.getResource("users.txt"));
        for (Identity id : u) {
            try {
                m.migrate(id);
            } catch (Exception e) {
                log.log(Level.SEVERE, null, e);
            }
        }
    }

    private void migrate(Identity fromId, Identity toId) throws DocumentListException, AuthenticationException, IOException, MalformedURLException, ServiceException {
        log.log(Level.INFO, "Logging in as {0}", fromId.getUsername());
        DocumentList docs = new DocumentList(APPLICATION_NAME);
        docs.login(fromId.getUsername(), fromId.getPassword());

        DocumentListFeed feed = docs.getDocsListFeed("all");

        for (DocumentListEntry entry : feed.getEntries()) {
            migrate(entry);
        }


    }

    private void migrate(DocumentListEntry entry) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
