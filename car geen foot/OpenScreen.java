 import greenfoot.*;

/**
 * This class is the main menu of the game
 */
public class OpenScreen extends World
{

    /**
     * some variables and enum and sounds 
     */
    Ground ground;
    enum ScreenState  {INSTRUCTIONS, VERSION, WELCOME, GAME};
    ScreenState state;
    GreenfootSound beginningTheme= new GreenfootSound("Game.mp3");
    GreenfootSound start= new GreenfootSound("Start.mp3");
    OpenScreen openScreen;
    /**
     * the size of the screen and declaring the enum to the welcome screen
     */
    public OpenScreen()
    { 
        super(800, 540, 1);
        state = ScreenState.WELCOME;

    }

    /**
     * giving refrence to ground class
     */
    public OpenScreen(Ground myGround)
    { 
        super(800, 540, 1);
        ground = myGround;
        state = ScreenState.WELCOME;
    }

    /**
     * act method that declars the methods the game have belo
     */

    public void act() {
        Enum();
        cheakEneter();
        cheakI();
        cheakShift();
        cheakV();
    }

    /**
     * enum class to declare what each button do 
     */
    public void Enum(){
        switch (state){
            case WELCOME:
            showImage();
            start.play();
            break;
            case INSTRUCTIONS:
            setBackground("instruction.jpg");
            break;
            case VERSION:
            setBackground("version.jpg");
            break;
            case GAME:
            Greenfoot.setWorld(ground);
            beginningTheme.play();
            start.stop();
            break;

        }
    }

    /**
     * main Image of the main menu
     */
    public void showImage() {
        setBackground("back2.jpg");

    }

    /**
     * beggining the game
     */

    public void cheakEneter() {
        if (Greenfoot.isKeyDown("enter")){
            state = ScreenState.GAME;
        }

    }

    /**
     * image of the instruction 
     */
    public void cheakI(){
        if (Greenfoot.isKeyDown("i")){
            state = ScreenState.INSTRUCTIONS;
        }
    }

    /**
     * the version of the game
     */
    public void cheakV(){
        if (Greenfoot.isKeyDown("v")){
            state = ScreenState.VERSION;
        }

    }

    /**
     * returning back from each image to main menu
     */
    public void cheakShift() {
        if (Greenfoot.isKeyDown("shift")){
            state = ScreenState.WELCOME;

        }
    }

}
