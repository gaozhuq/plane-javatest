package cn.bjsxt.test;

import java.awt.Graphics;
import java.awt.Image;
import cn.bjsxt.util.GameUtil;

public class Star {
	Image image;
	 double x;
	 double y;
	double width,height;
	
	
	public Star(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	public Star(String imagepath,int x,int y,double width, double height){
		this(width,height);
		image=GameUtil.getImage(imagepath);
		this.x=x;
		this.y=y;
	}

	public void draw(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
	}

}
