import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class options extends MenuWorld
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
        super(800, 450); 
        objectpreparation();
    }
    private void objectpreparation(){
        addObject(new back(),351,347);
        addObject(new controlsButton(),246,270);
        addObject(arrow,76,272);
    }
    
    public void act(){
        boolean good=goodToContinue(); 
    if(good == false){
        return;
    }
    if(Greenfoot.isKeyDown("UP")&& option!=0) {option++;}
    if(Greenfoot.isKeyDown("DOWN")&& option!=1) {option--;}
        
    if(option>=2)option=0;
    if(option<0)option=1;
        
    arrow.setLocation(76,272 +(option*75));
        
    if(Greenfoot.isKeyDown("SPACE")||Greenfoot.isKeyDown("ENTER")){
     switch(option){
                case 0://play
                Greenfoot.setWorld(new controls());
                break;
                case 1://options
                Greenfoot.setWorld(new Menu());
                break;
            }          
        }
        }
    }

