/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author S331474817
 */
public class BattleShip {

        public static JButton bAttack1, bAttack2,bAttack3,bFire; //declaring variables as buttons


        public static void buttonConfig(){


        bAttack1 =new JButton("Normal Attack");
       /*JButton bAttack2=new JButton("Cross Attack");
        JButton bAttack3=new JButton("2x2 Attack");
       JButton bFire=new JButton("fire");*/
        bAttack1.setBounds(600, 30,120,50);
        //bAttack1.setSize(50, 50);
       // bAttack2.setSize(50, 50);
       /// bAttack3.setSize(50, 50);
       // bFire.setSize(50, 50);
        //bAttack2.setBounds(600,110,610,160);
        //bAttack3.setBounds(600,190,610,240);
        //bFire.setBounds(600,400,610,450);
       // screen.add(bAttack2);
       // screen.add(bAttack3);



    }
    public static void screenInit(){
      JFrame screen = new JFrame("test");
      JPanel test= new grid();
      //screen.setLayout(null);
      buttonConfig();

      screen.add(bAttack1);
      screen.add(test);

      screen.setSize(1000,700);
      screen.setVisible(true);
      screen.setResizable(false);
      screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        screenInit();
    }

}


//https://stackoverflow.com/questions/15544549/how-does-paintcomponent-work
//https://stackoverflow.com/questions/20343667/java-graphics-graphics-panel-and-buttons-panel
