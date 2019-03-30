package devco.viajes.dominio.entidades;

public class Viaje {

    private int idViaje;
    private String destino;
    private String fechaViaje;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public Viaje() {  }


    public Viaje(int idViaje, String destino, String fechaViaje, String tipo) {
        this.idViaje = idViaje;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.tipo = tipo;
    }


    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(String fechaViaje) {
        this.fechaViaje = fechaViaje;
    }



}
