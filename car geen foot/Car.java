import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *  the green car class 
 */
public class Car extends Actor implements CarInterface 
{

    /**
     *  All variables of the car class
     */
    Ground temp;
    static int MAXSPEED = 5;
    private int speed;
    public boolean explodeTF; // true of false for explotion
    private int timerExplode; // time explode method
    private int explodeTime =120; // time of the explotion
    private int imageCounter;
    GreenfootImage[] image = new GreenfootImage[15]; // the arrays
    private static int laps = 0;
    // All points for the simlies
    private static  boolean Points1 = false;
    private static boolean Points2 = false;
    private static boolean Points3 = false;
    private static boolean Points4 = false;
    private boolean reset2 = Points1 && Points2 && Points3 && Points4;
    Ground temp1;

    /**
     * car method to call each one of the varibles
     */
    public Car()
    {
        setImages();
        timerExplode = explodeTime;
        speed = 0;
        explodeTF = false;
        setImage(image[0]);
    }

    /**
     *  all the pictures of the explotion stored in arrays
     */
    public void setImages(){

        image[0] = new GreenfootImage("car02.png");
        image[1] =   new GreenfootImage("explosion2.png");
        image[2] =   new GreenfootImage("explosion2.png");
        image[3] =   new GreenfootImage("explosion3.png");
        image[4] =   new GreenfootImage("explosion4.png");
        image[5] =   new GreenfootImage("explosion5.png");
        image[6] =   new GreenfootImage("explosion6.png");
        image[7] =   new GreenfootImage("explosion7.png");
        image[8] =   new GreenfootImage("explosion8.png");
        image[9] =   new GreenfootImage("explosion9.png");
        image[10] =  new GreenfootImage("explosion10.png");
        image[11] =  new GreenfootImage("explosion11.png");
        image[12] =  new GreenfootImage("explosion12.png");
        image[13] =  new GreenfootImage("explosion13.png");
        image[14] =  new GreenfootImage("car03.png");
    }

    /**
     * act method that holds the method 
     */
    public void act(){
        temp = (Ground)getWorld();
        remove();
        timer();
        points2();

    }

    /**
     *  cheack if the redcar got intersects with the points and it cant complete one lap inless it finished touching all points
     */
    public void points2(){

        temp = (Ground)getWorld();
        temp.showText("Lap(Red)" + laps + "/3," , 700, 530);
        touchcheakpoints1();
        if( Points1 == true){
            touchcheakpoints2(); 

        }
        if( Points2 == true){
            touchcheakpoints3();  
        }
        if( Points3 == true){
            touchcheakpoints4();  
        }
        if ( Points4 == true) {

            update();
        }  
    }

    /**
     *  timeer method for the explotion 
     */
    public void timer(){
        if (explodeTF&&timerExplode == 0){
            timerExplode = explodeTime;
            explode();
        }
        else if (explodeTF){ // if the bolean is true it will explode 
            explode();
        }
        else 
        {
            keys();
        } 

    }

    /**
     * cheak if the red car touched the green car and therefore it will explode  
     */
    public void remove(){
        RedCar inter = (RedCar)getOneIntersectingObject(RedCar.class);
        if (inter != null)
        {
            inter.explodeTF =true;
            explodeTF = true;
            // temp.showText(""+inter.explodeTF, 100, 100);
        }
    }

    /**
     *  buttons that make the program move
     */

    public void keys(){
        if ( Greenfoot.isKeyDown("left") )
        {
            turn(-5);
        }
        if ( Greenfoot.isKeyDown("right") )
        {
            turn(5);
        }
        if (Greenfoot.isKeyDown("up"))
        {
            if (speed < MAXSPEED) { // raisng up the speed
                speed++;
            }

        }
        if (Greenfoot.isKeyDown("down")) // dreacresing the speed
        {
            if (speed > 0)
            {
                speed--;
            }
        }
        move(speed);   
    }

    /**
     * Speed setter method
     */
    public void setSpeed( int mySpeed)
    {
        speed = mySpeed;
    }

    /**
     *Speed getter method
     */
    public int getSpeed() {
        return speed;
    }

    /**
     *  cheak if the speed is getting faster 
     */
    public void SpeedUp (int increase) {
        if(speed > 0)
        {
            speed += increase;
        }
    }

    /**
     *  cheak if the spped is slowing dowen
     */
    public void SpeedDown (int deccrease) {
        if(speed > 0)
        {
            speed -= deccrease;
        }
    }

    /**
     *  explode method that the car will crashes after it explode
     */
    public void explode()
    {
        Ground temp =(Ground)getWorld();
        setImage(image[imageCounter]);
        timerExplode --;                  
        if (imageCounter>image.length-2){
            imageCounter =0;
            reaset();

        }
        else if (timerExplode%(explodeTime/(image.length-1)) ==0){
            imageCounter ++;

        }

    }

    /**
     *  method that will reaset the car location after it explode
     */
    public void reaset(){
        setLocation(500, 250);
        explodeTF = false;
        setImage(image[0]);
    }

    /**
     *  cheak if the car touched the first point
     */
    public  boolean touchcheakpoints1(){
        Actor Car  = null;
        if (Points1.class != null)
            Car= getOneIntersectingObject(Points1.class);
        if(Car == null){
            return false;
        }
        else{
            Points1 = true;
            return true;
        }
    }

    /**
     *  cheak if the car touched point 2
     */
    public  boolean touchcheakpoints2(){
        Actor RedCar  = null;
        if (Points2.class != null)
            RedCar= getOneIntersectingObject(Points2.class);
        if (RedCar == null){
            return false;
        }
        else{
            Points2 =true;
            return true;
        }
    }

    /**cheak if the car touched point 3
     *  
     */
    public  boolean touchcheakpoints3(){
        Actor RedCar  = null;
        if (Points3.class != null)
            RedCar= getOneIntersectingObject(Points3.class);
        if (RedCar == null){
            return false;
        }
        else{
            Points3 =true;
            return true;
        }
    }

    /**
     *  cheak if the car touched point 4
     */
    public  boolean touchcheakpoints4(){
        Actor RedCar  = null;
        if (Points4.class != null)
            RedCar= getOneIntersectingObject(Points4.class);
        if (RedCar == null){
            return false;
        }
        else{
            Points4=true;
            return true;
        }
    }

    /**
     *  getters for all my four points and reaset and laps
     */
    public static boolean getPoints4(){
        return Points4;
    }

    public static boolean getPoints1(){
        return Points1;
    }

    public static boolean getPoints2(){
        return Points2;
    }

    public static boolean getPoints3(){
        return Points3;
    }

    public boolean reset2()
    {
        return reset2;
    }

    public static int getLaps() {
        return laps;
    }

    /**
     *  method for the fourth point to cheak if he complete a lap or not
     */

    public void update()
    {
        laps++;
        Points1 = false;
        Points2 = false;
        Points3 = false;
        Points4 = false;

    }
}
