/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import java.awt.Canvas;
import java.awt.Color;
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
        //JButton bAttack1, bAttack2,bAttack3,bFire; //declaring variables as buttons
        JButton bAttack1 =new JButton("Normal Attack");
       // JButton bAttack2=new JButton("Cross Attack");
       // JButton bAttack3=new JButton("2x2 Attack");
       // JButton bFire=new JButton("fire");
        bAttack1.setBounds(600, 30,50,50);
        bAttack1.setSize(50, 50);
       // bAttack2.setSize(50, 50);
       /// bAttack3.setSize(50, 50);
       // bFire.setSize(50, 50);
        //bAttack2.setBounds(600,110,610,160);
        //bAttack3.setBounds(600,190,610,240);
        //bFire.setBounds(600,400,610,450);
        screen.add(bAttack1);
       // screen.add(bAttack2);
       // screen.add(bAttack3);

        button();
        screen.setSize(1000,700);
        screen.setVisible(true);
        //screen.setResizable(false);

    }

    public void grid(Graphics g){
        int maxHeight=500;
        int maxLength=500;
        int gridSize=11;
        int charNum=9;
        String letter="";


        g.setColor(Color.blue);
        g.fillRect(50, 50, maxLength-50, maxHeight-50);
        g.setColor(Color.black);


        for(int x=0;x<gridSize;x++){
            int val=0+(x*50);
            xCoord[x]=val;
            yCoord[x]=val;
            g.drawLine(val, 0, val, maxHeight);
            g.drawLine(0, val,maxLength, val);
        }
        for(int x=0;x<charNum;x++){
            letter=String.valueOf((char)(65+x));
            int val=0+(x*50);
            g.drawString(letter, 70+val, 30);
            g.drawString(String.valueOf(x),20,80+val);
        }
    }

    public static void button(){

       //bAttack2.
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
