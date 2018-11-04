/*
 * inicial - true ssi es el inicial, false todos los demas
 * f - estado final
 * m - estado medio
 */

package automatas.AFD;

import java.util.ArrayList;

public class AutomataFD {
    public String nombre;
    public String tipo;
    public boolean inicial;
    public ArrayList conectores = new ArrayList();
    
    public AutomataFD() {
        this.nombre = null;
        this.tipo = null;
        this.conectores = null;
    }
    
    public AutomataFD(String nombre, String tipo, ArrayList conect) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.inicial = false;
        this.conectores = conect;
    }
    
    public AutomataFD(String nombre, String tipo, ArrayList conect, boolean init) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.inicial = init;
        this.conectores = conect;
    }
    
    public AutomataFD(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public void setNombre(String name) {
        this.nombre = name;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void setConectores(ArrayList conector) {
        this.conectores = (ArrayList<String>) conector.clone();
    }
    
    public void addConector(String conect) {
        this.conectores.add(conect);
    }
    
    public void setReplaceConect(int position, String conect) {
        this.conectores.set(position, conect);
    }
    
    public ArrayList<String> getConectores() {
        return this.conectores;
    }
    
    public String getConectIndex(int position) {
        return (String) this.conectores.get(position);
    }
    
    public int getIndexConect(String conect) {
        int position = 0;
        String conectAct = (String) this.conectores.get(position);
        while (!conectAct.equals(conect) && position < getSizeConect()) {
            conectAct = (String) this.conectores.get(position);
        }
        return position;
    }
    
    public int getSizeConect() {
        return this.conectores.size();
    }
    
    public void showAutomataFD() {
        System.out.println("Nombre: " + this.nombre);
        if (inicial) {
            System.out.println("\tEstado Inicial");
        }
        System.out.println("\tTipo: " + this.tipo);
        System.out.println("\tConectores:");
        for (int i = 0; i < this.conectores.size(); i++) {
            System.out.println("\t> " + this.conectores.get(i));
        }
    }
}
