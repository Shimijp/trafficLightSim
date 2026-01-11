import javafx.application.Platform;

public class TrafficLogic extends Thread{
    private TrafficLight topLight;
    private TrafficLight bottomLight;
    private TrafficLight leftLight;
    private TrafficLight rightLight;
    private final int blinkTime = 200;
    int redTime;
    int greenTime;

    public TrafficLogic(TrafficLight topLight, TrafficLight bottomLight, TrafficLight leftLight, TrafficLight rightLight, int redTime, int greenTime) {
        this.redTime = redTime;
        this.greenTime = greenTime;
        this.topLight = topLight;
        this.bottomLight = bottomLight;
        this.leftLight = leftLight;
        this.rightLight = rightLight;
    }
    public void turnCarTopBottomGreen() {
        Platform.runLater(() -> {
            topLight.setCarToGreen();
            bottomLight.setCarToGreen();
        });




    }
    public void turnCarLeftRightRed() {
        Platform.runLater(() -> {
            leftLight.setCarToRed();
            rightLight.setCarToRed();
        });



    }

    // i really thought that making then with a groups of two will help, nope :(
    public void turnCarLeftRightGreen()
    {
        Platform.runLater(() -> {
            leftLight.setCarToGreen();
            rightLight.setCarToGreen();
        });

    }
    public void turnCarTopBottomRed() {
        Platform.runLater(() -> {
            topLight.setCarToRed();
            bottomLight.setCarToRed();
        });
    }

    public void turnPedTopBottomRed() {
        Platform.runLater(() -> {
            topLight.setPedToRed();
            bottomLight.setPedToRed();
        });
    }
    public void turnPedTopBottomGreen() {
        Platform.runLater(() -> {
            topLight.setPedToGreen();
            bottomLight.setPedToGreen();
        });
    }
    public void turnPedLeftRightWhite() {
        Platform.runLater(() -> {
            leftLight.setPadToWhite();
            rightLight.setPadToWhite();
        });
    }
    public void turnPedTopBottomWhite() {
        Platform.runLater(() -> {
            topLight.setPadToWhite();
            bottomLight.setPadToWhite();
        });
    }
    public void turnPedLeftRightGreen() {
        Platform.runLater(() -> {
            leftLight.setPedToGreen();
            rightLight.setPedToGreen();
                 });
    }
    public void turnPedLeftRightRed() {
        Platform.runLater(() -> {
            leftLight.setPedToRed();
            rightLight.setPedToRed();
        });
    }

    ///omg this is so messy sorry, this was the most difficult part in the assignment , i used nesting threads :( sorry
    @Override
    public void run() {
        int totalCycleTime = blinkTime * 2;
        int numberOfBlinks = greenTime / totalCycleTime;
        while (true)
        {
            // turn the top and bottom car lights green, left and right red, pedestrian top and bottom red
            turnCarTopBottomGreen();
            turnCarLeftRightRed();
            turnPedTopBottomRed();
            new Thread(() -> {
                for (int i = 0; i < numberOfBlinks; i++) { // for the bling
                    try {
                        Thread.sleep(blinkTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                        turnPedLeftRightGreen();
                    try {
                        Thread.sleep(blinkTime);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                    turnPedLeftRightWhite();
                }
            }).start();
            try {
                Thread.sleep(greenTime);


            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            // turn the left and right car lights green, top and bottom red, pedestrian left and right red
            turnCarTopBottomRed();
            turnCarLeftRightGreen();
            turnPedLeftRightRed();
            new Thread(() -> {
                for (int i = 0; i < numberOfBlinks; i++) {
                    try {
                        Thread.sleep(blinkTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                    turnPedTopBottomGreen();
                    try {
                        Thread.sleep(blinkTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                    turnPedTopBottomWhite();
                }
            }).start();
            try {
                Thread.sleep(greenTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
    }
        }
}
