/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;
import java.util.*;
import java.util.Arrays;
/**
 *
 * @author S331461103
 */
public class Ship {

    /**
     * @param args the command line arguments
     */
        private String name;
        private int size;
        private int health;
        private boolean sunk;
        static int[][] position;
        static String[][] board = returnBoard();
        public static String[] shipName = {"Carrier","Battleship","Cruiser","Submarine","Destroyer"};
        public static int[] shipLength = {5,4,3,3,2};
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(board));
        shipSetup();
        System.out.println(Arrays.deepToString(board));
    }
        
    public Ship(int length, String name){
        this.name = name;
        this.size = length;
        this.health = length;
        this.sunk = false;
        this.position = returnposition(name,length);
    }
    public static void shipSetup(){

        Ship Carrier = new Ship(shipLength[1],shipName[1]);
        System.out.println(Arrays.deepToString(board));
        
        Ship Battleship = new Ship(shipLength[2],shipName[2]);
        System.out.println(Arrays.deepToString(board));
        
        Ship Cruiser = new Ship(shipLength[3],shipName[3]);
        System.out.println(Arrays.deepToString(board));
        
        Ship Submarine = new Ship(shipLength[4],shipName[4]);
        System.out.println(Arrays.deepToString(board));
        
        Ship Destroyer = new Ship(shipLength[5],shipName[5]);
        System.out.println(Arrays.deepToString(board));
        
    }
    
    public static int[][] returnposition(String name, int size){
        System.out.println("Enter a position for the: "+name);
        int counter = 0;
        int[][] shipPos = new int[2][2];
        for(int x=0;x < 2;x++){
                    for(int y=0;y < 2;y++){
                        String axis;
                        if (y == 1){
                        axis = ("x");
                        }
                        else {
                        axis = ("y");
                        }
                        shipPos[x][y] = check(axis,counter,size);
                    }
            counter ++;
        }
        counter = 0;
        for (int y = shipPos[1][2]; y <= shipPos[2][2]; y ++ ){   
            for (int x = shipPos[1][1]; x <= shipPos[2][1]; x ++ ){
                board[x][y] = ("s");
            }
        }
        return shipPos;
    }

    
    public static int check(String axis, int count, int val){
        Scanner input = new Scanner(System.in);
        int pos;
        while(true){
                try{
                    System.out.print("Enter the "+ axis +" value ");
                    String num=input.next();
                    pos = Integer.parseInt(num);
                        if (pos >= 1 && pos <=20){
                            if (count == 1){
                                if (pos )
                                break;
                            }
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
   

    public static String[][] returnBoard( )  {
        
        String[][] board = new String[20][20];
            for(int x=0;x < 20;x++){
                    for(int y=0;y < 20;y++){
                        board[x][y] = ("E");
                    }
            }
        return board;
    }
    
    
}
