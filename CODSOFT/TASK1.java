
import java.util.*;
public class TASK1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc=new Scanner(System.in);
        boolean playagain;
        do {
            int randomNumber = random.nextInt(100)+1;
            int score=0;
            int maxAttempts=7;
            int attempts=0;
            boolean correctGuess=false;
            System.out.println("Guess the number from 1 to 100.You've "+maxAttempts+"attempts are There");
            while(attempts<maxAttempts && !correctGuess)
            {
                  System.out.print("Enter your guess number : ");
                  int userguessNumber=sc.nextInt();
                  attempts++;
                  if(userguessNumber==randomNumber)
                  {
                    correctGuess=true;
                    score=maxAttempts-attempts+1;
                    System.out.println("Congratulations you've guessing correct number");
                    System.out.println("Your Score is "+ score);
                  }
                  else if(randomNumber>userguessNumber)
                  {
                    System.out.println("Too low.Try Again");
                  }
                  else
                  {
                    System.out.println("Too High.Try Again");
                  }
            }
            if(!correctGuess)
            {
                System.out.println("Sorry, you've completed all your attempts.The correct generate number is "+randomNumber);
            }
            System.out.println("Do you want Play Again?(YES or NO)");
            String userResponse=sc.next();
            playagain=userResponse.equalsIgnoreCase("yes");
        } while (playagain); 
        sc.close();
    } 
}


