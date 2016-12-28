import greenfoot.*;

    /**
     * green car class
     */
public class RedCar extends Car
{
    
 /**
     * all variables for the grenn car class
     */
    private static int laps = 0;
  private static  boolean points1 = false;
   private static boolean points2 = false;
   private static boolean points3 = false;
    private static boolean points4 = false;
    private boolean reset = points1 && points2 && points3 && points4;
    Ground temp;
    
 /**
     * calling the super method is the redcar
     */
    public RedCar()
    {
        super();
        setImage(image[14]);
    }
    


 /**
     * calling the methods declared below
     */
    public void act()
    {
       // super.act();
        Points2();
        keys();
   
       
    }
    
 /**
     * method to declare if the car is touching all four variables
     */
    public void Points2(){
      
        temp = (Ground)getWorld();
        temp.showText("Lap(Green)" + laps + "/3," , 90, 530);
        touchcheakpoints1();
        if( points1 == true){
         touchcheakpoints2(); 
         
        }
        if( points2 == true){
         touchcheakpoints3();  
        }
        if( points3 == true){
         touchcheakpoints4();  
        }
        if ( points4 == true) {
     
          update();
        }  
       }
   
 /**
     * buttons for the moving of the car
     */
    public void keys(){
        if ( Greenfoot.isKeyDown("a") )
        {
            turn(-5);
        }
        if ( Greenfoot.isKeyDown("d") )
        {
            turn(5);
        }
        if (Greenfoot.isKeyDown("w"))
        {
            if (getSpeed() < MAXSPEED) {
                setSpeed(getSpeed() + 1);
            }

        }
        if(Greenfoot.isKeyDown("s"))
        {
            if (getSpeed() > 0)
            {
                setSpeed(getSpeed() - 1);
            }
        }
        move(getSpeed());

    }
    
 /**
     * ceanking if it touched the first point
     */
   public  boolean touchcheakpoints1(){
        Actor RedCar  = null;
       if (Points1.class != null)
          RedCar= getOneIntersectingObject(Points1.class);
    if(RedCar == null){
        return false;
}
else{
    points1 = true;
    return true;
}
}

 /**
     * cheaking if the car touched the second point
     */
  public  boolean touchcheakpoints2(){
        Actor RedCar  = null;
       if (Points2.class != null)
           RedCar= getOneIntersectingObject(Points2.class);
    if (RedCar == null){
        return false;
}
else{
    points2 =true;
    return true;
}
}

 /**
     * cheaking if the car touched the third point
     */
  public  boolean touchcheakpoints3(){
        Actor RedCar  = null;
       if (Points3.class != null)
          RedCar= getOneIntersectingObject(Points3.class);
    if (RedCar == null){
        return false;
}
else{
    points3 =true;
    return true;
}
}

 /**
     * cheaking if the car touched the fourth point
     */
  public  boolean touchcheakpoints4(){
        Actor RedCar  = null;
       if (Points4.class != null)
    RedCar= getOneIntersectingObject(Points4.class);
    if (RedCar == null){
         return false;
}
else{
    points4=true;
    return true;
}
}

 /**
     * all geters to be used in other class
     */
public static boolean get(){
    return points4;
}
    public static boolean getpoints1(){
    return points1;
}
    public static boolean getpoints2(){
    return points2;
}
    public static boolean getpoints3(){
    return points3;
}
  public static int getLaps() {
            return laps;
    }
public boolean reset()
{
    return reset;
}

 /**
     * to increas one lap if the car touched the fourt point
     */
public void update()
{
    laps++;
    points1 = false;
    points2 = false;
    points3 = false;
    points4 = false;
   
 
}
 
    
}



   



