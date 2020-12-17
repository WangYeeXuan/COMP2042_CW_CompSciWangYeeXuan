package model;

import javafx.scene.image.ImageView;


import java.util.ArrayList;

/**
 * This class allow other class to implement its act method. ImageView is manipulated by moving it around in the GUI and check for collision
 * @author Wang
 *
 */
public abstract class Actor extends ImageView{

	/**
     * This method is to move Actor/ImageView object on x & y axis according to arguments.
     * @param dx indicate amount of movement on x axis
     * @param dy indicate amount of movement on y axis
     */
    protected void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
    
    /**
     * Method to return the World object that the Actor resides in.
     * @return returns Parent of the Actor object as a World object
     */
    private World getWorld() {
        return (World) getParent();
    }
    
    /**
     * This method is to check intersection between objects
     * @param <A> empty arraylist
     * @param cls object to check intersections with
     * @return an array that contain all actors that are intersecting
     */
    protected <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }
   
    /**
     * This Abstract method is to get parameter now
     * @param now now
     */
    public abstract void act(long now);

}
