/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.magpeople.gdocsmig;

/**
 *
 * @author ermh
 */
public class Identity {

    private String username, password;

    public Identity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Identity{" + "username=" + username + ", password=" + password + '}';
    }
}
