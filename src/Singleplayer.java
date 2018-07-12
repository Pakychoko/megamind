import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Fran Azorin
 *
 */
public class Singleplayer {

	public static void play(int mode) {
		
		int tries = 0;
		boolean match = false;
		
		int[] difficulty = Options.selectedDifficulty(mode);
		Options.printDifficulty(mode);

		int[] enemy = enemyMind(difficulty);
		
		do {
			int[] mine = myMind(difficulty);
			int[] result = fight(mine, enemy);
			int black = result[0];
			int white = result[1];
			tries++;
			if(black == difficulty[2]) match = true;
			showTry(tries,mine,black,white,difficulty);
			
		}while(tries < difficulty[1] && match == false);
		
		
	}
	
	
	public static int[] enemyMind(int[] difficulty) {
		
		int comb[] = new int[difficulty[2]];
		
		for(int i = 0; i < difficulty[2]; i++) {
			comb[i] = (int) (Math.random() * 5);
			System.out.print(comb[i]);
		}
		
		return comb;
	}
	
	public static int[] myMind(int[] difficulty) {
		
		int comb[] = new int[difficulty[2]];
		String entry;
		Scanner scan = new Scanner(System.in);
		System.out.println("\nElige tu combinacion");
		
		do {
			entry = scan.nextLine();
		}while(entry.isEmpty() || entry.length() != difficulty[2]);
		

		for(int i = 0; i < difficulty[2]; i++) {
				comb[i] = Integer.parseInt(entry.valueOf(entry.charAt(i)));
			}

		
		return comb;
	}
	
	public static int[] fight(int[] mine, int[]enemy) {
		
		int[] result = new int[2];

		ArrayList blacks = new ArrayList();
		ArrayList whites = new ArrayList();
		
		for(int i = 0; i < mine.length; i++) {
			
			int exists = 0;
			for(int j = 0; j < enemy.length; j++) {	
				
				if(mine[i] == enemy[j]) {
					
					if(i == j) {
						blacks.add(mine[i]);
						if(whites.contains(mine[i])) whites.remove(whites.lastIndexOf(mine[i])); 
						
					}else {
						exists++;
						
					}
				}
			}
			
			if( !whites.contains(mine[i]) ){
				
				if(blacks.contains(mine[i])) exists--;

				for(int z = 0; z < exists; z++){
					whites.add(mine[i]);
				}
			
			}			
			
		}
			
		
		
		result[0] = blacks.size();
		result[1] = whites.size();
		
		return result;
	}
	
	
	
	public static void showTry(int tries, int[] comb, int black, int white, int[] difficulty) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Intentos " + tries + " / "+ difficulty[1]+"\n");
		System.out.println("Combinacion   Negras   Blancas" );
		for(int n: comb) {
			System.out.print(n);
		}
		System.out.print("         ");
		for(int i = 0; i < black; i++) {
			System.out.print("x");
		}
		System.out.print("         ");
		for(int i = 0; i < white; i++) {
			System.out.print("o");
		}
		
		System.out.println("");
		if(tries == difficulty[1]) {
			System.out.println("YOU LOSE");
			scan.nextLine();
			
		}else {
			
			if(black == difficulty[2]) {
				System.out.println("YOU WIN");
				scan.nextLine();
			}else {
				System.out.println("TRY AGAIN");
			}
		}
		
	}
	

}
