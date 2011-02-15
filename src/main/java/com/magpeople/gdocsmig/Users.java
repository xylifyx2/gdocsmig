/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magpeople.gdocsmig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ermh
 */
public class Users extends AbstractCollection<Identity> {

    private final URL url;

    public Users(URL url) {
        this.url = url;
    }
    List<Identity> ids;

    private void load() {
        BufferedReader r = null;
        try {
            if (ids != null) {
                return;
            }
            ids = new ArrayList<Identity>();
            r = new BufferedReader(new InputStreamReader(url.openStream()));
            for (String l = r.readLine(); l != null; l = r.readLine()) {
                StringTokenizer t = new StringTokenizer(l, "\t", false);
                assert t.hasMoreTokens();
                String user = t.nextToken();
                assert t.hasMoreTokens();
                String password = t.nextToken();
                Identity id = new Identity(user, password);
                ids.add(id);
            }
            r.close();
        } catch (IOException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalStateException(ex);
        } finally {
            try {
                r.close();
            } catch (IOException ex) {
                Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public Iterator<Identity> iterator() {
        load();
        return ids.iterator();
    }

    @Override
    public int size() {
        load();
        return ids.size();
    }
}
