package movies.play.plataforma;

import movies.play.contenido.Genero;
import movies.play.contenido.Pelicula;
import movies.play.contenido.ResumenContenido;
import movies.play.excepcion.PeliculaExistenteException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido;

    public Plataforma(String nombre) {
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregar(Pelicula elemento) {
        Pelicula contenido = this.buscarPorTitulo(elemento.getTitulo());

        if (contenido != null) {
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        this.contenido.add(elemento);
    }

    public List<String> getTitulos() {
         return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();
    }

    public List<ResumenContenido> getResumenes() {
        return contenido.stream()
                .map(c -> new ResumenContenido(c.getTitulo(), c.getDuracion(), c.getGenero()))
                .toList();
    }

    public void eliminar(Pelicula elemento) {
        this.contenido.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo) {
        return contenido.stream()
                .filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);

    }

    public List<Pelicula> buscarPorGenero(Genero genero) {
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<Pelicula> getPopulares(int cantidad) {
        return contenido.stream()
                .sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public int getDuracionTotal() {
        return contenido.stream().mapToInt(Pelicula::getDuracion).sum();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }
}
