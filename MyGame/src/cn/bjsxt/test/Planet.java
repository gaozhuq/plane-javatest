package cn.bjsxt.test;

import java.awt.Color;
import java.awt.Graphics;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;

public class Planet extends Star {
	//行星起始位置 x，y，行星绕着star飞，行星速度。
	double longAxis;
	double shortAxis;
	Star center;
	double speed;
	double degree;
	
	
	
	public Planet(double longAxis, double shortAxis, Star center, double speed, double degree,double width, double height) {
		super(width, height);
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.center = center;
		this.speed = speed;
		this.degree = degree;
	}

	public void draw(Graphics g,String imagePath){
		Color color=g.getColor();
		g.setColor(Color.YELLOW);
		g.drawOval((int)(center.x-longAxis+center.width/2), (int)(center.y-shortAxis+center.height/2), (int)longAxis*2, (int)shortAxis*2);
		 x=center.x + center.width/2-this.width/2+longAxis*Math.cos(degree);
		 y=center.y+center.height/2-this.height/2+shortAxis*Math.sin(degree);
		 g.drawImage(GameUtil.getImage(imagePath), (int)x, (int)y, null);
		 degree+=speed;
	}
	

}
