import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.Scanner;

public class TrafficLightController extends Thread {

    @FXML
    private VBox bottom;

    @FXML
    private VBox left;

    @FXML
    private VBox right;

    @FXML
    private VBox top;
    private TrafficLight topLight;
    private TrafficLight bottomLight;
    private TrafficLight leftLight;
    private TrafficLight rightLight;
    private int redLight;
    private int greenLight;

    @FXML
    public void initialize() {

        bottomLight = new TrafficLight(bottom, greenLight, redLight );
        leftLight = new TrafficLight(left, greenLight, redLight );
        rightLight = new TrafficLight(right, greenLight, redLight );
        topLight = new TrafficLight(top,  greenLight, redLight );




    }
    // gets the time from command line arguments, in the main class
    public void setLightTimings(int redLight, int greenLight) {
        this.redLight = redLight;
        this.greenLight = greenLight;
        //i did this beacuse i had some issues with the initialize method not getting the correct timings
        TrafficLogic logic = new TrafficLogic(topLight, bottomLight, leftLight, rightLight, redLight, greenLight);
        logic.start();
    }





}
