class Node
{    
    Node left;
	Node right;
    Samochod element;
    int color;
    public final static int LEFT = 0;
    public final static int RIGHT = 1;
    
    /* Constructor */
    public Node(Samochod theElement)
    {
        this( theElement, null, null );
    } 
    /* Constructor */
    public Node(Samochod theElement, Node lt, Node rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }    
    
    
    public boolean is_red(){
    	if (this.color==0) return true;
    	else return false;
    }
    
    
    // any non-zero argument returns right
    Node link(int direction) {
        return (direction == LEFT) ? this.left : this.right;
    }
    // any non-zero argument sets right
    Node setLink(int direction, Node n) {
        if (direction == LEFT) this.left = n;
        else this.right = n;
        return n;
    }
}