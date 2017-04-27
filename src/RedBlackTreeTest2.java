import java.util.Scanner;
public class RedBlackTreeTest2
 {
	
	private static Samochod[] samochody;//deklarowanie tablicy obiektow Samochod
	private static int ile_obiektow;//podanie ile jest obiektow tego typu
	 
	
     public static void main(String[] args)
     {        
		 String ile_obj_str;
    	 int choice;
    	 String choiceString;
         char ch;
         Scanner scan = new Scanner(System.in);
		 Samochod Pickup = new Samochod("Pickup",67,160,30);
		 Samochod BMW = new Samochod("BMW",40,26,17);
		 Samochod Maluch = new Samochod("Maluch",10,10,20);
		 Samochod Opel = new Samochod("Opel",33,16,12);
		 Samochod Tir = new Samochod("Tir",330,160,120);
		 
		 RedBlackTree2 rbt = new RedBlackTree2(new Samochod("O",0,0,0)); 
         rbt.insert( Pickup); 
         rbt.insert( BMW);          
         rbt.insert( Maluch); 
         rbt.insert( Opel);         
         rbt.insert( Tir);        


        System.out.println("Red Black Tree Test\n");          
        /*  Perform tree operations  */
        do    
        {
            System.out.println("\n Najpierw stworz elementy, a nastepnie przeszukaj zeby znalec wiecej informacji o nim\n"
            		+ "\n w celach testowych zostalo stworzonych pare elementow");
            System.out.println("1. dodaj samochod ");
            System.out.println("2. wyszukaj samochody po ich objetosci");
            System.out.println("3. usun wszystko");

            int choice1 = scan.nextInt();            
            switch (choice1)
            {
            case 1 : 
            	
				System.out.println("Menu insertowania:");
				System.out.println("Wpisz ile obiektow chcialbys utworzyc");
		        Scanner wybierz = new Scanner(System.in);
				ile_obj_str = wybierz.nextLine();
				ile_obiektow = Integer.parseInt(ile_obj_str);
				samochody = new Samochod[ile_obiektow];
				String mode;

				for (int i = 0; i < ile_obiektow; i++) {
					System.out
							.println("Wpisz samochod w formacie: bmw,23,23,43 [nazwa,dlugosc,szerokosc,wysokosc]");

					String str = wybierz.nextLine();
					String[] tokens = str.split(",");
					String nazwa = tokens[0];

					int dlugosc = Integer.parseInt(tokens[1]);
					int szerokosc = Integer.parseInt(tokens[2]);
					int wysokosc = Integer.parseInt(tokens[3]);

					samochody[i] = new Samochod(nazwa, dlugosc, szerokosc,
							wysokosc);
					rbt.insert(samochody[i]);
				}
	            System.out.print("\nStan przed operacja : ");
	            rbt.stanPoOperacji();
	            System.out.print("\nCzas w trakcie operacji : ");
	            rbt.porzadkuj(); 
	            System.out.print("\nStan po operacji : ");
	            rbt.przedUlozeniem();
                        
                break;                          
            case 2 : 
                System.out.println("Znajdz samochod o danej objetosci - [dlugosc*szerokosc*wysokosc]"
                		+ "np: jezeli wprowadzone zostaly dane BMW,2,2,1 to objetosc bedzie 4");
                Scanner choose = new Scanner(System.in);
                choiceString = choose.nextLine();
                int x = Integer.parseInt(choiceString);
                System.out.println("Wynik wyszukiwania : "+ rbt.search(new Samochod("szukaj",1,1,x)));
                break;  
                
            case 3 : 
                System.out.println("\n Tablica zostwala wyczyszczona");
                rbt.deleteAll();
                break; 
            default : 
                System.out.println("Nieprawidlowy wybor \n ");
                break;    
            }
            /*  Stan Drzewa  */


 
            System.out.println("\n Kontynuowac (Wprowadz y zeby kontynuowac n zeby przerwac) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');    
     }
    	           
}
 