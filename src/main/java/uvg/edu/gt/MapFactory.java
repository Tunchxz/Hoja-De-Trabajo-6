package uvg.edu.gt;

/**
 * La clase MapFactory proporciona un método para obtener una instancia de la
 * interfaz IMap basada en el tipo especificado.
 */
public class MapFactory {

    /**
     * Obtiene una instancia de la interfaz IMap basada en el tipo especificado.
     * 
     * @param tipoMapa El tipo de mapa que se desea obtener ("HashMap", "TreeMap" o
     *                 "LinkedHashMap").
     * @return Una instancia de la interfaz IMap correspondiente al tipo
     *         especificado, o null si el tipo no es válido.
     */
    public IMap getIMap(String tipoMapa) {
        if (tipoMapa == null) {
            return null;
        }
        if (tipoMapa.equalsIgnoreCase("HashMap")) {
            return new MiHashMap();
        } else if (tipoMapa.equalsIgnoreCase("TreeMap")) {
            return new MiTreeMap();
        } else if (tipoMapa.equalsIgnoreCase("LinkedHashMap")) {
            return new MiLinkedHashMap();
        }
        return null;
    }
}