import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 //declare Sprinkles variables here 
 Sprites [] soot;
 Sprinkles [] candy;
 int pinkC, yellowC, whiteC, greenC;
 public void setup()   
 {     
 	size(800,800);
 	frameRate(30);
 	soot = new Sprites[100];
 	candy = new Sprinkles[20];
 	pinkC = color(252, 177, 207);
	whiteC = color(255, 242, 247);
	greenC = color(170, 250, 199);
	yellowC = color(255, 241, 135);

 	for (int i = 0; i < candy.length; i++)
 	{
 		int myC = color(0,0,0);
 		pinkC = color(252, 177, 207);
 		whiteC = color(255, 242, 247);
 		greenC = color(170, 250, 199);
 		yellowC = color(255, 241, 135);
 		if (Math.random() < .25f && Math.random() > 0)
 		{
 			myC = pinkC;
 		}
		else if (Math.random() >.25f && Math.random() <.5f)
 		{
 			myC = yellowC;
 		}
 		else if (Math.random() >.5f && Math.random() < .75f)
 		{
 			myC = whiteC;
 		}
 		else
 		{
 			myC = greenC;
 		}
 		int bX = ((int)(random(0, 800)));
		int bY = ((int)(random(0, 800)));
 		candy[i] = new Sprinkles(bX, bY,myC);
 	}
 	for (int i = 0; i < soot.length; i++)
 	{
 		int bX = ((int)(random(0, 800)));
		int bY = ((int)(random(0, 800)));
 		soot[i] = new Sprites(bX, bY);
 	}
 }   
 public void draw()   
 {    
	background(115, 41, 33);
	for (int i = 0; i < candy.length; i++)
 	{
 		candy[i].show();
 		//candy[i].eatCheck();
 	}
	for (int i = 0; i < soot.length; i++)
	{
		soot[i].walk();
		soot[i].show();
	}
	for (int i = 0; i < candy.length; i++)
 	{
 		//candy[i].show();
 		candy[i].eatCheck();
 	}
}  

class Sprinkles    
 {     
 	int myX;
 	int myY;
 	int myC;
 	Sprinkles (int x, int y, int c)
 	{
 		myX = x;
 		myY = y;
 		myC = c;
 	}
 	public void show()
 	{
 		
 		fill(myC); //yellow
 		noStroke();
 		rect(myX-4, myY-4, 8, 8, -4);
 		ellipse(myX, myY, 10, 10);
 	}
 	public void eatCheck()
 	{
 		if (get(myX, myY) != myC )
 		{
 			println("ALERT!");
 			myX = -10;
 		}
 	}
 }   
class Sprites
{
	int myX;
 	int myY;
	Sprites (int x, int y)
 	{
 		myX = x;
 		myY = y;
 	}
 	public void show()
 	{
 		fill(0);
 		ellipse(myX, myY, 20, 20);
 		stroke(0);
 		strokeWeight(3);
 		line(myX - 9, myY - 9, myX + 9, myY + 9); //diagonal top left
 		line(myX, myY + 12, myX, myY - 12); //perpendicular
 		line(myX + 12, myY, myX - 12, myY); //horizontal
 		line(myX - 9, myY +9, myX+9, myY-9);
 		noStroke();
 		fill(255);
 		ellipse(myX-4, myY-1, 6, 7);
 		ellipse(myX+4, myY-1, 6, 7);
 		fill(0);
 		ellipse(myX-4, myY-1, 2.5f, 2.5f);
 		ellipse(myX+4, myY-1, 2.5f, 2.5f);
 	}
 	public void walk()
 	{
 		myX = myX + (int)(Math.random()*5)-2;
 		myY = myY + (int)(Math.random()*5)-2;
 	}
 	
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
