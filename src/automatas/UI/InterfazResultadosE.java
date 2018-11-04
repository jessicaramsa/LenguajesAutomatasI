package automatas.UI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InterfazResultadosE {
    JFrame ventana;
    JLabel automataOriginal, automataEquivalente;
    JPanel panel1, panel2;
    JLabel errorE, aceptacion;
    JScrollPane datosListaO, datosListaE;
    JTable tablaO, tablaE;
    public static DefaultTableModel modeloR;
    public DefaultTableModel modeloE;
    boolean bandera;

    public InterfazResultadosE() {
        ventana = new JFrame("Automata Finito Determinista");
        automataOriginal = new JLabel("Automata Original");
        automataEquivalente = new JLabel("Automata Equivalente");
        errorE = new JLabel("Error estos Automatas no son Equivalentes");
        aceptacion = new JLabel("Estos Automatas son Equivalentes");
        panel1 = new JPanel();
        panel2 = new JPanel();
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setLayout(null);
        ventana.getContentPane().add(panel1);
        ventana.getContentPane().add(panel2);
        panel1.setBounds(0, 0, 800, 280);
        panel1.setLayout(null);
        panel2.setBounds(0, 280, 800, 320);
        panel2.setLayout(null);
        modeloR = new DefaultTableModel();
        tablaO = new JTable(modeloR);
        datosListaO = new JScrollPane(tablaO);
        modeloE = new DefaultTableModel();
        tablaE = new JTable(modeloE);
        datosListaE = new JScrollPane(tablaE);
        Original();
        Equivalente(bandera);
    }

    public void Original() {
        automataOriginal.setBounds(10, 10, 120, 20);
        automataOriginal.setOpaque(true);
        automataOriginal.setFont(new Font("Calibri", Font.BOLD, 15));
        panel1.add(automataOriginal);

        modeloR.addColumn("Nombre");
        modeloR.addColumn("Tipo");
        if (InterfazPrincipal.lista2.length == 1) {
            modeloR.addColumn("Conector " + InterfazPrincipal.lista2[0]);
        }
        if (InterfazPrincipal.lista2.length == 2) {
            modeloR.addColumn("Conector " + InterfazPrincipal.lista2[0]);
            modeloR.addColumn("Conector " + InterfazPrincipal.lista2[1]);
        }
        if (InterfazPrincipal.lista2.length == 3) {
            modeloR.addColumn("Conector " + InterfazPrincipal.lista2[0]);
            modeloR.addColumn("Conector " + InterfazPrincipal.lista2[1]);
            modeloR.addColumn("Conector " + InterfazPrincipal.lista2[2]);
        }
        tablaO.setBounds(10, 50, 700, 100);
        datosListaO.setBounds(10, 50, 700, 100);
        panel1.add(datosListaO);
        panel1.updateUI();
    }

    public void Equivalente(boolean bandera) {
        automataEquivalente.setBounds(10, 10, 140, 20);
        automataEquivalente.setOpaque(true);
        automataEquivalente.setFont(new Font("Calibri", Font.BOLD, 15));
        panel2.add(automataEquivalente);
        automataEquivalente.setBounds(20, 10, 140, 20);
        automataEquivalente.setOpaque(true);
        automataEquivalente.setFont(new Font("Calibri", Font.BOLD, 15));
        panel2.add(automataEquivalente);
        modeloE.addColumn("Nombre");
        modeloE.addColumn("Tipo");

        if (InterfazPrincipal.lista2.length == 1) {
            modeloE.addColumn("Conector " + InterfazPrincipal.lista2[0]);
        }
        if (InterfazPrincipal.lista2.length == 2) {
            modeloE.addColumn("Conector " + InterfazPrincipal.lista2[0]);
            modeloE.addColumn("Conector " + InterfazPrincipal.lista2[1]);
        }
        if (InterfazPrincipal.lista2.length == 3) {
            modeloE.addColumn("Conector " + InterfazPrincipal.lista2[0]);
            modeloE.addColumn("Conector " + InterfazPrincipal.lista2[1]);
            modeloE.addColumn("Conector " + InterfazPrincipal.lista2[2]);
        }
        tablaE.setBounds(10, 50, 700, 100);
        datosListaE.setBounds(10, 50, 700, 100);
        panel2.add(datosListaE);
        aceptacion.setVisible(false);
        errorE.setVisible(false);
        if (bandera == true) {
            aceptacion.setBounds(10, 170, 500, 80);
            aceptacion.setOpaque(true);
            aceptacion.setForeground(Color.red);
            aceptacion.setFont(new Font("Calibri", Font.BOLD, 35));
            panel2.add(aceptacion);
            aceptacion.setVisible(true);

        } else {
            errorE.setBounds(10, 170, 630, 80);
            errorE.setOpaque(true);
            errorE.setForeground(Color.red);
            errorE.setFont(new Font("Calibri", Font.BOLD, 35));
            panel2.add(errorE);
            errorE.setVisible(true);
        }
        panel2.updateUI();
    }
}
