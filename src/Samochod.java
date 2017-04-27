/*
 * 
 * Klasa Samochod
 * Klasa implementuje interfejs comparable, metoda compareTo 
 * jest przeznaczona do porownywania objetosci samochodu 
 * - czyli wyniku mnozenia trzech atrybutow
 * 
 *  @author pawel.kozlowski
 * 
 */



public class Samochod  implements Comparable<Samochod>{
    private String name;
    private int dlugosc;
    private int szerokosc;
    private int wysokosc;
    
    
    public Samochod(String name, int dlugosc, int szerokosc, int wysokosc)
    {
        this.dlugosc =dlugosc;
        this.name = name;
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }
    
    public int getDlugosc(){
        return dlugosc;
    }
    
    public String getName(){
        return name;
    }
    
    
    public int getObjetosc(){
    	return dlugosc*szerokosc*wysokosc;
    }
    
    
    public int compareTo(Samochod b1){
        if (this.getObjetosc() < b1.getObjetosc()) {
            return -1;
        } else if (this.getObjetosc() > b1.getObjetosc()) {
            return 1;
            } else {
        return 0;
     }
    }
    
    public String toString(){
    	return name;
    }
}
