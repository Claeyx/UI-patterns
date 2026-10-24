package content;

public class TarjetaElemento {
    private String nombre;
    private String estado;
    private String ip;
    private int puerto;
    private String ram;
    private boolean verAvanzado;

    public TarjetaElemento(String nombre, String estado, String ip, int puerto, String ram) {
        this.nombre = nombre;
        this.estado = estado;
        this.ip = ip;
        this.puerto = puerto;
        this.ram = ram;
        this.verAvanzado = false;
    }

    public void setVerAvanzado(boolean verAvanzado) {
        this.verAvanzado = verAvanzado;
    }

    public boolean isVerAvanzado() {
        return verAvanzado;
    }

    public void mostrarVista() {
        System.out.println("[Vista Resumen] " + nombre + " | Estado: " + estado);
        if (verAvanzado) {
            System.out.println("[Acordeón Desplegado] IP: " + ip + " | Puerto: " + puerto + " | RAM: " + ram);
        }
    }
}