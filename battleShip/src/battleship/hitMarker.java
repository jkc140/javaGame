package battleship;


import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;


public class hitMarker extends JPanel{
	String[] hit = new String[81];
	int numAttackPos;
	int[][] attackCoords = new int[81][2];
	int totalAttack = 0;
	
	public void getInfo(int attackSize, String[] HOM, int[][]coords) {
		totalAttack += attackSize;
		int tempSizeHit=HOM.length;
		int tempSizeCoords=coords.length;
		numAttackPos=attackSize;
		hit=new String[tempSizeHit];
		for(int x=0;x<tempSizeHit;x++) {
			hit[x]=HOM[x];
		}
		
		attackCoords=new int[tempSizeCoords][2];
		for(int x=0;x<tempSizeCoords;x++) {
			for(int y=0;y<2;y++) {
				attackCoords[x][y]=coords[x][y];
			}
		}
	}
	public void drawMarker(Graphics g) {
		for(int x=0;x<totalAttack;x++) {
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
