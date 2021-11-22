import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
    Arrow arrow = new Arrow();
    private int option=0;
    /**
     * Constructor for objects of class Menu.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        worldpreparation();
    }
    private void worldpreparation(){
        addObject(new play(),400,250);
        addObject(new option(),400,350);
        addObject(arrow,79,250);
        
    }
    public void act(){
        if(Greenfoot.isKeyDown("UP")&& option!=0) {option++;}
        if(Greenfoot.isKeyDown("DOWN")&& option!=1) {option--;}
        
        if(option>=2)option=0;
        if(option<0)option=1;
        
        arrow.setLocation(79,250 +(option*100));
        
        if(Greenfoot.isKeyDown("SPACE")||Greenfoot.isKeyDown("ENTER")){
            switch(option){
                case 0://play
                Greenfoot.setWorld(new Level1());
                break;
                case 1://options
                Greenfoot.setWorld(new options());
                break;
            }
            
            
        }
    }
}

