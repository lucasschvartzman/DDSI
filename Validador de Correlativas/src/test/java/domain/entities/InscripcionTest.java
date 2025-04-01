package domain.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InscripcionTest {

    Alumno unAlumno;

    Materia algoritmos;
    Materia paradigmas;
    Materia analisis;
    Materia diseno;

    Inscripcion unaInscripcion;

    @BeforeEach
    public void setUp() {

        unAlumno = new Alumno("Lucas","Schvartzman","213.140-8");
        unaInscripcion = new Inscripcion(unAlumno);

        algoritmos = new Materia("Algoritmos y Estructuras de Datos");
        analisis = new Materia("Análisis de Sistemas de Información");
        paradigmas = new Materia("Paradigmas de Programación");
        diseno = new Materia("Diseño de Sistemas de Información");

        paradigmas.addMateriaCorrelativa(algoritmos);

        diseno.addMateriaCorrelativa(paradigmas);
        diseno.addMateriaCorrelativa(analisis);
    }

    @Test
    public void testInscripcionEsValidaParaMateriaSinCorrelativas() {
        unaInscripcion.addMateriaACursar(algoritmos);
        assertTrue(unaInscripcion.estaAprobada());
    }

    @Test
    public void testInscripcionEsInvalidaParaMateriaConCorrelativasNoAprobadas() {
        unaInscripcion.addMateriaACursar(paradigmas);
        assertFalse(unaInscripcion.estaAprobada());
    }

    @Test
    public void testInscripcionEsValidaParaMateriaConCorrelativasAprobadas() {
        unAlumno.addMateriaAprobada(algoritmos);
        unaInscripcion.addMateriaACursar(paradigmas);
        assertTrue(unaInscripcion.estaAprobada());
    }

    @Test
    public void testInscripcionEsValidaParaMateriaConCorrelativasIndirectasAprobadas() {
        unAlumno.addMateriaAprobada(algoritmos);
        unAlumno.addMateriaAprobada(paradigmas);
        unAlumno.addMateriaAprobada(analisis);
        unaInscripcion.addMateriaACursar(diseno);
        assertTrue(unaInscripcion.estaAprobada());
    }
}
