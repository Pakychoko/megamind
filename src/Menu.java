import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * Class Menu for Megamind
 * @author Fran Azorin
 *
 */
public class Menu {

	/**
	 * Method that show a menu for the game
	 */
	public static void menu() {
		System.out.println("               MEGAMIND");
		System.out.println("-----------------------------------------\n");
		System.out.println("   Menu");
		System.out.println("----------");
		System.out.println("1. Jugador contra la Maquina");
		System.out.println("2. Jugador contra Jugador");
		System.out.println("3. Dificultad");
		System.out.println("4. Salir");
		
	}
	
	/**
	 * Method that execute the selection of menu
	 * @return mode Difficulty or Exit
	 */
	public static int execute() {
		
		int option; 
		int mode = 2;
		Scanner scan = new Scanner(System.in);
		
		do {
			
			menu();
			
			do {
				option = scan.nextInt();
			}while(option < 0 || option > 3);
			
			
			switch(option) {
				case 1: Singleplayer.play(mode);
						break;
				case 2: Multiplayer.pvp(mode);
						break;
				case 3: mode = Options.changeDifficulty();
						break;
				case 0: exit();
						break;
				}
			
		}while(option != 4);
		
		return option;
		
	}
	
	

	/**
	 * Method Exit game
	 * @return true
	 */
	public static void exit() {
		
		System.out.println("Hasta pronto");

	}
	
	

}
