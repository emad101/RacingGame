import greenfoot.*;

 /**
     * This class is to desplay the image of the red car if it wines 
     */
public class RedWinner extends World
{
   OpenScreen openScreen;

  
     /**
     * giving the image and the width of the picture
     */
    public RedWinner()
    {    
          super(800, 540, 1);
        showImage();
        
    }
     /**
     * giving the refrence of the open screen class
     */
    public RedWinner(OpenScreen myOpenScreen)
    { 
        super(800, 540, 1);
       openScreen = myOpenScreen;
       showImage();
       
    }
    /**
     * the image of the winnwe red car
     */
      public void showImage()
    {
        setBackground("redCar.jpg");
    }
    
    }

