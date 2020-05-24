/*
Fer un programa per a resoldre el següent exercici. Llenguatge lliure:

Tenim un vector on hi ha guardat els preus de mercat de cada dia de la setmana d'un producte. 
Volem calcular quin és el major màxim de benefici que pot obtenir un comercial.
Si per exemple el vector és [9, 11, 8, 4, 7, 10] el resultat ha de ser 6, ja que vàrem poder comprar un dia a 4 i 
ho varem poder vendre a 10. Indicar tambe el número de dia en que es va comprar i el dia en que es va vendre 
per a obtenir dit benefici (començant per 0)

Altres exemples:
    [9, 11, 8, 4, 7, 10] retorna 6
    [13, 7, 4, 8, 7, 6] retorna 4
    [4, 7, 2, 6, 7, 6] retorna 5.
    [5, 7, 9, 8, 7, 10] retorna 5.

/**
 * conf_t1
 * @Iván Pérez Portillo
 */
package prg.conf_t1;

import java.util.Arrays;

public class CONF_T1 {

    public static void main(String[] args) {
        //vectores
        int semana1[] = {9, 11, 8, 4, 7, 10};
        int semana2[] = {13, 7, 4, 8, 7, 6};
        int semana3[] = {4, 7, 2, 6, 7, 6};
        int semana4[] = {5, 7, 9, 8, 7, 10};

        //llamada a la funcion
        System.out.println("Resultats; ");
        maxim(semana1);
        maxim(semana2);
        maxim(semana3);
        maxim(semana4);
    }

    public static void maxim(int vector[]) {
        int minimo = 99999999;
        int posMin = -9999999;

        int maximo = -1;
        int posMax = -1;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < minimo) {
                minimo = vector[i];
                posMin = i;
            }
        }

        for (int i = posMin; i < vector.length; i++) {
            if (vector[i] > maximo) {
                maximo = vector[i];
                posMax = i;
            }
        }
        //no sumo a la salida +1 ya que dice que empieza de 0 que es lunes y 5 es sábado.
        System.out.println(Arrays.toString(vector) + ". Retorna " + (maximo - minimo) + ". La compra es del dia " + (posMin) + " y la venta del dia " + (posMax));

    }
}
