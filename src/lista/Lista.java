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
public class Lista {
    private Enlace first; // ref to first link on list
    private Enlace aux; // ref to first link on list
    private Enlace previous;
    // -------------------------------------------------------------
    
    public void Listas() // constructor
    {
    first = null; // no items on list yet
    aux = null; // no items on list yet
    }
    // -------------------------------------------------------------
    
    public boolean isEmpty() // true if list is empty
    {
    return (first==null);
    }
    
    // insert at start of list
    public void insertFirst(int id)
    { 
    Enlace newLink = new Enlace(id);
    aux = null;
    if(first == null)
    {
        first = newLink;
        first.next = first;
    }else
    {
        
        while(aux != first)
        {
            if (aux == null)
            {
                aux = first.next;
            }
            if(aux.next == first)
            {
                newLink.next = first; // newLink --> old first
                aux.next = newLink; // first --> newLink
                aux = first;
            }else
            {
                aux = aux.next;
            }
            
        }
        
    }
    
    }
  
    public void insertLast(int id)
    {
        Enlace newLink = new Enlace(id);
        Enlace current = first;
        Enlace previous = first;
        while(current.next != null) // until end of list,
        {        
        previous = current;
        current = current.next; // move to next link        
        }        
        current.next = newLink;        
    }
    
    public Enlace deleteFirst() // delete first item
    { // (assumes list not empty)
    Enlace temp = first; // save reference to link
    first = first.next; // delete it: first-->old next
    return temp; // return deleted link
    }
    
    public void displayList()
    {
    System.out.print("List (first-->last): ");
    Enlace current = first; // start at beginning of list
    while(current != null) // until end of list,
    {
        current.displayLink(); // print data
        current = current.next; // move to next link
    }
    System.out.println("");
    }
    
    // -------------------------------------------------------------
    public Enlace find(int key) // find link with given key
    { // (assumes non-empty list)
    Enlace current = first; // start at ‘first’
    while(current.iData != key) // while no match,
    {
        if(current.next == null) // if end of list,
            return null; // didn’t find it
        else // not end of list,
            current = current.next; // go to next link
        }
    return current; // found it
    }
    // -------------------------------------------------------------
    public Enlace delete(int key) // delete link with given key
    { // (assumes non-empty list)
    Enlace current = first; // search for link
    Enlace previous = first;
    while(current.iData != key)
    {
        if(current.next == null)
            return null; // didn’t find it
        else
        {
            previous = current; // go to next link
            current = current.next;
        }
    } // found it
    if(current == first) // if first link,
        first = first.next; // change first
    else // otherwise,
        previous.next = current.next; // bypass it
    
    return current;
    }
    
    
    public int getlength()
    {
        Enlace current = first;
        int cont = 0;
        while(current != null)
        {
            cont++;
            current = current.next;
        }
        return cont;
    }
    
    public void ordena()
    {
        Enlace pivote = first;
        Enlace current = first;
        Enlace reference = first;
        Enlace truefirst = null;
        Enlace truecurrent = null;
        Enlace aux2 = null;
        
        int tamaño = this.getlength(); 
        
        //reference.next = null;
        //truefirst = null;
        
        //while(reference != null)
        //{
        for(int i=0; i<tamaño; i++)
        {
            pivote = reference;
            current = reference;
            while(current != null)
                {            
                    if (pivote.iData <= current.iData )
                    {
                        previous =  current;
                        current = current.next;                
                    }else
                    {
                        if(pivote==first)
                        {
                           if(first.next == current)
                           {
                                aux = first;
                                first = current;
                                aux.next = first.next;
                                first.next = aux;
                                pivote = first;
                           }else
                           {
                               if(current.next != null)
                               {
                                    aux = first;
                                    aux2 = pivote.next;//new lines
                                    first = current; 
                                    aux.next = current.next;
                                    previous.next = aux; 
                                    current.next = aux2; //used to be current.next = previous
                                    pivote = first;
                               }else
                               {
                                    aux = first;
                                    first = current; 
                                    first.next = aux.next;
                                    aux.next = null;
                                    previous.next = aux; 
                                    //first.next = previous;
                                    pivote = first;
                               }

                           }                    
                        }
                        else
                        {
                            previous =  current;
                            current = current.next;
                        }
                    }
                }
            reference = first.next;
            if(truefirst == null)
            {
                truefirst = first;
                truecurrent = truefirst;
            }else
            {
                truecurrent.next = first;
                truecurrent = truecurrent.next;
            }            
            first = first.next;
        }                        
        //}
        first = truefirst;
    }
// ------------
    
    public void insertaOrdendo(int key)
    {
        this.ordena();
        Enlace previous = first;
        Enlace current = first;
        Enlace newLink = new Enlace(key);
        
        while(current != null)
        {
            if(current.iData <= key)
            {
                previous = current;
                current = current.next; 
            }   
            else
            {
                newLink.next = current;
                previous.next = newLink;
                current = null;
            }
        }
    }
    
    
}
