import javafx.application.*;
import javafx.scene.*;
import java.util.*;
import java.io.IOException;
import java.sql.*;
import javafx.stage.*;
import javafx.fxml.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
  
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Mainscene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
 public static void main(String[] args) {
        launch(args);
    }
}
// public class App extends Application{
//     public void start(Stage primaryStage) {
  
//         Parent root;
//         try{
//             root = FXMLLoader.load(getClass().getResource("Mainscene.fxml"));
//             Scene scene = new Scene(root);
      
//             primaryStage.setTitle("Hello World!");
//             primaryStage.setScene(scene);
//             primaryStage.show();
//         }
//         catch(Exception e){
//         }
//         }

//     public static void main(String[] args) throws Exception {
//         System.out.println("Hello, World!");
//     }
// }
