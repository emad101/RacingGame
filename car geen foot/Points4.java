import greenfoot.*;

/**
     * the fourth point and from there it count as a one lap
     */
public class Points4 extends Points
{
    /**
     * calling the car and the red car and cheacing if the car touched or not and then declaring the sad or happy smiley
     */
    
    public void act() 
    { 
        
        RedCar rc = new RedCar();
        Car rc2 = new Car();
         carpassed();
           carpassed2();
         if((cartouched== true && rc.reset() == false) || (rc2.reset2() ==false && cartouched2 == true))  {
                imageHappySmily();
           }
           else 
           {
              imageSadSmily();
           }   
}
}
