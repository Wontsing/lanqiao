import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y;
	int i,j;
	int leftFlag,rightFlag,upFlag,downFlag;
	Image downImg,leftImg,rightImg,upImg,downImg1,leftImg1,rightImg1,upImg1,downImg2,leftImg2,rightImg2,upImg2,currentImg;
	public MainCanvas(){
		try
		{ 
			downImg   = Image.createImage("/sayo10.png");
			leftImg   = Image.createImage("/sayo12.png");
			upImg     = Image.createImage("/sayo14.png");
			rightImg  = Image.createImage("/sayo16.png");
			downImg1  = Image.createImage("/sayo00.png");
			leftImg1  = Image.createImage("/sayo02.png");
			upImg1    = Image.createImage("/sayo04.png");
			rightImg1 = Image.createImage("/sayo06.png");
			downImg2  = Image.createImage("/sayo20.png");
			leftImg2  = Image.createImage("/sayo22.png");
			upImg2    = Image.createImage("/sayo24.png");
			rightImg2 = Image.createImage("/sayo26.png");
			currentImg = downImg;
			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;

			x=120;
			y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		  g.setColor(0,0,0);
		  g.fillRect(0,0,getWidth(),getHeight());
		  g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		
		repaint();
	    int action = getGameAction(keyCode);
		if(action == LEFT){
	
			if(leftFlag==1){
			currentImg=leftImg1;
			leftFlag++;
			
			
			}
			else if(leftFlag==2){
			currentImg=leftImg2;
			leftFlag=1;
			
			
			}	x=x-1;
			//currentImg=leftImg;
		}
		else if(action == UP){
				if(upFlag==1){
			currentImg=upImg1;
			upFlag++;
			
			
			}
			else if(upFlag==2){
			currentImg=upImg2;
			upFlag=1;
			
			
			}y=y-1;
			//currentImg=upImg;
		}
		else if(action == DOWN){
			if(downFlag==1){
			currentImg=downImg1;
			downFlag++;
			}
			else if(downFlag==2){
			currentImg=downImg2;
			downFlag=1;
			
			}	y=y+1;
			//currentImg=downImg;
		}
		else if(action == RIGHT){
			if(rightFlag==1){
			currentImg=rightImg1;
			rightFlag++;
			
			
			}
			else if(rightFlag==2){
			currentImg=rightImg2;	
			
			rightFlag=1;
			
			}x=x+1;
				//currentImg=rightImg;
		}
		
		repaint();
	}
}