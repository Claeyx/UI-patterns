import navigation.BreadcrumbNavigator;
import content.TarjetaElemento;
import input.ValidadorForgiving;
import state.GestorSesionUI;

public class Main {
    public static void main(String[] args) {
        System.out.println(" TALLER UI PATTERNS Y ÉTICA EN INTERFACES DE USUARIO");

        System.out.println("--- CASO 1: NAVEGACIÓN (BREADCRUMBS + TABS) ---");
        BreadcrumbNavigator nav = new BreadcrumbNavigator();
        nav.navegarA("Catálogo");
        nav.navegarA("Servidor Principal");
        System.out.println("Ruta actual: " + nav.obtenerRutaFormateada());
        System.out.println();

        System.out.println("--- CASO 2: CONTENIDO (PROGRESSIVE DISCLOSURE) ---");
        TarjetaElemento tarjeta = new TarjetaElemento("Servidor Principal", "Activo", "192.168.1.10", 8080, "4GB/16GB");

        System.out.println("-> Estado inicial (verAvanzado = false):");
        tarjeta.mostrarVista();

        System.out.println("\nUsuario solicita ver detalles avanzados...");
        tarjeta.setVerAvanzado(true);
        tarjeta.mostrarVista();
        System.out.println();

        System.out.println("--- CASO 3: ENTRADA DE DATOS (FORGIVING FORMAT) ---");
        ValidadorForgiving validador = new ValidadorForgiving();
        String entradaTelefono = "+57 (310) 999-8877";
        String telefonoNormalizado = validador.normalizarTelefono(entradaTelefono);

        System.out.println("Entrada del usuario: \"" + entradaTelefono + "\"");
        System.out.println("Teléfono normalizado sin error: \"" + telefonoNormalizado + "\"");
        System.out.println();

        System.out.println("--- CASO 4: FEEDBACK Y ESTADO (COMPLETENESS METER) ---");
        GestorSesionUI gestor = new GestorSesionUI();

        String campo1 = "Laboratorio de Redes";
        String campo2 = "3109998877";
        String campo3 = null;

        int progreso2 = gestor.calcularPorcentajeProgreso(campo1, campo2, campo3);
        System.out.println("[Progreso: " + progreso2 + "%] Campos listos: 2 de 3 (Falta: Correo de contacto)");

        System.out.println("Usuario ingresa correo: \"estudiante@udistrital.edu.co\"");
        campo3 = "estudiante@udistrital.edu.co";
        int progreso3 = gestor.calcularPorcentajeProgreso(campo1, campo2, campo3);
        System.out.println("[Progreso: " + progreso3 + "%] Formulario completado");
        System.out.println();

        System.out.println("--- CASO 5: LAZY REGISTRATION + TOAST ---");
        System.out.println("Usuario intenta guardar sin haber iniciado sesión...");
        gestor.guardarReserva("Reserva de Equipos de Redes");

        System.out.println("\nUsuario completa registro rápido -> Sesión activa = true");
        gestor.setUsuarioActivo(true);
        gestor.guardarReserva("Reserva de Equipos de Redes");
        System.out.println();
    }
}