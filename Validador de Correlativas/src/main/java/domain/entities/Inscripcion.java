package domain.entities;

import java.util.HashSet;
import java.util.Set;

public class Inscripcion {

    private final Alumno alumno;
    private final Set<Materia> materiasACursar;

    public Inscripcion(Alumno alumno) {
        this.alumno = alumno;
        materiasACursar = new HashSet<Materia>();
    }

    public void addMateriaACursar(Materia materiaACursar) {
        materiasACursar.add(materiaACursar);
    }

    public boolean estaAprobada() {
        return materiasACursar.stream().allMatch(materia ->
        {
            Set<Materia> materiasCorrelativas = materia.getMateriasCorrelativas();
            return materiasCorrelativas.stream().allMatch(this.alumno::tieneAprobada);
        });
    }
}
