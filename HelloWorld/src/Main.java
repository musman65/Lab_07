//https://github.com/musman65/Lab_07
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


/**
 *
 * @author 6298674
 */
public class Main extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        
        Button start = new Button("Start");
        Button reset = new Button("Reset");
        Button exit = new Button("Exit");
        
        Line mn = new Line(20, 20, 480, 20); 
        mn.setStroke(Color.BLACK);
        Line np = new Line(480, 20, 480, 210); 
        np.setStroke(Color.BLACK);
        Line pq = new Line(480, 210, 20, 210); 
        pq.setStroke(Color.BLACK);
        Line qm = new Line(20, 210, 20, 20); 
        qm.setStroke(Color.BLACK);
        
        
        Circle a = new Circle();
        a.setRadius(20);
        a.setCenterX(20);
        a.setCenterY(20);
        
        a.setFill(Color.AQUAMARINE);
        
        Ellipse b = new Ellipse(250, 100, 50, 25);
        
        
        PathTransition path1 = new PathTransition();
        path1.setDuration(Duration.millis(2000));
        path1.setPath(mn);
        path1.setNode(a);
        
        PathTransition path2 = new PathTransition();
        path2.setDuration(Duration.millis(1000));
        path2.setPath(np);
        path2.setNode(a);
        
        PathTransition path3 = new PathTransition();
        path3.setDuration(Duration.millis(2000));
        path3.setPath(pq);
        path3.setNode(a);
        
        PathTransition path4 = new PathTransition();
        path4.setDuration(Duration.millis(1000));
        path4.setPath(qm);
        path4.setNode(a);
        
        path1.setOnFinished(event -> path2.play());
        path2.setOnFinished(event -> path3.play());
        path3.setOnFinished(event -> path4.play());
        
        a.setOnMouseClicked(event -> path1.play());
        
        start.setOnMouseClicked(event -> {
            if ((!path1.getStatus().equals(Animation.Status.RUNNING)) && (!path2.getStatus().equals(Animation.Status.RUNNING)) && (!path3.getStatus().equals(Animation.Status.RUNNING)) && (!path4.getStatus().equals(Animation.Status.RUNNING))) {
                path1.play();
            }
        });
        
        reset.setOnMouseClicked(event -> {
            path1.stop();
            path2.stop();
            path3.stop();
            path4.stop();
            
            path1.play();
        });
        
        exit.setOnMouseClicked(event -> {
            path1.stop();
            path2.stop();
            path3.stop();
            path4.stop();
        });
        
        
        Pane pane = new Pane(a, b, mn, np, pq, qm);
        HBox hb = new HBox(5, start, reset, exit);
        hb.setPadding(new Insets(10));
        hb.setAlignment(Pos.CENTER);
        VBox vb = new VBox(10, pane, hb);
        Scene scene = new Scene(vb, 500, 300);
        stage.setScene(scene);
        stage.show();
    }
    
}
