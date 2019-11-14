package battleship;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

import ship.Ship;

public class shipInit extends JPanel{
		public static Ship[][] test=new Ship[2][5];
		public static int turn=0;
		public static int tester=1;
		int[][][][] pos=new int[2][5][5][2];
		public void init(int x) {
				test[x][0]=new Ship(5,"Carrier");
				posSave(x,0);		
				test[x][1]=new Ship(4,"Battleship");
				posSave(x,1);
				test[x][2]=new Ship(3,"Cruise");
				posSave(x,2);
				test[x][3]=new Ship(3,"Submarine");
				posSave(x,3);
				test[x][4]=new Ship(2,"Destroyer");
				posSave(x,4);
				
			
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
	public void posSave(int p, int x) {
		
			if(test[p][x].shipPos[0][0]==test[p][x].shipPos[1][0]) {
				//x pos are the same
				for(int y=0;y<test[x][0].size;y++) {
					pos[p][x][y][0]=test[p][x].shipPos[0][0];
					pos[p][x][y][1]=test[p][x].shipPos[0][1]+y;
				}
				for(int e=5;e>test[p][x].size;e--) {
					pos[p][x][e][0]=-1;
					pos[p][x][e][1]=-1;
				}
			}
			else if(test[p][x].shipPos[0][1]==test[p][x].shipPos[1][1]) {
				//y pos are the same
				for(int y=0;y<test[0][x].size;y++) {
					pos[p][x][y][0]=test[p][x].shipPos[0][0]+y;
					pos[p][x][y][1]=test[p][x].shipPos[0][1];
				}
				for(int e=5;e>test[p][x].size;e--) {
					pos[p][x][e][0]=-1;
					pos[p][x][e][1]=-1;
				}
			}
		
	}
   
}

