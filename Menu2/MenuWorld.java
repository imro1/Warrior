import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MenuWorld extends World

{
    private int frame=0;
    /**
     * Constructor for objects of class MenuWorld.
     * 
     */
    public MenuWorld(int x, int y )
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(x, y, 1); 
    }
    protected boolean goodToContinue(){
        frame++;
        if(frame < 30) {return false; }
        return true;
    } 
    
    
}
