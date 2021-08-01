package com.stuffvish;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Pane rootNode = loader.load();
        MenuBar menuBar = createMenu();

        rootNode.getChildren().addAll(menuBar);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(rootNode, 300, 275));
        primaryStage.show();
    }
    public MenuBar createMenu(){
        Menu fileMenu = new Menu("File");
        MenuItem newMenu = new MenuItem("New");
        newMenu.setOnAction(actionEvent -> {
            System.out.println("New Menu clicked");
            //If there is more code then use the curly bracket, for single line of code there is no use of curly bracket.
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem quitMenu = new MenuItem("Quit");
        quitMenu.setOnAction(actionEvent -> {
            Platform.exit();
            System.exit(0);
        });
        fileMenu.getItems().addAll(newMenu,separatorMenuItem, quitMenu);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutMenu = new MenuItem("About");
        aboutMenu.setOnAction(actionEvent -> aboutMethod());
        helpMenu.getItems().addAll(aboutMenu);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);
        return  menuBar;
    }

    private void aboutMethod() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About the App");
        alert.setHeaderText("Learning JavaFx");
        alert.setContentText("To get started, AWS DeepComposer provides a 12-month Free Tier for first-time users." +
                " With the Free Tier, you can perform up to 500 inference jobs translating to 500 pieces of music" +
                " using the AWS DeepComposer Music studio. You can use one of these instances to complete the " +
                "exercise at no cost. To learn more about AWS DeepComposer costs.");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alert.getButtonTypes().addAll(yesBtn, noBtn);
        Optional<ButtonType> clickedBtn = alert.showAndWait();

        if (clickedBtn.isPresent() && clickedBtn.get() == yesBtn) System.out.println("Yes Btn Clicked!");
        else if (clickedBtn.isPresent() && clickedBtn.get() == noBtn) System.out.println("No Btn Clicked");
        else System.out.println("Ok Btn Clicked!");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
