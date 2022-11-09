import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		System.out.println(r.nextInt(42));
		
		int randomInteger = 0, input = 0,min = 1, max = 100;
		String exitControl = "",exit = "exit";
		
		
		while(!(exitControl.equalsIgnoreCase(exit))) {
			randomInteger = r.nextInt(101);
			System.out.println(randomInteger);
			input = 0;
			do {
				
				do {
					System.out.print("Please enter number between 0 - 101 (for exit write \"" + exit +
				    "\")\nYour guess: ");
					exitControl = sc.next();
					if (exitControl.equalsIgnoreCase(exit))
						break;
					else
						input = Integer.parseInt(exitControl);
					
				}while(!(input<=100 && input>=1));
				
				if (exitControl.equalsIgnoreCase(exit))
					break;
				
				if (randomInteger == input) {
					System.out.print("Congrulations!\n\n-------------------------\n\tNEW GAME	\n-"+
				    "------------------------\n\n");
					max = 100;
					min = 1;
				}
				else {
					System.out.println("\nWrong answer!\n");
					
					if(randomInteger<input) {
						if(max > input-1)
							max = input-1;
						
						if (max == min) {
							System.out.print("You cant guess right. It should be: "+randomInteger+"\n\n-------------");
							System.out.print("------------\n\tNEW GAME\n-------------------------\n\n");
							max = 100;
							min = 1;
						}
						else
							System.out.print("(between " + (min-1) + "-" + (max+1) + ")");
						
					}
					else {
						if(min < input +1)
							min = input+1;
						
						if (max == min)
							System.out.print("Unfortunately all your guess wrong. It must be: "+randomInteger);
						else
							System.out.print("(between " + (min-1) + "-" + (max+1) + ")");
					}
				}
				
			}while(input != randomInteger);
		}
		sc.close();
	}
}