import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemySoldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemySoldier extends Enemies
{
    private int En_SoldierLife = 20;   
    
    GifImage E_image1 = new GifImage ("walking.gif"); 
    GifImage E_image2 = new GifImage ("walking180.gif");
    
    public void act()
    {
        // Add your action code here.
        chasing();
    }
    public void hit(int damage) 
    {
        En_SoldierLife = En_SoldierLife - damage;
        if (En_SoldierLife <= 0) {
            getWorld().removeObject(this);
        }
    }
    
    //we need to figue out how to make the enemy chase while its on the ground
    public void chasing()
    {
        Soldier soldier = (Soldier)getWorld().getObjects(Soldier.class).get(0);
        int PlayerX = soldier.getX();
        
        //int PlayerY = soldier.getY();  dont want it to follow ur y axis
        turnTowards(PlayerX,540);
        move(2);
        setRotation(0);
        //the image used will depend on which side the player is located
        if( PlayerX < getX() ) {
            setImage(E_image1.getCurrentImage());
        }
        if( PlayerX > getX() ) {
            setImage(E_image2.getCurrentImage());
        }
        
    }
}
