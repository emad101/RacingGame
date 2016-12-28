import greenfoot.*;

 /**
     * declaring the the green car is the winner
     */
public class GreenWinner extends World
{
     /**
     * giving REFENCES TO GROUND AND OPESCREEN CLASS
     */
     Ground ground;
  OpenScreen openScreen;
   
    public GreenWinner()
    {    
        super(800, 540, 1);
        showImage();
        
    }
     /**
     * refence from green winner to openscreen class
     */
      public GreenWinner(OpenScreen myOpenScreen)
    { 
        super(800, 540, 1);
       openScreen = myOpenScreen;
       showImage();
    }
     /**
     * image  of the green winner
     */
      public void showImage()
    {
        setBackground("greenCar.jpg");
    }


}
