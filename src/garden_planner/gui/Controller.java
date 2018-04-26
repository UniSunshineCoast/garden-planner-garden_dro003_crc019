package garden_planner.gui;

import garden_planner.model.GardenPlanner;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Controller {

    interface Generate
    {
        void generate(GardenBed a);
    }

    public BorderPane reference ParentObj;
    public Pane centerpane;
    public GardenPlanner planner;
    public double scale = 100;

    @FXML
    Label lengthField;
    @FXML
    Label widthField;
    @FXML
    Label heightfield;
    @FXML
    Label costfield;
    @FXML
    Label totalcostfield;

    public Controller () {
    }

    public void setup(Borderpane referenceParentObj, GardenPlanner planner)
    {
        this.referenceParentObj = referenceParentObj;
        this.planner = planner;
        centerpane = (Pane) referenceParentObj.getCenter();
    }

    Generate rectan = (gardenName) ->(...);
    Generate ellips = (gardenName) ->(...);
    Generate circle = (gardenName) ->(...);
    Generate triang = (gardenName) ->(...);

    public void deleteBed(int indexNo)
    {
        planner.getBeds().remove(indexNo-1);
        centerPane.getChildren().remove(indexNo);
    }

    public void BackEndUpdate()
    {
        centerpane.getChildren().forEach(child -> {
            if (centerPane.getChildren().indexOf(child) !=0)
            {
                GardenBed bed = planner.getBeds().get(centerpane.getChildren().indexOf());
                String type = bed.type.get();
                bed.setLeft(bed.getLeft() +(child.getTranslateX()/100))
                bed.setTop(bed.getTop() + (child.getTranslateY()/100));
                System.out.println(bed.getLeft());
                System.out.println(bed.getTop());
            }
        });
    }

    @FXML
    public void initialise()
    {
        system.out.println("Wake up Neo." + " " + "The Matrix has you.")
    }

    public void guiEventRefresh()
    {
        final ContextMenu contextMenu0 = new ContextMenu();
        MenuItem resize = new MenuItem( text: "Reshape");
        MenuItem Gridmode = new MenuItem( text: "Grid Mode");
        MenuItem Erase = new Menutiem (text: "Erase");
        contextMenu0.getItems().addAll(resize,Gridmode,Erase);

        final ContextMenu contextmenu1 = new ContextMenu();
        MenuItem add = new MenuItem(text: "Add New Bed");
        MenuItem StartOver = new Menuitem(text: "Start Garden Over");
        contextmenu1.getItems().addAll(add, StartOver);

        final ContextMenu contextmenu2 = new ContextMenu();
        MenuItem square = new MenuItem(text: "Add Square");
        MenuItem rectangle = new MenuItem(text: "Add Rectangle");
        MenuItem triangle = new MenuItem(text: "Add Triangle");
        MenuItem ellipse = new MenuItem(text: "Add Ellipse");
        MenuItem circle = new MenuItem(text: "Add Circle");
        contextmenu2.getItems().addAll(square, rectangle, triangle, ellipse, circle);

        AtomicBoolean startChild = new AtomicBoolean(false);
        centerpane.getChildren().forEach(child ->
        {
            if(centerpane.getChildren().indexOf(child) != 0) {
                    child.setOnMouseEntered(event -> {
                        startChild.set(true);
                    });}
        });

        centerpane.getChildren().forEach(child -> child.setOnMouseExited(event ->
        {
            startChild.set(false);
        }));

        //background context menu items
        centerpane.setOnContextMenuRequested(event ->
            if(startChild.get())){
                contextMenu0.hide();
                contextmenu1.show(centerpane,event.getScreenX(),event.getScreenY());
                rectangle.setOnAction(event2 -> {
                    garden_planner.model.Rectangle newBed = new garden_planner.model.Rectangle();
                    newBed.setLeft(event.getX()/100);
                    newBed.setTop(event.getY()/100);
                    planner.getBeds().add(newBed);
                    rectangle.generate(newBed);
                    guiEventRefresh();
                });
                square.setOnAction(event 2 -> {
                    garden_planner.model.square newBed = new square();
                })

            centerpane.getChildren().forEach(child -> {
                child.setOnContextMenuRequested(event -> {
                    contextmenu1.hide();
                    contextMenu0.show(child, event.getScreenX(), event.getScreenY());

                    //resizing script
                    resize.setOnAction(event1 -> (...));


                    //gridMode cde
                    gridMode.setOnAction(event1 -> {
                        system.out.println("node relocation grid");
                        system.out.println(centerpane.getChildren().size());
                        system.out.println(planner.getBeds().size());
                        backEndRefresh();
                        totalcostfield.setText("You spent how much!!!!!");
                    });
                });

                //drag and drop code for each pane in the stage
                AtomicReference<Double> x = new AtomicReference<>();
                AtomicReference<Double> y = new AtomicReference<>();
                AtomicReference<Double> mousex = new AtomicReference<>();
                AtomicReference<Double> mousey = new AtomicReference<>();
                child.setOnMousePressed(event -> (...));
                child.setOnMouseDragged(event -> (...));
                child.setOnMouseDragExited(event -> (guiEventRefresh();))
            });
            });
    }

    public void updateGui()
    {
        planner.getBeds().forEach(
                (bed) -> {
                    if (bed.getClass().getCanonicalName() == "Gardem_Planner.model.Rectangle") {
                        rectan.generate(bed);
                    } else if (bed.getClass(). getCanonicalName() == "Garden_planner.model.Cirlce") {
                        circle.generate(bed);
                    } else if (bed.getClass(). getCanonicalName() == "Garden_planner.model.Ellipse") {
                        ellips.generate(bed);
                    }
                }
        );
        guiEventRefresh();
    }
}
