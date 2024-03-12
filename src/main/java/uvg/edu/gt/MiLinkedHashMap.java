package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * La clase MiLinkedHashMap implementa la interfaz IMap utilizando un
 * LinkedHashMap para almacenar las colecciones de cartas.
 */
public class MiLinkedHashMap implements IMap {
    private Map<String, Carta> coleccionEntera;
    private Map<String, Carta> coleccionUsuario;

    /**
     * Constructor de la clase MiLinkedHashMap.
     * Inicializa las colecciones de cartas como LinkedHashMap.
     */
    public MiLinkedHashMap() {
        this.coleccionEntera = new LinkedHashMap<>();
        this.coleccionUsuario = new LinkedHashMap<>();
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
            coleccionUsuario.entrySet()
                    .stream()
                    .sorted(Comparator.comparing(entry -> entry.getValue().getTipo()))
                    .forEach(entry -> System.out.println("[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: "
                            + entry.getValue().getTipo() + ", Cantidad: " + entry.getValue().getCantidad()));
        } else {
            for (Map.Entry<String, Carta> entry : coleccionUsuario.entrySet()) {
                Carta carta = entry.getValue();
                System.out.println("[Sistema]: Nombre Carta: " + entry.getKey() +
                        ", Tipo: " + carta.getTipo() + ", Cantidad: " + carta.getCantidad());
            }
        }
    }

    @Override
    public void mostrarColeccionEntera(boolean ordenar) {
        if (coleccionEntera.isEmpty()) {
            System.out.println("[Sistema]: No tienes cartas en tu colección.");
        } else if (ordenar) {
            coleccionEntera.entrySet()
                    .stream()
                    .sorted(Comparator.comparing(entry -> entry.getValue().getTipo()))
                    .forEach(entry -> System.out.println("[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: "
                            + entry.getValue().getTipo() + ", Cantidad: " + entry.getValue().getCantidad()));
        } else {
            for (Map.Entry<String, Carta> entry : coleccionEntera.entrySet()) {
                System.out.println("[Sistema]: Nombre Carta: " + entry.getKey() + ", Tipo: "
                        + entry.getValue().getTipo() + ", Cantidad: " + entry.getValue().getCantidad() + ".");
            }
        }
    }
}