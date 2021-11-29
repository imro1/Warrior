import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private int delay = 0;
    private boolean waiting = false;
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
        for( int i = 0; i <= 0; i++){
           int x = 950; 
           int y =(540);
           //int y = 530;
           addObject( new enemySoldier(), x, y );
           addObject( new enemySoldier(),950,540);
           waiting = true;
        } 
        
    }
    public void act()
    {
        if (waiting) {
            delay++;
            if (delay >= 200) { // you'll have to pick a number for limit
           
                int x = 950; 
                int y = 540;
                //int y = 530;
                addObject( new enemySoldier(), x, y );
                addObject( new enemySoldier(),0,540);
                waiting = true;
                delay = 0;
                // you may set waiting to true or false depending on if you want to add more objects or just one
            }
        } 

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

        soldier.setLocation(436,515);
        soldier.setLocation(430,14);

        Border border = new Border();
        addObject(border,30,525);
        border.setLocation(30, 525);

        
    }
}
