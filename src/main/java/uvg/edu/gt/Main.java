package uvg.edu.gt;

import java.util.Scanner;

/**
 * Esta clase representa el punto de entrada principal para el programa.
 * Proporciona un menú interactivo para que los usuarios interactúen con las
 * implementaciones de mapa.
 * 
 * @author Cristian Túnchez, Javier Linares
 * @version 1.0
 * @since 12/03/2024
 */
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        MapFactory fabrica = new MapFactory();
        IMap implementacion = null;
        boolean primerMenu = true;
        boolean segundoMenu = true;

        while (primerMenu) {
            System.out.println(
                    "\n[Sistema]: ¿Qué implementación de Map te gustaría usar?\n1. HashMap\n2. TreeMap\n3. LinkedHashMap");
            String opcion = entrada.nextLine();

            switch (opcion) {
                case "1": {
                    opcion = "HashMap";
                    implementacion = fabrica.getIMap(opcion);
                    if (implementacion.crearColeccion("HDT6-AED\\src\\main\\java\\uvg\\edu\\gt\\cards_desc.txt")) {
                        System.out.println("[Sistema]: Colección cargada desde el archivo correctamente.");
                        primerMenu = false;
                    } else if (!implementacion
                            .crearColeccion("HDT6-AED\\src\\main\\java\\uvg\\edu\\gt\\cards_desc.txt")) {
                        System.out.println("[Sistema]: No se pudo cargar la colección del archivo.");
                        primerMenu = false;
                        segundoMenu = false;
                    }
                    break;
                }
                case "2": {
                    opcion = "TreeMap";
                    implementacion = fabrica.getIMap(opcion);
                    if (implementacion.crearColeccion("HDT6-AED\\src\\main\\java\\uvg\\edu\\gt\\cards_desc.txt")) {
                        System.out.println("[Sistema]: Colección cargada desde el archivo correctamente.");
                        primerMenu = false;
                    } else if (!implementacion
                            .crearColeccion("HDT6-AED\\src\\main\\java\\uvg\\edu\\gt\\cards_desc.txt")) {
                        System.out.println("[Sistema]: No se pudo cargar la colección del archivo.");
                        primerMenu = false;
                        segundoMenu = false;
                    }
                    break;
                }
                case "3": {
                    opcion = "LinkedHashMap";
                    implementacion = fabrica.getIMap(opcion);
                    if (implementacion.crearColeccion("HDT6-AED\\src\\main\\java\\uvg\\edu\\gt\\cards_desc.txt")) {
                        System.out.println("[Sistema]: Colección cargada desde el archivo correctamente.");
                        primerMenu = false;
                    } else if (!implementacion
                            .crearColeccion("HDT6-AED\\src\\main\\java\\uvg\\edu\\gt\\cards_desc.txt")) {
                        System.out.println("[Sistema]: No se pudo cargar la colección del archivo.");
                        primerMenu = false;
                        segundoMenu = false;
                    }
                    break;
                }
                default: {
                    System.out.println("[Sistema]: Por favor, selecciona una implmentación válida.");
                    break;
                }
            }
        }
        while (segundoMenu) {
            System.out.println(
                    "\n[Sistema]: ¿Qué desea realizar?\n1. Agregar una carta a mi colección\n2. Mostrar el tipo de una carta específica\n3. Mostrar el nombre, tipo y cantidad de cada carta que hay en mi colección\n4. Mostrar el nombre, tipo y cantidad de cada carta en mi colección (ordenadas por tipo)\n5. Mostrar el nombre y tipo de todas las cartas existentes\n6. Mostrar el nombre y tipo de todas las cartas existentes (ordenadas por tipo)\n7. Salir");
            String opcion = entrada.nextLine();
            switch (opcion) {
                case "1": {
                    System.out
                            .println("\n[Sistema]: Ingresa el nombre de la carta que deseas agregar a tu colección: ");
                    String nombreCarta = entrada.nextLine();
                    if (implementacion.agregarCarta(nombreCarta)) {
                        System.out.println("[Sistema]: La carta se ha agregado con éxito a tu colección.");
                    }
                    System.out.println("[Sistema]: No existe esa carta en la colección general.");
                    break;
                }
                case "2": {
                    System.out
                            .println("\n[Sistema]: Ingresa el nombre de la carta que deseas buscar en la colección: ");
                    String nombreCarta = entrada.nextLine();
                    System.out.println(implementacion.mostrarTipoDeCarta(nombreCarta));
                    break;
                }
                case "3": {
                    implementacion.mostrarColeccionUsuario(false);
                    break;
                }
                case "4": {
                    implementacion.mostrarColeccionUsuario(true);
                    break;
                }
                case "5": {
                    implementacion.mostrarColeccionEntera(false);
                    break;
                }
                case "6": {
                    implementacion.mostrarColeccionEntera(true);
                    break;
                }
                case "7": {
                    segundoMenu = false;
                    break;
                }
                default: {
                    System.out.println("[Sistema]: Por favor, selecciona una opción válida del menú.");
                }
                    break;
            }
        }
        entrada.close();
    }
}