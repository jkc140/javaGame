package battleship;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class hitMarker extends JPanel{ //create a class called hitmarker and make it extends jPanel so it can be added to the screen
    String[][] hit = new String [2][81]; //create an array of strings called hit that is 2d and will store whether the attack is a hit or a miss for each player
      // first slot of 81 subslots will be for player 0 ([x][81]  x is the player) ([2][x]  x number of slots on the board) <-- we are pressuming the players can win with 81 attack position cause that is how many squares are on the board
    int[][][] attackCoords = new int [2][81][2]; //create an array of integers called attack coords to store the coordinates of the attack
      // [x][y][z]  x is the player, y is for the number of slots on the board, z is the x or y coordinate of the attack
    int[] totalAttack= new int[2];//create an array of integers called totalAttack to hold the total number of attack positions the player has used, array cause it is more efficient that to use two variables
    public void getInfo(int pTurn,int attackSize, String[] HOM, int[][]coords) { //create function called getInfo that will get the information on the players attack (ex if it was a hit or not and the coordinate for the attacks)
      //parameters pTurn <-- player turn, attackSize <-- number of attack positions, HOM <-- hit or miss, coords <-- position of attack
        int temp=0; //create variable called temp to hold the temporary number of attack position
        for(int x=0;x<attackSize;x++) { // loops for the number of attack position the latest attack used
            if (hit[pTurn][0]!=null){ //if this is no the first attacks
                temp=x+totalAttack[pTurn]; //set temp to be the total number of attacks plus the current attack number of the latest attack
            }
            else { //if it the first attack
              temp=x; //temp is equal to x
            }
	        hit[pTurn][(temp)]=HOM[x]; //sets hit to equal hit or miss
	        for(int y=0;y<2;y++) {  //loops twice as there is two coords (x and y)
		    	attackCoords[pTurn][temp][y]=coords[x][y];		 //sets the x and y coords for the attack
          }
        }
        
        totalAttack[pTurn] += attackSize; //set totalAttack for the player who's turn it is to be equal to the previous total attack plus the latest attack size
    }
    public void drawMarker(Graphics g, int pTurn) { //create a function called drawMarker to draw the markers on the grid
      //take in parameters graphics and pTurn <-- player turn
	     for(int x=0;x<totalAttack[pTurn];x++) {			//loops the total number of attack positions the user used
          if(hit[pTurn][x].equalsIgnoreCase("hit")){ //checks to see if the attack was a hit or not
	            g.setColor(Color.red);; //if it was a hit it would turn the marker red
          }
          else {
	            g.setColor(Color.white); //if it was not a hit it would turn the marker white
          }
          g.fillOval(attackCoords[pTurn][x][0]*50, attackCoords[pTurn][x][1]*50, 50, 50); //draws the circle/marker at the coordinate of the attack times 50 as each square is 50by 50
	     }
  }
}
