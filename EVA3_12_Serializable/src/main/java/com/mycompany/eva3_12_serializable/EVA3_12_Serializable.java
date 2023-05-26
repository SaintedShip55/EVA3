/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.eva3_12_serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cavil
 */
public class EVA3_12_Serializable {

    public static void main(String[] args){
        try {
            String ruta="C:\\Windows\\Archivos\\archivoObjeto.per";
            Persona perso=new Persona("Carlos","Villa",19);
            //Guardar objeto
            guardarObj(perso, ruta);
            Persona resu=leerObj(ruta);
            System.out.println("Nombre: "+resu.getNombre());
            System.out.println("Apellido: "+resu.getApellido());
            System.out.println("Edad: "+resu.getEdad());
        } catch (IOException ex) {
            Logger.getLogger(EVA3_12_Serializable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
            
        }
    
    }
    public static void guardarObj(Persona perso, String ruta) throws IOException{
        FileOutputStream foStream=new FileOutputStream(ruta);
        ObjectOutputStream ooStream =new ObjectOutputStream(foStream);
        ooStream.writeObject(perso);
        ooStream.close();
    }
    public static Persona leerObj(String ruta) throws IOException, ClassNotFoundException{
        Persona perso=null;
        FileInputStream fileStream=new FileInputStream(ruta);
        ObjectInputStream oiStream=new ObjectInputStream(fileStream);
        perso=(Persona)oiStream.readObject();
        return perso;
    }
}
class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private int edad;
    public Persona(){
        this.nombre = "...";
        this.apellido = "...";
        this.edad = 0;
    }

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
}


