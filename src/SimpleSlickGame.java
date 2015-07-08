
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class SimpleSlickGame extends BasicGame
{
	private Background bg;
	
	private Image turtle;
	private Image seaweed;
	private double tx;
	private double ty;
	private double dtx;
	private double dty;
	
	public SimpleSlickGame(String gamename)
	{
		super(gamename);
		bg=new Background();
		
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		bg.init(gc);
		turtle = new Image("/Users/kitchen/Desktop/turtle2.png");
		seaweed = new Image("/Users/kitchen/Desktop/seaweed.png");
		tx = 100;
		ty = 100;
		dtx = 0;
		dty = 1;
	}
	public void keyPressed(int key, char c)
	{
		if (c == 'x')
		{
			dtx = 5;
		}
		if (c == ' ')
		{
			dty -= 2;
			ty += dty;
		}
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
//		if (isKeyDown(32))
//		{
//		   dtx = 1;
//		}
		if (tx < 0 || tx > 1200)
		{
		  dtx = -dtx;
		}
		
		if (ty > 800)
		{
		  dty = 0;
		}
		else if (ty < 0)
		{
			dty = 0.01;
		}
		else
		{
			dty += 0.01;
		}
		
		tx += dtx;
		ty += dty;
		
		bg.update(gc, delta);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
//		float scale = 0.6f;
		bg.render(gc, g);
		turtle.draw((int) tx, (int) ty);
		seaweed.draw(100f,600f);
		
		// g.drawImage
		//String pos = "X: " + Integer.toString(tx);
		//g.drawString(pos, 10, 100);
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new SimpleSlickGame("Simple Slick Game"));
			appgc.setDisplayMode(1200, 856, false);
			appgc.start();
		}
		catch (SlickException ex)
		{
			Logger.getLogger(SimpleSlickGame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}