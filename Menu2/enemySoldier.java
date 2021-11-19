import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemySoldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemySoldier extends Enemies
{
    private int En_SoldierLife = 50;      
    
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
        int PlayerY = soldier.getY();
        turnTowards(PlayerX,PlayerY);
        move(2);
         
    }
}
