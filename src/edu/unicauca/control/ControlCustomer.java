/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicauca.control;

import edu.unicauca.datos.GestionArchivoServidor;
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

}
