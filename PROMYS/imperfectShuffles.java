import java.io.*;
import java.util.*;
public class imperfectShuffles {
    public static void main(String[] args) {
        int numOfCards = 10;
        int unequalSplit = numOfCards / 2 + 1;
        int numShuffles = numOfCards * 10;

        int[] lHShuffleAlgorithm = {2, 2, 2};
        int[] rHShuffleAlgorithm = {1, 2, 1};

        for(int i = 1; i <= numOfCards; i++){
            int[] cards = new int[numOfCards];
            int[] ogCards = new int[numOfCards];
            for(int j = 1; j <= numOfCards; j++){
                cards[j - 1] = j;
                ogCards[j - 1] = j;
            }
            int num = i;
            boolean foundSolution = false;
            int counter = 1;
            int counter2 = 1;
            while(!foundSolution){
                int[] leftHand = Arrays.copyOfRange(cards, 0, unequalSplit);
                int[] rightHand = Arrays.copyOfRange(cards, unequalSplit, cards.length);
                int lHCount = 0;
                int rHCount = 0;
                int count = 0;
                for(int j = 0; j < lHShuffleAlgorithm.length; j++){
                    for(int k = 0; k < lHShuffleAlgorithm[j]; k++){
                        cards[count] = leftHand[lHCount];
                        lHCount++;
                        count++;
                    }
                    for(int k = 0; k < rHShuffleAlgorithm[j]; k++){
                        cards[count] = rightHand[rHCount];
                        rHCount++;
                        count++;
                    }
                }
                if(checkSolution(cards, ogCards)){
                    System.out.print("CYCLE! ");
                    foundSolution = true;
                }
                System.out.println(counter + " shuffles = " + Arrays.toString(cards) + "\\\\");
                // if(positionOf(cards, num) == num){
                //     System.out.println(counter + " shuffles, position of " + num + ": " + positionOf(cards, num));
                //     foundSolution = true;
                // }
                counter++;
            }
        }
    }
    public static boolean checkSolution(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    public static int positionOf(int[] cards, int a){
        for(int i = 0; i < cards.length; i++){
            if(cards[i] == a){
                return i + 1;
            }
        }
        return -1;
    }
}
