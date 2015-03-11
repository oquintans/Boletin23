package boletin23;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
    String linea;
    ArrayList<Libro> libro;
    int bucle;

    public void add() {

        try {
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            sc = new Scanner(new File(nombF));
            do {
                libro = new ArrayList();
                String n = JOptionPane.showInputDialog("Nombre?");
                String a = JOptionPane.showInputDialog("Autor?");
                float p = Float.parseFloat(JOptionPane.showInputDialog("Precio?"));
                int u = Integer.parseInt(JOptionPane.showInputDialog("Unidades"));

                Libro l = new Libro(n, a, p, u);
                libro.add(l);
                fich.println(l);
                bucle = JOptionPane.showConfirmDialog(null, "Añadir mas?");
            } while (bucle == 0);

        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void consultar() {
        String nombreL;
        float precio = 0;
        String n = "";
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            do {
                int aux = 0;
                libro = new ArrayList();

                while (sc.hasNextLine()) {
                    linea = sc.nextLine();
                    String[] l = linea.split(",");
                    for (int i = 0; i < l.length; i += 4) {
                        libro.add(new Libro(l[i], l[i + 1], Float.parseFloat(l[i + 2]), Integer.parseInt(l[i + 3])));
                    }
                }
                nombreL = JOptionPane.showInputDialog("Nombre del Libro");
                for (Libro l : libro) {
                    if (l.getNombre().replace(' ', '-').equalsIgnoreCase(nombreL.replace(' ', '-'))) {
                        precio = l.getPrecio();
                        n = l.getNombre();
                        aux = 1;
                    }
                }
                if (aux == 1) {
                    JOptionPane.showMessageDialog(null, n + " - Precio: " + precio + "€");
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el libro: " + nombreL + ", en la Base de Datos.");
                }
                bucle = JOptionPane.showConfirmDialog(null, "Buscar mas?");
            } while (bucle == 0);

        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public void visualizar() {
        libro = new ArrayList();
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
                System.out.println("Libro " + (j + 1) + "---> " + "Nombre: " + libro.get(j).getNombre() + " Autor: " + libro.get(j).getAutor() + " Precio: " + libro.get(j).getPrecio() + "€" + " Cant: " + libro.get(j).getUnidades());
            }
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }

    public void remove() {
        libro = new ArrayList();
        try {
            int preg = JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar?");
            if (preg == 0) {
                sc = new Scanner(new File(nombF)).useDelimiter(delim);
                fich = new PrintWriter(new FileWriter(new File(nombF), true));
                while (sc.hasNextLine()) {
                    linea = sc.nextLine();
                    String[] l = linea.split(",");
                    for (int i = 0; i < l.length; i += 4) {
                        libro.add(new Libro(l[i], l[i + 1], Float.parseFloat(l[i + 2]), Integer.parseInt(l[i + 3])));
                    }
                }
                sc.close();
                fich.close();
                File f = new File(nombF);
                f.delete();
                f.createNewFile();
                fich = new PrintWriter(new FileWriter(new File(nombF), true));
                for (int i = 0; i < libro.size(); i++) {
                    if (libro.get(i).getUnidades() != 0) {
                        fich.println(libro.get(i));
                    }
                }
                JOptionPane.showMessageDialog(null, "Borrado Completado");
            }
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void modificar() {
        libro = new ArrayList();
        int cont;
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                String[] l = linea.split(",");
                for (int i = 0; i < l.length; i += 4) {
                    libro.add(new Libro(l[i], l[i + 1], Float.parseFloat(l[i + 2]), Integer.parseInt(l[i + 3])));
                }
            }
            sc.close();
            fich.close();
            do {
                cont = 0;
                String preg = JOptionPane.showInputDialog("Nombre del Libro");
                for (int i = 0; i < libro.size(); i++) {
                    if (libro.get(i).getNombre().equalsIgnoreCase(preg)) {
                        String precio = JOptionPane.showInputDialog("Libro: " + libro.get(i).getNombre() + " Precio: " + libro.get(i).getPrecio() + "€\nIntroducir nuevo precio.");
                        libro.get(i).setPrecio(Float.parseFloat(precio));
                        cont = 1;
                        break;
                    } else {
                        cont = 0;
                    }
                }
                if (cont == 1) {
                    File f = new File(nombF);
                    f.delete();
                    f.createNewFile();
                    fich = new PrintWriter(new FileWriter(new File(nombF), true));
                    for (int j = 0; j < libro.size(); j++) {
                        if (libro.get(j).getUnidades() != 0) {
                            fich.println(libro.get(j));
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No existe el libro: " + preg + ", en la Base de Datos");
                }
                bucle = JOptionPane.showConfirmDialog(null, "Buscar mas?");
            } while (bucle == 0);
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void ordenar() {
        libro = new ArrayList();
        try {
            sc = new Scanner(new File(nombF)).useDelimiter(delim);
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                String[] l = linea.split(",");
                for (int i = 0; i < l.length; i += 4) {
                    libro.add(new Libro(l[i], l[i + 1], Float.parseFloat(l[i + 2]), Integer.parseInt(l[i + 3])));
                }
            }
            Collections.sort(libro);
            sc.close();
            fich.close();
            File f = new File(nombF);
            f.delete();
            f.createNewFile();
            fich = new PrintWriter(new FileWriter(new File(nombF), true));
            for (int i = 0; i < libro.size(); i++) {
                if (libro.get(i).getUnidades() != 0) {
                    fich.println(libro.get(i));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            fich.close();
            sc.close();
        }
    }

    public void buscar() {
        try {
            sc = new Scanner(new File(nombF));
        } catch (IOException ex) {
            Logger.getLogger(Libreria.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            sc.close();
        }
    }
}
