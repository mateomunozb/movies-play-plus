package movies.play.contenido;

public class Documental extends Contenido implements Promocionable {
    private String narrador;

    public Documental(String titulo, int duracion, Genero genero, double calificacion, String narrador) {
        super(titulo, duracion, genero, calificacion);
        this.narrador = narrador;
    }

    public Documental(String titulo, int duracion, Genero genero) {
        super(titulo, duracion, genero);
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo el documental " + getTitulo() + " narrador por " + getNarrador());
    }

    @Override
    public String obtenerFichaTecnica() {
        return getTitulo() + " (" + getFechaEstreno().getYear() + ")\n" +
                "Género: " + getGenero() + "\n" +
                "Calificación: " + getCalificacion() + "/5\n" +
                "Narrador: " + getNarrador();
    }

    @Override
    public String promocionar() {
        return "💥 Descubre el documental " + this.getTitulo() + " narrado por " + getNarrador() + ". ¡Ahora en Movies Play!";
    }

    public String getNarrador() {
        return narrador;
    }
}
