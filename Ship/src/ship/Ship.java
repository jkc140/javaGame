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
        public static String[] shipName = {};
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(board));
        
    }
        
    public Ship(int length, String name){
        this.name = name;
        this.size = length;
        this.health = length;
        this.sunk = false;
        this.position = returnposition(name);
    }
    public static shipsetup(){
    
    }
    
    public static int[][] returnposition(String name){
        System.out.println("Enter a position for the: "+name);
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
                        shipPos[x][y] = check(axis);
                    }
        }
        return shipPos;
    }
    public static int check(String axis){
        Scanner input = new Scanner(System.in);
        int pos;
        while(true){
                try{
                    System.out.print("Enter the "+ axis +" value ");
                    String num=input.next();
                    pos = Integer.parseInt(num);
                        if (pos >= 0 && pos <=20){
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
