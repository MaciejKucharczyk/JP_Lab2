package tb.soft;
/*
 * Program: Prosta biblioteka metod do realizacji dialogu z użytkownikiem
 *          w prostych aplikacjach bez graficznego interfejsu użytkownika.
 *    Plik: ConsoleUserDialog.java
 *          
 *   Autor: Paweł Rogaliński
 *    Data: październik 2018 r.
 *
 */

import java.util.Scanner;

/**
 * Biblioteka metod do realizacji dialogu z użytkownikiem
 * w prostych aplikacjach bez graficznego interfejsu użytkownika.
 *
 * @author Paweł Rogaliński
 *
 */
public class ConsoleUserDialog {
	
	   private final String  ERROR_MESSAGE =
		          "Nieprawidłowe dane!\nSpróbuj jeszcze raz.";
	   
	   private final Scanner sc = new Scanner(System.in);

	   
		public void printMessage(String message) {
			System.out.println(message);
		}
		
		
		public void printInfoMessage(String message) {
			System.out.println(message);
			enterString("Nacisnij ENTER");
		}
		
		
		public void printErrorMessage(String message) {
			System.err.println(message);
			System.err.println("Nacisnij ENTER");
			enterString("");
		}
		
		
		public void clearConsole(){
			System.out.println("\n\n");
		}

		
		public String enterString(String prompt) {
			System.out.print(prompt);
			return sc.nextLine();
		}
		
		
		public char enterChar(String prompt) {
			boolean isError;
			char c = ' ';
			do {
				isError = false;
				try {
					c = enterString(prompt).charAt(0);
				} catch (IndexOutOfBoundsException e) {
					System.err.println(ERROR_MESSAGE);
					isError = true;
				}
			} while (isError);
			return c;
		}

		
		public int enterInt(String prompt) {
	        boolean isError;
	        int i = 0;
	        do{
	            isError = false;
	            try{ 
	                i = Integer.parseInt(enterString(prompt));
	            } catch(NumberFormatException e){
	            	System.err.println(ERROR_MESSAGE);
	            	isError = true;
	            }
	        }while(isError);
	        return i;
	    }
		
		
		public float enterFloat(String prompt) {
	        boolean isError;
	        float d = 0;
	        do{
	            isError = false;
	            try{
	                d = Float.parseFloat(enterString(prompt));
	            } catch(NumberFormatException e){
	            	System.err.println(ERROR_MESSAGE);
	                isError = true;
	            }
	        } while(isError);
	        return d;
	    }   
		
		
		public double enterDouble(String prompt) {
	        boolean isError;
	        double d = 0;
	        do{
	            isError = false;
	            try{
	                d = Double.parseDouble(enterString(prompt));
	            } catch(NumberFormatException e){
	            	System.err.println(ERROR_MESSAGE);
	                isError = true;
	            }
	        }while(isError);
	        return d;
	    }   

		
} // koniec kasy ConsoleUserDialog



