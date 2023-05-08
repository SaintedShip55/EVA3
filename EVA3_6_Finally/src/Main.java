public class Main {
    public static void main(String[] args) {
        int x=5, y=1;
        try{
            int resu=x/y;
        }catch (ArithmeticException b){
            System.out.println(b.getMessage());
        }finally{
            System.out.println("Siempre me ejecuto");
        }
        System.out.println("Fin del programa");
    }
}