import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String ruta= "C:\\Windows\\Archivos\\prueba.txt";
        try {
            readUsingFiles(ruta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void readUsingFiles(String ruta) throws IOException {
        //Recibimos la ruta en formato de texto
        //La convertimos a formato Path
        Path path= Paths.get(ruta);

        //readAllLines me regresa una lista de tipo String
        /*List<String> contenidoArch = Files.readAllLines();
        //System.out.println(contenidoArch.toString());}
        for(int i=0;i<contenidoArch.size();i++){
            System.out.println(contenidoArch.get(i));
        }*/
        byte[] arregloBytes = Files.readAllBytes(path);
        System.out.println(new String(arregloBytes));
    }
}