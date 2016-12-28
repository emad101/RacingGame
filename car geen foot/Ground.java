import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ground class that runs the progra
 */
public class Ground  extends World
{

    /**
     * All variables 
     */
    OpenScreen openScreen;
    int greenLaps;
    int redLaps;
    Ground ground;
    boolean starting = true;
    boolean starting2 = true;
    boolean starting3 = true;
    Car player1;
    RedCar player2;
    Points1 points1;
    Points2 points2;
    Points3 points3;
    Points4 points4; 
    GreenfootSound finale= new GreenfootSound("final.mp3");
    public Ground()
    {  
        /**
         * declaring new variables and setting their location 
         */
        super(800, 540, 1);
        points1 = new Points1();
        points2 = new Points2();
        points3 = new Points3();
        points4 = new Points4();
        player1 = new Car();
        player2 = new RedCar();
        addObject( player1, 95, 460);//anonymous object is created
        addObject( player2, 96, 395);//anonymous object is created
        addObject( points1, 180, 430);//anonymous object is created
        addObject( points2, 630, 430);
        addObject( points3, 610, 195);
        addObject( points4, 125, 125);
        showMap1();

    }

    public void act(){
        /**
         * act method calling each methods bellow 
         */
        open();
        checkGreenLaps();
        checkRedLaps();

    }

    /**
     * open method declare the ground class in openScreen class
     */
    public void open()
    {
        if (starting){
            ground = this;
            openScreen = new OpenScreen(ground);
            Greenfoot.setWorld(openScreen);
            starting = false;

        }  
    }

    /**
     * cheaking if the green car finished three laps or not and if it did then it will ope RedWinner class
     */
    public void checkGreenLaps()
    {   //Call a Getter from the RedCar Class.
        greenLaps = RedCar.getLaps();

        if (greenLaps == 3){ //If the Red Car wo 

            if (starting2){
                // openScreen = this;
                finale.play();
                GreenWinner greenWinner = new GreenWinner(openScreen);
                Greenfoot.setWorld(greenWinner);
                starting2= false;
            }
        }
    }

    /**
     * background of the ground picture
     */
    public void showMap1()
    {
        setBackground("ground.png");
    }

    /**
     * cheaking if the red car finished three laps or not and if it did then it will ope RedWinner class
     */
    public void checkRedLaps()
    {
        redLaps= Car.getLaps();
        if (redLaps == 3){ //I);the Red Car won
            finale.play();

            if (starting3){
                //  openScreen = this;
                RedWinner redWinner = new RedWinner(openScreen);
                Greenfoot.setWorld(redWinner);
                starting3 = false;
            }
        }

    }

}
