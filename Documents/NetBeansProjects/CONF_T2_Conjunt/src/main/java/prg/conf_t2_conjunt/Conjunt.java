/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prg.conf_t2_conjunt;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author: Iván Pérez Portillo
 */
public class Conjunt {

    private ArrayList<Integer> numeros; //array para objeto conjunt tipo Integer

    //1. constructor un conjunt→ Es crearà el conjunt buit, aquell que no te elements
    public Conjunt() {
        this.numeros = new ArrayList<>();
    }

    //2. constructor de còpia, a partir d’altre conjunt ja creat.
    public Conjunt(Conjunt altre) {
        this.numeros = altre.numeros;
    }

    //3. constructor(int[])a partir d’un array d’enters. Fixar-se que no poden haver 
    //elements repetits. Cas de hi haure no donarà error, però evitarà duplicats.not
    public Conjunt(int numero[]) {
        if (this.numeros == null) {//si no existe la array la creo
            this.numeros = new ArrayList<>();
        }
        for (int i : numero) {
            if (!this.numeros.contains(i)) {//si no contiene el elemento
                this.numeros.add(i);//lo agrego
            }
        }

    }

    //4. size→retorna el número d’elements del conjunt. Per exemple Q.size()=6
    public int size() {
        if (this.numeros != null) { // si la array no es nula
            int resultado = this.numeros.size();//agrego el tamaño a resultado
            return resultado;
        } else {// si es null devuelve 0
            return 0;
        }
    }

    //5. contains(element)→retorna un boolean indicant si l’element pertany o no al conjunt. 
    // Per exemple Q.contains(8)=true,Q.contains(4)=false.
    public boolean contains(int element) {
        if (this.numeros == null) {// si es nulo 
            return false;
        }
        return this.numeros.contains(element);
    }

    //6. afegir(element)→afig el element al nostre conjunt, cas de no estar ja. 
    //Retorna el número d’elements del conjunt un cop afegit el nom element o el que tenia.
    public int afegir(int element) {
        if (this.numeros == null) { // si es nulo esta vacio
            this.numeros = new ArrayList<>();//creo array
            this.numeros.add(element);//añado los elementos
        }
        if (!this.numeros.contains(element)) { //si la array no lo contiene
            this.numeros.add(element);//añado el elemento
        }
        return size();//llamo a size() y devuelvo el tamaño
    }

    //7. eliminar(element)→elimina, cas d’estar el element. Retorna true si ha pogut eliminar-se 
    //o false en cas contrari.
    public boolean eliminar(int element) {
        if (this.numeros == null) {// si es nulo o vacio
            return false;
        }
        if (this.numeros.contains(element)) {// si lo contiene lo quito
            this.numeros.remove((Integer) element);// realizo un casting ya que el método está sobrecargado
            return true;
        } else {//ya no lo contiene
            return false;
        }

    }

