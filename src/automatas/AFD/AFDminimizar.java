package automatas.AFD;

import java.util.ArrayList;

public class AFDminimizar {
    ArrayList<AutomataFD> estados = new ArrayList();
    public ArrayList<AutomataFD> copiaAFD = new ArrayList();
    public ArrayList<AutomataFD> minimo = new ArrayList();
    AFDequivalente AFDe;
    String[] vector;
    
    public AFDminimizar() {}
   
    public AFDminimizar(ArrayList<AutomataFD> q) {
        copiaAFD = (ArrayList<AutomataFD>) q.clone();
        minimo = (ArrayList<AutomataFD>) q.clone();
        AFDe = new AFDequivalente(copiaAFD, minimo);
        minimo = (ArrayList<AutomataFD>) minimizar(q, copiaAFD).clone();
    }
    
    public ArrayList<AutomataFD> minimizar(ArrayList<AutomataFD> a1,
                                            ArrayList<AutomataFD> a2) {
        // se buscan estados equivalentes
        AFDequivalente AFDeTemp = new AFDequivalente(a1, a2);
        if (AFDeTemp.esEquivalente()) {
            // eliminar estado y redirigir flechas
            a2 = (ArrayList<AutomataFD>) eliminarEstado(a1, a2).clone();
            return a2; // buscar otra minimizacion
        } else {
            return a2; // AFDminimo
        }
    }
    
    public ArrayList<AutomataFD> buscarEquivalentes(ArrayList<AutomataFD> a,
                                                    ArrayList<AutomataFD> b) {
        b = (ArrayList<AutomataFD>) AFDe.cambiarInicial(b).clone();
        AFDequivalente AFDeTemp = new AFDequivalente(a, b);
        if (AFDeTemp.esEquivalente()) {
            return minimizar(a, b);
        } else {
            a = (ArrayList<AutomataFD>) AFDe.cambiarInicial(a).clone();
            //buscarEquivalentes(a, b);
            return buscarEquivalentes(a, b);
        }
    }
    
    public ArrayList<AutomataFD> eliminarEstado(ArrayList<AutomataFD> a,
                                                ArrayList<AutomataFD> b) {
        // tomando como estado inicial el primer elemento
        AutomataFD temp = (AutomataFD) AFDe.buscarAutomata(a.get(0).nombre, b);
        int index = 0;
        boolean flagFound = false;
        while (index < b.size() && !flagFound) {
            flagFound = temp.nombre.equals(b.get(index).nombre);
            index++;
        }
        // comprueba que se haya encontrado el Automata equivalente a eliminar
        if (index < b.size() && flagFound) {
            String d = b.get(index + 1).nombre;
            b.remove(index + 1);
            b = (ArrayList<AutomataFD>) redirigirFlechas(d, b).clone();
        }
        return b;
    }
    
    public ArrayList<AutomataFD> redirigirFlechas(String n, ArrayList<AutomataFD> a) {
        // buscar los Automatas que apuntaban al nodo a eliminar
        for (int i = 0; i < a.size(); i++) {
            // buscar conectores
            for (int j = 0; j < a.get(i).getSizeConect(); j++) {
                if (a.get(i).getConectIndex(j).equals(n)) {
                    a.get(i).setReplaceConect(j, a.get(j).nombre);
                }
            }
        }
        return a;
    }
    
    public static void main(String[] args) {
        AFDminimizar test = new AFDminimizar();
    }
}
