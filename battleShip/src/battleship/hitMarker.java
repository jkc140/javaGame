package battleship;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class hitMarker extends JPanel{
	String[] hit = new String [81];
	int[][] attackCoords = new int [81][2];
	int totalAttack = 0;

	public void getInfo(int attackSize, String[] HOM, int[][]coords) {
		int temp=0;
		//System.out.println("tot attack val: "+ totalAttack);

		//hit=new String[attackSize];
		//System.out.println("hit length " +hit.length);
		for(int x=0;x<attackSize;x++) {
			if (hit[0]!=null){
				//System.out.println("adding");
				 temp=x+totalAttack;
			}
			else {
				temp=x;
			}//test

			/*System.out.println("tot attack val: "+ totalAttack);
			System.out.println("tot attack +x val: "+ (totalAttack+x));
			System.out.println("drawing x val: "+x);
			System.out.println("temp: "+temp);*/

			//System.out.println("HOM: "+HOM[x]);
			hit[(temp)]=HOM[x];
			/*System.out.println("hit xTot: "+hit[(temp)]);
			System.out.println("hit x: "+hit[x]);*/
		}

		//attackCoords=new int[tempSizeCoords][2];
		temp=0;
		for(int x=0;x<attackSize;x++) {
			temp=x+totalAttack;
			for(int y=0;y<2;y++) {
				//System.out.println("coords: "+coords[x][y]);
				attackCoords[temp][y]=coords[x][y];
				/*System.out.println("coords: "+coords[x][y]);
				System.out.println("attack Coords: "+attackCoords[temp][y]);*/
			}
			/*System.out.println("attack Coords: "+attackCoords[x][0]);
			System.out.println("attack Coords: "+attackCoords[x][1]);*/
		}
		totalAttack += attackSize;

	}
	public void drawMarker(Graphics g) {
		System.out.println("tot attack val: "+ totalAttack);
		for(int x=0;x<totalAttack;x++) {
			/*System.out.println("drawing x val: " +x);
			System.out.println("hit length " +hit.length);
			System.out.println(hit[x]);*/
			if(hit[x].equalsIgnoreCase("hit")){
				g.setColor(Color.red);;

			}
			else {
				g.setColor(Color.white);
			}
			g.fillOval(attackCoords[x][0]*50, attackCoords[x][1]*50, 50, 50);
		}
	}
}
