import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1); 
        prepare();
    }

    public void prepare() {
        
        Soldier soldier = new Soldier();
        addObject(soldier,149,515);
        enemySoldier enemySoldier = new enemySoldier();
        addObject(enemySoldier,909,504);
        Brick brick = new Brick(300, 30);
        addObject(brick,481,379);
        brick.setLocation(517,378);
    }
}
