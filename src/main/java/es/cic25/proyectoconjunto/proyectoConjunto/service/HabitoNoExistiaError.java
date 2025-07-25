package es.cic25.proyectoconjunto.proyectoConjunto.service;

public class HabitoNoExistiaError extends RuntimeException {
    public HabitoNoExistiaError() {
        super();
    }

    public HabitoNoExistiaError(String mensaje, Throwable error) {
        super(mensaje, error);
    }

    public HabitoNoExistiaError(String mensaje) {
        super(mensaje);
    }

    public HabitoNoExistiaError(Throwable error) {
        super(error);
    }
}
