package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * La clase MiHashMap implementa la interfaz IMap utilizando un HashMap para
 * almacenar las colecciones de cartas.
 */
public class MiHashMap implements IMap {
    private Map<String, Carta> coleccionEntera;
    private Map<String, Carta> coleccionUsuario;

    /**
     * Constructor de la clase MiHashMap.
     * Inicializa las colecciones de cartas.
     */
    public MiHashMap() {
        this.coleccionEntera = new HashMap<>();
        this.coleccionUsuario = new HashMap<>();
    }

    @Override
    public boolean crearColeccion(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 2) {
                    String nombreCarta = parts[0];
                    String tipoDeCarta = parts[1];

                    Carta nuevaCarta = new Carta(tipoDeCarta);

                    coleccionEntera.put(nombreCarta, nuevaCarta);
                }
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarCarta(String nombreCarta) {
        if (coleccionEntera.get(nombreCarta) == null) {
            return false;
        } else if (coleccionUsuario.containsKey(nombreCarta)) {
            Carta cartaExistente = coleccionUsuario.get(nombreCarta);
            cartaExistente.setCantidad(cartaExistente.getCantidad() + 1);
            coleccionUsuario.put(nombreCarta, cartaExistente);
            return true;
        } else {
            Carta nuevaCarta = coleccionEntera.get(nombreCarta);
            coleccionUsuario.put(nombreCarta, nuevaCarta);
            return true;
        }
    }

    @Override
    public String mostrarTipoDeCarta(String nombreCarta) {
        if (coleccionEntera.get(nombreCarta) == null) {
            return "[Sistema]: La carta indicada, no existe.";
        } else {
            return "[Sistema]: El tipo de la carta '" + nombreCarta + "' es: "
                    + coleccionEntera.get(nombreCarta).getTipo();
        }
    }

    @Override
    public void mostrarColeccionUsuario(boolean ordenar) {
        if (coleccionUsuario.isEmpty()) {
            System.out.println("[Sistema]: No tienes cartas en tu colección.");
        } else if (ordenar) {
            boolean hayMonstruos = false;
            boolean hayHhechizos = false;
            boolean hayTtrampas = false;

            System.out.println("[Sistema]: Cartas de Tipo Monstruo: ");
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                if (entry.getValue().getTipo().equals("Monstruo")) {
                    System.out.println(
                            "[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipo());
                    hayMonstruos = true;
                }
            }
            if (!hayMonstruos) {
                System.out.println("[Sistema]: No hay cartas de Tipo Monstruo.\n");
            }

            System.out.println("[Sistema]: Cartas de Tipo Hechizo: ");
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                if (entry.getValue().getTipo().equals("Hechizo")) {
                    System.out.println(
                            "[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipo());
                    hayHhechizos = true;
                }
            }
            if (!hayHhechizos) {
                System.out.println("[Sistema]: No hay cartas de Tipo Hechizo.\n");
            }

            System.out.println("[Sistema]: Cartas de Tipo Trampa: ");
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                if (entry.getValue().getTipo().equals("Trampa")) {
                    System.out.println(
                            "[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipo());
                    hayTtrampas = true;
                }
            }
            if (!hayTtrampas) {
                System.out.println("[Sistema]: No hay cartas de Tipo Trampa.\n");
            }
        } else {
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                System.out.println("[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: "
                        + entry.getValue().getTipo() + ", Cantidad: " + entry.getValue().getCantidad() + ".");
            }
        }
    }

    @Override
    public void mostrarColeccionEntera(boolean ordenar) {
        if (coleccionEntera.isEmpty()) {
            System.out.println("[Sistema]: No tienes cartas en tu colección.");
        } else if (ordenar) {
            boolean hayMonstruos = false;
            boolean hayHhechizos = false;
            boolean hayTtrampas = false;

            System.out.println("[Sistema]: Cartas de Tipo Monstruo: ");
            for (Map.Entry<String, Carta> entry : coleccionEntera.entrySet()) {
                if (entry.getValue().getTipo().equals("Monstruo")) {
                    System.out.println(
                            "[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipo());
                    hayMonstruos = true;
                }
            }
            if (!hayMonstruos) {
                System.out.println("[Sistema]: No hay cartas de Tipo Monstruo.\n");
            }

            System.out.println("[Sistema]: Cartas de Tipo Hechizo: ");
            for (Map.Entry<String, Carta> entry : coleccionEntera.entrySet()) {
                if (entry.getValue().getTipo().equals("Hechizo")) {
                    System.out.println(
                            "[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipo());
                    hayHhechizos = true;
                }
            }
            if (!hayHhechizos) {
                System.out.println("[Sistema]: No hay cartas de Tipo Hechizo.\n");
            }

            System.out.println("[Sistema]: Cartas de Tipo Trampa: ");
            for (Map.Entry<String, Carta> entry : coleccionEntera.entrySet()) {
                if (entry.getValue().getTipo().equals("Trampa")) {
                    System.out.println(
                            "[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: " + entry.getValue().getTipo());
                    hayTtrampas = true;
                }
            }
            if (!hayTtrampas) {
                System.out.println("[Sistema]: No hay cartas de Tipo Trampa.\n");
            }
        } else {
            for (Map.Entry<String, Carta> entry : coleccionEntera.entrySet()) {
                System.out.println("[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: "
                        + entry.getValue().getTipo() + ", Cantidad: " + entry.getValue().getCantidad() + ".");
            }
        }
    }
}