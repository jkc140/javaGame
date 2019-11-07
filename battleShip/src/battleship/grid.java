/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author S331474817
 */
public class grid extends JPanel{
    public int[] xCoord=new int[10];
    public int[] yCoord=new int[10];
    public void boardInit(Graphics g){
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
        //testing
                
        
    }
    public void paintComponent(Graphics g){
        boardInit(g);
    }
}
