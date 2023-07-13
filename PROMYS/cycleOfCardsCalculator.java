import java.io.*;
import java.util.*;
public class cycleOfCardsCalculator{
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
            System.out.println("Enter number of cards: ");
            int numCards = input.nextInt();
            if(isRHShuffle){
                rHshuffle(numCards);
            }
            else{
                lHshuffle(numCards);
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
                System.out.println("-------------------------------------");
                System.out.println("Took " + counter + " right hand shuffles to cycle");
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
                System.out.println("-------------------------------------");
                System.out.println("Took " + counter + " left hand shuffles to cycle");
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
}