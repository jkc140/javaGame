package battleship;
import java.awt.*;
import javax.swing.*;

public class grid extends JPanel{
  public  int[] xCoord=new int[12];
  public  int[] yCoord=new int[12];
  public void boardInit(Graphics g){
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
  public Dimension getPreferredSize() {
	    return new Dimension(100,100);
	}
  public void paintComponent(Graphics g){
	  boardInit(g);
  }
}
