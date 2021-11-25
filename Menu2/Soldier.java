import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soldier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soldier extends Actor
{
    private final int GRAVITY = 1;
    private int velocity;
    
    public Soldier() {
        velocity = 0; 
    }
    
    public void act()
    {
        fall();
        move();
        if (Greenfoot.isKeyDown("space" ) && isOnPlatform() ) {
            jump();
        }
        if(isTouching(f.class)){
            Greenfoot.setWorld(new Level1());
        }
    }
    public void fall() {
        setLocation( getX() , getY() + velocity );
        if( isOnPlatform() ) {
            velocity = 0;
            
            while( isOnPlatform() ) {
                setLocation( getX() , getY() - 1 );
            }
            setLocation( getX() , getY() + 1 );
        }else if(velocity < 0 && bumpingHead()) { //stop moving when we bump head on Brick and fall back down
            velocity = 0;
        }else { 
            velocity += GRAVITY;
        }
    }
    public void jump() {
        velocity = -20;
    }
    public void move() {
        int y = getY();
        int x = getX();
        if( Greenfoot.isKeyDown("left") ) {
            x -= 5;
            
        }
        if( Greenfoot.isKeyDown("right") ) {
            x += 5;
            
        }
        setLocation(x,y);
    }
    //preventing from going through the Brick object (from the bottom)
    public boolean isOnPlatform(){
        boolean isOnGround = false;
        if (getY() > getWorld().getHeight() - 50) {
            isOnGround = true  ;
        }
        
        int imageWidth = getImage().getWidth();  
        int imageHeight = getImage().getHeight();
        //positive hight is downwards
        if( getOneObjectAtOffset( imageWidth / -2 , imageHeight / 2 , Brick.class) != null ||
            getOneObjectAtOffset( imageWidth / 2 , imageHeight / 2 , Brick.class) != null ){
            isOnGround = true;
        }
        
        return isOnGround;
    }
    //preventing from going through the Brick object (from the bottom)
    public boolean bumpingHead() {
        boolean bumpedHead = false;
        int imageWidth = getImage().getWidth();  
        int imageHeight = getImage().getHeight();
        //negative height is upwards
        if( getOneObjectAtOffset( imageWidth / -2 , imageHeight / -2 , Brick.class) != null ||
            getOneObjectAtOffset( imageWidth / 2 , imageHeight / -2 , Brick.class) != null ){
             bumpedHead = true;
        }
        return bumpedHead;
    }
}
