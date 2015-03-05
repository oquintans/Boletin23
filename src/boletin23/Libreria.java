package boletin23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author oquintansocampo
 */
public class Libreria {

    PrintWriter fich;
    Scanner sc;
    String nombF = "Libreria.txt";
    ArrayList<Libro> libro = new ArrayList();

    public void add() {
        try {
            fich = new PrintWriter(new File(nombF));
            sc = new Scanner(new File(nombF));
            String n = JOptionPane.showInputDialog("Nombre?");
            String a = JOptionPane.showInputDialog("Autor?");
            float p = Float.parseFloat(JOptionPane.showInputDialog("Precio?"));
            int u = Integer.parseInt(JOptionPane.showInputDialog("Unidades"));

            Libro l = new Libro(n, a, p, u);
            libro.add(l);
            
            
            //fich.println(n + "." + a + "." + p + "." + u + ",");
            if (sc.hasNextLine()) {                    
                fich.println(libro);
            } else {
                fich.println(libro);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void consultar() {
        try {
            sc = new Scanner(new File(nombF));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void visualizar() {
        try {
            sc = new Scanner(new File(nombF));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void remove() {
        try {
            fich = new PrintWriter(new File(nombF));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void modificar() {
        try {
            fich = new PrintWriter(new File(nombF));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void ordenar() {
        try {
            fich = new PrintWriter(new File(nombF));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void buscar() {
        try {
            sc = new Scanner(new File(nombF));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }
}
