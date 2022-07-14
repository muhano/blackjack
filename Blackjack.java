import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        //Task 3 – Wait for the user to press enter.
        // System.out.println(cardString(drawRandomCard()));
        scan.nextLine();
        //Task 4 – Get two random cards.
        //       – Print them: \n You get a \n" + <randomCard> + "\n and a \n" + <randomCard>
        int firstCard = drawRandomCard();
        int secondCard = drawRandomCard();
        System.out.println("\n You get a \n" + cardString(firstCard) + "\n and a \n" + cardString(secondCard));

        //Task 5 – Print the sum of your hand value.
        //       – print: your total is: <hand value>
        int handValue = 0;
        if (firstCard <=10 && secondCard <=10) {
            handValue = firstCard + secondCard;
        } else if (firstCard <=10 && secondCard > 10) {
            handValue = firstCard + 10; 
        } else if (firstCard > 10 && secondCard <=10) {
            handValue = secondCard + 10;
        } else if (firstCard > 10 & secondCard > 10) {
            handValue = 20;
        }
        /**
        * Alternatif perhitungan handValue:
        * int handValue = Math.min(firstCard, 10) + Math.min(secondCard, 10);
        *
         */
        System.out.println("your total is: " + handValue);

        
        //Task 6 – Get two random cards for the dealer.
        //       – Print: The dealer shows \n" + <first card> + "\nand has a card facing down \n" + <facedown card>
        //       – Print: \nThe dealer's total is hidden
        int dealerCard1 = drawRandomCard();
        int dealerCard2 = drawRandomCard();
        System.out.println("\nThe dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
        System.out.println("\nThe dealer's total is hidden");


       
        //Task 8 – Keep asking the player to hit or stay (while loop).
        //       1. Every time the player hits
        //             – draw a new card.
        //             – calculate their new total.
        //             – print: (new line) You get a (new line) <show new card>.
        //             - print: your new total is <total>

        //       2. Once the player stays, break the loop. 
        String answer;
        int newCard = 0;
        while (true) {
            answer = hitOrStay();
            if (answer.equalsIgnoreCase("hit")) {
                newCard = drawRandomCard();
                if (newCard <=10) {
                    handValue += newCard;
                } else {
                    handValue += 10;
                }
                System.out.println("\nYou get a \n" + cardString(newCard));
                System.out.println("your new total is " + handValue);
                if (handValue > 21) {
                    System.out.println("Bust! Player loses");
                    System.exit(0);
                }
            } else if (answer.equalsIgnoreCase("stay")) {
                break;
            }
        }
        
        //For tasks 9 to 13, see the article: Blackjack Part II. 
        System.out.println("\nDealer's turn");
        System.out.println("\nThe dealer's cards are \n" + cardString(dealerCard1) + "\n and a \n" + cardString(dealerCard2));

        int dealerValue = 0;
        if (dealerCard1 <=10 && dealerCard2 <=10) {
            dealerValue = dealerCard1 + dealerCard2;
        } else if (dealerCard1 <=10 && dealerCard2 > 10) {
            dealerValue = dealerCard1 + 10; 
        } else if (dealerCard1 > 10 && dealerCard2 <=10) {
            dealerValue = dealerCard2 + 10;
        } else if (dealerCard1 > 10 & dealerCard2 > 10) {
            dealerValue = 20;
        }

        int dealerNewCard = 0;
        // if (dealerValue >= 17) System.out.println("\nDealer's total is " + dealerValue);
        System.out.println("\nDealer's total is " + dealerValue);
        while (dealerValue < 17) {
            dealerNewCard = drawRandomCard();
            if (dealerNewCard <=10) {
                dealerValue += dealerNewCard;
            } else {
                dealerValue += 10;
            }
            System.out.println("\nDealer gets a \n" + cardString(dealerNewCard));
            System.out.println("\nDealer's total is " + dealerValue);
        }
        
        if (dealerValue > 21) {
        System.out.println("Bust! Dealer loses");
        System.exit(0);
        }

        if (handValue > dealerValue) {
            System.out.println("Player wins!");
        } else if (dealerValue > handValue) {
            System.out.println("Dealer wins!");
        }

         scan.close();

    }

    /** Task 1 – make a function that returns a random number between 1 and 13
     * Function name – drawRandomCard
     * @return (int)
     *
     * Inside the function:
     *   1. Gets a random number between 1 and 13.
     *   2. Returns a card.
     */
    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13 + 1;
        return (int)randomNumber;
    }

    /** Task 2 – make a function that returns a String drawing of the card.
     * Function name – cardString
     * @param cardNumber (int)
     * @return (String)
     *
     * Inside the function:
     *   1. Returns a String drawing of the card.
     */
    public static String cardString(int cardNumber) {
            // System.out.println(cardNumber);
        switch (cardNumber) {
            case 1:
            return "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";
            case 2:
            return  "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";
            case 3:
            return  "   _____\n" +
                    "  |3    |\n"+
                    "  | o o |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____E|\n";
            case 4:
            return "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n";
            case 5:
            return  "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";
            case 6:
            return  "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";
            case 7:
            return  "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
            case 8:
            return  "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            case 9:
            return  "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";
            case 10:
            return  "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            case 11:
            return  "   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n";
            case 12:
            return  "   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n";
            case 13:
            return  "   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";
            default: return "";
        }
    }

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    /** Task 7 – make a function that asks the user to hit or stay.
     * Function name – hitOrStay
     * @return (String)
     *
     * Inside the function:
     *   1. Asks the user to hit or stay.
     *   2. If the user doesn't enter "hit" or "stay", keep asking them to try again by printing:
     *      Please write 'hit' or 'stay'
     *   3. Returns the user's option 
     */
     public static String hitOrStay() {
        String answer;
        System.out.println("Would you like to hit or stay?");
        answer = scan.nextLine();
        while (true) {
            if (answer.equalsIgnoreCase("stay") || answer.equalsIgnoreCase("hit")) break;
            System.out.println("Please write 'hit' or 'stay'");
            answer = scan.nextLine();
        }
        return answer;
     }
    }

