package boletin23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    String delim = ",";

    public void add() {
        try {
            ArrayList<Libro> libro = new ArrayList();
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            sc = new Scanner(new File(nombF));

            String n = JOptionPane.showInputDialog("Nombre?");
            String a = JOptionPane.showInputDialog("Autor?");
            float p = Float.parseFloat(JOptionPane.showInputDialog("Precio?"));
            int u = Integer.parseInt(JOptionPane.showInputDialog("Unidades"));

            Libro l = new Libro(n, a, p, u);
            libro.add(l);
            fich.println(libro);

        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void consultar() {
        float precio;
        try {
            ArrayList<Libro> libro = new ArrayList();
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            String preg = JOptionPane.showInputDialog("Introducir Título:");
            while (sc.hasNextLine()) {

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
        }
    }

    public void visualizar() {
        ArrayList<Libro> libro = new ArrayList();
        String linea;
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                String[] l = linea.split(",");
                for (int i = 0; i < l.length; i += 4) {
                    libro.add(new Libro(l[i], l[i + 1], Float.parseFloat(l[i + 2]), Integer.parseInt(l[i + 3])));
                }
            }
            for (int j = 0; j < libro.size(); j++) {
                System.out.println("Libro " + (j + 1) + "--->" + "Nombre: " + libro.get(j).getNombre() + " Autor: " + libro.get(j).getAutor() + " Precio: " + libro.get(j).getPrecio() + "€" + " Cant: " + libro.get(j).getUnidades());
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
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
