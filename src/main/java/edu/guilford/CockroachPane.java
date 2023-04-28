package edu.guilford;

import java.io.File;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class CockroachPane extends GridPane{

    private Label startLabel;
    private Label cockroachPromptLabel;
    private Label cockroachNameLabel;
    private Label cockroachGameNameLabel;
    private Label gameDirections;

    private TextField cockroachName;

    private Button submitButton;
    private Button startButton;

    private ContextMenu contextMenu;

    //step 1: create an imageview attribute to store the image of the roach
    private ImageView roachView;

    public CockroachPane(cockroach cockroach) {
        
        //instantiate the attributes
        startLabel = new Label("Cockroach Simulator");
        cockroachPromptLabel = new Label("Name the cockroach");
        cockroachName = new TextField();
        cockroachNameLabel = new Label("Cockroach Name: " + cockroach.getName());
        submitButton = new Button("Submit");
        startButton = new Button("Start");        

        File roach = new File(this.getClass().getResource("cover1.jpg").getPath());

        //step 2: instantiate the imageview attribute with the image of the roach from the roach file
        roachView = new ImageView(roach.toURI().toString());
        
        this.add(startLabel, 0, 0);
        //center the start label
        this.setAlignment(Pos.CENTER);
        //add the cockroach prompt label to the grid pane
        this.add(cockroachPromptLabel, 0, 1);
        //add the cockroachNameLabel\
        this.add(cockroachNameLabel, 0, 2);     
        //add the textfield to the grid pane
        this.add(cockroachName, 0, 3);
        //add the submit button to the grid pane
        this.add(submitButton, 0, 4);
        //add the start button to the grid pane
        this.add(startButton, 1, 4);

        
        //set the background color of the grid pane to light brown
        this.setStyle("-fx-background-color: #f4a460;");

        submitButton.setOnAction(e -> {
            // set the name
            cockroach.setName(cockroachName.getText());
            // update the label
            cockroachNameLabel.setText("Cockroach Name: " + cockroach.getName());            
        });

        //add a listener for the start button that makes all the labels and textfields disappear when pressed
        startButton.setOnAction(e -> {
            startLabel.setVisible(false);
            cockroachPromptLabel.setVisible(false);
            cockroachName.setVisible(false);
            cockroachNameLabel.setVisible(false);
            submitButton.setVisible(false);
            startButton.setVisible(false);
            this.setStyle("-fx-background-color: none;");
            
            cockroachGameNameLabel = new Label(cockroach.getName());
            gameDirections = new Label("Click the cockroach to make him DANCE!!!\nRight click to see a poem");

            this.add(cockroachGameNameLabel, 0, 1);
            this.add(gameDirections, 0, 2);

            //change the font of the labels
            cockroachGameNameLabel.setStyle("-fx-font-size: 20px;");

            //step 3: add the roachview (image) to the pane
            //add a roachview to the pane
            this.add(roachView, 0, 0);
            //make the image smaller
            roachView.setFitHeight(300);
            roachView.setPreserveRatio(true);
        });

        //Step 4 & 5: add an event listener to the roachview that reads when the image is clicked and flips the image
        //flip the roach everytime the roach is clicked
        roachView.setOnMouseClicked(e -> {
            roachView.setScaleX(-1 * roachView.getScaleX());
            //change the background to a random color every time the roach is clicked
            this.setStyle("-fx-background-color: #" + Integer.toHexString((int)(Math.random() * 16777215)));

            
        });

        //add context menu to the roach
        contextMenu = new ContextMenu();
        MenuItem item1 = new MenuItem("I dance");
        MenuItem item2 = new MenuItem("You dance");
        MenuItem item3 = new MenuItem("We dance");
        MenuItem item4 = new MenuItem("They dance");
        MenuItem item5 = new MenuItem("But... ");
        MenuItem item6 = new MenuItem("HE DANCES!");
        contextMenu.getItems().addAll(item1, item2, item3, item4, item5, item6);
        //show the contextmenu when the button is right clicked
        roachView.setOnContextMenuRequested(e -> contextMenu.show(submitButton, e.getScreenX(), e.getScreenY()));
       
        
    }

    //add a listener for the submit button that changes the labels when pressed
    
    
}
