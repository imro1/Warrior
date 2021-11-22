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
        super(900, 600, 1); 
        prepare();
        setPaintOrder(Plane.class);
        for( int i = 0; i <= 6; i++){
           int x = 950; int y = 530;
           addObject( new enemySoldier(), x, y);
        }
    }
    public void act()
    {
        //Enemy Soldiers
      /*  if (Greenfoot.getRandomNumber(100) < 5) {
             addObject( new  enemySoldier(), 50, 530);
            }
        if (Greenfoot.getRandomNumber(1000) < 5) {
            addObject( new  enemySoldier(), 950,530);
        }
        */
     
        //Enemy Planes
        if (Greenfoot.getRandomNumber(1000) <= 3) {
             addObject( new  Plane(), 1, Greenfoot.getRandomNumber(40)+40);
             
            }
        /*if (Greenfoot.getRandomNumber(1000) <= 5) {
            addObject( new  Plane(), 1000,80);
        }   */         
    }

    public void prepare() {
        
        Soldier soldier = new Soldier();
        addObject(soldier,149,515);
        ///////////////////////////////////////////////////////////
        /*
        enemySoldier enemySoldier = new enemySoldier();
        addObject(enemySoldier,947,530);
         */
        ///////////////////////////////////////////////////////////
        Brick brick2 = new Brick(250, 30);
        addObject(brick2,450,420);
        brick2.setLocation(450,420);

    }
}
