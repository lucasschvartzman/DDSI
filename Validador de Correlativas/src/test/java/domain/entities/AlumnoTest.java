package domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlumnoTest {

    private Alumno unAlumno;
    private Materia unaMateria;

    @BeforeEach
    public void setUp() {
        unAlumno = new Alumno("Lucas","Schvartzman","213.140-8");
        unaMateria = new Materia("Materia Genérica");
        unAlumno.addMateriaAprobada(unaMateria);
    }

    @Test
    public void testTieneAprobadaMateria() {
        assertTrue(unAlumno.tieneAprobada(unaMateria));
    }

    @Test
    public void testNoTieneAprobadaMateria() {
        Materia otraMateria = new Materia("Otra Materia");
        assertFalse(unAlumno.tieneAprobada(otraMateria));
    }
}
