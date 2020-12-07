package model;

import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;

import java.util.ArrayList;

/**
 * This class allow other class to implement its act method. ImageView is manipulated by moving it around in the GUI and check for collision
 * @author E.B. Wang
 *
 */
public abstract class Actor extends ImageView{
	
	/**
     * Method to move Actor/ImageView object on x & y axis according to arguments.
     * @param dx indicate amount of movement on x axis
     * @param dy indicate amount of movement on y axis
     */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    /**
     * Method to return the World object that the Actor resides in.
     * @return returns Parent of the Actor object as a World object
     */
    public World getWorld() {
        return (World) getParent();
    }
    
    /**
     * Gets the width relative to where it resides in the World/Parent
     * @return returns width of Actor relative to Parent 
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }
    
    /**
     * Gets height relative to where it resides in the World/Parent
     * @return returns height of Actor relative to Parent
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }
    
    /**
     * Is a method that check intersection between objects
     * @param <A> empty arraylist
     * @param cls object to check intersections with
     * @return an array that contain all actors that are intersecting
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
    
    //public void manageInput(InputEvent e) {
    //    
    //}
    
    /**
     * This Abstract method is to get parameter now
     * @param now
     */
    public abstract void act(long now);

}
