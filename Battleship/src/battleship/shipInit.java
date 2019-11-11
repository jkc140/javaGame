package battleship;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import ship.Ship;

public class shipInit extends JPanel{
		public static Ship[][] test=new Ship[2][5];
		public static int turn=0;
		public static int tester=1;
		public void init(int x) {
				test[x][0]=new Ship(5,"Carrier");
				/*test[x][1]=new Ship(4,"Battleship");
				test[x][2]=new Ship(3,"Cruise");
				test[x][3]=new Ship(3,"Submarine");
				test[x][4]=new Ship(2,"Destroyer");*/
			
		}
		
		

	public void shipDraw(Graphics g){

		g.setColor(Color.gray);

		for (int x=0;x<tester;x++) {
			if(test[0][x].shipPos[0][0]==test[0][x].shipPos[1][0]) {
				g.fillRect(test[0][x].shipPos[0][0]*50, test[0][x].shipPos[0][1]*50, 50, test[0][x].size*50);
				
			}
			else if (test[0][x].shipPos[0][1]==test[0][x].shipPos[1][1]) {
				g.fillRect(test[0][x].shipPos[0][0]*50, test[0][x].shipPos[0][1]*50, test[0][x].size*50, 50);

			}
		}
		
    }
	public void shipDraw2(Graphics g){

		g.setColor(Color.gray);

		for (int x=0;x<tester;x++) {
			if(test[1][x].shipPos[0][0]==test[1][x].shipPos[1][0]) {
				g.fillRect(test[1][x].shipPos[0][0]*50, test[1][x].shipPos[0][1]*50, 50, test[1][x].size*50);
				
			}
			else if (test[1][x].shipPos[0][1]==test[1][x].shipPos[1][1]) {
				g.fillRect(test[1][x].shipPos[0][0]*50, test[1][x].shipPos[0][1]*50, test[1][x].size*50, 50);

			}
		}
		
    }
	public void turnDraw(Graphics g) {

    	if(turn==0) {
    		shipDraw(g);
    	}
    	else if (turn==1) {
    		shipDraw2(g);
    	}
    	else {
    		System.out.println("Error");
    	}
       
    }
   
}
