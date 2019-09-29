/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.unicauca.date;

//import edu.unicauca.control.Cliente;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Brn Hurtado
 */
public class ManagementFilesServer{
    private String path;

    public void setPath(String path) {
        this.path = path;
    }
    
    public void saveChat(String chat, String nameCustomer) throws IOException {

        File archivo = new File("C:/Users/USER/Desktop/" + nameCustomer + ".txt");
        String Path = archivo.getCanonicalPath();
        setPath(Path);
        FileWriter flwriter = null;
        try {
            FileOutputStream fos = new FileOutputStream(archivo.getAbsoluteFile(), true); //agrega el texto al contenido
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bfwriter = new BufferedWriter(osw);
            //Escribe el mensaje en el archivo
            bfwriter.write(chat + "\r\n");
            //cierra el buffer intermedio
            bfwriter.close();
            osw.close();
            fos.close();
            System.gc();
            //System.out.println("Archivo creado satisfactoriamente..");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void deleteChat(String nameCustomer) {
        File archivo = new File("C:/Users/USER/Desktop/" + nameCustomer + ".txt");
        archivo.delete();

    }

    /*
    public void guardarClientes(ArrayList<Cliente> lstClientes) {

        File archivo = new File("C:/Users/USER/Desktop/admin.txt");

        FileWriter flwriter = null;

        try {
            //crea el flujo para escribir en el archivo
            FileOutputStream fos = new FileOutputStream(archivo.getAbsoluteFile(), true); //agrega el texto al contenido

            //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bfwriter = new BufferedWriter(osw);

            for (Cliente cliente : lstClientes) {
                //escribe los datos en el archivo
                bfwriter.write(cliente + "\n");
            }

            //cierra el buffer intermedio
            //cierra el buffer intermedio
            bfwriter.close();
            osw.close();
            fos.close();
            System.gc();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (flwriter != null) {
                try {//cierra el flujo principal
                    flwriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    public static ArrayList<String> leerArchivo( String ArchivoDestino) throws ClassNotFoundException, FileNotFoundException, IOException{
        
        ArrayList<String> lstClientesLeidos = new ArrayList<>();
        try{
            lecturaArchivo = new ObjectInputStream (new FileInputStream (ArchivoDestino));
            lstClientesLeidos = (ArrayList <String>) lecturaArchivo.readObject();
            lecturaArchivo.close();
            
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, "Error !! no es posible leer el archivo");
            System.exit(0);
        }
        finally{
            lecturaArchivo.close();
        }
        return lstClientesLeidos;
        }
    
     */
 /*public static void crearArchivo(String chat, String cliente) {
        
         File archivo = new File("C:\\Users\\Maritza\\Desktop\\"+cliente+".txt");
     
          try {
            //Si no Existe el archivo lo crea
            if(!archivo.exists()){
                archivo.createNewFile();
            }
            //Abre un Flujo de escritura,sobre el archivo con codificacion utf-8, que es es un formato de 
            //codificacion de caracteres. Ademas en el pedazo de sentencia "FileOutputStream(Ffichero,true)", 
            //true es por si existe el fichero
            //seguir añadiendo texto y no borrar lo que tenia
            FileOutputStream fos = new FileOutputStream(archivo,true);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter writer = new BufferedWriter(osw);
            //Escribe en el fichero la cardena que recibe la funcion. la cadena "\r\n" significa salto de linea
            writer.write(chat+ "\r\n");
            
            } catch (Exception ex) {
            //Captura un posible error y le imprime en pantalla 
            System.out.println(ex.getMessage());
            
        }
   	
    }*/
}
