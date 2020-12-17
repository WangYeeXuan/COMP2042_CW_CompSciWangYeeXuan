package model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Music_player{

	private MediaPlayer mediaPlayer;
	
	/**
	 * Load music player
	 */
	public Music_player(){
		
		String musicFile = "src/main/resources/audio/Frogger Main Song Theme (loop).mp3";   
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		
	}
	
	/**
	 * Play music
	 */
	public void play() {
		
	    mediaPlayer.play();
	}
	
	/**
	 * Stop music
	 */
	public void stop() {
		mediaPlayer.stop();
	}
	
}
