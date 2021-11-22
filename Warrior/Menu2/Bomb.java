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
        canSee();
    }
    public void move()
    {
        move(10);
    }
     
    public void canSee()
    {
        int number = 0;
        if( isTouching(Brick.class) )
        {
           //setImage("");
            
           getWorld().removeObject(this);
       
        }
    }
}
