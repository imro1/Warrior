import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Enemies
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setLocation(getX(), getY() +20);
        move();
        
        disappear();
    }
    public void move()
    {
        move(8);
    }
     
    
    
    public void disappear()
    {
        int number = 0;
        if( isTouching(Brick.class) || (isAtEdge() ))
        {
           //setImage("");

           getWorld().removeObject(this);
       
        }
        
       
    }
}
