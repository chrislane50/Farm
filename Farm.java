import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Farm extends Application {

    private final TextField nameField = new TextField();
    private final TextField eggField = new TextField();
    private final TextArea logArea = new TextArea();
    private final ArrayList<Animal> animals = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Pane root = new Pane();

        Label nameLabel = new Label("Chicken name:");
        nameLabel.setLayoutX(20);
        nameLabel.setLayoutY(20);

        nameField.setLayoutX(140);
        nameField.setLayoutY(20);

        Label eggLabel = new Label("Number of initial eggs:");
        eggLabel.setLayoutX(20);
        eggLabel.setLayoutY(50);

        eggField.setLayoutX(140);
        eggField.setLayoutY(50);

        Button addChickenButton = new Button("Add Chicken");
        addChickenButton.setLayoutX(140);
        addChickenButton.setLayoutY(80);

        logArea.setLayoutX(20);
        logArea.setLayoutY(110);

        addChickenButton.setOnAction(e -> {

                    try {
                        Chicken c = new Chicken(getName(),getEgg());
                        animals.add(c);
                        log("Added Chicken " + c + System.lineSeparator());
                        c.display();
                    } catch (NumberFormatException ex) {
                        showError("Input Error", "Check that initial number of eggs is a valid number.");
                    }
            });

        root.getChildren().addAll(nameLabel, nameField, eggLabel, eggField, addChickenButton, logArea);
        stage.setScene(new 
            Scene(root, 560, 400));
        stage.setTitle("Farm Step 1");
        stage.show();
    }
    
    private String getName(){
       return nameField.getText();
    }
    private int getEgg(){
        return Integer.parseInt(eggField.getText().trim());
    }
    
    private void log(String msg){
    logArea.appendText(msg);
}

    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    
    public static void main(String[] args) { launch(); }
}