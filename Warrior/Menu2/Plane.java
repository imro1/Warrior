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
    private int timeToDrop = 0;
    
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
       
        if (getX() >= 100 && getX() <= 800) {
            if (timeToDrop == 0){
                //time to drop the bomb
                getWorld().addObject(new Bomb(), getX(), getY()); 
                timeToDrop = 30;
            } else {
                timeToDrop--;
            }
            //time to drop the bomb
            //drop every 30 fram 
        }
    
    }
    
    public void touchingEdge() {
        if( isAtEdge() ) {
            getWorld().removeObject(this);
        }
    }
}
