
package cn.bjsxt.test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;


public class GameFrame02 extends MyFrame {
	Image img=GameUtil.getImage("images/sun.jpg");
	 double x=0,y=0;
	 double degree=3.14/3;
	 private double speed=10;
	// int wx=500,wy=500;
	
	
	@Override
	public void paint(Graphics g) {	
		g.drawImage(img, (int)x, (int)y, null);
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		if(speed >0){
			speed-=0.02;
		}else{
			speed=0;
		}
		if(y<0 || y>500-30){
			degree=-degree;
		}
		if(x>500-30 || x<0){
			degree=Math.PI-degree;
		}	
		
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame02().launchFrame();

	}

}

