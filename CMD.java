import java.io.Console;
import java.util.*;
import java.io.IOException;

public class CMD {
    public static void main (String args[]) throws IOException {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String Read = c.readLine("How many Dimensions would you like? ");
        int dim = 2;
        if(Integer.parseInt(Read) != 0){
            dim = Integer.parseInt(Read);
        }
        TicTacToe TTT = new TicTacToe(dim);
        System.out.println("You will play on "+dim+" dimensions");

        Read = c.readLine("Would you like to play against my AI? ");
        boolean AI = false;
        if(Read.equals("yes") || Read.equals("y")){
            AI=!AI;
            System.out.println("You will play against my AI");
        }
        else{
            System.out.println("You will play against yourself");
        }
        boolean gameHasEnded = false;
        while(!gameHasEnded){
            Read = c.readLine("Enter your Coodinates: ");
            if(Read.equals("exit")){
                gameHasEnded=true;
            }
            else{
                String[] Coords = Read.split("\\|");
                if(Coords.length == dim){
                    boolean works = true;
                    for(int i=0;i<Coords.length;i++){
                        if(!isInteger(Coords[i])){
                            works = false;
                        }
                    }
                    if(works){
                        ArrayList<Integer> Array = new ArrayList<Integer>();
                        for(int i=0;i<Coords.length;i++){
                            Array.add(Integer.parseInt(Coords[i]));
                        }
                        Field field = new Field(Array);
                        int click = TTT.click(field);
                        if(click == 0||click == 1){
                            System.out.println("Player "+(click+1)+" has drawn");
                            if(AI){
                                int ai = TTT.aiTurn();
                                if(ai == 0){
                                    System.out.println("AI has drawn.");
                                }
                                if(ai == 1){
                                    System.out.println("You lost against my AI :P");
                                }
                            }
                        }
                        else if(click == 2||click == 3){
                            System.out.println("Player "+(click-1)+" has won");
                            gameHasEnded=true;
                        }
                        else if(click == -1){
                            System.out.println("You put in invalid Coordinates");
                        }
                        if(TTT.checkTie()){
                            System.out.println("That is a Tie!");
                            gameHasEnded=true;
                        }
                    }
                    else{
                        System.out.println("You put in sth that is not a number");
                    }
                }
                else{
                    System.out.println("You put in an incorrect number of Coordinates");
                }
            }
        }
    }

    public static boolean isInteger(String s) {
        int radix = 10;
        if(s.isEmpty()) return false;
        for(int i = 0; i < s.length(); i++) {
            if(i == 0 && s.charAt(i) == '-') {
                if(s.length() == 1) return false;
                else continue;
            }
            if(Character.digit(s.charAt(i),radix) < 0) return false;
        }
        return true;
    }
}