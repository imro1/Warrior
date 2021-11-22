import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane extends Enemies
{
    private int speed;
    
    public Plane() {
        speed = Greenfoot.getRandomNumber(10) + 5;
    }
    
    public void act()
    {
        setLocation(getX() + speed, getY());
        bombFalling();
        touchingEdge();
        
    }
    
    public void bombFalling(){
        
        //int num =  Greenfoot.getRandomNumber(500) +200 ;
        if ( getX() >= 200 && getX() <= 400) {
            getWorld().addObject(new Bomb(), getX(), getY()); 
        }
        
    }
    
    public void touchingEdge() {
        if( isAtEdge() ) {
            getWorld().removeObject(this);
        }
    }
}
