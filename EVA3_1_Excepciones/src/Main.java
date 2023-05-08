public class Main {
    public static void main(String[] args) {
        //Arithmetic exception: Dividir por 0
        System.out.println("Iniciando programa");
        System.out.println("Declarando variables");
        int x=5, y=0;
        System.out.println("Haciendo división");
        int resu=x/y;
        //Se produjo la excepcion y se detuvo el programa
        System.out.println("Resultado: "+resu);

        //inputmismatch exception
        Scanner input = new Scanner(System.in);
        System.out.println("Introduce un número");
        int num= input.nextInt();
        System.out.println("El número es: "+num);

        //Arrayindexoutoutofbounds exception
        int [] arreglo =new int[5]; //Arreglo de 5 posicione
        arreglo[0]=100;
        arreglo[1]=200;
        arreglo[2]=300;
        arreglo[3]=400;
        arreglo[4]=500;
        arreglo[5]=600; // el arreglo va de 0 a 4

        //NullPointerException
        Prueba objprueba= null; //objeto inexistente
        System.out.println("Valor de X: "+objprueba.x);
}

class Prueba{
    int x =100;
}