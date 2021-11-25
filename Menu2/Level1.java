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
        super(800, 400, 1); 
    }
    public void prepare() {
        Soldier soldier = new Soldier();
        addObject(soldier,173,116);
        soldier.setLocation(182,524);
        Brick brick = new Brick(200 , 10);
        addObject(brick , 450 , 400);
    }
}
