import greenfoot.*;

/**
 * Write a description of class Points1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Points1 extends Points
{

    /**
     * calling the car and the red car and cheacing if the car touched or not and then declaring the sad or happy smiley
     */
    public void act() 
    {
           carpassed();
           carpassed2();
       RedCar rc = new RedCar();  
         Car rc2 = new Car();
    if((cartouched== true && rc.reset() == false) || (rc2.reset2() ==false && cartouched2 == true))  {
        imageHappySmily();
    }
    else 
    {
        imageSadSmily();
    }
    
  }
    /**
     *  setters for the car touched of the green car
     */
  public void setCartouched()
  {
      cartouched = false;
  }
      /**
     *  setters for the car touched of the red car
     */
  public void setCartouched2()
  {
      cartouched2 = false;
  }
}

