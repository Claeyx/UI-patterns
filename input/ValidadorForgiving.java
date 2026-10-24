package input;

public class ValidadorForgiving {
    public String normalizarTelefono(String entrada) {
        if (entrada == null) return "";

        // Remover espacios, paréntesis, guiones y el símbolo +
        String limpio = entrada.replaceAll("[\\s()\\-\\+]", "");

        // Remover prefijo de país 57 si está presente al inicio
        if (limpio.startsWith("57") && limpio.length() > 10) {
            limpio = limpio.substring(2);
        }

        return limpio;
    }
}