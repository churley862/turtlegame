import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class Background 
{
	private Image img;
	private double offset = 0.25;
	private double Xbg = 0;
	private int width;

	public Background() {
		// TODO Auto-generated constructor stub
	}
	
	public void init(GameContainer gc) throws SlickException {
		img = new Image("/Users/kitchen/Desktop/water_bg.jpg");
		width = img.getWidth();
	}
	


	public void update(GameContainer gc, int delta) throws SlickException {
	if (Xbg > -width)
	{
		Xbg-= offset * delta;
	}
	else 
		Xbg = 0;
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
//		float scale = 0.6f;
		img.draw((int) Xbg, 0, 1.0f);
		img.draw((int) Xbg + width, 0, 1.0f);
		
		
		// g.drawImage
		//String pos = "X: " + Integer.toString(tx);
		//g.drawString(pos, 10, 100);
	}

}
