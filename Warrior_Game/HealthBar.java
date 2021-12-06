import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class HealthBar extends Actor
{
    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int health = 20;//health
    int healthBarWidth = 80;
    int healthBarHeight = 10;
    int pixelhealthPerHealthPoint = (int)healthBarWidth/health;
    public HealthBar(){
      update();  
    }
    public void act()
    {
        update();
    }
    public void update(){
        setImage(new GreenfootImage(healthBarWidth +2 ,healthBarHeight +2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.drawRect(1, 1, healthBarWidth - 1, healthBarHeight - 1);
        myImage.fillRect(1, 1, health*pixelhealthPerHealthPoint, healthBarHeight);
        setImage(myImage);
        
    }
    public void loseHealth(){
        health--;
        if(health==0){//losse condition 
            Greenfoot.stop();
            getWorld().showText("You losse",250,250);//to make it look better make own image 
        }
    }
}
