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
        for(int x=0;x<attackSize;x++) {
            if (hit[pTurn][0]!=null){
                temp=x+totalAttack[pTurn];
            }
            else {
            temp=x;
            }
	hit[pTurn][(temp)]=HOM[x];			
        }
        temp=0;
        for(int x=0;x<attackSize;x++) {
            temp=x+totalAttack[pTurn];
            for(int y=0;y<2;y++) {
		attackCoords[pTurn][temp][y]=coords[x][y];		
            }
        }     
        totalAttack[pTurn] += attackSize;
    }
    public void drawMarker(Graphics g, int pTurn) {
	System.out.println("tot attack val: "+ totalAttack[pTurn]);
	for(int x=0;x<totalAttack[pTurn];x++) {			
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
