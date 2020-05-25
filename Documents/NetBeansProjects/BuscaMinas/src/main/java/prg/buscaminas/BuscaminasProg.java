package prg.buscaminas;

/**
 *
 * @author Iván Pérez
 */
//Librerias
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;

public class BuscaminasProg {

    public static void main(String args[]) {

        /**
         * Programa principal Inicio matrices, tablero y visible Muestro tablero
         * Pido fila y columna a destapar Comprueba tablero Si comprobación es
         * =-1 mina, Game Over Hasta que se destapen todas las casillas, ganado
         */
        //Matrices
        int tablero[][];
        boolean visible[][];
        tablero = new int[10][10];
        visible = new boolean[10][10];
        //Variables
        int colum;
        int fila;
        int resultado;

        //inicio los tableros
        inicializartablero(tablero, visible);

        //Marcar o destapar
        String marcarDestapar;

        do {
            marcarDestapar = leerTexto("¿Quieres destapar o marcar una casilla? (d/m):  ");
            if (marcarDestapar.equalsIgnoreCase("d") || marcarDestapar.equalsIgnoreCase("m")) {
                break;
            }
            System.out.println("!Tienes que decir d para destapar y m para marcar");
        } while (true);

        do {
            escribirtablero(tablero, visible);
            // Pedir fila y columna de casilla a destapar
            do {
                fila = leerEntero("Elige fila: ");
            } while (!(fila >= 0 && fila <= 9));
            do {
                colum = leerEntero("Elige columna: ");
            } while (!(colum >= 0 && colum <= 9));
            // Comprobamos el tablero
            resultado = compruebatablero(tablero, visible, fila, colum);
            System.out.println("");
        } while (!(resultado == -1 || resultado == 88));
        escribirtablero(tablero, visible);
        // Has destapado una mina
        if (resultado == -1) {
            System.out.println("¡¡¡EXPLOTO!!! ¡¡¡MINA!!!");
            System.out.println("GAME OVER");

            // has destapado todas las casillas
        } else {
            System.out.println("¡Enhorabuena!");
            System.out.println("¡Has ganado!");
        }

    }//fin main

    //FUNCIONES
    /**
     * Funcion max: Cálcula el máximo de dos números
     */
    public static int max(int num1, int num2) {
        int num;

        if (num1 > num2) {
            num = num1;
        } else {
            num = num2;
        }
        return num;
    }

    /**
     * Funcion min: Cálcula el mínimo de dos números
     */
    public static int min(int num1, int num2) {
        int num;

        if (num1 < num2) {
            num = num1;
        } else {
            num = num2;
        }
        return num;
    }

    /**
     * Funcion InicializarTablero: recibe dos matrices, tablero , visible.
     * Inicio tablero a 0 Inicio visible a falso, todas las celdas están ocultas
     */
    public static void inicializartablero(int tablero[][], boolean visible[][]) {
        int colum;
        int fila;
        // Incializo el tablero con valor 0
        for (fila = 0; fila <= 9; fila++) {
            for (colum = 0; colum <= 9; colum++) {
                tablero[fila][colum] = 0;
            }
        }
        ponerminas(tablero);
        // Incializo la tabla visible a falso indicando que ninguna celda está descubierta
        for (fila = 0; fila <= 9; fila++) {
            for (colum = 0; colum <= 9; colum++) {
                visible[fila][colum] = false;
            }
        }
    }

    /**
     * Funcion ponerminas: recibe tablero de [10][10] Genera 12 minas con valor
     * 9 ya que que como máximo una mina puede tener alrededor de 1 a 8 por lo
     * que 9 es mina Asegura que pone 12 minas. Cuando pone 1 mina incrementa en
     * 1 el valor de las celdas contiguas, si no son mina.
     */
    public static void ponerminas(int tablero[][]) {
        int colum;
        int colum2;
        int fila;
        int fila2;
        int num_minas;
        num_minas = 0;
        Random random = new Random();
        // Vamos a poner 12 minas en el tablero
        while (num_minas < 12) {
            // Me aseguro que no haya ya una mina en la posición que se genera aleatoriamente
            do {
                fila = random.nextInt(9);
                colum = random.nextInt(9);
            } while (tablero[fila][colum] == 9);
            // Reperesentamos la mina con el número 9
            tablero[fila][colum] = 9;
            // Ahora incremento el número de minas cercanas en las casillas vecinas
            for (fila2 = max(0, fila - 1); fila2 <= min(9, fila + 1); fila2++) {
                for (colum2 = max(0, colum - 1); colum2 <= min(9, colum + 1); colum2++) {
                    if (tablero[fila2][colum2] != 9) {
                        tablero[fila2][colum2] = tablero[fila2][colum2] + 1;
                    }
                }
            }
            num_minas = num_minas + 1;
        }
    }

