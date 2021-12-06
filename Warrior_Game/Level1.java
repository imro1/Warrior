import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends MenuWorld
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
        super(900, 600); 
        prepare();
        setPaintOrder(HealthBar.class,Border.class,Plane.class);
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
              
    }
    
    public HealthBar getHealthBar(){
     return getObjects(HealthBar.class).get(0);
    }

    public void prepare() {
        Soldier soldier = new Soldier();
        addObject(soldier,149,515);

        soldier.setLocation(436,515);
        soldier.setLocation(430,14);
        
        HealthBar healthbar = new HealthBar();
        addObject(healthbar, 123,45);
        
        Brick brick = new Brick(250, 20);
        addObject(brick,800,410);
        brick.setLocation(800,410);

        Brick brick2 = new Brick(250, 20);
        addObject(brick2,100,410);
        brick2.setLocation(100,410);

        Border border = new Border();
        addObject(border,615,396);
        border.setLocation(896, 520);

        Border border2 = new Border();
        addObject(border2,825,225);
        border2.setLocation(896, 370);

        Border border3 = new Border();
        addObject(border3,74,73);
        border3.setLocation(896, 220);

        Border border4 = new Border();
        addObject(border4,862,524);
        border4.setLocation(896,70);
        
        Border border5 = new Border();
        addObject(border5,619,378);
        border5.setLocation(896,593);
        
    
        Border border6 = new Border();
        addObject(border6,615,396);
        border6.setLocation(4, 520);

        Border border7 = new Border();
        addObject(border7,825,225);
        border7.setLocation(4, 370);

        Border border8 = new Border();
        addObject(border8,74,73);
        border8.setLocation(4, 220);

        Border border9 = new Border();
        addObject(border9,862,524);
        border9.setLocation(4,70);
        
        Border border10 = new Border();
        addObject(border10,619,378);
        border10.setLocation(4,593);
        
    }

    
}
