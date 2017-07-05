package cn.bjsxt.plane;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	double x;
	double y;
	double width,height;
	Image image;
	
public Rectangle getRect() {
		
		return new Rectangle((int)x, (int)y, (int)width, (int)height);
	}

}
