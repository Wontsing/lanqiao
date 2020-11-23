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
	int x,y,flag;
    Image heroImg[][]=new Image[4][3];
	Image currentImg;
	public MainCanvas(){
		try
		{ 
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[0].length;j++){
			       heroImg[i][j]  = Image.createImage("/sayo"+i+j+".png");//i£º0×ó¡¢3ÓÒ¡¢1ÉÏ¡¢2ÏÂ
			    }
			}
			currentImg = heroImg[2][1];
			flag=1;
			x=120;
			y=100;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		  g.setColor(255,180,182);
		  g.fillRect(0,0,getWidth(),getHeight());
		  g.drawImage(currentImg,x,y,0);
	}
	public void changeAndDirect(int direction){
	    if(flag==1){
			currentImg= heroImg[direction][0];
			flag=2;
			}
			else if(flag==2){
			currentImg= heroImg[direction][2];
			flag=1; 
			} 
	}
	public void keyPressed(int keyCode){
		
	    int action = getGameAction(keyCode);
		if(action == LEFT){
			changeAndDirect(0);
			x=x-3;	
		}
		else if(action == UP){	
		    changeAndDirect(1);
			y=y-3;
		}
		else if(action == DOWN){
		    changeAndDirect(2);
		    y=y+3;
		}
		else if(action == RIGHT){
			changeAndDirect(3);
			x=x+3;
		}
		repaint();
	}
}
