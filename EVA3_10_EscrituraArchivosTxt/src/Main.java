import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        String ruta= "C:\\Windows\\Archivos\\";
        try{
            writeUsingFiles(ruta,"Prueba de escritura de datos");
            writeUsingFileWriter(ruta,"Usando filewriter");
            writeUsingBufferedWriter(ruta,"1 2 3 4 5 6 7 8 9 10 11");
        }catch(IOException ex){
            Logger.getLogger("EVA3_10_Escritura de datos");
        }
    }
    public static void writeUsingFiles(String ruta, String datos) throws IOException {
        //Si no existe lo crea
        //Si existe lo sobreescribe
        Path path= Paths.get(ruta+"ArchivoFiles.Txt");
        Files.write(path,datos.getBytes());
    }
    public static void writeUsingFileWriter (String ruta, String datos) throws IOException{
        File file =new File(ruta+"archivosFlieWriter.txt");
        FileWriter fileWriter= new FileWriter(file);
        fileWriter.write(datos);
        fileWriter.close();
    }
    public static void writeUsingBufferedWriter (String ruta, String datos) throws IOException{
        Path path= Paths.get(ruta+"ArchivoBufferedWriter.Txt");
        OutputStream out =Files.newOutputStream(path);
        OutputStreamWriter osWriter=new OutputStreamWriter(out);
        BufferedWriter bufWriter =new BufferedWriter(osWriter);
        for (int i=0;i<10;i++){
            bufWriter.write((i+1)+". "+datos);
            bufWriter.write("\n");
        }
        bufWriter.close();
        osWriter.close();
    }
}