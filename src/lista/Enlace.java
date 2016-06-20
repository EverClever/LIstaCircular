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
public class Enlace {
    public int iData; // data
    public Enlace next; // reference to next link
    
    // -------------------------------------------------------------
    public Enlace(int id) // constructor
    {
    iData = id; // initialize data
 // (‘next’ is automatically
    } // set to null)
    // -------------------------------------------------------------
    public void displayLink() // display ourself
    {
    System.out.print("{" + iData + "}");
    }
    
}
