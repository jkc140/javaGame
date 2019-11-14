package battleship;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class hitMarker extends JPanel{
	String[][] hit = new String [2][81];
	int[][][] attackCoords = new int [2][81][2];
	int[] totalAttack= new int[2];

	public void getInfo(int pTurn,int attackSize, String[] HOM, int[][]coords) {
		int temp=0;
		//System.out.println("tot attack val: "+ totalAttack);

		//hit=new String[attackSize];
		//System.out.println("hit length " +hit.length);
		for(int x=0;x<attackSize;x++) {
			if (hit[pTurn][0]!=null){
				//System.out.println("adding");
				 temp=x+totalAttack[pTurn];
			}
			else {
				temp=x;
			}//test

			/*System.out.println("tot attack val: "+ totalAttack);
			System.out.println("tot attack +x val: "+ (totalAttack+x));
			System.out.println("drawing x val: "+x);
			System.out.println("temp: "+temp);*/

			//System.out.println("HOM: "+HOM[x]);
			hit[pTurn][(temp)]=HOM[x];
			/*System.out.println("hit xTot: "+hit[(temp)]);
			System.out.println("hit x: "+hit[x]);*/
		}

		//attackCoords=new int[tempSizeCoords][2];
		temp=0;
		for(int x=0;x<attackSize;x++) {
			temp=x+totalAttack[pTurn];
			for(int y=0;y<2;y++) {
				//System.out.println("coords: "+coords[x][y]);
				attackCoords[pTurn][temp][y]=coords[x][y];
				/*System.out.println("coords: "+coords[x][y]);
				System.out.println("attack Coords: "+attackCoords[temp][y]);*/
			}
			/*System.out.println("attack Coords: "+attackCoords[x][0]);
			System.out.println("attack Coords: "+attackCoords[x][1]);*/
		}
              
                    totalAttack[pTurn] += attackSize;
                
		

	}
	public void drawMarker(Graphics g, int pTurn) {
		System.out.println("tot attack val: "+ totalAttack[pTurn]);
		for(int x=0;x<totalAttack[pTurn];x++) {
			/*System.out.println("drawing x val: " +x);
			System.out.println("hit length " +hit.length);
			System.out.println(hit[x]);*/
			if(hit[pTurn][x].equalsIgnoreCase("hit")){
				g.setColor(Color.red);;

			}
			else {
				g.setColor(Color.white);
			}
			g.fillOval(attackCoords[pTurn][x][0]*50, attackCoords[pTurn][x][1]*50, 50, 50);
		}
	}
}
