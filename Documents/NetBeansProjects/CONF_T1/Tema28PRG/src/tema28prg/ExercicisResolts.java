/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema28prg;

import java.awt.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class ExercicisResolts {

    public static void provaEscripturaBinaria() {
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            File f = new File("sequencial.dat");
            fos = new FileOutputStream(f);   // ESCRIURE BYTES
            dos = new DataOutputStream(fos); // ESCRIURE TIPUS
            
               
            
            dos.writeInt(10);
            System.out.println("S'han escrit " + dos.size() + " bytes.");
            
            dos.writeUTF("Hola caracola");
            System.out.println("S'han escrit " + dos.size() + " bytes.");
            dos.writeDouble(Math.PI);
            System.out.println("S'han escrit " + dos.size() + " bytes.");
            dos.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void provaLecturaBinaria() {
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {
            File f = new File("sequencial.dat");
            fis = new FileInputStream(f);
            dis = new DataInputStream(fis);
           
            
            
            //System.out.println("mark()? " + dis.markSupported());
            
            System.out.println("Queden per llegir " + dis.available() + " bytes al fitxer");
            System.out.println("El numero es " + dis.readInt());
            
            
            System.out.println("Queden per llegir " + dis.available() + " bytes al fitxer");
            System.out.println("El text es " + dis.readUTF());
            
            
            System.out.println("Queden per llegir " + dis.available() + " bytes al fitxer");
            System.out.println("El double es " + dis.readDouble());
            System.out.println("Queden per llegir " + dis.available() + " bytes al fitxer");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void provaAleatori() {
        try {
            File f = new File("aleatori.dat");
            RandomAccessFile raf = new RandomAccessFile(f, "rw");

            raf.seek(raf.length());
            raf.writeInt(10);
            raf.writeInt(20);
            raf.writeDouble(Math.PI);
            raf.writeUTF("Hola");
            raf.writeBoolean(false);

            // ens situem desprès dels dos primers enter
            raf.seek(8);

            System.out.println(raf.readDouble());
            System.out.println(raf.readUTF());
            System.out.println(raf.readBoolean());

            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generaFitxerEnters(String fitxer, int quants) {
        try {
            File f = new File(fitxer);
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            Random r = new Random(System.currentTimeMillis());

            for (int i = 0; i < quants; i++) {
                raf.writeInt(r.nextInt(100));
            }
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void afegirFitxerEnters(String fitxer, int quants) {
        try {
            File f = new File(fitxer);
            RandomAccessFile raf = new RandomAccessFile(f, "rw");
            Random r = new Random(System.currentTimeMillis());

            //posició al final
            raf.seek(raf.length());
            for (int i = 0; i < quants; i++) {
                raf.writeInt(r.nextInt(100));
            }
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void mostrarFitxerEnters(String fitxer) {
        try {
            File f = new File(fitxer);
            RandomAccessFile raf = new RandomAccessFile(f, "r");
            long bytesLLegits = 0;
            long tam = raf.length();
            while (bytesLLegits < tam) {
                int num = raf.readInt();
                bytesLLegits += 4;
                System.out.print(num + "\t");
            }

            System.out.println("");
            raf.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void provaFitxersObjectesPunts() {

        FileOutputStream fos = null;

        try {
            System.out.println("Creem punts i guardem.");
            File f = new File("Punts.dat");
            fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            Punt p1=new Punt(2,4);
            Punt p2=new Punt(0,0);
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(new Punt(-5,0));
            oos.writeObject(new Point(23, 2));
            oos.writeObject(new Random(34));
            
            oos.close();
            fos.close();
            
            System.out.println("Llegim punts");
            
            FileInputStream fis=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fis);
            
            Punt p;
            while (fis.available()>0){
                p=(Punt)ois.readObject();
                System.out.println(p);
            }
            
            ois.close();
            fis.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ExercicisResolts.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
