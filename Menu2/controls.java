import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class controls here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class controls extends MenuWorld
{
    Arrow arrow = new Arrow();
    private int option=0;
    /**
     * Constructor for objects of class controls.
     * 
     */
    public controls()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400); 
        addObject(new keyboard(),303,203);
        addObject(new back(),351,346);
        addObject(arrow,69,347);
        addObject(new controlsButtom(),295,34);
    }
    public void act(){
         boolean good=goodToContinue(); 
    if(good == false){
        return;
    }
    
        
    if(option>=2)option=0;
    
        
    arrow.setLocation(69,347);
        
    if(Greenfoot.isKeyDown("SPACE")||Greenfoot.isKeyDown("ENTER")){
     switch(option){
                case 0://play
                Greenfoot.setWorld(new options());
                break;
                
            }          
        }
    }
}
