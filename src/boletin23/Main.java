/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boletin23;

import javax.swing.JOptionPane;

/**
 *
 * @author oquintansocampo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Libreria libro = new Libreria();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("opciones: \n1 --> Añadir\n2 --> Visualizar\n3 --> Consultar Libro\n4 --> Borrar\n5 --> Exit"));
            switch (op) {
                case 1:
                    libro.add();
                    break;
                case 2:
                    libro.visualizar();
                    break;
                case 3:
                    libro.consultar();
                    break;
                case 4:
                    libro.remove();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.exit(0);
            }
        } while (op != 0 && op != 5);
    }

}
