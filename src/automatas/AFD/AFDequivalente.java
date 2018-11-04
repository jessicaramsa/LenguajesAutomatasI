package automatas.AFD;

import java.util.ArrayList;

public class AFDequivalente {
    ArrayList<AutomataFD> q = new ArrayList();
    ArrayList<AutomataFD> qPrima = new ArrayList();
    ArrayList<ArrayList<AutomataFD>> tablaTrans = new ArrayList();
    int position;
    public boolean flag = false;
    
    public AFDequivalente() {}
    
    public AFDequivalente(ArrayList<AutomataFD> q, ArrayList<AutomataFD> qPrima) {
        flag = esEquivalente();
    }
    
    public boolean esEquivalente() {
        boolean equiv = true;
        int index = 0;
        // error en minimizacion
        if (!esIgual(q, qPrima)) {
            while(equiv && index < q.size() && index < qPrima.size()) {
                if (compareType(q.get(index), qPrima.get(index))) {
                    equiv = true;
                    // agregar tupla
                    equiv = addTupla(q.get(index), qPrima.get(index), q, qPrima);
                    // recorrer los conectores de cada estado
                } else {
                    equiv = false; // los Automatas no son equivalentes
                }
                index++;
            }
        } else {
            System.out.println("Los autómatas son iguales");
        }
        return equiv;
    }
    
    public boolean esIgual(ArrayList<AutomataFD> a, ArrayList<AutomataFD> b) {
        boolean equal = false;
        int i = 0;
        while (!equal && i < a.size() && i < b.size()) {
            equal = a.get(i).equals(b.get(i));
            i++;
        }
        return equal;
    }
    
    public boolean compareType(AutomataFD e1, AutomataFD e2) {
        String a = e1.tipo.toLowerCase();
        String b = e2.tipo.toLowerCase();
        return a.equals(b);
    }
    
    public boolean addTupla(AutomataFD a, AutomataFD b,
                        ArrayList<AutomataFD> a1, ArrayList<AutomataFD> a2) {
        boolean flag = false;
        // busca que la tupla no haya sido añadida previamente
        if (!buscarTupla(a, b, tablaTrans)) {
            ArrayList<AutomataFD> temp = new ArrayList();
            temp.add(a);
            temp.add(b);
            System.out.println(a.nombre + ", " +b.nombre);
            tablaTrans.add(temp);
            flag = true;
        } else { // si ya fue añadida, busca que los conectores sean del mismo tipo
            // mandar conectores de automatas para agregar a tablaTrans
            while (!flag) {
                System.out.println("Recorriendo conect " + a.nombre + " y " + b.nombre);
                flag = recorrerConect(a, b, a1, a2);
            }
        }
        return flag;
    }
    
    public boolean recorrerConect(AutomataFD a, AutomataFD b,
                            ArrayList<AutomataFD> a1, ArrayList<AutomataFD> a2) {
        boolean flag = true;
        int j = 0;
        // recibe los dos automatas para generar las nuevas tuplas
        while (j < a.getSizeConect() && j < b.getSizeConect() && flag) {
            // busca los Automatas de acuerdo al nombre guardado en el Conector
            AutomataFD ne1 = buscarAutomata(a.getConectIndex(j), a1);
            AutomataFD ne2 = buscarAutomata(b.getConectIndex(j), a2);
            // busca que no haya sido añadida anteriormente esta tupla
            flag = !buscarTupla(ne1, ne2, tablaTrans);
            if (flag && compareType(ne1, ne2)) {
                // compara el tipo de ambos Automatas para generar las tuplas
                flag = addTupla(ne1, ne2, a1, a2);
            }
            j++;
        }
        return flag;
    }
    
    public AutomataFD buscarAutomata(String c, ArrayList<AutomataFD> a) {
        AutomataFD e = new AutomataFD();
        boolean flag = false;
        int index = 0;
        // recorre la lista de estados para encontrar el automata en especifico
        while (!flag && index < a.size()) {
            if (a.get(index).nombre.equals(c)) {
                flag = true;
                e = a.get(index);
            }
            flag = a.get(index).nombre.equals(c);
            index++;
        }
        return e;
    }
    
    public boolean buscarTupla(AutomataFD e1, AutomataFD e2,
                                    ArrayList<ArrayList<AutomataFD>> t) {
        boolean a = false;
        int i = 0, j = 0;
        while (!a && i < t.size()) {
            a = t.get(i).get(j).nombre.equals(e1.nombre);
            while (!a && t.get(i).get(j).equals(e2) && j < t.get(i).size()) {
                a = t.get(i).get(j).equals(e2);
                j++;
            }
            i++;
        }
        return a;
    }
    
    public ArrayList<AutomataFD> cambiarInicial(ArrayList<AutomataFD> a) {
        boolean move = false;
        int i = 0;
        while(!move && i < a.size() && position >= 0) {
            if (a.get(i).inicial) {
                AutomataFD temp = a.get(i);
                temp.inicial = false;
                a.add(temp);
                a.remove(i);
                move = true;
                position--;
            }
            i++;
        }
        return a;
    }
    
    public ArrayList<AutomataFD> cambiarOrden(ArrayList<AutomataFD> a) {
        ArrayList<AutomataFD> nuevo = new ArrayList();
        boolean flag = false;
        int index = 0;
        // cambiar el estado inicial
        nuevo = (ArrayList<AutomataFD>) a.clone();
        while (!flag && index < a.size()) {
            if (a.get(index).inicial) {
                int j = (int) (Math.random() * a.size());
                if (j != index) {
                    a.get(j).inicial = true;
                }
            }
            index++;
        }
        return nuevo;
    }
    
    public static void main(String[] args) {
        AFDequivalente test = new AFDequivalente();
    }
}
