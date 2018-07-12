import java.util.Scanner;

/**
 * 
 */

/**
 * @author Fran Azorin
 *
 */
public class Multiplayer {

	
	
	
	public static void pvp(int mode) {
			
			int[] difficulty = Options.selectedDifficulty(mode);
			int tries = 0;

			boolean match = false;
			System.out.println("Jugador 1");
			int[] player1 = createMind(difficulty);
			System.out.println("Jugador 2");
			int[] player2 = createMind(difficulty);
			int[] attack;
			
			System.out.println("\nComienza la partida");
			do {
				
				System.out.println("Turno del Jugador 1");
				attack = createMind(difficulty);
				int[] resultP1 = playerTry(attack, player2, tries, difficulty);
	
		
				System.out.println("Turno del Jugador 2");
				attack = createMind(difficulty);
				int[] resultP2 = playerTry(attack, player1, tries, difficulty);
				
				tries++;
				
			}while(tries < difficulty[1]*2);


	
		}
	public static int[] createMind(int[] difficulty) {
			
			int comb[] = new int[difficulty[2]];
			
			String entry;
			Scanner scan = new Scanner(System.in);
			System.out.println("Elige tu combinacion: ");
			
			do {
				entry = scan.nextLine();
			}while(entry.isEmpty() || entry.length() != difficulty[2]);
			
	
			for(int i = 0; i < difficulty[2]; i++) {
				comb[i] = Integer.parseInt(entry.valueOf(entry.charAt(i)));
			}
			
			return comb;
	}

	public static int[] playerTry(int[] attack, int[] player, int tries, int[] difficulty) {
		
		boolean match = false;
		int[] result = Singleplayer.fight(attack, player);
		int black = result[0];
		int white = result[1];

		
		if(black == difficulty[2]) match = true;
		Singleplayer.showTry(tries,attack,black,white,difficulty);
		return result;
	}
	
	
	
}
