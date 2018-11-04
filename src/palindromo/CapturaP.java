/*
    CapturaP.java
    Capturar de una cadena de caracteres y comprobar si es un palindromo o no
    Ramírez Sánchez Jéssica
    Lenguajes y Automatas I
    10:30 - 12:10
*/

package palindromo;

import static java.lang.String.valueOf;
import java.util.Stack;
import javax.swing.JOptionPane;

public class CapturaP {
    String cadena, nuevaCadena;
    Stack<String> pila = new Stack<String>();
    Stack<String> palindromo = new Stack<String>();
    
    public void capturar() {
        cadena = JOptionPane.showInputDialog("> Escribe la cadena de texto:");
        nuevaCadena = cadena.toLowerCase();
        nuevaCadena = cadena.replace(" ", "");
        
        for(int cont = 0; cont < nuevaCadena.length(); cont++) {
            pila.push(valueOf(nuevaCadena.charAt(cont)));
        }
        
        System.out.println(comprobar());
    }
    
    public String comprobar() {
        int j = pila.size() - 1;
        int i = 0;
        boolean flag = true;
        
        while(i < j && flag) {
            if(pila.get(i).equals(pila.get(j))) {
                palindromo.push(pila.get(j));
            } else {
                flag = false;
            }
            i++;
            j--;
        }
        return flag ? cadena + " : es un palindromo."
                    : cadena + " : no es un palindromo.";
    }
    
    public static void main(String[] args) {
        CapturaP test = new CapturaP();
        test.capturar();
    }
}
