package garden_planner.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GuiMain extends Application {

    public GardenPlanner planner = new GardenPlanner();

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Sets up the parent root, size and shape of the stage, scene and name
        // of title.
        Borderpane root = FXMLLoader.load(getClass().getResource("garden_gui.fxml"));
        primaryStage.setScene(scene);
        //sets intial name of scene
        primaryStage.setTitle("Garden_planner");
        //initiates creation of design of Garden Planner and
        //centres the entre pane
        planner.createintialdesign();
        pane centrePane = (pane) root.getcenter();
        primaryStage.show();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
//Button root = new Button("TODO: design garden planner GUI");