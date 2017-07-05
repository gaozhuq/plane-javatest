package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.bjsxt.util.Constant;

public class Bullet extends GameObject{
	
	double degree;
	static double speed=2;

	

	public Bullet() {
		degree=Math.random()*Math.PI*2;
		x=Constant.GAME_WIDTH/2;
		y=Constant.GAME_HEIGHT/2;
		width=10;
		height=10;
		
	}
	
	

	public void draw(Graphics g){
		Color color=g.getColor();
		g.setColor(Color.red);
		g.fillOval((int)x, (int)y, (int)width, (int)height);
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(y<30 || y>Constant.GAME_HEIGHT-height){
			degree=-degree;
		}
		if(x>Constant.GAME_WIDTH-width || x<0){
			degree=Math.PI-degree;
		}	
		g.setColor(color);
	}
}
