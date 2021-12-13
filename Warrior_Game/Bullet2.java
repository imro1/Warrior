import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet2 extends Mover
{
    
    private static final int damage = 10;
    private int life = 30;
    public void act()
    {
         setLocation(getX()-20,getY());
        if(getX() == 0 && getX() == 900 && getY() == 0 ){ //isAtEdge will give me an error on the left side 
            getWorld().removeObject(this);
        }
        if(life <= 0) {
            getWorld().removeObject(this);
        } 
        else {
            life--;
            move();
            checkEnemyHit();
            checkTankHit();
        }
    }
    public void resize()
    {
        GreenfootImage image = new GreenfootImage("Bullet_3.png");
        image.scale(image.getWidth() - 560, image.getHeight() - 450);
        setImage(image);
    }
    private void checkEnemyHit()
    {
        enemySoldier enemysoldier = (enemySoldier) getOneIntersectingObject(enemySoldier.class);
        if (enemysoldier != null) 
        {
            getWorld().removeObject(this);
            enemysoldier.hit(damage);
        }
    }
    private void checkTankHit()
    {
        T_body tank = (T_body) getIntersectingObjects(T_body.class);
        if (tank !=null)
        {
            getWorld().removeObject(this);
            tank.hit(damage);
        }
    }
}
