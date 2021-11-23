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
    GifImage right = new GifImage("runRight2.gif");
    GifImage left = new GifImage("runLeft2.gif");
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
        if( "down".equals( Greenfoot.getKey() )) { //getKey allows to shoot only when i press the key
             shoot();
        }
        
    }
    
    public void shoot(){
        
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY()-37);
        
        bullet.setRotation(getRotation()); //allows to shoot the bullet towards the direction u are looking at
        bullet.move(60);     //shoots bullet infront of the soldier and not from inside of him
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
    //jumping
    public void jump() {
        velocity = -20;
    }
    //moving the soldier
    public void move() {
        int y = getY();
        int x = getX();
        if( Greenfoot.isKeyDown("a") ) {
            
            setImage( left.getCurrentImage());
            setRotation(180);
            //setImage(image1);
            x -= 5;
            
        }
        if( Greenfoot.isKeyDown("d") ) {
            setRotation(0);
            //setImage(image2);
            x += 5;
            setImage( right.getCurrentImage());
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
