package movies.play.contenido;

public class Pelicula extends Contenido {

    public Pelicula(String titulo, int duracion, Genero genero, double calificacion) {
        super(titulo, duracion, genero, calificacion);
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo la pelicula " + getTitulo());

    }

    @Override
    public String obtenerFichaTecnica() {
        return getTitulo() + " (" + getFechaEstreno().getYear() + ")\n" +
                "Género: " + getGenero() + "\n" +
                "Calificación: " + getCalificacion() + "/5";
    }
}
