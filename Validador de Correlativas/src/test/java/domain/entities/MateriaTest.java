package domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

// Como la clase no tiene mucho, solo pruebo agregar una correlativa.
public class MateriaTest {

    Materia unaMateria;
    Materia materiaCorrelativa;

    @BeforeEach
    void setUp() {
        unaMateria = new Materia("Una materia");
        materiaCorrelativa = new Materia("Materia correlativa");
    }

    @Test
    public void testAddMateriaCorrelativa() {
        unaMateria.addMateriaCorrelativa(materiaCorrelativa);
        assertTrue(unaMateria.getMateriasCorrelativas().contains(materiaCorrelativa));
    }
}
