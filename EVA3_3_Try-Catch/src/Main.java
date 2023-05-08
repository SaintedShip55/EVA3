public class Main {
    public static void main(String[] args) {
        System.out.println("Inicia programa");
        int x=5,y=1;
        try {
            int resu = x / y;
            System.out.println("Resultado = " + resu);
        }catch(ArithmeticException a){
            System.out.println("Se produjo un error: "+a.getMessage());
        }
        System.out.println("Programa terminado");

    }
}