package battleship;

import java.awt.Color;
import java.awt.Graphics;

import ship.Ship;

public class shipInit {

	 	public static Ship C;
	    public static Ship B;
	    public static Ship Cr;
	    public static Ship S;
	    public static Ship D;
	    public static void shipInit() {
	    	C =new Ship(5,"Carrier");
	    	/*B = new Ship(4,"Battleship");
	    	Cr=new Ship(3,"Cruise");
	    	S=new Ship(3,"Submarine");
	    	D=new Ship(2,"Destroyer");*/
	    }
	    public void shipDraw(Graphics g){
            //Ship C =new Ship(5,"Carrier");
						//test
    g.setColor(Color.gray);
    /*System.out.println(C.check("x")*50);
    System.out.println(C.check("y")*50);
    System.out.println(C.check("x")*50);
    System.out.println(C.check("y")*50);*/
   /* System.out.println("xStart "+C.shipPos[0][0]);
    System.out.println("yStart "+C.shipPos[0][1]);
    System.out.println("xEnd "+C.shipPos[1][0]);
    System.out.println("yEnd "+C.shipPos[1][1]);*/

    if(C.shipPos[0][0]==C.shipPos[1][0]) {
        g.fillRect(C.shipPos[0][0]*50, C.shipPos[0][1]*50, 50, C.size*50);

   	}
    else if (C.shipPos[0][1]==C.shipPos[1][1]) {
        g.fillRect(C.shipPos[0][0]*50, C.shipPos[0][1]*50, C.size*50, 50);

    }
   /* System.out.println("box xS "+C.shipPos[0][0]*50);
    System.out.println("box yS "+C.shipPos[0][1]*50);
    System.out.println("box xe "+C.shipPos[1][0]*50);
    System.out.println("box ye "+C.shipPos[1][1]*50);

    Ship B = new Ship(4,"Battleship");
    System.out.println(B.size);
    System.out.println("xStart "+B.shipPos[0][0]);
    System.out.println("yStart "+B.shipPos[0][1]);
    System.out.println("xEnd "+B.shipPos[1][0]);
    System.out.println("yEnd "+B.shipPos[1][1]);
    if(B.shipPos[0][0]==B.shipPos[1][0]) {
    	g.fillRect(B.shipPos[0][0]*50, B.shipPos[0][1]*50, 50, B.size*50);
    	//g.setColor(Color.green);
    	g.drawLine(B.shipPos[0][0]*50,  B.shipPos[1][1]*50+50, B.shipPos[0][0]*50+50, B.shipPos[1][1]*50+50);
    	System.out.println("Horizontal");
    }
    else if (B.shipPos[0][1]==B.shipPos[1][1]) {
        g.fillRect(B.shipPos[0][0]*50, B.shipPos[0][1]*50, B.size*50, 50);
        System.out.println("Vertical");
    }

    System.out.println("box xS "+B.shipPos[0][0]*50);
    System.out.println("box yS "+B.shipPos[0][1]*50);
    System.out.println("box xe "+B.shipPos[1][0]*50);
    System.out.println("box ye "+B.shipPos[1][1]*50);

    Ship Cr=new Ship(3,"Cruise");
    System.out.println("xStart "+Cr.shipPos[0][0]);
    System.out.println("yStart "+Cr.shipPos[0][1]);
    System.out.println("xEnd "+Cr.shipPos[1][0]);
    System.out.println("yEnd "+Cr.shipPos[1][1]);
    if(Cr.shipPos[0][0]==Cr.shipPos[1][0]) {
    	System.out.println("Drawing Horiz");
        g.fillRect(Cr.shipPos[0][0]*50, Cr.shipPos[0][1]*50, 50, Cr.size*50);

   	}
    else if (Cr.shipPos[0][1]==Cr.shipPos[1][1]) {
    	System.out.println("Drawing Vert");
        g.fillRect(Cr.shipPos[0][0]*50, Cr.shipPos[0][1]*50, Cr.size*50, 50);

    }


    Ship S=new Ship(3,"Submarine");
    if(S.shipPos[0][0]==S.shipPos[1][0]) {
        g.fillRect(S.shipPos[0][0]*50, S.shipPos[0][1]*50, 50, S.size*50);

   	}
    else if (S.shipPos[0][1]==S.shipPos[1][1]) {
        g.fillRect(S.shipPos[0][0]*50, S.shipPos[0][1]*50, S.size*50, 50);

    }
    Ship D=new Ship(2,"Destroyer");
    if(D.shipPos[0][0]==D.shipPos[1][0]) {
        g.fillRect(D.shipPos[0][0]*50, D.shipPos[0][1]*50, 50, D.size*50);

   	}
    else if (D.shipPos[0][1]==D.shipPos[1][1]) {
        g.fillRect(D.shipPos[0][0]*50, D.shipPos[0][1]*50, D.size*50, 50);

    }

   */
}
}
