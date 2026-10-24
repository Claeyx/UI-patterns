package navigation;

import java.util.ArrayList;
import java.util.List;

public class BreadcrumbNavigator {
    private final List<String> ruta;

    public BreadcrumbNavigator() {
        this.ruta = new ArrayList<>();
        this.ruta.add("Inicio");
    }

    public void navegarA(String seccion) {
        this.ruta.add(seccion);
    }

    public void cambiarPestana(String pestana) {
        if (this.ruta.size() > 1) {
            this.ruta.set(this.ruta.size() - 1, pestana);
        } else {
            this.ruta.add(pestana);
        }
    }

    public void regresar() {
        if (this.ruta.size() > 1) {
            this.ruta.remove(this.ruta.size() - 1);
        }
    }

    public String obtenerRutaFormateada() {
        return String.join(" > ", this.ruta);
    }
}