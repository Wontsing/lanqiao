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
{	        int HeroX,HeroY;
            Image HeroImg;
            int flag;
			/*Image heroImg0,heroImg1,heroImg2,heroImg3,heroImg4,heroImg5,heroImg6,heroImg7,heroImg8;*/
			/*Image heroLeftImg[]=new Image[3];
			Image heroUpImg[]=new Image[3];
			Image heroDownImg[]=new Image[3];
			Image heroRightImg[]=new Image[3];*/
			Image heroImg[][]=new Image[4][3];
	public MainCanvas(){
		try{
			/*heroImg0 =Image.createImage("/sayo10.png");//down
			heroImg1 =Image.createImage("/sayo02.png");//left
			heroImg2 =Image.createImage("/sayo22.png");
			heroImg3 =Image.createImage("/sayo00.png");//down
			heroImg4 =Image.createImage("/sayo20.png");//down
			heroImg5 =Image.createImage("/sayo06.png");//right
			heroImg6 =Image.createImage("/sayo26.png");
			heroImg7 =Image.createImage("/sayo04.png");//up
			heroImg8 =Image.createImage("/sayo24.png");*/
//
              for (int i=0;i<heroImg.length ;i++ ){
				  for (int j=0;j<heroImg[0].length ;j++ ){
				   heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				  }

				
			  }
           /* for (int i=0;i<heroDownImg.length ;i++ ){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}*/

			flag=1;
			HeroX=100;
			HeroY=120;
			HeroImg=heroImg[0][1];
			
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void movAndDirect(int direction){
	       if(flag==1){
			HeroImg=heroImg[direction][0];
		     flag=2;
			}
			else{
				HeroImg=heroImg[direction][2];
			flag=1;}
	}
	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(HeroImg,HeroX,HeroY,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT){
			
		 movAndDirect(1);
		 HeroX=HeroX-1;
		}
		else if(action==RIGHT){
			movAndDirect(3);
		
		 HeroX=HeroX+1;
		}
		else if(action==UP){
			movAndDirect(2);
		
		 HeroY=HeroY-1;
		}
		else if(action==DOWN){
			movAndDirect(0);
	
		 HeroY=HeroY+1;
		}
		repaint();
	}
}