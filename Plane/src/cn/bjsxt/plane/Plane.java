package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import cn.bjsxt.util.GameUtil;

public class Plane extends GameObject{
	boolean right,left,up,down;
	boolean live=true;
	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Plane(double x, double y) {
		super();
		this.x = x;
		this.y = y;
		
		
		
	}
	
	public void  level(int time,Graphics g){
		switch (time) {
		case 1:
			PlaneFrame.printInfo(g, "等级：菜鸟", 20, Color.yellow, 60, 100);
			break;

		default:
			PlaneFrame.printInfo(g, "等级：大鸟", 20, Color.yellow, 60, 100);
			break;
		}
	}	
	public void controlDirection(KeyEvent e){
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			down=true;
			break;
		case KeyEvent.VK_UP:
			up=true;
			break;
		case KeyEvent.VK_LEFT:
			left=true;
			break;
		case KeyEvent.VK_RIGHT:
			right=true;
			break;
		default:
			break;
		}
	}
		public void releaseDirection(KeyEvent e){
			switch (e.getKeyCode()) {
			case KeyEvent.VK_DOWN:
				down=false;
				break;
			case KeyEvent.VK_UP:
				up=false;
				break;
			case KeyEvent.VK_LEFT:
				left=false;
				break;
			case KeyEvent.VK_RIGHT:
				right=false;
				break;

			default:
				break;
			}
		}
		
		
	
	public void move(){
		if(left){
			x-=5;
		}
		if(right){
			x+=5;
		}if(up){
			y-=5;
		}if(down){
			y+=5;
		}
		
	}
	
	public void draw(Graphics g,String imagepath){
		if(live){
			g.drawImage(image, (int)x, (int)y, null);
		}
		
		image=GameUtil.getImage(imagepath);
		this.width=image.getWidth(null);
		this.height=image.getHeight(null);
		move();
		
	}

}

