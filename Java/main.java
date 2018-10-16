import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner( System.in );
		System.out.print("Exercice: ");
		int Choice = 12; //scanner.nextInt();
		
		switch(Choice){
			case 1: {Hello();break;}
			case 2:{WordIndex();break;}
			case 3:{ConditionalAge();break;}
			case 4:{ConditionalEvenNumber();break;}
			case 5:{LoopIterationOddNumber();break;}
			case 6:{LoopIterationTranspose();break;}
			case 7:{LoopIterationTriangle();break;}
			case 8:{LoopIterationVowels();break;}
			case 9:{GuessingGame();break;}
			case 10:{HangmanGame();break;}
			case 11:{RicePackage();break;}
			case 12:{RockPaperScissors();break;}
			default: System.out.println("Invalid choice.");
		}  
	}
	static void Hello(){
	    Scanner scanner = new Scanner( System.in );
	    System.out.print("Enter your name: ");
	    String name = scanner.nextLine();
	    System.out.println( "Hello " + name + "!" );
	}
	static void WordIndex(){
		System.out.print("Your word is: ");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine();
		System.out.print("The index you want is: ");
		int index = scanner.nextInt();
		System.out.println(word.charAt(index));
	}
	static void ConditionalAge(){
		System.out.print("Your age is: ");
		Scanner scanner = new Scanner(System.in);
		int age = scanner.nextInt();
		if(age>=18 && age <=120){
			System.out.println("You are eligible to Vote.");
		}
		else if (age>120) System.out.println("How are you still alive?");
		else if (age<0) System.out.println("Did you travel back in time or what?");
		else System.out.println("You are not eligible to vote.");
	}
	static void ConditionalEvenNumber(){
		System.out.print("The number you wish to check if it is even:");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		if (number % 2 == 0){
			System.out.println("The number is even.");
		}
		else System.out.println("The number is not even.");
	}
	static void LoopIterationOddNumber(){
	    int upperLimit = 100;
	    for(int number=1;number<upperLimit;number++){
	        if(number % 2 != 0){
	            System.out.println(number);
	        }
	    }
	}
	static void LoopIterationTranspose(){
	    int sizeMatrix = 3;
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int transpose[][]=new int[sizeMatrix][sizeMatrix];
        for(int i=0;i<sizeMatrix;i++){
            for(int j=0;j<sizeMatrix;j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        for(int i=0;i<sizeMatrix;i++){
            for(int j=0;j<sizeMatrix;j++){
                System.out.print(" " + transpose[i][j]);
            }
            System.out.println("");
        }
	}
	static void LoopIterationTriangle(){
	    System.out.print("Number of lines is: ");
	    Scanner scanner = new Scanner(System.in);
	    int nrLines = scanner.nextInt();
	    System.out.println("");
	    for(int i = 1; i<=nrLines; i++){
	        for(int j = 0; j < nrLines - i; j++){
	            System.out.print(" ");
	        }
	        for(int k = 2*i-1; k > 0; k--){
	            System.out.print("*");
	        }
	        System.out.println("");
	    }
	}
	static void LoopIterationVowels(){
		System.out.print("Your word is: ");
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine(); 
        //String word = "qzeuzteqiea zei ahy";
        word = word.replaceAll("[AaEeIiOoUu]", "");
        System.out.println(word);
	}
	static void GuessingGame(){
	    int valMin=1, valMax=100, nrGuesses=5, guess=-666;
	    Random rand = new Random();
        int number = valMin + rand.nextInt(valMax - valMin);
        System.out.print("\nGuess the number between " + valMin + " and " + valMax + " : ");
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<nrGuesses;i++){
            do{
                guess = scanner.nextInt();
                if (guess < valMin || guess > valMax){
                    System.out.print("\nError! Value not in range. Try again: ");
                }
            }while(guess < valMin || guess > valMax);
            if(guess < number){
                System.out.print("\nGuess higher: ");
            }
            else if(guess > number){
                System.out.print("\nGuess lower: ");
            }
            else break;
        }
        if(guess == number){
            System.out.println("Congratulations! You guessed correctly!\n");
        }
        else System.out.println("You failed to guess the number!\n");
	}
	static void HangmanDraw(int level){
	    switch(level){
	        case 0:{System.out.println("\n   _________\n   |/      |\n   |         \n   |         \n   |        \n   |          \n   |\n___|___");break;}
	        case 1:{System.out.println("\n   _________\n   |/      |\n   |      (_)\n   |         \n   |        \n   |          \n   |\n___|___");break;}
	        case 2:{System.out.println("\n   _________\n   |/      |\n   |      (_)\n   |       | \n   |       |\n   |          \n   |\n___|___");break;}
	        case 3:{System.out.println("\n   _________\n   |/      |\n   |      (_)\n   |      \\| \n   |       |\n   |          \n   |\n___|___");break;}
	        case 4:{System.out.println("\n   _________\n   |/      |\n   |      (_)\n   |      \\|/\n   |       |\n   |          \n   |\n___|___");break;}
	        case 5:{System.out.println("\n   _________\n   |/      |\n   |      (_)\n   |      \\|/\n   |       |\n   |      /   \n   |\n___|___");break;}
	        case 6:{System.out.println("\n   _________\n   |/      |\n   |      (_)\n   |      \\|/\n   |       |\n   |      / \\\n   |\n___|___");break;}
	        default:{System.out.println("\n   _________\n   |/      |\n   |      (_)\n   |      \\|/\n   |       |\n   |      / \\\n   |\n___|___");break;}
	    }
	}
	static void HangmanHideWord(String word, int[] indexes, String letters){
	    System.out.print("\nYour word is: ");
            for(int i=0;i<word.length();i++){
               if(indexes[i] > 0){
                   System.out.print(word.charAt(i));
               }
               else System.out.print("_ ");
            }
            System.out.print("\nYour wrong attempts: " + letters);
	}
    static void HangmanGame(){
        Scanner scanner = new Scanner(System.in);
        int nrWords=3, guessedIndexes[],wrongTimes=0, before=0, after=0, tries = 6;
        String stringArray[] = new String[] {"abcad","efegh","ijkil","mnopm","qrstq","uvwxyuz"},
               chosenWord, guessingLetter, triedLetters ="";
        Random rand = new Random();
        int chosenWordIndex = rand.nextInt(stringArray.length);
        chosenWord = stringArray[chosenWordIndex];
        guessedIndexes  = new int[chosenWord.length()];
        Arrays.fill(guessedIndexes, 0);
        //debuging
        System.out.println("the word is: " + chosenWord);
        //
        while(wrongTimes < tries && after < chosenWord.length()){
            HangmanDraw(wrongTimes);
            HangmanHideWord(chosenWord,guessedIndexes,triedLetters);
            
            System.out.print("\nWhat letter you think is in the word? ");
            guessingLetter = scanner.nextLine();
            System.out.print("\nguessed letter " + guessingLetter);
            
            for(int i=0;i<chosenWord.length();i++){
                if(guessingLetter.charAt(0) == chosenWord.charAt(i)){
                    guessedIndexes[i]=1;
                    after++;
                }
                
            }
             if(before != after) System.out.print("\nYou are correct!\n");
             else{
                System.out.print("\nYou are wong!\n");
                wrongTimes++;
                triedLetters += guessingLetter.charAt(0);
            }
            before=after;
        }
        
        HangmanDraw(wrongTimes);
        Arrays.fill(guessedIndexes, 1);
        HangmanHideWord(chosenWord,guessedIndexes,triedLetters);
        if(wrongTimes < tries){
            System.out.print("\nCongratulations, you guessed the word!\n");
            
        }
        else System.out.print("\nYou failed to guess all the letters. The word is " + chosenWord + " !\n");
    }
    static void RicePackage(){
        int smallBag=1, bigBag=5, goal, smallMin=0, bigMin=0, total=0;
        int nrSmallBags, nrBigBags;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nThe nr of small bags is: ");
        nrSmallBags = scanner.nextInt();
        System.out.print("\nThe nr of big bags is: ");
        nrBigBags = scanner.nextInt();
        System.out.print("\nThe goal is: ");
        goal = scanner.nextInt();
        
        while(total+bigBag<=goal && bigMin < nrBigBags){
            total += bigBag;
            bigMin++;
        }
        while(total+smallBag<=goal && smallMin < nrSmallBags){
            total += smallBag;
            smallMin++;
        }
        if( total == goal){
            System.out.print("The minilmim number of bags is: " + smallMin + " small bags and " +  bigMin + " big bags\n");
        }
        else System.out.print("goal can't be reached");
    }
    static void RockPaperScissors(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        char yesno ='y';
        while(yesno == 'y'){
            System.out.print("\nChoose your weapon:\n1.Rock\n2.Paper\n3.Scissors\n");
            choice = scanner.nextInt();
            
            switch(choice){
                case 1:{break;}
                case 2:{break;}
                case 3:{break;}
                default:{break;}
            }
            System.out.print("\nDo you want to continue? (y/n): ");
            yesno = scanner.nextLine().charAt(0);
        }
        
    }
}