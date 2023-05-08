import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Ingresa un valor positivo");
                int valor=input.nextInt();
                Prueba ob1 = new Prueba();
                ob1.setValor(valor);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }catch (InputMismatchException ex) {//Excepciones es superclase y atrapa
             //a todas las excepciones
                //complica la deteccion de excepcion
                //y no se puede solucionar

            }
    }
}
class Prueba{
    private int valor;
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) throws Exception{
        if(valor<0){
            throw new Exception("El valor "+valor+" es negativo, es inválido");
        }else {
            this.valor = valor;
        }
    }
}