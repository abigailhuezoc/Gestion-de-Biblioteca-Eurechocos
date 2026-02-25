package bibl;
import java.time.LocalDate;
import java.util.Date;

public class Usuario {
    String nombre;
    String apellido;
    int edad;
    String carnet;
    Date fechaDeNacimiento;
    String correo;
    String numeroCelular;
    String documento;
    String genero;
    LocalDate fechaCreacion;

    public Usuario (String nombre, String apellido, int edad, String carnet, Date fechaDeNacimiento, String correo, String numeroCelular, String documento, String genero, LocalDate fechaCreacion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carnet = carnet;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.documento = documento;
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;

    }

    public void ObtenerInfo (){
        System.out.println("Nombre: " + nombre + " " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Carnet: " + carnet);
    }

}
