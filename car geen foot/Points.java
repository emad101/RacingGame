import greenfoot.*;

/**
 * Main class for all the points 
 */
public class Points extends Actor
{
    /**
     * variables to declare if the car touched the points for both car
     */
    boolean cartouched = false;
    boolean cartouched2 = false;

    /**
     *  variables to declare if the car touched the points for both car
     */
    public void act() 
    {
        carpassed();
        carpassed2();
    }

    /**
     * image of the sad smiley 
     */
    public void imageSadSmily(){
        setImage("smiley3.png");
    }

    /**
     * image of the happy smiley 
     */
    public void imageHappySmily(){
        setImage("smiley2.png");
    }

    /**
     * to cheak of the cars touched the points using the Intersecting method for the green car
     */
    public void carpassed(){
        Actor Points = getOneIntersectingObject(RedCar.class);
        if (Points == null){
            cartouched = false;
        }
        else{
            cartouched =true;
        }

    }

    /**
     * to cheak of the cars touched the points using the Intersecting method for the red car
     */
    public void carpassed2(){
        Actor Points = getOneIntersectingObject(Car.class);
        if (Points == null){
            cartouched2 = false;
        }
        else{
            cartouched2 =true;
        }
    }
}

