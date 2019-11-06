/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ship;

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
    int[][] board = new int[20][20]; 
    private String name;
    private int size;
    private int health;
    
    private boolean sunk;
    
    public Ship(int length, String name){
    this.name = name;
    this.size = length;
    this.health = length;
    this.sunk = false
  
    }
    
    
}
