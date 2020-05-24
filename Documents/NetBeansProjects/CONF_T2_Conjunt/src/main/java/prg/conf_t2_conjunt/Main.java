/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prg.conf_t2_conjunt;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Main {

    public static void main(String[] args) {

        /*
    public void init() {
        elConjunt = new Conjunt();
        altre = new Conjunt();
    }
         */
        Conjunt elConjunt = new Conjunt();
        Conjunt altre = new Conjunt();

        /*
    @Test
    public void constructorTestSize() {
        assertEquals(0, elConjunt.size());
    }
         */
        // System.out.println("Funcion size()" + elConjunt.size());
        /*    
    @Test
    public void afegirTest() {
        assertEquals(1, elConjunt.afegir(4));
        assertEquals(2, elConjunt.afegir(5));
        assertEquals(2, elConjunt.afegir(4));
    }
         */
        // elConjunt.afegir(4);
        //elConjunt.afegir(5);
        //elConjunt.afegir(4);

        /*
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
         */
 /*
        System.out.println("elConjunt es: " + elConjunt.toString());
        System.out.println("Eliminar elemento 4: " + elConjunt.eliminar(4));
        elConjunt.afegir(4);
        elConjunt.afegir(8);
        elConjunt.afegir(2);
        System.out.println("Eliminar elemento 5, debe ser false " + elConjunt.eliminar(5));
        System.out.println("Eliminar elemento 2, debe ser false " + elConjunt.eliminar(2));
        System.out.println("El tamaño nuevo tiene que ser 2 " + elConjunt.size());
         */
 /*    
    @Test
    public void equalsTest() {
        assertEquals(true, elConjunt.equals(altre));
        elConjunt.afegir(4);
        assertEquals(false, elConjunt.equals(altre));
        elConjunt.afegir(7);
        elConjunt.afegir(3);
        altre.afegir(3);
        altre.afegir(7);
        altre.afegir(4);
        assertEquals(true, elConjunt.equals(altre));
    }
         */
        //System.out.println("elConjunt " + elConjunt.toString());
        //System.out.println("altre " + altre.toString());
        //elConjunt.eliminar(4);
        //elConjunt.eliminar(8);
        //System.out.println("elConjunt " + elConjunt.toString());
        //System.out.println("altre " + altre.toString());
        //System.out.println("elConjunt es el mateix que altre? ha d'eixir true: " + elConjunt.equals(altre));

        /*
            @Test
    public void toStringTest() {
        assertEquals("{}", elConjunt.toString());
        altre.afegir(3);
        altre.afegir(7);
        altre.afegir(4);
        assertEquals("{3, 7, 4}", altre.toString());

    }
         */
 /*
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

        interseccio = elConjunt.interseccio(altre);

        assertEquals(true, interseccio.equals(intereseccioFinal));
        assertEquals(intereseccioFinal, interseccio);
    }
         */
 /*
        System.out.println("");
        System.out.println("INTERSSECIO");
        Conjunt interseccio;

        interseccio = elConjunt.unio(altre);
        //assertEquals(true, interseccio.buit());
        System.out.println("El conjunt de Interseccio " + interseccio);
        int v1[] = {6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4};
        int v2[] = {12, 3, 7, 5, 16, 8};
        int v3[] = {7, 5, 8};
        elConjunt = new Conjunt(v1);
        System.out.println("el conjunt "+ elConjunt.toString());
        altre = new Conjunt(v2);
        System.out.println("altre " +altre.toString());
        Conjunt intereseccioFinal = new Conjunt(v3);
        System.out.println("Conjunt "+intereseccioFinal.toString());
 

        System.out.println("");
        interseccio = elConjunt.interseccio(altre);
        //{6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4} + {12, 3, 7, 5, 16, 8} = {7,5,8}
        System.out.println("INTERSECCIO tiene que ser  {7,5,8} resultado"+ interseccio.toString());
        System.out.println("INTERSECCIO FINAL"+ intereseccioFinal.toString());
        System.out.println("Es igual interseccio a interseccioFinal, es TRUE: "+interseccio.equals(intereseccioFinal) );
         */
        elConjunt = new Conjunt();
        altre = new Conjunt();
        
        System.out.println(elConjunt.equals(altre)); 
        elConjunt.afegir(4);
        System.out.println(elConjunt.equals(altre)); 

        elConjunt.afegir(7);
        elConjunt.afegir(3);
        altre.afegir(3);
        altre.afegir(7);
        altre.afegir(4);
        System.out.println(elConjunt.equals(altre));
        System.out.println("ToString "+ elConjunt.toString());
    }

}
