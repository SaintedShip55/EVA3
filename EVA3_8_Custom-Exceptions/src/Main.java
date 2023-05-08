public class Main {
    public static void main(String[] args) {
        Persona per1=new Persona();
        per1.setNombre("Carlos");
        per1.setApellido("Villa");
        try {
            per1.setEdad(-2);
        }catch(DatoIncorrectoCheckException e){
            System.out.println(e.getMessage());
        }
    }
}
class Persona{
    private String nombre;
    private String apellido;
    private int edad;
    public Persona() {
    }
    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        setEdad(edad);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) throws DatoIncorrectoCheckException{
        if(edad<0)
            //throw new DatoIncorrectoException();
            throw new DatoIncorrectoCheckException();
        this.edad = edad;
    }
}
class DatoIncorrectoException extends RuntimeException{
    public DatoIncorrectoException() {
        super("Dato Incorrecto!!, El valor introducido no puede ser negativo");
    }
}
class DatoIncorrectoCheckException extends RuntimeException{
    public DatoIncorrectoCheckException() {
        super("Dato Incorrecto!!, El valor introducido no puede ser negativo");
    }
}



