import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class TrafficLight  {

    private final Circle carGreen;
    private final Circle carRed;
    private final Rectangle pedGreen;
    private final Rectangle pedRed;
    private final int redCycleTime; // milliseconds
    private final int greenCycleTime; // milliseconds



    // create a traffic light object from a VBox containing the lights, instead of given then fx:id each one.....
    public TrafficLight(VBox lightBox, int redCycleTime, int greenCycleTime) {
        this.redCycleTime = redCycleTime;
        this.greenCycleTime = greenCycleTime;
        carRed = (Circle) lightBox.getChildren().get(0);
        carGreen = (Circle) lightBox.getChildren().get(1);
        pedRed = (Rectangle) lightBox.getChildren().get(2);
        pedGreen = (Rectangle) lightBox.getChildren().get(3);
    }


    // simply change the color of the lights


    public void setCarToGreen()
    {
        carGreen.setFill(Color.GREEN);
        carRed.setFill(Color.WHITE);


    }
    public void setCarToRed()
    {
        carGreen.setFill(Color.WHITE);
        carRed.setFill(Color.RED);



    }
    public void setPadToWhite()
    {
        pedGreen.setFill(Color.WHITE);
        pedRed.setFill(Color.WHITE);
    }
    public void setPedToRed()
    {
        pedGreen.setFill(Color.WHITE);
        pedRed.setFill(Color.RED);
    }
    public void setPedToGreen()
    {
        pedRed.setFill(Color.WHITE);
        pedGreen.setFill(Color.GREEN);
    }



}