    //8. esBuit→ens diu si el conjunt està buit. Retorna un booleà. Per exempleP.esBuit()=false,R.esBuit()=true
    public boolean buit() {
        /*
        if (this.numeros == null) {
            return true;
        }
        if (this.numeros.size() > 0) {//si tiene algún número introducido
            return false;
        } else {//si no tiene nada está vacio
            return true;
         */
        return this.numeros.size() <= 0; //si es 0 o < en true

    }
    //9. equals(Conjunt)→ens diu si un conjunt és igual o no respecte a altre donat
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.numeros);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Conjunt other = (Conjunt) obj;
        for (int i = 0; i < this.numeros.size(); i++) {//todos los elements iguales
            if (!other.numeros.contains(this.numeros.get(i))) {//si hay alguno diferente es false
                return false;
            }

        }
        return true;
    }

    //10. toString()→el mostra per pantalla, separant els elements per comes i tancats entre claus.
    @Override
    public String toString() {
        String res = "{";
        for (int i = 0; i < numeros.size(); i++) {
            res += numeros.get(i);
            if (i < numeros.size() - 1) {// hasta que llegue al final de la array
                res += ", ";
            }
        }
        res += "}";
        return res;

    }

    //11. unio(Conjunt)→crea un nou conjunt amb tots els elements del primer i del que passem com argument. 
    //Per exemple P.unio(Q)={6, 13, 1, 7, 14, 5, 9, 11, 8, 2, 4, 12, 3,16}
    /*
    public void unio(Conjunt altre) {
        if (this.numeros == null) {// si es nulo lo creo
            this.numeros = new ArrayList<>();
        }
        if (altre.numeros == null) {// si altre no tiene números salgo
            return;
        }
        for (int i = 0; i < altre.numeros.size(); i++) {
            if (!this.numeros.contains(altre.numeros.get(i))) {//si mi lista no contiene el número de altre
                this.numeros.add(altre.numeros.get(i));// lo meto en mi lista
            }
        }
    }
     */
    //funcion unio
    public Conjunt unio(Conjunt altre) {
        Conjunt salida = new Conjunt(this);//creo objeto de union

        for (int i = 0; i < altre.numeros.size(); i++) {
            if (!this.numeros.contains(altre.numeros.get(i))) {//si elConjunt no contiene de altre
                salida.numeros.add(altre.numeros.get(i));// lo meto salida
            }
        }
        return salida;

    }

    //12. interseccio(Conjunt)→crea un nou conjunt amb els elements que pertanyen a els dos conjnts. 
    //Per exemple P.interseccio(Q)={7,5,8}
    public Conjunt interseccio(Conjunt altre) {
        Conjunt salida = new Conjunt();//creo objeto de interseccio
        for (int i = 0; i < this.numeros.size(); i++) {
            if (altre.numeros.contains(this.numeros.get(i))) {//si altre contiene conjunt
                salida.numeros.add(this.numeros.get(i));
            }
        }
        return salida; // devuelvo conjunto nuevo
    }

    //13. diferencia(Conjunt)→crea un nou conjunt amb els element que pertanyan al primer conjunt però no al segon,
    // com si fora una resta.  Per exemple P.diferencia(Q)={6,13,1,14,9,11,2,4}
    public Conjunt diferencia(Conjunt altre) {
        Conjunt salida = new Conjunt();// nuevo conjunto
        for (int i = 0; i < this.numeros.size(); i++) {
            if (!altre.numeros.contains(this.numeros.get(i))) {//si es diferente Conjunt están en altre
                salida.numeros.add(this.numeros.get(i));
            }
        }
        return salida;

    }

    //14. diferenciaSimetrica(Conjunt)→crea un nou conjunt amb els elemnts que pertanyan alprimer conjunt però no 
    //al segon, afegint-li els que pertanyan al segon conjunt però no al primer. P.diferenciaSimetrica(Q)={6,13,1,14,9,11,2,4,12,3,16}. 
    //De manera senzilla la diferència simètrica és la unió menys la intersecció
    public Conjunt diferenciaSimetrica(Conjunt altre) {
        Conjunt salida = new Conjunt();
        for (int i = 0; i < this.numeros.size(); i++) {
            if (!altre.numeros.contains(this.numeros.get(i))) {
                salida.numeros.add(this.numeros.get(i));
            }
        }
        for (int i = 0; i < altre.numeros.size(); i++) {
            if (!this.numeros.contains(altre.numeros.get(i))) {
                salida.numeros.add(altre.numeros.get(i));
            }
        }

        return salida;
    }

    //15. inscrit(Conjunt)→retorna un boolea quan el primAbril20er conjunt està dins del passat com argument, és a dir, 
    //quan tots els elements del conjunt pertanyen al segon conjunt també. Per exemple T.inscrit(P)=true,Q.inscrit(P)=false,T.inscrit(Q)=true
    public boolean inscrit(Conjunt altre) {
        boolean encontrado = false;
        if (this.numeros == null) {//si está vacio es false
            return false;
        }
        for (int i = 0; i < this.numeros.size(); i++) {
            encontrado = false;
            for (int j = 0; j < altre.numeros.size(); j++) {
                if (this.numeros.get(i) == altre.numeros.get(j)) {
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                return false;
            }
        }
        return true;

    }
}//FIN

