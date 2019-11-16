package battleship;
import java.awt.*;
import javax.swing.*;

public class grid extends JPanel{

    public void gridInit(Graphics g){ //create a function called boardInit to create the grid
        int maxHeight=500; //create a variable to hold the max height of the board
        int maxLength=500; //create a variable to hold the max width of the board
        int gridSize=11; //create a variable to hold how many columns and rows are on the grid (number of columns is 1 less because gridsize holds the number of lines that divide columns and rows)
        int charNum=gridSize-2; //create a variable to hold the number of columns in the grid (two less than gridsize as two lines (1 column is used for the numbers)
        String letter=""; //create a variable to hold the letters that are placed on top


        g.setColor(Color.blue);// set colour to blue
        g.fillRect(50, 50, maxLength-50, maxHeight-50); //draw a rectangle that is filled in with blue that is 100 smaller in length and width of the grid
        g.setColor(Color.black); //changes the colour to black


        for(int x=0;x<gridSize;x++){ //draws the grid lines (loops for the number of lies that need to be drawn)
            int val=(x*50); //create a variable called val to hold the temporary x or y value of the grid ( set it to be 50 times the grid/column as every slot/square is 50 by 50

            g.drawLine(val, 0, val, maxHeight); //draws the column lines
            g.drawLine(0, val,maxLength, val); //draws the row lines based
        }
        for(int x=0;x<charNum;x++){ //draws the letts and numbers on the row and columns
            letter=String.valueOf((char)(65+x)); // set letter to be A to the number of columns (converts 65+x to a char and then convert it to a string) (65 is the start of capital letters)
            int val=(x*50); //same as previous val
            g.drawString(letter, 70+val, 30); //draws the letters on the top row roughly in the center of the column
            g.drawString(String.valueOf(x),20,80+val);  //draws the numbers on the left most column roughly in the center of the row
        }
    }
    public void switchScreen(Graphics g,int turn) { //create a class that will let the users witch players so they don't know where the others ships are
    	Font switchFont=new Font("Verdana", Font.BOLD,40);//create an object of class font that will change the font used when drawing text
    	g.setFont(switchFont); //set the font to switchFont (make it so that this is the font that is used
    	g.drawString("Player "+turn,300,300); // draws/write the word player with a number roughly in the center of the screen
    	
    }
    
  public Dimension getPreferredSize() { //calls funtion getPrefferedSize
	    return new Dimension(100,100);  //set the Dimension to be 100 by 100
	}
  public void paintComponent(Graphics g){ //override the function paintComponent
	  gridInit(g); //calls function boardInit to show board
  }
}
