package CoctelApp;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]){
	      Scanner sc = new Scanner(System.in);
	      int str = 0;
	      System.out.println("Put your choose for research :");
	      for(Choix liste : Choix.values()){    
	            System.out.println(liste.toStringEnum());
	      }
	      try {
	    	 
	      str = sc.nextInt();
	      
	     
	      while(!(str >= 1 && str <= Choix.values().length)) {
		      System.out.println("Number between 1 and " + Choix.values().length);  
		      str = sc.nextInt();  
		  }
	      System.out.println("ok");
	      sc.close();
	      } catch(Exception e) {
	    	  e.printStackTrace();
	      }
		
	}
}
	