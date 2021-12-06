import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Brick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Brick extends Objects
{
    public Brick(){
        this(100,25);
    }
    public Brick( int width, int height){
        GreenfootImage image = getImage();
        image.scale(width,height);
        setImage(image);
    }
    public void act()
    {
        // Add your action code here.
    }
}
