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
    
    public static int[] xCoord=new int[10];
    public static int[] yCoord=new int[10];
    
    
    public static void boardInit(){
        JFrame screen = new JFrame("test");
        BattleShip ship = new BattleShip();
        screen.add(ship);
        screen.setSize(1000,500);
        screen.setVisible(true);
        screen.setResizable(false);
 
    }
    public void grid(Graphics g){
        int maxHeight=450;
        int maxLength=450;
        int gridSize=10;
        String testing="";
        for(int x=0;x<gridSize;x++){
            //testing=String.valueOf(char(65+x));
            int val=0+(x*50);
            xCoord[x]=val;
            yCoord[x]=val;
            g.drawLine(val, 0, val, maxHeight);
            g.drawLine(0, val,maxLength, val);
            //g.drawString(, 25, 25);
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