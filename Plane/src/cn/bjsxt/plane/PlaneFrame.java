package cn.bjsxt.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cn.bjsxt.util.Constant;
import cn.bjsxt.util.GameUtil;
import cn.bjsxt.util.MyFrame;


public class PlaneFrame extends MyFrame{
	int startTime;
	int endTime;
	int time=0;
	int counttime=0;
	Plane plane1=new Plane(50, 50);
	
	ArrayList<Bullet> bullets=new ArrayList<>();
	
	Image image=GameUtil.getImage("img/bg.jpg");
	
	
 
	public void paint(Graphics g){
		Calendar current=Calendar.getInstance();
		int currenttime=(int)current.getTimeInMillis();
		
		g.drawImage(image, 0, 0, null);
		plane1.draw(g,"img/plane.jpg");
		for(int k=0;k<bullets.size();k++){
			Bullet bullet=(Bullet)bullets.get(k);
			bullet.draw(g);
			boolean peng;
			peng=bullet.getRect().intersects(plane1.getRect());
			if(peng){
				plane1.setLive(false);
				Calendar calendar=Calendar.getInstance();
				endTime=(int)calendar.getTimeInMillis();
				Bullet.speed=0;
				
			}
		}
		
		if(!plane1.isLive()){
			time=(endTime-startTime)/1000;
			printInfo(g, "时间:"+time+"秒", 20,Color.WHITE,60,60);
			plane1.level(time, g);
			
		}else{
			counttime=((currenttime-startTime)/1000);
		}
		printInfo(g, "计时:"+counttime+"秒", 20,Color.white,350,50);
			
		
	}
	
	public static void printInfo(Graphics g,String str,int size,Color c,int x,int y){
		Color color =g.getColor();
		g.setColor(c);
		Font font=new Font("宋体", NORMAL, size);
		g.setFont(font);
		g.drawString(str, x, y);
		g.setColor(color);
	}
	
	public void launchFrame(){
		
		super.launchFrame();
		for(int k=0;k<10;k++){
			Bullet bullet=new Bullet();
			bullets.add(bullet);
		}
		Calendar calendar=Calendar.getInstance();
		
		startTime=(int)calendar.getTimeInMillis();
		//System.out.println(startTime);
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("PRESSED:"+e.getKeyCode());
				plane1.controlDirection(e);
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("released"+e.getKeyCode());
				plane1.releaseDirection(e);
				
				
				
			}
			
		});
		
	}
	
	

	public static void main(String[] args) {
		
		
		new PlaneFrame().launchFrame();

	}

}
