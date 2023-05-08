import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int valor;
        do {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Ingresa un valor (Número entero)");
                valor = input.nextInt();
                break;
            }catch(InputMismatchException b){
                System.out.println("No se puede o¿convertir a número");
            }
        }while(true);
        System.out.println("Valor es: "+valor);
    }
}