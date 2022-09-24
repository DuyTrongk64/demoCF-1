package cf.democf;

import cf.democf.model.nhan_vien;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {

    public static Stage stg;

    double x,y;

    public static void setStg(Stage stg) {
        Main.stg = stg;
    }

    @Override
    public void start(Stage stage) throws IOException {
        stg = stage;

        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));

        stage.initStyle(StageStyle.UNDECORATED);
        root.setOnMousePressed(event -> {
            x=event.getSceneX();
            y=event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getSceneX()-x);
            stage.setY(event.getSceneX()-y);
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public  void switchScene(String fxml) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(root);
        stg.sizeToScene();
    }

    public  void switchSC(String fxml,Node node,String data) throws IOException{
        stg = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setUserData(data);
        stg.getScene().setRoot(root);
        stg.sizeToScene();
    }

    public  void switchSV(String fxml,Node node,nhan_vien data) throws IOException{
        stg = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setUserData(data);
        stg.getScene().setRoot(root);
        stg.sizeToScene();
    }

    public Parent sc(String fxml) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        return root;
    }

    public  void sendNv_id(String fxml,Node node,String data) throws IOException{
        stg = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        stg.setUserData(data);
        stg.getScene().setRoot(root);
        stg.sizeToScene();
    }
    public static void main(String[] args) {
        launch();
    }
}