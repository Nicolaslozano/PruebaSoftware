package modelo;

public class Medidor {

    private String idMedidor;
    private double lecturaActual;
    private double lecturaAnterior;
    private double limiteConsumoDiario; // Nuevo límite de consumo diario

    public Medidor(String idMedidor) {
        this.idMedidor = idMedidor;
        this.lecturaActual = 0;
        this.lecturaAnterior = 0;
        this.limiteConsumoDiario = 1000; // Límite de consumo predeterminado
    }

    public void registrarLectura(double nuevaLectura) {
        if (nuevaLectura < 0) {
            throw new IllegalArgumentException("La lectura no puede ser negativa");
        }
        this.lecturaAnterior = this.lecturaActual;
        this.lecturaActual = nuevaLectura;
    }

    public double calcularConsumo() {
        return this.lecturaActual - this.lecturaAnterior;
    }

    // Comprueba si el consumo calculado supera el límite diario
    public boolean excedeLimiteDiario() {
        return calcularConsumo() > limiteConsumoDiario;
    }

    // Restablece las lecturas a cero
    public void resetearLecturas() {
        this.lecturaAnterior = 0;
        this.lecturaActual = 0;
    }

    // Getters y Setters
    public String getIdMedidor() {
        return idMedidor;
    }

    public void setIdMedidor(String idMedidor) {
        this.idMedidor = idMedidor;
    }

    public double getLecturaActual() {
        return lecturaActual;
    }

    public void setLecturaActual(double lecturaActual) {
        this.lecturaActual = lecturaActual;
    }

    public double getLecturaAnterior() {
        return lecturaAnterior;
    }

    public void setLecturaAnterior(double lecturaAnterior) {
        this.lecturaAnterior = lecturaAnterior;
    }

    public double getLimiteConsumoDiario() {
        return limiteConsumoDiario;
    }

    public void setLimiteConsumoDiario(double limiteConsumoDiario) {
        this.limiteConsumoDiario = limiteConsumoDiario;
    }
}
