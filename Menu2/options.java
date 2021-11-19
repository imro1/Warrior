import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class options extends World
{
    Arrow arrow = new Arrow();
    private int option=0;
    /**
     * Constructor for objects of class options.
     * 
     */
    public options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        objectpreparation();
    }
    private void objectpreparation(){
        addObject(new back(),326,346);
        addObject(arrow,49,350);
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("SPACE")||Greenfoot.isKeyDown("ENTER")){
            Greenfoot.setWorld(new Menu());
        }
    }
}
