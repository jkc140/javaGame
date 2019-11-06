/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.*;
/**
 *
 * @author S331474817
 */
public class BattleShip extends JPanel{
    
    public static int[] xCoord=new int[12];
    public static int[] yCoord=new int[12];
    
    
    public static void boardInit(){
        JFrame screen = new JFrame("test");
        BattleShip ship = new BattleShip();
        screen.add(ship);
        screen.setSize(1000,600);
        screen.setVisible(true);
        screen.setResizable(false);
 
    }
    public void grid(Graphics g){
        int maxHeight=500;
        int maxLength=500;
        int gridSize=11;
        int charNum=9;
        String testing="";
        for(int x=0;x<gridSize;x++){
            int val=0+(x*50);
            xCoord[x]=val;
            yCoord[x]=val;
            g.drawLine(val, 0, val, maxHeight);
            g.drawLine(0, val,maxLength, val);
        }
        for(int x=0;x<charNum;x++){
            testing=String.valueOf((char)(65+x));
            int val=0+(x*50);
            g.drawString(testing, 70+val, 30);
            g.drawString(String.valueOf(x),20,80+val);
        }
    }
    public void paintComponent(Graphics g){
        grid(g);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boardInit();
    }
    
}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work