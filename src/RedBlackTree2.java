/*Drzewo czerwono czarne posiada pewne atrybuty i warunki ktore musza zostac spelnione:
 * 
 * 1 -Jezeli dwa czerwone liscie(krawedzie) sa czerwone nalezy je przekrecic (rotate)
 *    do tego celu sluzy metoda rotate clasy statycznej Leaflet(lisc) - dzieki temu 
 *    mozemy przejsc do nastepnego etapu przeksztalcen w celu utrzymania balansu drzewa
 * 
 * 2 - Zawsze po przekreceniu danych elementow w drzewie, bedzie istniala potrzeba
 *     zmiany kolorow. Wychodzi to z wlasnosci drzewa czerwono-czarnego. Dwa czerwone liscie
 *     nie moga byc ze soba spiete.
 * 
 * 3 - Korzen zawsze jest czarny - private static final int CZARNY = 1; 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

class RedBlackTree2
{
    private Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;    
    private static Node nullNode;

    static 
    {
        nullNode = new Node(new Samochod("Korzen",0,0,0));
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }

    static final int CZARNY = 1;    
    static final int CZERWONY   = 0;


    public RedBlackTree2(Samochod negInf)
    {
        header = new Node(negInf);
        header.left = nullNode;
        header.right = nullNode;
    }


    public void insert(Samochod item )
    {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element != item)
        {            
            great = grand; 
            grand = parent; 
            parent = current;
            current = item.compareTo(current.element)==-1 ? current.left : current.right;
       
            if (current.left.color == CZERWONY && current.right.color == CZERWONY)
                handleReorient( item );
        }

        if (current != nullNode)
            return;
        current = new Node(item, nullNode, nullNode);

        if (item.compareTo(parent.element)==-1) 
            parent.left = current;
        else
            parent.right = current;        
        handleReorient( item );
    }
    private void handleReorient(Samochod samochod)
    {
        // Do the color flip
        current.color = CZERWONY;
        current.left.color = CZARNY;
        current.right.color = CZARNY;

        if (parent.color == CZERWONY)   
        {
            // Have to rotate
            grand.color = CZERWONY;
            //samochod.compareTo(grand.element)==-1 != samochod.compareTo(parent.element)==-1
            if ((samochod.compareTo(grand.element)==-1) != (samochod.compareTo(parent.element)==-1))
                parent = rotate( samochod, grand );  // Start dbl rotate
            current = rotate(samochod, great );
            current.color = CZARNY;
        }

        header.right.color = CZARNY; 
    }      
    private Node rotate(Samochod samochod, Node parent)
    {
        if(samochod.compareTo(parent.element)==-1)
            return parent.left = samochod.compareTo(parent.left.element)==-1   ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;  
        else
            return parent.right = samochod.compareTo(parent.right.element)==-1  ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);  
    }

    private Node rotateWithLeftChild(Node k2)
    {
        Node k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }

    private Node rotateWithRightChild(Node k1)
    {
        Node k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    /* Functions to search for an element */
    public boolean search(Samochod val)
    {
        return search(header.right, val);
    }
    private boolean search(Node r, Samochod val)
    {
        boolean found = false;
        while ((r != nullNode) && !found)
        {
            Samochod rval = r.element;
            if (rval.compareTo(val)==1)
                r = r.left;
            else if (rval.compareTo(val)==-1)
                r = r.right;
            else
            {
                found = true;
                if (found==true){
                	System.out.println(r.element.getName()+" : dl:  " + Integer.toString(r.element.getDlugosc()) + " objetosc " +  Integer.toString(r.element.getObjetosc()));
                }
                break;
            }
            found = search(r, val);
        }
        if (found==false)
        {
        	System.out.println("nie znaleziono");
        }
        return found;

    }
    
    
    /***
     * 
     * 
     * Algorytm usuwania danych
     * 
     * 
     */
    
    
    
    
    public void deleteAll()
    {
        header.right = nullNode;
    }
    

    public void porzadkuj()
    {
        porzadkuj(header.right);
    }
    private void porzadkuj(Node r)
    {
        if (r != nullNode)
        {
            porzadkuj(r.left);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            porzadkuj(r.right);
        }
    }

    
    public void przedUlozeniem()
    {
        przedUlozeniem(header.right);
    }
    private void przedUlozeniem(Node r)
    {
        if (r != nullNode)
        {
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
            przedUlozeniem(r.left);             
            przedUlozeniem(r.right);
        }
    }

    public void stanPoOperacji()
    {
        stanPoOperacji(header.right);
    }
    private void stanPoOperacji(Node r)
    {
        if (r != nullNode)
        {
            stanPoOperacji(r.left);             
            stanPoOperacji(r.right);
            char c = 'B';
            if (r.color == 0)
                c = 'R';
            System.out.print(r.element +""+c+" ");
        }
    }     
}