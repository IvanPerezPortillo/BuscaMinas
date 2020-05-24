/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import prg.conf_t2_conjunt.Conjunt;

/**
 *
 * @author user
 */
public class TestConjunt {

    Conjunt elConjunt, altre;

    @Before
    public void init() {
        elConjunt = new Conjunt();
        altre = new Conjunt();
    }

    @Test
    public void constructorTestSize() {
        assertEquals(0, elConjunt.size());
    }

    @Test
    public void afegirTest() {
        assertEquals(1, elConjunt.afegir(4));
        assertEquals(2, elConjunt.afegir(5));
        assertEquals(2, elConjunt.afegir(4));
    }

    @Test
    public void eliminarTest() {
        assertEquals(false, elConjunt.eliminar(4));
        elConjunt.afegir(4);
        elConjunt.afegir(8);
        elConjunt.afegir(2);
        assertEquals(false, elConjunt.eliminar(5));
        assertEquals(true, elConjunt.eliminar(2));
        assertEquals(2, elConjunt.size());
    }

    @Test
    public void buitTest() {
        assertEquals(true, elConjunt.buit());
        elConjunt.afegir(4);
        assertEquals(false, elConjunt.buit());
        elConjunt.eliminar(4);
        assertEquals(true, elConjunt.buit());
    }

    @Test
    public void equalsTest() {
        assertEquals(true, elConjunt.equals(altre));
        System.out.println("elConjunt "+ elConjunt.toString());
        System.out.println("altre "+ altre.toString());
        elConjunt.afegir(4);
        assertEquals(false, elConjunt.equals(altre));
        elConjunt.afegir(7);
        elConjunt.afegir(3);
        altre.afegir(3);
        altre.afegir(7);
        altre.afegir(4);
        assertEquals(true, elConjunt.equals(altre));
    }

    @Test
    public void toStringTest() {
        assertEquals("{}", elConjunt.toString());
        altre.afegir(3);
        altre.afegir(7);
        altre.afegir(4);
        assertEquals("{3, 7, 4}", altre.toString());

    }

    @Test
    public void unioTest() {
        Conjunt unio;
        unio = elConjunt.unio(altre);

        // la unió de dos buits es buida
        assertEquals(true, unio.buit());
        
        int v1[] = {6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4};
        int v2[] = {12, 3, 7, 5, 16, 8};
        int v3[] = {6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4, 12, 3, 16};

        elConjunt = new Conjunt(v1);
        altre = new Conjunt(v2);
        Conjunt unioFinal = new Conjunt(v3);

        unio = elConjunt.unio(altre);

        assertEquals(true, unio.equals(unioFinal));
        assertEquals(unio, unioFinal);

    }

    @Test
    public void interseccioTest() {
        Conjunt interseccio;

        interseccio = elConjunt.unio(altre);
        assertEquals(true, interseccio.buit());


        int v1[] = {6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4};
        int v2[] = {12, 3, 7, 5, 16, 8};
        int v3[] = {7, 5, 8};

        elConjunt = new Conjunt(v1);
        altre = new Conjunt(v2);
        Conjunt intereseccioFinal = new Conjunt(v3);
        //System.out.println("EL CONJUNT "+ elConjunt.toString());
        interseccio = elConjunt.interseccio(altre);

        assertEquals(true, interseccio.equals(intereseccioFinal));
        assertEquals(intereseccioFinal, interseccio);
    }

    @Test
    public void diferenciaTest() {
        Conjunt diferencia;

        diferencia = elConjunt.diferencia(altre);
        assertEquals(true, diferencia.buit());

        int v1[] = {6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4};
        int v2[] = {12, 3, 7, 5, 16, 8};
        int v3[] = {6, 13, 1, 14, 9, 11, 2, 4};

        elConjunt = new Conjunt(v1);
        altre = new Conjunt(v2);
        Conjunt diferenciaFinal = new Conjunt(v3);

        diferencia = elConjunt.diferencia(altre);

        assertEquals(true, diferencia.equals(diferenciaFinal));
        assertEquals(diferenciaFinal, diferencia);
    }

    @Test
    public void diferenciaSimetricaTest() {
        Conjunt diferenciaSim;

        diferenciaSim = elConjunt.diferenciaSimetrica(altre);
        assertEquals(true, diferenciaSim.buit());

        int v1[] = {6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4};
        int v2[] = {12, 3, 7, 5, 16, 8};
        int v3[] = {6, 13, 1, 14, 9, 11, 2, 4, 12, 3, 16};

        elConjunt = new Conjunt(v1);
        altre = new Conjunt(v2);
        Conjunt diferenciaSimFinal = new Conjunt(v3);

        diferenciaSim = elConjunt.diferenciaSimetrica(altre);

        assertEquals(true, diferenciaSim.equals(diferenciaSimFinal));
        assertEquals(diferenciaSimFinal, diferenciaSim);
    }

    @Test
    public void inscritTest() {

        assertEquals(true, elConjunt.inscrit(altre));

        int v1[] = {6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4};
        int v2[] = {12, 3, 7, 5, 16, 8};

        elConjunt = new Conjunt(v1);
        altre = new Conjunt(v2);
        Conjunt intereseccio = elConjunt.interseccio(altre);

        assertEquals(true, intereseccio.inscrit(elConjunt));
        assertEquals(true, intereseccio.inscrit(altre));
    }

}
