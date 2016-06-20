/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lista;

/**
 *
 * @author UVM
 */
public class Main {

    
    public static void main(String[] args) {
        Lista theList = new Lista(); 
        theList.insertFirst(0);
        theList.insertFirst(2);
        theList.insertFirst(4);
        theList.insertFirst(6);
        theList.insertFirst(8);
        theList.displayList();
    }
    
}
