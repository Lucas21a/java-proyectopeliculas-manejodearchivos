package peliculas.negocio;

import peliculas.datos.*;
import peliculas.domain.Pelicula;
import peliculas.excepciones.AccesoDatosEx;
import peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImp implements ICatalogoPelicula {

    private final IAccesoDatos datos;

    public CatalogoPeliculasImp() {
        this.datos = new AccesoDatosImpl();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_ARCHIVO);
            datos.escribir(pelicula, NOMBRE_ARCHIVO, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_ARCHIVO);
            for (var pelicula : peliculas) {
                System.out.println("Pelicula: " + pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al listar peliculas");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = datos.buscar(NOMBRE_ARCHIVO, buscar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al buscar peliculas");
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado: " + resultado);

    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_ARCHIVO)) {
                datos.borrar(NOMBRE_ARCHIVO);
                datos.crear(NOMBRE_ARCHIVO);
            } else {
                datos.crear(NOMBRE_ARCHIVO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
            ex.printStackTrace(System.out);
        }
    }

}
