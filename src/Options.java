import java.util.Scanner;

/**
 * 
 */

/**
 * @author Fran Azorin
 *
 */
public class Options {

	
	
	public static int changeDifficulty(){
		
		int difficulty;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Seleccion de dificultad");
		System.out.println("1. Facil");
		System.out.println("2. Estandar");
		System.out.println("3. Dificil");
		
		do {
			difficulty = scan.nextInt();
		}while(difficulty < 1 || difficulty > 3);
		
		
		return difficulty;
	}
	
	public static int[] selectedDifficulty(int difficulty) {
		
		int[] selection = new int[3];
		selection[0] = difficulty;
		
		switch(difficulty) {
		case 1: selection[1] = 20;
				selection[2] = 3;
			break;
		case 2: selection[1] = 10;
				selection[2] = 5;
			break;		
		case 3: selection[1] = 5;
				selection[2] = 6;
			break;
		
		}
		return selection;
	}
	
	public static void printDifficulty(int mode) {
		
		switch(mode) {
		case 1: System.out.println("Dificultad Facil");
				System.out.println("El codigo es de 3 caracteres y tienes 20 intentos");
				break;
		case 2: System.out.println("Dificultad Normal");
				System.out.println("El codigo es de 5 caracteres y tienes 10 intentos");
				break;
		case 3: System.out.println("Dificultad Dificil");
				System.out.println("El codigo es de 6 caracteres y tienes 5 intentos");
				break;
		}
	}
	
	
}
