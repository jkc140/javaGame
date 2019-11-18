package ship;
import java.util.*;
import java.util.Arrays;
import java.lang.*;
import java.math.*;
/**
 *
 * @author S331461103
 */
public class Ship {

    /**
     * @param args the command line arguments
     */
    //declaring variables
        private String name;
        public int size;
        public int health;
        public boolean sunk;
        static int[][] shipPosition;
        static String[][] board = returnBoard();
        public  String shipName ;
        public  int shipLength;
        public   int[][] shipPos = new int[2][2];
        public int [] SmallestPos = new int [2];
        public static String[] LetterCoord = {"a","b","c","d","e","f","g","h","i"};
        public static String[] NumberCoord = {"1","2","3","4","5","6","7","8","9"};
        public static boolean cycle = true;

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(board));
       /* shipSetupP1();
        shipSetupP2();*/
        System.out.println(Arrays.deepToString(board));
    }

    //Constructor
    public Ship(int length, String name){
        this.name = name;
        this.size = length;
        this.health = length;
        this.sunk = false;
        Ship.shipPosition = returnposition(name,length);
    }


    //Starting method to get position
    public  int[][] returnposition(String name, int length){
        System.out.println("Enter a position for the: "+name);
        int counter = 0;
        while (1 == 1 ){
            for(int x=0;x < 2;x++){
                cycle = true;
                        for(int y=0;y < 2;y++){
                            String axis;
                            if (y == 1){
                            axis = ("y");
                            }
                            else {
                            axis = ("x");
                            }
                            shipPos[x][y] = check(axis);

                        }
                counter ++;
            }
            int y2 = Math.max(shipPos[0][1], shipPos[1][1]);
            int x2 = Math.max(shipPos[0][0], shipPos[1][0]);

            int y1 = Math.min(shipPos[0][1], shipPos[1][1]);
            int x1 = Math.min(shipPos[0][0], shipPos[1][0]);
             SmallestPos[0] = x1;
             SmallestPos[1] = y1;
            counter = 0;


            if ((lenCheck(length, x1, y1, x2, y2)==true) &&(overlapCheck(x1, y1, x2, y2)==true)){


                break;
            }
            else {
                System.out.println("Not a valid position, try again");
            }
        }

       return shipPos;
       //test
    }

    //Checks if the coordinates picked are the correct length away or not
    public boolean lenCheck(int len, int x1, int y1, int x2, int y2){
    int y = y2 - y1;
    int x = x2 - x1;
    //System.out.printf("lenght: %d Coordinate 1: %d,%d Coordinate 2: %d,%d Y distance: %d X distance: %d \n", len, x1, y1 , x2, y2, y , x);

        if (y == len - 1 || x == len - 1){
            System.out.println("Length check passed");

        	return true;
        }
        else {
        	System.out.println("Incorrect length");
        	return false;
        }

    }

    //Checks if the position picked overlaps with any other ships that have already been placed
    public boolean overlapCheck(int x1, int y1, int x2, int y2){
        int boardOverlapped = 0;
        for (int x = x1 - 1; x < x2; x ++ ){
            for (int y = y1 - 1; y < y2; y ++ ){
                if (board[x][y] == "s"){
                    boardOverlapped ++;


                }

            }
        }

        if (boardOverlapped == 0){
        //System.out.println("Overlap check passed");
    	return true;
        }
        else {
        	System.out.println("overlapping other ship");
        return false;
        }
    }

    //if the x value entered is a letter converts it to the same integer value
    public static String LetterToNumber(String pos){
    for (int x = 0; x < 9; x ++ ){ 
        if (pos.equalsIgnoreCase(LetterCoord[x])){
            pos = NumberCoord[x];

        }
    } 
    cycle = false;
    return pos;
    }
    


    //Getting the x and y coordinates from the user
    public static int check(String axis){
        Scanner input = new Scanner(System.in);
        int pos;
        while(true){
                try{
                    System.out.print("Enter the "+ axis +" value ");
                    String num=input.next();
                    while (cycle == true){
                      num = LetterToNumber(num);    
                      }
                    pos = Integer.parseInt(num);
                        if (pos >= 1 && pos <=9){
                           break;
                        }
                        else{
                            System.out.println("Not valid, try again");
                        }
                }
                catch (Exception err) {
                    System.out.println("Not valid, try again");
                }
        }
        return pos;
    }


    //Sets the board to empty
    public static String[][] returnBoard( )  {

        String[][] board = new String[9][9];
            for(int x=0;x < 9;x++){
                    for(int y=0;y < 9;y++){
                        board[x][y] = ("E");
                    }
            }
        return board;
    }


    
}
