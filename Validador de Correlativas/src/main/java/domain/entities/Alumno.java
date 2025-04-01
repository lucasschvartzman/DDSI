package domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Alumno {

    private final String nombre;
    private final String apellido;
    private final String legajo;

    private final Set<Materia> materiasAprobadas;

    public Alumno(String nombre, String apellido, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new HashSet<Materia>();
    }

    public void addMateriaAprobada(Materia materia) {
        this.materiasAprobadas.add(materia);
    }

    public boolean tieneAprobada(Materia materia) {
        return this.materiasAprobadas.contains(materia);
    }
}
