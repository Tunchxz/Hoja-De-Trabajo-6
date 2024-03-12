package uvg.edu.gt;

/**
 * La clase Carta representa una carta de un juego de cartas.
 */
public class Carta {
    private String tipoDeCarta;
    private int cantidad;

    /**
     * Constructor de la clase Carta.
     * 
     * @param tipoDeCarta El tipo de carta que se va a crear.
     */
    public Carta(String tipoDeCarta) {
        this.tipoDeCarta = tipoDeCarta;
        this.cantidad = 1;
    }

    /**
     * Establece el tipo de carta.
     * 
     * @param tipoDeCarta El nuevo tipo de carta.
     */
    public void setTipo(String tipoDeCarta) {
        this.tipoDeCarta = tipoDeCarta;
    }

    /**
     * Establece la cantidad de cartas.
     * 
     * @param cantidad La nueva cantidad de cartas.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el tipo de carta.
     * 
     * @return El tipo de carta.
     */
    public String getTipo() {
        return tipoDeCarta;
    }

    /**
     * Obtiene la cantidad de cartas.
     * 
     * @return La cantidad de cartas.
     */
    public int getCantidad() {
        return cantidad;
    }
}