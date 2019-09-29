/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicauca.control;

import edu.unicauca.date.ManagementFilesServer;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author BrnHutado
 */
public class ControlCustomer extends Thread {

    private String nameCustomer;
    private static List customerAct = new ArrayList();
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ControlCustomer(Socket socket) throws IOException {
        this.socket = socket;
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        start();
    }
    
    public void run() {
        String textUser = "";
        try {
            out.println("Welcome Java Socket Chat: ");
            nameCustomer = (in.readLine()).trim();
            System.out.println("User " + nameCustomer + " connected ");
            if ((nameCustomer.equals("")) || (nameCustomer == null)) {
                nameCustomer = "Anonimo";
            }
            Iterator it = customerAct.iterator();
            while (it.hasNext()) {
                if (nameCustomer.equals(((ControlCustomer) it.next()).nameCustomer)) {
                    nameCustomer = nameCustomer + socket.getPort();
                    break;
                }
            }
            AddingChat(this);
            out.println("name user: " + nameCustomer);
            while ((textUser = in.readLine()) != null) {
                writeAll(nameCustomer + " :> " + textUser);
                
            }
        } catch (IOException e2) {
        }
    }
    
     private static synchronized void AddingChat(ControlCustomer control) {
        customerAct.add(control);
    }

    private synchronized void writeAll(String textUs) {
        Iterator it = customerAct.iterator();
        while (it.hasNext()) {
            ControlCustomer tmp = (ControlCustomer) it.next();
            if (!(tmp.equals(this))) {
                writeCustomer(tmp, textUs);
            }
        }
    }

    private synchronized void writeCustomer(ControlCustomer control, String textUs) {
        (control.out).println(textUs);
           //ManagementFilesServer mf=new managementFileServer();
           //mf.saveChat(textUs, nameCustomer);
       
    }
}
