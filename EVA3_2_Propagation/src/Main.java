public class Main {
    public static void main(String[] args) {
        System.out.println("Inicia Main");
        A();
        System.out.println("Termina Main");
    }
}
public static void A(){
    System.out.println("Inicia A");
    B();
    System.out.println("Termina A");
}
public static void B(){
    System.out.println("Inicia B");
    C();
    System.out.println("Termina B");
}
public static void C(){
    System.out.println("Inicia C");
    int x=5,y=0, resu;
    resu=x/y;
    System.out.println("Resultado: "+resu);
    System.out.println("Termina C");
}
