import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe représente le ROBOT FAST qui bouge en diagonale.
 * 
 * @author Oumaima EL ARBAOUI
 * @version 0.01
 */
public class RobotList {
    private static ArrayList<Robot> ListRobots;
    private static final int MIN_POSITION = 0;
    private static final int MAX_POSITION = 10;
    private CanvasRobot canvasrobot;

    /**
     * Constructs a new RobotList, initializing the list of robots.
     */
    public RobotList() {
        ListRobots = new ArrayList<Robot>();
    }

    /**
     * Creates a new robot based on the type selected.
     *  
     * @param choice Le choix du type de robot.
     * @param choice 1 = RobotFAST
     */
    public void newRobot(int choice) {
        switch (choice) {
            case 1:
                ListRobots.add(new RobotFAST()); // Robot Oumaima
                break;
           default:
                System.out.println("Choix invalide");
                break;
        }
    }
    
    /**
     * Ajouter automatiquement tous les robots
     */
    public void addAllRobot(){
        
        //Creation of RobotFAST
        RobotFAST robot2 = new RobotFAST();
        ListRobots.add(robot2);
        robot2.setList(this);
    }

    /**
     * Method to avoid collisions between robots.
     *
     * @param r Un robot.
     * @return True si une collision est évitée, sinon false.
     */
    private boolean robotCollision(Robot r) {
        boolean collision = false;
        int ox = r.getX();
        int oy = r.getY();
        for (Robot e : ListRobots) {
            if (e != r) {
                int vx = e.getX();
                int vy = e.getY();
                if (ox == vx && oy == vy) {
                    collision = true;
                    break;
                }
            }
        }
        return collision;
    }

    /**
     * Moves each robot in the list.
     *
     * @throws InterruptedException if interrupted during movement.
     */
    public void moveAll() throws InterruptedException {
        for (Robot theRobot : ListRobots) {
            theRobot.setNextStep();
            if (robotCollision(theRobot)) {
                break;
            } else {
                theRobot.avancer();
            }
        }
    }
   
    /**
     * Continuously executes the movement of each robot in the list, with a 1 second pause between each iteration.
     * This method is designed for indefinite execution of robot motion, and is likely to enter an infinite loop.
     * Collisions between robots are managed, and the motion is interrupted in the event of a collision.
     *
     * @throws InterruptedException If execution is interrupted during movement (for example, with a thread interrupt).
     */
    public void moveINFINIT() throws InterruptedException {
        while (true) {
            moveAll();
            TimeUnit.MILLISECONDS.sleep(1000);
        }
    }
    

    /**
     * Checks whether a given position is valid and avoids collisions.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return True if the position is valid, otherwise false.
     */
    public static boolean checkthePosition(int x, int y) {
        if (x > MAX_POSITION || y > MAX_POSITION || x < MIN_POSITION || y < MIN_POSITION)
            return false;
        for (Robot robot : ListRobots) {
            if (robot.getX() == x && robot.getY() == y)
                return false;
        }
        return true;
    }
}
