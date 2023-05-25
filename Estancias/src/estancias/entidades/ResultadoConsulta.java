
package estancias.entidades;

public class ResultadoConsulta {

    private String pais;
    private int cantidad;

    public ResultadoConsulta() {
    }

    public ResultadoConsulta(String pais, int cantidad) {
        this.pais = pais;
        this.cantidad = cantidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    

    
    
}
