package state;

public class GestorSesionUI {
    private boolean usuarioActivo;
    private String borradorReserva;

    public GestorSesionUI() {
        this.usuarioActivo = false;
        this.borradorReserva = null;
    }

    public void setUsuarioActivo(boolean usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }

    // Calcula el Completeness Meter (0%, 33%, 67%, 100%)
    public int calcularPorcentajeProgreso(String campo1, String campo2, String campo3) {
        int completados = 0;
        if (campo1 != null && !campo1.trim().isEmpty()) completados++;
        if (campo2 != null && !campo2.trim().isEmpty()) completados++;
        if (campo3 != null && !campo3.trim().isEmpty()) completados++;

        switch (completados) {
            case 1: return 33;
            case 2: return 67;
            case 3: return 100;
            default: return 0;
        }
    }

    // Lazy Registration + Toast
    public void guardarReserva(String datosReserva) {
        if (!usuarioActivo) {
            this.borradorReserva = datosReserva;
            System.out.println("Por favor cree su cuenta o inicie sesión para finalizar.");
        } else {
            this.borradorReserva = null;
            mostrarToast("Reserva guardada.");
        }
    }

    public void mostrarToast(String mensaje) {
        System.out.println("[Toast de Estado] " + mensaje);
    }
}