package es.cic25.proyectoconjunto.proyectoConjunto.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Habito {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private boolean estado;

    private Categoria categoria;

    private LocalDate[] fechasCompletadas;

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

    @Override
    public String toString() {
        return "Habito [id=" + id + ", nombre=" + nombre + ", estado=" + estado  + ", categoria=" + categoria + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    //Método equals que comprueba si dos objetos son el mismo en función de si su id es igual o no
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Habito other = (Habito) obj;
        if (id != other.getId())
            return false;
        return true;
    }
}
