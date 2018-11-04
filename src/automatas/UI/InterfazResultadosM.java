package automatas.UI;

import java.awt.Font;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InterfazResultadosM {
    JFrame ventana;
    JLabel automataOriginal, automataMinimizado;
    JPanel panel1, panel2;
    JScrollPane datosListaO, datosListaM;
    JTable tablaO, tablaM;
    public static DefaultTableModel modeloR;
    public DefaultTableModel modeloM;

    public InterfazResultadosM() {
        ventana = new JFrame("Automata Finito Determinista");
        automataOriginal = new JLabel("Automata Original");
        automataMinimizado = new JLabel("Automata Minimizado");
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
        modeloM = new DefaultTableModel();
        tablaM = new JTable(modeloM);
        datosListaM = new JScrollPane(tablaM);
        Original();
        Minimizado();
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

    public void Minimizado() {
        automataMinimizado.setBounds(10, 10, 140, 20);
        automataMinimizado.setOpaque(true);
        automataMinimizado.setFont(new Font("Calibri", Font.BOLD, 15));
        panel2.add(automataMinimizado);
        automataMinimizado.setBounds(20, 10, 140, 20);
        automataMinimizado.setOpaque(true);
        automataMinimizado.setFont(new Font("Calibri", Font.BOLD, 15));
        panel2.add(automataMinimizado);
        modeloM.addColumn("Nombre");
        modeloM.addColumn("Tipo");
        if (InterfazPrincipal.lista2.length == 1) {
            modeloM.addColumn("Conector " + InterfazPrincipal.lista2[0]);
        }
        if (InterfazPrincipal.lista2.length == 2) {
            modeloM.addColumn("Conector " + InterfazPrincipal.lista2[0]);
            modeloM.addColumn("Conector " + InterfazPrincipal.lista2[1]);
        }
        if (InterfazPrincipal.lista2.length == 3) {
            modeloM.addColumn("Conector " + InterfazPrincipal.lista2[0]);
            modeloM.addColumn("Conector " + InterfazPrincipal.lista2[1]);
            modeloM.addColumn("Conector " + InterfazPrincipal.lista2[2]);
        }
        tablaM.setBounds(10, 50, 700, 100);
        datosListaM.setBounds(10, 50, 700, 100);
        panel2.add(datosListaM);
        panel2.updateUI();
    }
}
