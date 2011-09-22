
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game {
	public void start(){


		System.out.println("Hello Ladies & Genteelman , Welcome to Gussing Game!");
		Scanner input = new Scanner(System.in);
		int numberOfGusses=0, userChoiceInt=0 , computerChoice, topMargin, bottomMargin;
		ArrayList<HighscoreItem> highScore = new ArrayList<HighscoreItem>();
		String tryAgain = "y", userChoiceString="", computerDoGuessing="";
		long startTime=0, endTime=0;

		do{	
			System.out.println("Do you want to the computer to do the guessing (yes/no)?");
			computerDoGuessing=input.nextLine();
			System.out.println("start gussing, it's a number between 1 to 1000 ...");
			if(computerDoGuessing.toLowerCase().equals("no")){
				computerChoice=2+(int)(Math.random()*(998));
				do{
					userChoiceString=input.nextLine();
					if(userChoiceString.toLowerCase().equals("quit") || userChoiceString.toLowerCase().equals("q")){
						System.out.println("game was interupted");
						System.exit(0);	
					}else{
						try{
							userChoiceInt=Integer.parseInt(userChoiceString);
						}catch (NumberFormatException ex){
							System.out.println("\nPlease enter a valid integer number!");
							continue;
						}
						if((userChoiceInt>1)&&(userChoiceInt<1000)){
							numberOfGusses++;
							if(numberOfGusses==1){
								startTime=System.currentTimeMillis();
							}
							if(userChoiceInt==computerChoice){
								endTime=System.currentTimeMillis();

								HighscoreItem item = new HighscoreItem();
								item.setGuesses(numberOfGusses);
								item.setTime((endTime-startTime)/1000);
								System.out.println("*correct! \n you guessed the correct number in "+item.getGuesses()+" guesses and "
										+item.getTime()+" seconds  \n please enter your name:");
								item.setName(input.nextLine());
								highScore.add(item);
								Collections.sort(highScore);
								numberOfGusses=0;

								printHighScore(highScore);
							}else if(userChoiceInt<computerChoice){
								System.out.println("too low");
							}else{
								System.out.println("too high");
							}
						}else{
							System.out.println("stupid, wont count");
						}
					}
				}while(userChoiceInt!=computerChoice);
			}else if(computerDoGuessing.toLowerCase().equals("yes")){
				System.out.println("please use these terms for answers:(correct/low/high/quit)");
				bottomMargin=1; topMargin=1000;
				do{
					computerChoice = bottomMargin+(int)(Math.random()*(topMargin-bottomMargin+1));System.out.println(computerChoice);
					userChoiceString=input.nextLine();
					if(userChoiceString.equals("high")){
						topMargin=computerChoice;
					}else if(userChoiceString.equals("low")){
						bottomMargin=computerChoice;
					}else if(userChoiceString.equals("quit")){
						System.out.println("game was interupted");
						System.exit(0);	
					}
				}while(!userChoiceString.equals("correct"));	
			}else if(computerDoGuessing.toLowerCase().equals("quit") ||computerDoGuessing.toLowerCase().equals("q")){
				System.exit(0);
			}else {
				System.out.println("\nPlease enter yes or no !");
				continue;
			}
			while (true){
				System.out.println("play again?(y/n)");
				tryAgain=input.nextLine();
				if(tryAgain.toLowerCase().equals("n")){
					System.out.println("game over");
					System.exit(0);
				}else if (tryAgain.equals("y")){
					printHighScore(highScore);
					break;
				}else {
					System.out.println("\n Please enter y or n !");
				}
			}
		}while(tryAgain.equals("y"));
	}

	private void printHighScore(ArrayList<HighscoreItem> highScore) {
		System.out.println("\n Current HighScore List \n");
		System.out.println("Name           Guesses            Time\n");
		for (HighscoreItem item:highScore){
			System.out.println(item.getName()+ "          " + item.getGuesses() + "                     " + item.getTime() + "\n");
		}
	}
}