    /**
     * Función Destaparcelda: recibe las dos tablas fila y col que ha de
     * destapar. La posición de la tabla visible tiene que ser false para poder
     * destapar. Se destapa la posición de la tabla visible a verdadero Si no
     * hay minas cerca tiene que intentar destapar las vecinas Si la celda no es
     * una mina la destapo, recursividad.
     */
    public static void destaparcelda(int tablero[][], boolean visible[][], int fila, int colum) {
        int colum2;
        int fila2;
        // Si es una casilla que se puede destapar
        if (visible[fila][colum] == false) {
            visible[fila][colum] = true;
            // Si no hay minas cerca tengo que intentar destapar las vecinas
            if (tablero[fila][colum] == 0) {
                for (fila2 = max(0, fila - 1); fila2 <= min(9, fila + 1); fila2++) {
                    for (colum2 = max(0, colum - 1); colum2 <= min(9, colum + 1); colum2++) {
                        if (tablero[fila2][colum2] != 9) {
                            destaparcelda(tablero, visible, fila2, colum2);
                        }
                    }
                }
            }
        }
    }

    /**
     * Función marcar: marca la celda seleccionada ya que al parecer tiene mina
     */
    public static void marcar(int tablero[], boolean visible[][], int fila, int colum) {
        int colum2;
        int fila2;
        
        
    }

    /**
     * Función contarCeldasDestapadas: recible tabla visible Recorre y cuenta
     * los valores true, se devuelve Si el contador es 88 todas destapadas, han
     * ganado.
     */

    public static int contarceldasdestapadas(boolean visible[][]) {
        int colum;
        int fila;
        int contador = 0;

        for (fila = 0; fila <= 9; fila++) {
            for (colum = 0; colum <= 9; colum++) {
                if (visible[fila][colum]) {
                    contador = contador + 1;
                }
            }
        }
        return contador;
    }

    /**
     * Funcion compruebaTablero, recibe las dos matrices y la fila y colum que
     * se va a destapar. Si la posicion es mina =9 devolverá -1, perdió. Si no
     * se destapa la casilla y cuenta las casillas destapadas.
     */
    public static int compruebatablero(int tablero[][], boolean visible[][], int fila, int colum) {
        int resultado;
        // Si es una mina devuelvo -1
        if (tablero[fila][colum] == 9) {
            // Destapar celda
            visible[fila][colum] = true;
            resultado = -1;
        } else {
            destaparcelda(tablero, visible, fila, colum);
            resultado = contarceldasdestapadas(visible);
        }
        return resultado;
    }

    /**
     * Funcion escribirtablero: dos matrices, recorre las tablas y las muestra.
     * Según valores: 1. Si está destapada true 2. Sin minas alrededor valor=0
     * mostrar hueco 3. Si no mostrar el valor de la casilla. Indica cuantas
     * minas 4. Posición no visible X
     */
    public static void escribirtablero(int tablero[][], boolean visible[][]) {
        int colum;
        int fila;
        String tituloColum;
        String tituloFilas;
        tituloFilas = "0123456789";
        tituloColum = "    0 1 2 3 4 5 6 7 8 9";
        System.out.println(tituloColum);
        System.out.println("");
        // Recorro las tablas
        for (fila = 0; fila <= 9; fila++) {
            System.out.print(tituloFilas.substring(fila, fila + 1) + "   ");
            for (colum = 0; colum <= 9; colum++) {
                // está destapada
                if (visible[fila][colum]) {
                    // Sin minas alrededor
                    if (tablero[fila][colum] == 0) {
                        System.out.print("  ");
                    } else {
                        // Mina
                        if (tablero[fila][colum] == 9) {
                            System.out.print("* ");
                            // muestro el número de minas 
                        } else {
                            System.out.print(tablero[fila][colum] + " ");
                        }
                    }
                    // La casilla no es visible
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println("");
        }
    }

    //LEER
    private final static BufferedReader entradaConsola
            = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

    public static String leerTexto(String mensaje) {
        String respuesta = null;
        do {
            try {
                System.out.print(mensaje);
                respuesta = entradaConsola.readLine();
            } // ()
            catch (IOException ex) {
                return "";
            }
        } while (respuesta == null);
        return respuesta;

    } // ()

    /**
     * Introducció de numeros enters
     *
     * @param mensaje Missatge que es dona a l'usuari
     * @return un enter amb el valor
     */
    public static int leerEntero(String mensaje) {
        int n = 0;
        boolean aconseguit = false;
        while (!aconseguit) {
            try {
                n = Integer.parseInt(leerTexto(mensaje));
                aconseguit = true;
            } catch (NumberFormatException ex) {
                System.out.println("Deus posar un numero correcte");
            }
        }
        return n;
    }

    /**
     * Introducció de numeros enters
     *
     * @param mensaje Missatge que es dona a l'usuari
     * @return un enter amb el valor
     */
    public static double leerDouble(String mensaje) {
        double n = 0.0;
        boolean aconseguit = false;
        while (!aconseguit) {
            try {
                n = Double.parseDouble(leerTexto(mensaje));
                aconseguit = true;
            } catch (NumberFormatException ex) {
                System.out.println("Tienes que poner un número correcto");
            }
        }
        return n;
    }
}//fin class
