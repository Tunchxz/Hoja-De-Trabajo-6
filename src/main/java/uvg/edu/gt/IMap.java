package uvg.edu.gt;

/**
 * La interfaz IMap proporciona métodos para la gestión de una colección de
 * cartas.
 */
public interface IMap {

    /**
     * Crea una colección de cartas a partir de un archivo.
     * 
     * @param filename El nombre del archivo que contiene la colección de cartas.
     * @return true si la colección se creó correctamente, false en caso contrario.
     */
    public boolean crearColeccion(String filename);

    /**
     * Agrega una carta a la colección.
     * 
     * @param nombreCarta El nombre de la carta que se va a agregar.
     * @return true si la carta se agregó correctamente, false en caso contrario.
     */
    public boolean agregarCarta(String nombreCarta);

    /**
     * Muestra el tipo de carta de una carta específica.
     * 
     * @param nombreCarta El nombre de la carta de la cual se quiere conocer el
     *                    tipo.
     * @return El tipo de carta de la carta especificada.
     */
    public String mostrarTipoDeCarta(String nombreCarta);

    /**
     * Muestra la colección de cartas del usuario.
     * 
     * @param ordenar Indica si se debe ordenar la colección antes de mostrarla.
     */
    public void mostrarColeccionUsuario(boolean ordenar);

    /**
     * Muestra la colección completa de cartas.
     * 
     * @param ordenar Indica si se debe ordenar la colección antes de mostrarla.
     */
    public void mostrarColeccionEntera(boolean ordenar);
}