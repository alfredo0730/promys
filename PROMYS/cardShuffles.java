import java.io.*;
import java.util.*;
public class cardShuffles{
    public static void main(String args[]) throws IOException{
        Scanner input = new Scanner(System.in);
        System.out.println("Enter type of Shuffle:");
        System.out.println("1 = Right Hand");
        System.out.println("2 = Left Hand");
        int shuffleType = input.nextInt();
        boolean rHShuffle;
        if(shuffleType == 1){
            rHShuffle = true;
        }
        else{
            rHShuffle = false;
        }
        System.out.println("Enter number of cards: ");
        int numCards = input.nextInt();
        System.out.println("Enter number of card shuffles: ");
        int numCardShuffles = input.nextInt();
        if(rHShuffle){
            rHshuffle(numCards, numCardShuffles);
        }
        else{
            lHshuffle(numCards, numCardShuffles);
        }
    }
    public static void rHshuffle(int a, int b){
        int[] cards = new int[a];
        for(int i = 0; i < a; i++){
            cards[i] = i + 1;
        }
        System.out.println("No shuffles:" + Arrays.toString(cards));
        System.out.println();
        for(int i = 0; i < b; i++){
            int[] rH = new int[a/2];
            int[] lH = new int[a/2];
            for(int j = 0; j < a/2; j++){
                rH[j] = cards[j];
                lH[j] = cards[j + a/2];
            }
            for(int j = 0; j < a; j += 2){
                cards[j] = lH[j/2];
                cards[j + 1] = rH[j/2];
            }
            System.out.println((i + 1) + " shuffles: " + Arrays.toString(cards));
        }
    }
    public static void lHshuffle(int a, int b){
        int[] cards = new int[a];
        for(int i = 0; i < a; i++){
            cards[i] = i + 1;
        }
        System.out.println("No shuffles:" + Arrays.toString(cards));
        System.out.println();
        for(int i = 0; i < b; i++){
            int[] rH = new int[a/2];
            int[] lH = new int[a/2];
            for(int j = 0; j < a/2; j++){
                lH[j] = cards[j];
                rH[j] = cards[j + a/2];
            }
            for(int j = 0; j < a; j += 2){
                cards[j] = lH[j/2];
                cards[j + 1] = rH[j/2];
            }
            System.out.println((i + 1) + " shuffles: " + Arrays.toString(cards));
        }
    }
}