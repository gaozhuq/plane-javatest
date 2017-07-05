package cn.bjsxt.test;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;

public class SolarSystem extends MyFrame{
	
	Image image=GameUtil.getImage("images/bg.jpg");
	Star sun=new Star("images/sun.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2,30,30);
	Planet earth=new Planet(150, 80, sun, 0.1, 0, 30, 30);
	Planet moon=new Planet(50, 20, earth, 0.1, 0, 10, 10);
	public void paint(Graphics g){
		g.drawImage(image, 0, 0,null);
		
		sun.draw(g);
		earth.draw(g,"images/earth.jpg");
		moon.draw(g,"images/earth2.jpg");
		
	}

	
	public static void main(String[] args){
		new SolarSystem().launchFrame();
	}
}
