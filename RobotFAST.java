import java.util.List;
import java.util.ArrayList;

/**
 * The RobotFAST class extends the Robot class.
 * It represents a specific type of robot with movement and drawing capabilities.
 *
 * @author: EL ARBAOUI Oumaima
 * @date: 18/10/2023
 */
public class RobotFAST extends Robot {
    // Attributes of the RobotFAST class
    private int x;         // x-coordinate of the robot
    private int y;         // y-coordinate of the robot
    private int direction; // direction the robot is facing

    /**
     * Constructor for RobotFAST class. Initializes the robot's starting properties.
     */
    public RobotFAST() {
        // Calling the constructor of the parent class with default values
        super(1, 1, 3, 1, "YELLOW");
        // Changing the color of the robot's head to RED
        super.changeHeadColor("RED");
    }

    /**
     * Sets the next step for the robot based on its current direction.
     */
    public void setNextStep() {
        switch (direction) {
            case 0: // Moving to the right and down
                this.x += 2;
                this.y += 2;
                // Checking boundaries and adjusting direction if necessary
                if (this.x >= 11 || this.y >= 11) {
                    this.x = 11;
                    this.y = 11;
                    this.direction = 1;
                }
                break;

            case 1: // Moving to the left and down
                this.x -= 3;
                // Checking boundaries and adjusting direction if necessary
                if (this.x <= 0) {
                    this.x = 0;
                    this.direction = 2;
                }
                break;

            case 2: // Moving to the right and up
                this.x += 2;
                this.y -= 2;
                // Checking boundaries and adjusting direction if necessary
                if (this.x >= 11 || this.y <= 0) {
                    this.x = 11;
                    this.y = 0;
                    this.direction = 3;
                }
                break;

            case 3: // Moving to the left and up
                this.x -= 3;
                // Checking boundaries and adjusting direction if necessary
                if (this.x <= 0) {
                    this.x = 0;
                    this.direction = 0;
                }
                break;
        }
        // Setting the new coordinates of the robot
        super.setX(this.x);
        super.setY(this.y);
        // Changing the color of the robot's body to YELLOW
        super.changeColor("YELLOW");
        // Changing the color of the robot's head to RED
        super.changeHeadColor("RED");
    }

    /**
     * Method to advance the robot. It is expected to draw the robot at its new coordinates.
     * Note: The drawRobot method needs to be implemented to draw the robot at the given (x, y) position.
     */
    public void avancer() {
        // Draw the robot at its new coordinates (x, y) (Implementation needed for drawing the robot)
        super.drawRobot(this.x, this.y); // This method is supposed to draw the robot, implementation is required
    }
}
