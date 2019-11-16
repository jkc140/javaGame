package battleship;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import ship.Ship;

public class shipInit extends JPanel{ //create a class that extends JPanel to let be shown on the screen
		public static int shipNum=5; //create a variable to hold the number of ships
		public static Ship[][] shipList=new Ship[2][shipNum]; //create an array of type ship that holds objects of type shipPos
		// Ship[x][y] x <-- player turn, y <-- object of a ship
		public static int turn=0; //create a variable called turn to hold the turn of the game
		int[][][][] pos=new int[2][5][5][2];//create an array of integers called pos
		//pos[x][y][z][a] x<-- player turn. y<-- ships number, z <-- ship length/the max length of a ship/how many squares a ship occupies, a <-- x or y coords
		public void init(int player) { //create a function called init and takes in a variable called player as it would initiate each player's ships and the ships positions
				shipList[player][0]=new Ship(5,"Carrier"); //create an object of ship in shipList[player] in slot 0 with a ship size of 5 and a name of carrier
				posSave(player,0); //saves the position of player # ship 0;
				shipList[player][1]=new Ship(4,"Battleship"); //same as carrier but for a ship called battleship with the length/size of 4
				posSave(player,1); //same as previous one, but for ship 1
				shipList[player][2]=new Ship(3,"Cruise"); //same as carrier but for a ship called cruise with the length/size of 3
				posSave(player,2); //same as previous one, but for ship 2
				shipList[player][3]=new Ship(3,"Submarine"); //same as carrier but for a ship called submarine with the length/size of 3
				posSave(player,3); //same as previous one, but for ship 3
				shipList[player][4]=new Ship(2,"Destroyer"); //same as carrier but for a ship called Destroyer with the length/size of 2
				posSave(player,4); //same as previous one, but for ship 4


		}



	public void shipDraw(Graphics g, int player){//create a function called shipDraw to draw the shipSetupP1
		System.out.println("Drawing for "+ player);
		g.setColor(Color.gray); //set colour to grey

		for (int x=0;x<shipNum;x++) { //loops for the number of ships
			if(shipList[player][x].shipPos[0][0]==shipList[player][x].shipPos[1][0]) { //checks to see if the ships have been placed horizontally
				g.fillRect(shipList[player][x].shipPos[0][0]*50, shipList[player][x].shipPos[0][1]*50, 50, shipList[player][x].size*50); //create a rectangle that starts at the first set of xy coords given and is 50 wide and is the ship size*50 long
			}
			else if (shipList[player][x].shipPos[0][1]==shipList[player][x].shipPos[1][1]) {//same as horizontal, but checks for vertical ship
				g.fillRect(shipList[player][x].shipPos[0][0]*50, shipList[player][x].shipPos[0][1]*50, shipList[player][x].size*50, 50); //same as horizontal, but the height is now 50 and the width is the ship size*50 long
			}
		}

    }


	public void posSave(int p, int x) { //create a function called posSave to save the position of the ship and all the squares occupied by thie ship

			if(shipList[p][x].shipPos[0][0]==shipList[p][x].shipPos[1][0]) { //checks to see if the ship is palced horizontally
				//x pos are the same
				for(int y=0;y<shipList[p][x].size;y++) { //loops for the size of the ship
					pos[p][x][y][0]=shipList[p][x].shipPos[0][0]; //sets the x position <-- x stays same cause it is placed horizontally
					pos[p][x][y][1]=shipList[p][x].shipPos[0][1]+y; //sets the y position to be the same as the previous one plus 1
				}

			}
			else if(shipList[p][x].shipPos[0][1]==shipList[p][x].shipPos[1][1]) { //checks to see if the ship is palced vertically, exact same as the horizonal one, but for vertically placed
				//y pos are the same
				for(int y=0;y<shipList[p][x].size;y++) {
					pos[p][x][y][0]=shipList[p][x].shipPos[0][0]+y; //sets the x position to be the same as the previous one plus 1
					pos[p][x][y][1]=shipList[p][x].shipPos[0][1];  //sets the y position <-- x stays same cause it is placed vertically
				}
			}
	}
}
