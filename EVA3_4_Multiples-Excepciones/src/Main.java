import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x, y;
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Introduce los valores de X y Y");
            x = input.nextInt();
            y = input.nextInt();
            int resu = x / y;
            System.out.println("Resultado de "+x+"/"+y+" es: " + resu);
        }catch(InputMismatchException b){
            System.out.println("Captura incorrecta de datos");
        }catch (ArithmeticException b){
            System.out.println("División entre 0");
        }
            System.out.println("Programa terminado exitosamente");
    }
}