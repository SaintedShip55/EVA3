package org.example;
import java.io.*;
import java.util.*;


class Estudiante implements Serializable {
    private String nombre;
    private int numeroLista;
    private String grado;


    public Estudiante(String nombre, int numeroLista, String grado) {
        this.nombre = nombre;
        this.numeroLista = numeroLista;
        this.grado = grado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumeroLista() {
        return numeroLista;
    }
    public void setNumeroLista(int numeroLista) {
        this.numeroLista = numeroLista;
    }
    public String getGrado() {
        return grado;
    }
    public void setGrado(String grado) {
        this.grado = grado;
    }
    public void imprimirDatos(){
        System.out.println("No. de lista: " + getNumeroLista());
        System.out.println("Nombre " + getNombre());
        System.out.println("Grado:  " + getGrado());
    }
}
class StudentManagementSystem {
    private List<Estudiante> estudiantes;
    public StudentManagementSystem() {
        estudiantes = new ArrayList<>();
    }
    public void addStudent(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }
    public Estudiante getStudent(int rollNumber) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getNumeroLista() == rollNumber) {
                estudiante.imprimirDatos();
                return estudiante;
            }
        }
        System.out.println("Estudiante no encontrado");
       return null;
    }
    public void storeData(String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(estudiantes);
            objectOut.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error al almacenar los datos de los estudiantes en el archivo: " + e.getMessage());
        }
    }
    public void loadData(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            estudiantes = (ArrayList<Estudiante>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
            System.out.println("Los datos de los estudiantes se han cargado correctamente desde el archivo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos de los estudiantes desde el archivo: " + e.getMessage());
        }
    }
    public void clearData(int rollNumber){
        Iterator<Estudiante> iterator = estudiantes.iterator();
        while (iterator.hasNext()){
            Estudiante estudiante = iterator.next();
            if (estudiante.getNumeroLista() == rollNumber){
                iterator.remove();
                estudiante.setNumeroLista(0);
                break;
            }
        }
    }
}
public class Main {
    public static void main(String[] args){
        String ruta = "c:\\archivos\\examenPrueba.txt";
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();
        system.loadData(ruta);
        System.out.println("Inicia el Sistema de Gestion de Estudiantes");
        System.out.println("Se cargaron los datos correctamente");
        do {
            System.out.println("Que desea realizar?");
            System.out.println("1.- Añadir un estudiante  2.-Consultar la lista de estudiantes  3.- Salir");
            String nombre;
            int numeroLista;
            String grado;
            try {
                int opc = sc.nextInt();
                if (opc == 1) {
                    sc.nextLine();
                        System.out.println("Nombre: ");
                        nombre = sc.nextLine();
                        System.out.println("No. de lista: ");
                        numeroLista = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Grado: ");
                        grado = sc.nextLine();
                        Estudiante estudiante = new Estudiante(nombre, numeroLista, grado);
                        system.addStudent(estudiante);
                        system.storeData(ruta);
                        System.out.println("Los datos de los estudiantes se han almacenado correctamente en el archivo.");

                } else if (opc == 2) {
                    System.out.println("Ingrese el numero de No. de lista del estudiante: ");
                    numeroLista = sc.nextInt();
                    System.out.println(system.getStudent(numeroLista));
                    if (numeroLista!=0){
                        System.out.println("Desea eliminar la informacion del estudiante? \n Si/No");
                        sc.nextLine();
                        String opc1 = sc.nextLine();
                        try {
                            do {
                                if (opc1.equalsIgnoreCase("si")) {
                                    system.clearData(numeroLista);
                                    system.storeData(ruta);
                                    break;
                                } else if (opc1.equalsIgnoreCase("no")) {
                                    break;
                                } else {
                                    System.out.println("Esa opcion no es valida");
                                }
                            }while (opc1!="si" && opc1=="no");
                        }catch (InputMismatchException e){
                            System.out.println("Captura invalida, vuelva a intentar");
                        }
                    }else {
                     break;
                    }
                } else if (opc == 3) {
                    System.out.println("Saliendo del programa");
                    break;
                } else {
                    System.out.println("Opcion no disponible");
                }
            } catch (InputMismatchException e) {
                System.out.println("No se ingreso un numero entero, vuelva a ingresar");
                e.getMessage();
            }
        }while (true);
    }
}