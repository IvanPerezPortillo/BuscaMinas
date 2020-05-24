/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema28prg;

import Utils.Utilitats;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class ExercicisProposats {

    public static void modificarEnterAt(String fitxer) {
        try {
            ExercicisResolts.mostrarFitxerEnters(fitxer);
            File f = new File(fitxer);
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            
            //calculem quants nombres hi han
            int quantsEnters = (int) (f.length() / 4);
            int pos = 0;
            do {
                pos = Utilitats.leerEnteroG("Quina posició vols modificar? 1 -" + quantsEnters);
            } while (pos < 1 || pos > quantsEnters);
            
            // correcció per que el primer és un zero
            pos--;
            //ens situem en l'enter demanat i el llegim
            raf.seek(pos*4);
            int vell=raf.readInt();
            
            //demane el nou enter i l'escrivim
            
            int nou = Utilitats.leerEnteroG("Per quin nombre vols substituir el " + vell);
            
            //ens situem en l'enter demanat i l'escrivim
            raf.seek(pos*4);
            raf.writeInt(nou);

            ExercicisResolts.mostrarFitxerEnters(fitxer);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisProposats.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisProposats.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class NomClasse implements java.io.Serializable {
	//
}

