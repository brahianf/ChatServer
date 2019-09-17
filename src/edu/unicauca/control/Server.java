package edu.unicauca.control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//***package edu.unicauca.control;

import edu.unicauca.control.ControlCustomer;
import java.io.*;
import java.net.*;

/**
 *
 * @author BrnHurtado
 */
public class Server {

    private ServerSocket socketServer;
    private final int PORT = 9002;

    public Server() {
        start();
        acceptCustomer(); 
    }
    

    public static void main(String[] cuec) {
        new Server();
    }

    private void start() {
        try {
            //Create socket 
            socketServer = new ServerSocket(PORT);
            System.out.println(" SERVER IN PORT " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void acceptCustomer() {
        //Method accept Connection Customer
        Socket socketCustomer = null;
        //loop infinite - customer infinte
        while (true) {
            try {
                //Accept input connection  of Customer
                socketCustomer = socketServer.accept();
                //Start Class Control customer
                new ControlCustomer(socketCustomer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


