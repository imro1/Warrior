import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class godPlane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class godPlane extends Player
{
    protected GifImage yo =  new  GifImage("Greenplane.gif");
    protected SimpleTimer shotTimer =  new  SimpleTimer();
    public void act()
    {
        setImage(yo.getCurrentImage());
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY()-5);
    }
     if(Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+5);
    }
     if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+5,getY());
    }
     if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-5,getY());
    }
    if( (Greenfoot.isKeyDown("SPACE") && shotTimer.millisElapsed() > 250)) { //getKey allows to shoot only when i press the key
             shoot();
             shotTimer.mark();
        }
    if(isTouching(Plane2.class)||isTouching(Bullet2.class)){
       World world = getWorld();
       Level2 myWorld = (Level2)world;
       HealthBar healthbar = myWorld.getHealthBar();
       healthbar.loseHealth(); 
        removeTouching(Plane2.class);
        removeTouching(Bullet2.class);
    }
    if (isTouching(Plane2.class)) {
            World world = getWorld();
            Level1 myWorld = (Level1)world;
            HealthBar healthbar = myWorld.getHealthBar();
            healthbar.loseHealth();
            removeTouching(Plane2.class);
        }
    }
    public void shoot(){
        
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY()-20);
        
        bullet.setRotation(getRotation()); //allows to shoot the bullet towards the direction u are looking at
        bullet.move(60);     //shoots bullet infront of the soldier and not from inside of him
    }
}
