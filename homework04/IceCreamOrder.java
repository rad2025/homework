// Delta College - CST 183 - Klingler
// This application provides a simple front-end for ordering ice cream with
// toppings.  It includes both radio buttons, checkboxes, and a button, and
// handles events for any of these components.

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class IceCreamOrder extends Application
{
    // Fields for the Label control
    private RadioButton vanilla, chocolate, strawberry, mint;
    private CheckBox addOns[];
    private String addOnNames[] = {"Sprinkles", "Nuts", "Whipped Cream", "Oreos", "Strawberries", "Caramel", "Cookie Dough"};
    private Button orderButton, resetButton;
    private Label iceCreamLabel, toppingsLabel, toppingsTitle, baseIceCreamLabel;

    private final double ICE_CREAM_COST   = 3.00;
    private final double PER_TOPPING_COST = 0.50;

    public static void main(String[] args)
    {
        // Launch the application.
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Instantiate radio button set.  Add to horizontal box.  Assuming vanilla as default choice.
        vanilla    = new RadioButton("Vanilla");
        vanilla.setSelected(true);
        chocolate  = new RadioButton("Chocolate");
        strawberry = new RadioButton("Strawberry");
        mint       = new RadioButton("Mint");

        // Add the RadioButtons to a ToggleGroup.
        ToggleGroup radioGroup = new ToggleGroup();
        chocolate.setToggleGroup(radioGroup);
        vanilla.setToggleGroup(radioGroup);
        strawberry.setToggleGroup(radioGroup);
        mint.setToggleGroup(radioGroup);

        //added label for "Base Ice Cream"
        baseIceCreamLabel = new Label("Base Ice Cream");

        // Build box containing radio button set, add base
        VBox iceCreamBox = new VBox(10, baseIceCreamLabel, vanilla, chocolate, strawberry, mint);

        // Instantiate ice cream add-on check boxes. Add to vertical box.
        VBox addOnBox = new VBox(10);
        addOns = new CheckBox[addOnNames.length];
        for (int i = 0; i < addOnNames.length; i++)
        {
            // Instantiate checkbox, assign associated label, and relate to a common listener.
            addOns[i] = new CheckBox(addOnNames[i]);
            addOnBox.getChildren().add(addOns[i]);
            addOns[i].setOnAction(event ->
            {
                handleCheckBoxChange();
            });
        }

        VBox.setMargin(addOnBox, new Insets(0,0,0,20));   // Add inset space - top, left, bottom, right

        //gonna add a "Toppings" label above toppings
        toppingsTitle = new Label("Toppings");
        VBox toppingContainer = new VBox(10, toppingsTitle, addOnBox);

        // Instantiate order button.  Assign to listener method
        orderButton = new Button("Order");
        orderButton.setOnAction(new ButtonClickHandler());

        //add reset button
        resetButton = new Button("Reset");
        resetButton.setOnAction(event -> resetOrder());

        // Instantiate labels
        iceCreamLabel = new Label("Vanilla Ice Cream");
        toppingsLabel = new Label();

        // Define actions for buttons
        chocolate.setOnAction(event ->
        {
            iceCreamLabel.setText("Chocolate Ice Cream");
        });
        vanilla.setOnAction(event ->
        {
            iceCreamLabel.setText("Vanilla Ice Cream");
        });
        strawberry.setOnAction(event ->
        {
            iceCreamLabel.setText("Strawberry Ice Cream");
        });

        //new flavor
        mint.setOnAction(event ->
        {
            iceCreamLabel.setText("Mint Ice Cream");
        });


        // Complete building left side of GUI
        //add reset
        VBox guiBox = new VBox(20, iceCreamBox, toppingContainer, orderButton, resetButton);

        // Build right side of GUI with label object
        VBox labelBox = new VBox(20, iceCreamLabel, toppingsLabel);
        labelBox.setAlignment(Pos.CENTER);

        // Define main layout by combining left GUI and right labels
        BorderPane mainLayout = new BorderPane();
        mainLayout.setLeft(guiBox);
        mainLayout.setCenter(labelBox);

        //trying some new sizes for layout
        Scene scene = new Scene(mainLayout, 600, 650);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Delta Ice Cream");
        primaryStage.show();
    }

    // Handle checkbox click event.  Any change of state for any checkbox will invoke
    // this method.  The method then will redefine the string for ice cream toppings.
    // This string is then "set" in the designated GUI label.
    public void handleCheckBoxChange()
    {
        String toppingsString = "";
        for(int i = 0; i < addOnNames.length; i++)
        {
            if (addOns[i].isSelected())
                toppingsString += addOnNames[i] + "\n";
        }
        toppingsLabel.setText(toppingsString);
    }

    // Handle button click event.  Collect values in operand text fields, add
    // them, and display them via a JavaFX Alert dialog box.
    class ButtonClickHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            double totalOrderCost = ICE_CREAM_COST;     // Assign base cost - assuming no toppings

            // Add per topping cost for each topping checked
            for(int i = 0; i < addOnNames.length; i++)
            {
                if (addOns[i].isSelected())
                    totalOrderCost += PER_TOPPING_COST;
            }

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ice Cream Order");
            alert.setHeaderText("ORDER");
            alert.setContentText(String.format("Total for Order: $%6.2f\n", totalOrderCost));

            alert.showAndWait();
        }
    }

    // for the reset, clear boxes, etc
    private void resetOrder()
    {
        vanilla.setSelected(true);
        iceCreamLabel.setText("Vanilla Ice Cream");
        toppingsLabel.setText("");

        for (CheckBox checkBox : addOns) {
            checkBox.setSelected(false);
        }
    }
}
