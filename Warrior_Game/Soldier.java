import lang.stride.*;
import greenfoot.*;

/**
 * Write a description of class Soldier here.
 * @author (your name) @version (a version number or a date)
 */
public class Soldier extends Player
{
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    private final int GRAVITY = 1;
    private int velocity;
    protected GifImage right =  new  GifImage("RunRight.gif");
    protected GifImage left =  new  GifImage("RunLeft.gif");
    protected SimpleTimer shotTimer =  new  SimpleTimer();

    /**
     * 
     */
    public Soldier()
    {
        velocity = 0;
    }

    /**
     * 
     */
    public void act()
    {
        fall();
        move();
        if (Greenfoot.isKeyDown("w") && isOnPlatform()) {
            jump();
        }
        if (Greenfoot.isKeyDown("SPACE") && shotTimer.millisElapsed() > 250) {
            /* getKey allows to shoot only when i press the key*/
            shoot();
            Greenfoot.playSound("gunshot.mp3");
            shotTimer.mark();
        }
        if (isTouching(Bomb.class)) {
            World world = getWorld();
            Level1 myWorld = (Level1)world;
            HealthBar healthbar = myWorld.getHealthBar();
            healthbar.loseHealth();
            removeTouching(Bomb.class);
        }
        if (isTouching(enemySoldier.class)) {
            World world = getWorld();
            Level1 myWorld = (Level1)world;
            HealthBar healthbar = myWorld.getHealthBar();
            healthbar.loseHealth();
            removeTouching(enemySoldier.class);
        }
    }

    /**
     * 
     */
    public void shoot()
    {
        Bullet bullet =  new  Bullet();
        getWorld().addObject(bullet, getX(), getY() - 37);
        bullet.setRotation(getRotation());
        /* allows to shoot the bullet towards the direction u are looking at*/
        bullet.move(60);
        /* shoots bullet infront of the soldier and not from inside of him*/
    }

    /**
     * 
     */
    public void fall()
    {
        setLocation(getX(), getY() + velocity);
        if (isOnPlatform()) {
            velocity = 0;
            while (isOnPlatform()) {
                setLocation(getX(), getY() - 1);
            }
            setLocation(getX(), getY() + 1);
        }
        else if (velocity < 0 && bumpingHead()) {
            /* stop moving when we bump head on Brick and fall back down*/
            velocity = 0;
        }
        else {
            velocity = velocity + GRAVITY;
        }
    }

    /* jumping*/

    /**
     * 
     */
    public void jump()
    {
        velocity = -20;
    }

    /* moving the soldier*/

    /**
     * 
     */
    public void move()
    {
        int y = getY();
        int x = getX();
        if (Greenfoot.isKeyDown("a")) {
            setImage(left.getCurrentImage());
            setRotation(180);
            /* setImage(image1);*/
            x = x - 5;
        }
        if (Greenfoot.isKeyDown("d")) {
            setRotation(0);
            /* setImage(image2);*/
            x = x + 5;
            setImage(right.getCurrentImage());
        }
        setLocation(x, y);
    }

    /* preventing from going through the Brick object (from the bottom)*/

    /**
     * 
     */
    public boolean isOnPlatform()
    {
        boolean isOnGround = false;
        if (getY() > getWorld().getHeight() - 50) {
            isOnGround = true;
        }
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        /* positive hight is downwards*/
        if (getOneObjectAtOffset(imageWidth / -2, imageHeight / 2, Brick.class) != null || getOneObjectAtOffset(imageWidth / 2, imageHeight / 2, Brick.class) != null) {
            isOnGround = true;
        }
        return isOnGround;
    }

    /* preventing from going through the Brick object (from the bottom)*/

    /**
     * 
     */
    public boolean bumpingHead()
    {
        boolean bumpedHead = false;
        int imageWidth = getImage().getWidth();
        int imageHeight = getImage().getHeight();
        /* negative height is upwards*/
        if (getOneObjectAtOffset(imageWidth / -2, imageHeight / -2, Brick.class) != null || getOneObjectAtOffset(imageWidth / 2, imageHeight / -2, Brick.class) != null) {
            bumpedHead = true;
        }
        return bumpedHead;
    }
}
