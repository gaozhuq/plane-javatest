package cn.bjsxt.test;

import java.awt.Graphics;
import java.awt.Image;

import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;

public class TuoYuan extends MyFrame{
	
	Image img=GameUtil.getImage("images/sun.jpg");
	 double x=300,y=200;
	 double degree=0;
	 private double a=100,b=80;
	 int init=200;
	// int wx=500,wy=500;
	
	
	@Override
	public void paint(Graphics g) {	
		g.drawOval(init-(int)a, init-(int)b, (int)a*2, (int)b*2);
		g.drawImage(img, (int)x-15, (int)y-15, null);
		x=init+a*Math.cos(degree);
		y=init+b*Math.sin(degree);
		if(degree>=6.28){
			degree-=6.28;
		}else if(degree <0){
			degree+=6.28;
		}
		else{
			degree+=0.1;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TuoYuan().launchFrame();

	}
}
