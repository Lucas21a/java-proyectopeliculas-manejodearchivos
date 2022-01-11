package peliculas.negocio;

public interface ICatalogoPelicula {
    String NOMBRE_ARCHIVO ="peliculas.txt";
    void agregarPelicula(String nombrePelicula );
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarCatalogoPeliculas();
    
}
