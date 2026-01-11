import javafx.application.Application;

import java.util.List;

public class TrafficMain extends Application {
    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {



        javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("TrafficLightView.fxml"));


        List<String> args = getParameters().getRaw();
        int redTime = Integer.parseInt(args.get(0));
        int greenTime = Integer.parseInt(args.get(1));
        System.out.println("Red Time: " + redTime + " Green Time: " + greenTime);

        javafx.scene.Parent root = loader.load();
        TrafficLightController controller = loader.getController();



        controller.setLightTimings(redTime, greenTime);
        primaryStage.setTitle("Traffic Light Simulation");
        primaryStage.setScene(new javafx.scene.Scene(root, 400, 400));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
