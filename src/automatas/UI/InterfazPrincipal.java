package automatas.UI;

import automatas.AFD.AFDequivalente;
import automatas.AFD.AFDminimizar;
import automatas.AFD.AutomataFD;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InterfazPrincipal {
    AutomataFD afd1 = new AutomataFD();
    AutomataFD afd2 = new AutomataFD();
    DefaultTableModel modelo, modelo2;
    JFrame ventana;
    JPanel panel1, panel2, panel3;
    JLabel alfabeto, aut1, nombreE, conI1, tipoE, listaE, conI2, conI3;
    JLabel aut2, nombreAut2, conI12, tipoE2, listaE2, conI22, conI32;
    JTextField areaAlf, areaNom, areaCon1, areaCon2, areaCon3;
    JTextField areaNom2, areaCon12, areaCon22, areaCon32;
    JButton agregarA, agregarA1, eliminarA1, agregarA2, eliminarA2, minim, equiv;
    JScrollPane datosLista, datosLista2;
    JTable tabla, tabla2;
    JComboBox listaT, listaT2;
    JRadioButton minimizar, equivalentes;
    ButtonGroup grupo;
    String lista[] = {"I", "M", "F", "I-M", "I-F"};
    static String lista2[] = {};
    String error = "Error solo debe ser una letra en el nombre y/o conector";
    ArrayList<String> Automata1 = new ArrayList<>();
    ArrayList<String> Automata2 = new ArrayList<>();
    boolean bandera = false;

    public InterfazPrincipal() {
        ventana = new JFrame("Automata Finito Determinista");
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        alfabeto = new JLabel("Alfabeto: Separado por \",\"", SwingConstants.CENTER);
        aut1 = new JLabel("Automata 1", SwingConstants.CENTER);
        aut2 = new JLabel("Automata 2", SwingConstants.CENTER);
        nombreE = new JLabel("Nombre", SwingConstants.CENTER);
        nombreAut2 = new JLabel("Nombre", SwingConstants.CENTER);
        conI1 = new JLabel();
        conI12 = new JLabel();
        conI2 = new JLabel();
        conI22 = new JLabel();
        conI3 = new JLabel();
        conI32 = new JLabel();
        tipoE = new JLabel("Tipo", SwingConstants.CENTER);
        tipoE2 = new JLabel("Tipo", SwingConstants.CENTER);
        listaE = new JLabel("Automata 1, Listado de Estados", SwingConstants.CENTER);
        listaE2 = new JLabel("Automata 2, Listado de Estados", SwingConstants.CENTER);
        areaAlf = new JTextField();
        areaNom = new JTextField();
        areaNom2 = new JTextField();
        areaCon1 = new JTextField();
        areaCon12 = new JTextField();
        areaCon2 = new JTextField();
        areaCon22 = new JTextField();
        areaCon3 = new JTextField();
        areaCon32 = new JTextField();
        agregarA = new JButton("Agregar Alfabeto");
        agregarA1 = new JButton("Agregar Estado");
        agregarA2 = new JButton("Agregar Estado");
        minim = new JButton("Minimizar");
        equiv = new JButton("Equivalentes");
        eliminarA1 = new JButton("Eliminar");
        eliminarA2 = new JButton("Eliminar");
        equivalentes = new JRadioButton("Equivalentes");
        minimizar = new JRadioButton("Minimizar");
        grupo = new ButtonGroup();
        listaT = new JComboBox(lista);
        listaT2 = new JComboBox(lista);
        modelo = new DefaultTableModel();
        modelo2 = new DefaultTableModel();
        tabla = new JTable(modelo);
        tabla2 = new JTable(modelo2);
        datosLista = new JScrollPane(tabla);
        datosLista2 = new JScrollPane(tabla2);
        ventana.setSize(900, 700);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.getContentPane().add(panel1);
        ventana.getContentPane().add(panel2);
        ventana.setLayout(null);
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 900, 300);
        panel2.setLayout(null);
        panel2.setBounds(0, 300, 900, 360);
        panel3.setLayout(null);
        panel3.setBounds(300, 80, 400, 218);
        panel1.add(panel3);

        EquivalenteMinimizar();
        Alfabeto();
        Automatas();
        ListaEstados();
        Botones();
    }

    public void EquivalenteMinimizar() {
        grupo.add(equivalentes);
        grupo.add(minimizar);
        alfabeto.setVisible(false);
        aut1.setVisible(false);
        aut2.setVisible(false);
        nombreE.setVisible(false);
        nombreAut2.setVisible(false);
        tipoE.setVisible(false);
        tipoE2.setVisible(false);
        listaE.setVisible(false);
        listaE2.setVisible(false);
        areaAlf.setVisible(false);
        areaNom.setVisible(false);
        areaNom2.setVisible(false);
        agregarA.setVisible(false);
        agregarA1.setVisible(false);
        agregarA2.setVisible(false);
        minim.setVisible(false);
        equiv.setVisible(false);
        eliminarA1.setVisible(false);
        eliminarA2.setVisible(false);
        listaT.setVisible(false);
        listaT2.setVisible(false);
        tabla.setVisible(false);
        tabla2.setVisible(false);
        datosLista.setVisible(false);
        datosLista2.setVisible(false);
        ActionListener escuchaA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (equivalentes.isSelected() == true) {
                    bandera = true;
                    alfabeto.setVisible(true);
                    aut1.setVisible(true);
                    aut2.setVisible(true);
                    nombreE.setVisible(true);
                    nombreAut2.setVisible(true);
                    tipoE.setVisible(true);
                    tipoE2.setVisible(true);
                    listaE.setVisible(true);
                    listaE2.setVisible(true);
                    areaAlf.setVisible(true);
                    areaNom.setVisible(true);
                    areaNom2.setVisible(true);
                    agregarA.setVisible(true);
                    agregarA1.setVisible(true);
                    agregarA2.setVisible(true);
                    equiv.setVisible(true);
                    eliminarA1.setVisible(true);
                    eliminarA2.setVisible(true);
                    listaT.setVisible(true);
                    listaT2.setVisible(true);
                    tabla.setVisible(true);
                    tabla2.setVisible(true);
                    datosLista.setVisible(true);
                    datosLista2.setVisible(true);
                    minim.setVisible(false);
                } else if (equivalentes.isSelected() == false) {
                    alfabeto.setVisible(false);
                    aut1.setVisible(false);
                    aut2.setVisible(false);
                    nombreE.setVisible(false);
                    nombreAut2.setVisible(false);
                    tipoE.setVisible(false);
                    tipoE2.setVisible(false);
                    listaE.setVisible(false);
                    listaE2.setVisible(false);
                    areaAlf.setVisible(false);
                    areaNom.setVisible(false);
                    areaNom2.setVisible(false);
                    agregarA.setVisible(false);
                    agregarA1.setVisible(false);
                    agregarA2.setVisible(false);
                    equiv.setVisible(false);
                    eliminarA1.setVisible(false);
                    eliminarA2.setVisible(false);
                    listaT.setVisible(false);
                    listaT2.setVisible(false);
                    tabla.setVisible(false);
                    tabla2.setVisible(false);
                    datosLista.setVisible(false);
                    datosLista2.setVisible(false);
                }
                if (minimizar.isSelected() == true) {
                    bandera = false;
                    alfabeto.setVisible(true);
                    aut1.setVisible(true);
                    nombreE.setVisible(true);
                    tipoE.setVisible(true);
                    listaE.setVisible(true);
                    areaAlf.setVisible(true);
                    areaNom.setVisible(true);
                    agregarA.setVisible(true);
                    agregarA1.setVisible(true);
                    minim.setVisible(true);
                    eliminarA1.setVisible(true);
                    listaT.setVisible(true);
                    tabla.setVisible(true);
                    datosLista.setVisible(true);
                    conI1.setVisible(true);
                    conI12.setVisible(false);
                    areaCon12.setVisible(false);
                    conI22.setVisible(false);
                    areaCon22.setVisible(false);
                    conI32.setVisible(false);
                    areaCon32.setVisible(false);
                } else if (equivalentes.isSelected() == false) {
                    minim.setVisible(false);
                }
            }
        };
        equivalentes.addActionListener(escuchaA);
        minimizar.addActionListener(escuchaA);
    }

    public void Alfabeto() {
        equivalentes.setBounds(10, 10, 110, 30);
        minimizar.setBounds(130, 10, 90, 30);
        alfabeto.setBounds(250, 10, 170, 30);
        alfabeto.setOpaque(true);
        alfabeto.setFont(new Font("Calibri", Font.BOLD, 15));
        areaAlf.setBounds(430, 10, 300, 30);
        areaAlf.setFont(new Font("Calibri", Font.BOLD, 15));
        areaAlf.setText("");
        panel1.add(equivalentes);
        panel1.add(minimizar);
        panel1.add(alfabeto);
        panel1.add(areaAlf);
        panel1.updateUI();
    }

    public void Automatas() {
        aut1.setBounds(10, 50, 120, 30);
        aut1.setOpaque(true);
        aut1.setFont(new Font("Calibri", Font.BOLD, 15));
        nombreE.setBounds(10, 90, 120, 30);
        nombreE.setOpaque(true);
        nombreE.setFont(new Font("Calibri", Font.BOLD, 15));
        tipoE.setBounds(160, 90, 120, 30);
        tipoE.setOpaque(true);
        tipoE.setFont(new Font("Calibri", Font.BOLD, 15));

        conI1.setBounds(10, 10, 120, 30);
        conI1.setOpaque(true);
        conI1.setFont(new Font("Calibri", Font.BOLD, 15));
        conI1.setVisible(false);
        conI2.setBounds(140, 10, 120, 30);
        conI2.setOpaque(true);
        conI2.setFont(new Font("Calibri", Font.BOLD, 15));
        conI2.setVisible(false);
        conI3.setBounds(270, 10, 120, 30);
        conI3.setOpaque(true);
        conI3.setFont(new Font("Calibri", Font.BOLD, 15));
        conI3.setVisible(false);

        areaNom.setBounds(10, 130, 120, 30);
        areaNom.setFont(new Font("Calibri", Font.BOLD, 15));
        areaNom.setText("");
        listaT.setBounds(160, 130, 120, 30);

        areaCon1.setBounds(10, 50, 120, 30);
        areaCon1.setFont(new Font("Calibri", Font.BOLD, 15));
        areaCon1.setText("");
        areaCon1.setVisible(false);
        areaCon2.setBounds(140, 50, 120, 30);
        areaCon2.setFont(new Font("Calibri", Font.BOLD, 15));
        areaCon2.setText("");
        areaCon2.setVisible(false);
        areaCon3.setBounds(270, 50, 120, 30);
        areaCon3.setFont(new Font("Calibri", Font.BOLD, 15));
        areaCon3.setText("");
        areaCon3.setVisible(false);

        aut2.setBounds(10, 170, 120, 30);
        aut2.setOpaque(true);
        aut2.setFont(new Font("Calibri", Font.BOLD, 15));
        nombreAut2.setBounds(10, 210, 120, 30);
        nombreAut2.setOpaque(true);
        nombreAut2.setFont(new Font("Calibri", Font.BOLD, 15));
        tipoE2.setBounds(160, 210, 120, 30);
        tipoE2.setOpaque(true);
        tipoE2.setFont(new Font("Calibri", Font.BOLD, 15));

        conI12.setBounds(10, 130, 120, 30);
        conI12.setOpaque(true);
        conI12.setFont(new Font("Calibri", Font.BOLD, 15));
        conI12.setVisible(false);
        conI22.setBounds(140, 130, 120, 30);
        conI22.setOpaque(true);
        conI22.setFont(new Font("Calibri", Font.BOLD, 15));
        conI22.setVisible(false);
        conI32.setBounds(270, 130, 120, 30);
        conI32.setOpaque(true);
        conI32.setFont(new Font("Calibri", Font.BOLD, 15));
        conI32.setVisible(false);
        areaNom2.setBounds(10, 250, 120, 30);
        areaNom2.setFont(new Font("Calibri", Font.BOLD, 15));
        areaNom2.setText("");
        listaT2.setBounds(160, 250, 120, 30);

        areaCon12.setBounds(10, 170, 120, 30);
        areaCon12.setFont(new Font("Calibri", Font.BOLD, 15));
        areaCon12.setText("");
        areaCon12.setVisible(false);
        areaCon22.setBounds(140, 170, 120, 30);
        areaCon22.setFont(new Font("Calibri", Font.BOLD, 15));
        areaCon22.setText("");
        areaCon22.setVisible(false);
        areaCon32.setBounds(270, 170, 120, 30);
        areaCon32.setFont(new Font("Calibri", Font.BOLD, 15));
        areaCon32.setText("");
        areaCon32.setVisible(false);

        panel1.add(aut1);
        panel1.add(aut2);
        panel1.add(nombreE);
        panel1.add(nombreAut2);
        panel1.add(tipoE);
        panel1.add(tipoE2);
        panel3.add(conI1);
        panel3.add(conI12);
        panel3.add(conI2);
        panel3.add(conI22);
        panel3.add(conI3);
        panel3.add(conI32);
        panel1.add(areaNom);
        panel1.add(areaNom2);
        panel3.add(areaCon1);
        panel3.add(areaCon12);
        panel3.add(areaCon2);
        panel3.add(areaCon22);
        panel3.add(areaCon3);
        panel3.add(areaCon32);
        panel1.add(listaT);
        panel1.add(listaT2);
        panel1.updateUI();
        panel3.updateUI();
    }

    public void ListaEstados() {
        listaE.setBounds(10, 5, 200, 30);
        listaE.setOpaque(true);
        listaE.setFont(new Font("Calibri", Font.BOLD, 15));
        panel2.add(listaE);
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        tabla.setBounds(10, 40, 680, 130);
        datosLista.setBounds(10, 40, 680, 130);
        panel2.add(datosLista);

        listaE2.setBounds(10, 175, 200, 30);
        listaE2.setOpaque(true);
        listaE2.setFont(new Font("Calibri", Font.BOLD, 15));
        panel2.add(listaE2);
        modelo2.addColumn("Nombre");
        modelo2.addColumn("Tipo");
        tabla2.setBounds(10, 210, 680, 130);
        datosLista2.setBounds(10, 210, 680, 130);
        panel2.add(datosLista2);

    }

    public void Botones() {
        ActionListener escuchaAc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == agregarA) {
                    String cadena = areaAlf.getText();
                    String cad = cadena.toLowerCase();
                    String simbolos[] = cad.split(",");
                    lista2 = new String[simbolos.length];
                    for (int i = 0; i < simbolos.length; i++) {
                        lista2[i] = simbolos[i];
                    }
                    if (lista2.length == 1) {
                        conI1.setVisible(true);
                        areaCon1.setVisible(true);
                        conI1.setText("Conector de: " + lista2[0]);
                        if (bandera == true) {
                            conI12.setVisible(true);
                            areaCon12.setVisible(true);
                            conI12.setText("Conector de: " + lista2[0]);
                        } else if (bandera == false) {
                            conI12.setVisible(false);
                            areaCon12.setVisible(false);
                            conI12.setText("Conector de: " + lista2[0]);
                        }

                        modelo.addColumn("Conector " + lista2[0]);
                        modelo2.addColumn("Conector " + lista2[0]);
                    }
                    if (lista2.length == 2) {
                        conI1.setVisible(true);
                        areaCon1.setVisible(true);
                        conI1.setText("Conector de: " + lista2[0]);
                        conI2.setVisible(true);
                        areaCon2.setVisible(true);
                        conI2.setText("Conector de: " + lista2[1]);
                        if (bandera == true) {
                            conI12.setVisible(true);
                            areaCon12.setVisible(true);
                            conI12.setText("Conector de: " + lista2[0]);
                            conI22.setVisible(true);
                            areaCon22.setVisible(true);
                            conI22.setText("Conector de: " + lista2[1]);
                        } else if (bandera == false) {
                            conI12.setVisible(false);
                            areaCon12.setVisible(false);
                            conI12.setText("Conector de: " + lista2[0]);
                            conI22.setVisible(false);
                            areaCon22.setVisible(false);
                            conI22.setText("Conector de: " + lista2[1]);
                        }
                        modelo.addColumn("Conector " + lista2[0]);
                        modelo.addColumn("Conector " + lista2[1]);
                        modelo2.addColumn("Conector " + lista2[0]);
                        modelo2.addColumn("Conector " + lista2[1]);
                    }
                    if (lista2.length == 3) {
                        conI1.setVisible(true);
                        areaCon1.setVisible(true);
                        conI1.setText("Conector de: " + lista2[0]);
                        conI2.setVisible(true);
                        areaCon2.setVisible(true);
                        conI2.setText("Conector de: " + lista2[1]);
                        conI3.setVisible(true);
                        areaCon3.setVisible(true);
                        conI3.setText("Conector de: " + lista2[2]);
                        conI12.setVisible(true);
                        areaCon12.setVisible(true);
                        if (bandera == true) {
                            conI12.setText("Conector de: " + lista2[0]);
                            conI22.setVisible(true);
                            areaCon22.setVisible(true);
                            conI22.setText("Conector de: " + lista2[1]);
                            conI32.setVisible(true);
                            areaCon32.setVisible(true);
                            conI32.setText("Conector de: " + lista2[2]);
                        } else if (bandera == false) {
                            areaCon12.setVisible(false);
                            conI12.setVisible(false);
                            conI12.setText("Conector de: " + lista2[0]);
                            areaCon22.setVisible(false);
                            conI22.setVisible(false);
                            conI22.setText("Conector de: " + lista2[1]);
                            areaCon32.setVisible(false);
                            conI32.setVisible(false);
                            conI32.setText("Conector de: " + lista2[2]);
                        }
                        modelo.addColumn("Conector " + lista2[0]);
                        modelo.addColumn("Conector " + lista2[1]);
                        modelo.addColumn("Conector " + lista2[2]);
                        modelo2.addColumn("Conector " + lista2[0]);
                        modelo2.addColumn("Conector " + lista2[1]);
                        modelo2.addColumn("Conector " + lista2[2]);
                    }
                    areaAlf.setText("");
                }
                if (e.getSource() == agregarA1) {
                    String Dato[] = new String[6];
                    String nom = areaNom.getText();
                    String con = areaCon1.getText();
                    String con2 = areaCon2.getText();
                    String con3 = areaCon3.getText();
                    if (nom.length() <= 2 && con.length() <= 2 && con2.length() <= 2 && con3.length() <= 2) {
                        Dato[0] = areaNom.getText();
                        Dato[1] = (String) listaT.getSelectedItem();
                        Dato[2] = areaCon1.getText();
                        Dato[3] = areaCon2.getText();
                        Dato[4] = areaCon3.getText();
                        modelo.addRow(Dato);
                        afd1.setNombre(areaNom.getText());
                        if ("I".equals((String) listaT.getSelectedItem())) {
                            afd1.inicial = true;
                            if ("I-M".equals((String) listaT.getSelectedItem())) {
                                afd1.setTipo("M");
                            }
                            if ("I-F".equals((String) listaT.getSelectedItem())) {
                                afd1.setTipo("F");
                            }
                        } else if ("M".equals((String) listaT.getSelectedItem())) {
                            afd1.inicial = false;
                            afd1.setTipo("M");
                        }
                        if ("F".equals((String) listaT.getSelectedItem())) {
                            afd1.inicial = false;
                            afd1.setTipo("F");
                        }
                        Automata1.add(areaCon1.getText());
                        Automata1.add(areaCon2.getText());
                        Automata1.add(areaCon2.getText());
                        afd1.setConectores(Automata1);
                    } else {
                        JOptionPane.showMessageDialog(null, error);
                    }
                    areaNom.setText("");
                    areaCon1.setText("");
                    areaCon2.setText("");
                    areaCon3.setText("");
                }
                if (e.getSource() == eliminarA1) {
                    int seleccion = tabla.getSelectedRow();
                    if (seleccion >= 0) {
                        modelo.removeRow(seleccion);
                    }
                }
                if (e.getSource() == agregarA2) {
                    String Dato2[] = new String[6];
                    String nom = areaNom2.getText();
                    String con = areaCon12.getText();
                    String con2 = areaCon22.getText();
                    String con3 = areaCon32.getText();
                    if (nom.length() <= 2 && con.length() <= 2 && con2.length() <= 2 && con3.length() <= 2) {
                        Dato2[0] = areaNom2.getText();
                        Dato2[1] = (String) listaT2.getSelectedItem();
                        Dato2[2] = areaCon12.getText();
                        Dato2[3] = areaCon22.getText();
                        Dato2[4] = areaCon32.getText();
                        modelo2.addRow(Dato2);

                        afd2.setNombre(areaNom2.getText());
                        if ("I".equals((String) listaT2.getSelectedItem())) {
                            afd2.inicial = true;
                            afd2.setTipo("I");
                            if ("I-M".equals((String) listaT2.getSelectedItem())) {
                                afd2.setTipo("M");
                            }
                            if ("I-F".equals((String) listaT2.getSelectedItem())) {
                                afd2.setTipo("F");
                            }
                        } else if ("M".equals((String) listaT2.getSelectedItem())) {
                            afd2.inicial = false;
                            afd2.setTipo("M");
                        }
                        if ("F".equals((String) listaT2.getSelectedItem())) {
                            afd2.inicial = false;
                            afd2.setTipo("F");
                        }
                        Automata2.add(areaCon12.getText());
                        Automata2.add(areaCon22.getText());
                        Automata2.add(areaCon32.getText());
                        afd2.setConectores(Automata2);
                    } else {
                        JOptionPane.showMessageDialog(null, error);
                    }
                    areaNom2.setText("");
                    areaCon12.setText("");
                    areaCon22.setText("");
                    areaCon32.setText("");
                }
                if (e.getSource() == eliminarA2) {
                    int seleccion = tabla2.getSelectedRow();
                    if (seleccion >= 0) {
                        modelo2.removeRow(seleccion);
                    }
                }
                if (e.getSource() == minim) {
                    InterfazResultadosM r = new InterfazResultadosM();
                    r.ventana.setVisible(true);
                    String Vector[] = new String[7];
                    ArrayList<AutomataFD> VectorA = new ArrayList();
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        Vector[0] = tabla.getValueAt(i, 0).toString();
                        Vector[1] = tabla.getValueAt(i, 1).toString();
                        if (lista2.length == 1) {
                            Vector[2] = tabla.getValueAt(i, 2).toString();
                        }
                        if (lista2.length == 2) {
                            Vector[2] = tabla.getValueAt(i, 2).toString();
                            Vector[3] = tabla.getValueAt(i, 3).toString();
                        }
                        if (lista2.length == 3) {
                            Vector[2] = tabla.getValueAt(i, 2).toString();
                            Vector[3] = tabla.getValueAt(i, 3).toString();
                            Vector[4] = tabla.getValueAt(i, 4).toString();
                        }
                        r.modeloR.addRow(Vector);
                        tabla.updateUI();
                        //pasar String[] a Arraylist<AutomataFD>
                        AutomataFD temp = new AutomataFD();
                        temp.nombre = Vector[0];
                        temp.tipo = Vector[1];
                        switch (Vector[1]) {
                            case "I-F":
                                temp.inicial = true;
                                temp.setTipo("F");
                                break;
                            case "I-M":
                                temp.inicial = true;
                                temp.setTipo("M");
                                break;
                            case "I":
                                temp.inicial = true;
                                temp.setTipo("M");
                                break;
                        }
                        ArrayList<String> c = new ArrayList();
                        int j = 2;
                        while (Vector[j] != null && j < Vector.length) {
                            c.add(Vector[j]);
                            j++;
                        }
                        temp.setConectores((ArrayList<String>) c.clone());
                        VectorA.add(temp);
                    }
                    AFDminimizar AFDm = new AFDminimizar(VectorA);
                    for (int i = 0; i < AFDm.minimo.size(); i++) {
                        String Vector2[] = new String[7];
                        Vector2[0] = AFDm.minimo.get(i).nombre;
                        Vector2[1] = AFDm.minimo.get(i).tipo;
                        for (int j = 0; j < AFDm.minimo.get(i).conectores.size(); j++) {
                            Vector2[j + 2] = (String) AFDm.minimo.get(i).conectores.get(j);
                        }
                        r.modeloM.addRow(Vector2);
                    }
                    ventana.dispose();
                }
                if (e.getSource() == equiv) {
                    InterfazResultadosE r2 = new InterfazResultadosE();
                    AFDequivalente AFDe = new AFDequivalente();
                    String Vector[] = new String[7];
                    String Vector3[] = new String[7];
                    r2.ventana.setVisible(true);
                    for (int i = 0; i < tabla.getRowCount(); i++) {
                        Vector[0] = tabla.getValueAt(i, 0).toString();
                        Vector[1] = tabla.getValueAt(i, 1).toString();
                        if (lista2.length == 1) {
                            Vector[2] = tabla.getValueAt(i, 2).toString();
                        }
                        if (lista2.length == 2) {
                            Vector[2] = tabla.getValueAt(i, 2).toString();
                            Vector[3] = tabla.getValueAt(i, 3).toString();
                        }
                        if (lista2.length == 3) {
                            Vector[2] = tabla.getValueAt(i, 2).toString();
                            Vector[3] = tabla.getValueAt(i, 3).toString();
                            Vector[4] = tabla.getValueAt(i, 4).toString();
                        }
                        r2.modeloR.addRow(Vector);
                    }
                    for (int i = 0; i < tabla2.getRowCount(); i++) {
                        Vector3[0] = tabla2.getValueAt(i, 0).toString();
                        Vector3[1] = tabla2.getValueAt(i, 1).toString();
                        if (lista2.length == 1) {
                            Vector3[2] = tabla2.getValueAt(i, 2).toString();
                        }
                        if (lista2.length == 2) {
                            Vector3[2] = tabla2.getValueAt(i, 2).toString();
                            Vector3[3] = tabla2.getValueAt(i, 3).toString();
                        }
                        if (lista2.length == 3) {
                            Vector3[2] = tabla2.getValueAt(i, 2).toString();
                            Vector3[3] = tabla2.getValueAt(i, 3).toString();
                            Vector3[4] = tabla2.getValueAt(i, 4).toString();
                        }
                        r2.modeloE.addRow(Vector3);
                    }
                    ArrayList<AutomataFD> VectorA = new ArrayList();
                    ArrayList<AutomataFD> Vector3A = new ArrayList();
                    for (int i = 0; i < Vector.length; i++) {
                        // pasar String[] a ArrayList
                        AutomataFD temp = new AutomataFD();
                        temp.nombre = Vector[0];
                        temp.tipo = Vector[1];
                        ArrayList<String> c = new ArrayList();
                        for (int j = 2; j < Vector.length; j++) {
                            c.add(Vector[j]);
                        }
                        temp.conectores = (ArrayList<String>) c.clone();
                        VectorA.add(temp);
                        // pasar String[] a ArrayList temp2
                        AutomataFD temp2 = new AutomataFD();
                        temp2.nombre = Vector3[0];
                        temp2.tipo = Vector3[1];
                        ArrayList<String> c2 = new ArrayList();
                        for (int j = 2; j < Vector3.length; j++) {
                            c2.add(Vector3[j]);
                        }
                        temp2.conectores = (ArrayList<String>) c2.clone();
                        Vector3A.add(temp2);
                    }
                    AFDequivalente AFDe2 = new AFDequivalente(VectorA, Vector3A);
                    r2.Equivalente(AFDe2.flag);
                    ventana.dispose();
                }
            }
        };
        equiv.setBounds(730, 120, 110, 30);
        equiv.addActionListener(escuchaAc);
        panel2.add(equiv);
        minim.setBounds(740, 180, 90, 30);
        minim.addActionListener(escuchaAc);
        panel2.add(minim);
        agregarA.setBounds(740, 10, 130, 30);
        agregarA.addActionListener(escuchaAc);
        panel1.add(agregarA);
        agregarA1.setBounds(720, 90, 130, 30);
        agregarA1.addActionListener(escuchaAc);
        panel1.add(agregarA1);
        eliminarA1.setBounds(730, 130, 110, 30);
        eliminarA1.addActionListener(escuchaAc);
        panel1.add(eliminarA1);
        agregarA2.setBounds(720, 220, 130, 30);
        agregarA2.addActionListener(escuchaAc);
        panel1.add(agregarA2);
        eliminarA2.setBounds(730, 260, 110, 30);
        eliminarA2.addActionListener(escuchaAc);
        panel1.add(eliminarA2);
        panel1.updateUI();
        panel2.updateUI();
    }
}
