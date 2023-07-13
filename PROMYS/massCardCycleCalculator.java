import java.io.*;
import java.util.*;
public class massCardCycleCalculator {
    public static void main(String args[]) throws IOException{
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("-------------------------------------");
            System.out.println("Enter type of Shuffle:");
            System.out.println("1 = Right Hand");
            System.out.println("2 = Left Hand");
            System.out.println("3 = Exit");
            int shuffleType = input.nextInt();
            boolean isRHShuffle;
            if(shuffleType == 3){
                break;
            }
            else if(shuffleType == 1){
                isRHShuffle = true;
            }
            else{
                isRHShuffle = false;
            }
            System.out.println("-------------------------------------");
            System.out.println("Enter multiples of cards (must be even): ");
            int multsCards = input.nextInt();
            System.out.println("Check only primes? (numCards + 1 is prime?)");
            System.out.println("1 = yes");
            System.out.println("2 = no");
            boolean onlyPrimes = (input.nextInt() % 2) == 1;
            for(int i = 1; i <= 50; i++){
                if(onlyPrimes){
                    if(checkPrime(i * multsCards + 1)){
                        System.out.println("-------------------------------------");
                        System.out.print("cards = " + (i * multsCards) + "; ");
                        if(isRHShuffle){
                            rHshuffle(i * multsCards);
                        }
                        else{
                            lHshuffle(i * multsCards);
                        }
                    }
                }
                else{
                    System.out.println("-------------------------------------");
                    System.out.print("cards = " + (i * multsCards) + "; ");
                    if(isRHShuffle){
                        rHshuffle(i * multsCards);
                    }
                    else{
                        lHshuffle(i * multsCards);
                    }
                }
            }
        }
    }
    public static void rHshuffle(int a){
        ArrayList<Integer> cards = new ArrayList<>(a);
        ArrayList<Integer> ogCards = new ArrayList<>(a);
        for(int i = 0; i < a; i++){
            cards.add(i, i + 1);
            ogCards.add(i, i + 1);
        }
        boolean noSolution = true;
        int counter = 0;
        while(noSolution){
            ArrayList<Integer> rH = new ArrayList<>(a/2);
            ArrayList<Integer> lH = new ArrayList<>(a/2);
            for(int j = 0; j < a/2; j++){
                rH.add(j, cards.get(j));
                lH.add(j, cards.get(j + a/2));
            }
            for(int j = 0; j < a; j += 2){
                cards.set(j, lH.get(j/2));
                cards.set(j + 1, rH.get(j/2));
            }
            counter++;
            if(checkSolution(ogCards, cards)){
                noSolution = false;
                if(counter == cards.size()){
                    System.out.println("Took " + counter + " right hand shuffles to cycle");
                }
                else{
                    System.out.println("Took " + counter + " right hand shuffles to cycle");
                }
            }
        }
    }
    public static void lHshuffle(int a){
        ArrayList<Integer> cards = new ArrayList<>(a);
        ArrayList<Integer> ogCards = new ArrayList<>(a);
        for(int i = 0; i < a; i++){
            cards.add(i, i + 1);
            ogCards.add(i, i + 1);
        }
        boolean noSolution = true;
        int counter = 0;
        while(noSolution){
            ArrayList<Integer> rH = new ArrayList<>(a/2);
            ArrayList<Integer> lH = new ArrayList<>(a/2);
            for(int j = 0; j < a/2; j++){
                lH.add(j, cards.get(j));
                rH.add(j, cards.get(j + a/2));
            }
            for(int j = 0; j < a; j += 2){
                cards.set(j, lH.get(j/2));
                cards.set(j + 1, rH.get(j/2));
            }
            counter++;
            if(checkSolution(ogCards, cards)){
                noSolution = false;
                System.out.println("Took " + counter + " left hand shuffles to cycle");
                if(counter == cards.size()){
                    System.out.println("Matches.");
                }
            }
        }
    }
    public static boolean checkSolution(ArrayList<Integer> a, ArrayList<Integer> b){
        for(int i = 0; i < a.size(); i++){
            if(!a.get(i).equals(b.get(i))){
                return false;
            }
        }
        return true;
    }
    public static boolean checkPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
