/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;
import java.util.Arrays;
/**
 *
 * @author S331461103
 */


public class Ship {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        
    }
     
    private String name;
    private int size;
    private int health;
    private boolean sunk;
    public String[][] board = returnBoard();
    
    public Ship(int length, String name){
    this.name = name;
    this.size = length;
    this.health = length;
    this.sunk = false;
  
    }
    public static String[][] returnBoard( )  
{  
    String[][] board = new String[20][20];
    for(int x=0;x < 20;x++)
        {
            for(int y=0;y < 20;y++)
        {
            board[x][y] = ("E");
        }
        }
    
    return board;
}
}
