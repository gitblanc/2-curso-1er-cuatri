package player;


import java.io.File;

import javazoom.jlgui.basicplayer.*;

public class MusicPlayer {
	private BasicPlayer basicPlayer = null;
	
	public MusicPlayer(){
		basicPlayer = new BasicPlayer();
	}
	
	public void play (File file){
		try {
			basicPlayer.open(file);
			basicPlayer.play();
		}
		catch (Exception e){}
	}
	
	public void stop(){
		try {
			basicPlayer.stop();
		}
		catch (BasicPlayerException e){
		}
	}
	
	public void setVolume(double vol, double volMax){
		try{
			
			basicPlayer.setGain(vol/volMax);
		}
		catch (BasicPlayerException e){
		}
	}
}
