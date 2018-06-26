/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineUsersCounter implements HttpSessionListener {

    private static int numberOfUsersOnline;

    public OnlineUsersCounter() {
        numberOfUsersOnline = 0;
    }

    public static int getNumberOfUsersOnline() {
        return numberOfUsersOnline;
    }

    public void sessionCreated(HttpSessionEvent event) {

        System.out.println("Session created by Id : " + event.getSession().getId());

        synchronized (this) {
            numberOfUsersOnline++;
        }

    }

    public void sessionDestroyed(HttpSessionEvent event) {

        System.out.println("Session destroyed by Id : " + event.getSession().getId());

        try {
            DB.Execute("UPDATE users SET sid='' WHERE sid='" + event.getSession().getId() + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }

        synchronized (this) {
            numberOfUsersOnline--;
        }

    }

}
