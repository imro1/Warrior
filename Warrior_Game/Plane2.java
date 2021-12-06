import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Plane2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plane2 extends Enemies
{
    /**
     * Act - do whatever the Plane2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private int timeToDrop = 0;
    SimpleTimer shotTimer = new SimpleTimer();
    public Plane2() {
        speed = Greenfoot.getRandomNumber(2) + 5;
    }
    public void act()
    {
        setLocation(getX() - speed, getY());
        
        if(  !isAtEdge() && shotTimer.millisElapsed() > 600){
          shoot();
          shotTimer.mark();
        }
         if(isTouching(godPlane.class)){
       World world = getWorld();
       Level2 myWorld = (Level2)world;
       HealthBar healthbar = myWorld.getHealthBar();
       healthbar.loseHealth(); 
        
       }
        touchingEdge();
    }
    public void touchingEdge() {
        if( isAtEdge() ) {
            getWorld().removeObject(this);
        }
    }
    public void shoot(){
        if(this !=null ){
            Bullet2 bullet2 = new Bullet2();
            
            getWorld().addObject(bullet2, getX()-100, getY()-17);
        
            //bullet.setRotation(getRotation()); //allows to shoot the bullet towards the direction u are looking at
        
            bullet2.move(10); 
        }
           //shoots bullet infront of the soldier and not from inside of him
    }
}
