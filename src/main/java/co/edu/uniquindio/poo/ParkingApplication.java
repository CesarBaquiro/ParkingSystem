package co.edu.uniquindio.poo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ParkingApplication extends Application {

    @Override
    public void init(){

    }

    @Override
    public void start(Stage stage) throws IOException {


        BorderPane root = new BorderPane();

        FXMLLoader fxmlLoader = new FXMLLoader(ParkingApplication.class.getResource("parking-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 720);
        stage.setTitle("Parking System");

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop(){
    }

    public static void main(String[] args) {
        launch();
    }
}