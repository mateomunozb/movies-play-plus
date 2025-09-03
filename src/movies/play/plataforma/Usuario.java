package movies.play.plataforma;

import movies.play.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    private String nombre;
    private String email;
    private LocalDateTime fechaRegistro;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        this.fechaRegistro = LocalDateTime.now();
    }

    public void ver(Pelicula pelicula) {
        System.out.println(nombre + " esta viendo...");
        pelicula.reproducir();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
