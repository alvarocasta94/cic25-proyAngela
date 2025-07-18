package es.cic25.proyectoconjunto.proyectoConjunto.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habito {

    // ATRIBUTOS

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public String nombre;
    public String descripcion;
    public LocalDate fechaInicio;
    public boolean estado;

    public Categoria categoria;

    public LocalDate[] fechasCompletadas;

    // Getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public LocalDate[] getFechasCompletadas() {
        return fechasCompletadas;
    }

    public void setFechasCompletadas(LocalDate[] fechasCompletadas) {
        this.fechasCompletadas = fechasCompletadas;
    }
}
