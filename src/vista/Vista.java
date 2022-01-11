package vista;

import java.util.Scanner;
import peliculas.negocio.*;

public class Vista {

    public static void main(String[] args) {

        var opc = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPelicula catalogo = new CatalogoPeliculasImp();

        while (opc != 0) {
            System.out.println("Ingrese una opcion: \n "
                    + "1 . Iniciar catalogo de peliculas\n"
                    + "2. Agregar pelicula\n"
                    + "3. Listar peliculas\n"
                    + "4. Buscar peliculas \n"
                    + "0. Salir\n");
            System.out.println("Ingrese una opcion : ");
            opc = Integer.parseInt(scanner.nextLine());
            switch (opc) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingrese nombre de pelicula:");
                    String nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingrese nombre de pelicula a buscar:");
                    String buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion desconocida. Ingrese una opcion valida");
            }
        }

    }

}
