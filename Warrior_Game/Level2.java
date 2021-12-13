import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends MenuWorld
{
    private int delay = 0;
    private boolean waiting = false;
    /**
     * Constructor for objects of class Level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600);
        setPaintOrder(Plane2.class);
        for( int i = 0; i <= 0; i++){
            addObject( new Plane2(),799,Greenfoot.getRandomNumber(450));
            waiting = true;
        } 
        prepare();
        Explosion.initializeImages();
    }

    public void act()
    {
       if (waiting) {
       delay++;
       if (delay >= 200) { // you'll have to pick a number for limit
           
        int x = 799; 
        int y = Greenfoot.getRandomNumber(450);
        addObject( new Plane2(), x, y );
        waiting = true;
        delay = 0;
        // you may set waiting to true or false depending on if you want to add more objects or just one
       }
       } 
       if (Greenfoot.getRandomNumber(1000) <= 3) {
             addObject( new  Plane2(), 1, Greenfoot.getRandomNumber(40)+40);
             
            }      
    }
    private void prepare()
    {
        godPlane goodPlane = new godPlane();
        addObject(goodPlane,219,160);
        Plane2 plane2 = new Plane2();
        addObject(plane2,726,174);
        removeObject(plane2);
        HealthBar healthBar = new HealthBar();
        addObject(healthBar,476,96);
    }
    public HealthBar getHealthBar(){
     return getObjects(HealthBar.class).get(0);
    }
}
