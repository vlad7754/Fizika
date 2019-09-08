package sample;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class Main extends Application {

    double x1 = 150;
    double x2 = 400;
    double x3 = 600;
    double yD = 50;
    double Dx;
    double l;
    double D;
    double lamda0;

    Rectangle node  = new Rectangle(0, 110,3, 280);



    final Rectangle[] nodes21 = new Rectangle[num];
    final Rectangle[] nodes22 = new Rectangle[num];


    static final  int num = 500;
    final Rectangle[] nodes = new Rectangle[num];
    final double[] alfa = new double[num];

    final Random random = new Random();


    @Override
    public void start(Stage primaryStage) throws Exception{
   node.setFill(Color.WHITE);









//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        root.getChildrenUnmodifiable().add(canvas);
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 700, 700));
//        primaryStage.show();




        Canvas canvas = new Canvas(700, 500);
        GraphicsContext context = canvas.getGraphicsContext2D();
        drawShapes(context);


        Group root = new Group();









        for (int i = 0; i<num;i++){
            nodes[i] = new Rectangle(2,2, Color.WHITE);
            nodes21[i] = new Rectangle(2,2, Color.WHITE);
            nodes22[i] = new Rectangle(2,2, Color.WHITE);

            alfa[i] = random.nextDouble()*1/5*Math.PI;

        }

        for (int i = 0; i < num /2; i++){
            alfa[i] = -alfa[i];
        }







        root.getChildren().add(node);

//

        root.getChildren().addAll(nodes);

        Rectangle rec2 = new Rectangle(x2,0,400,500);
        rec2.setFill(Color.GREY);
        root.getChildren().add(rec2);

        root.getChildren().addAll(nodes21);
        root.getChildren().addAll(nodes22);


        Rectangle rec3 = new Rectangle(x3,0,200,500);
        rec3.setFill(Color.GREY);
        root.getChildren().add(rec3);

        Rectangle rec4 = new Rectangle(x3+40,40,60,420);
        rec4.setFill(Color.color(0.25,0.25, 0.25));
        root.getChildren().add(rec4);

        root.getChildren().add(canvas);

        Rectangle rec5 = new Rectangle(0,500,800, 100);
        rec5.setFill(Color.color(0.25,0.25, 0.25));
        root.getChildren().add(rec5);

        TextField textDX = new TextField();
        TextField textD = new TextField();
        TextField textlamda = new TextField();
        TextField textl = new TextField();
        Button button = new Button();


        textDX.setLayoutX(10);
        textDX.setLayoutY(517);

        textD.setLayoutX(170);
        textD.setLayoutY(517);

        textlamda.setLayoutX(330);
        textlamda.setLayoutY(517);

        textl.setLayoutX(490);
        textl.setLayoutY(517);

        button.setLayoutX(650);
        button.setLayoutY(517);
        button.setMinSize(50,20);


        root.getChildren().addAll(textD,textDX,textl,textlamda, button);




        Scene scene = new Scene(root,700,550, Color.GREY);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);





        Timeline timeline1 = new Timeline();
        timeline1.setCycleCount(Timeline.INDEFINITE);

        KeyValue kv = new KeyValue(node.xProperty(), x1);
        KeyFrame kf = new KeyFrame(Duration.millis(9000), kv);
        timeline1.getKeyFrames().add(kf);

        timeline1.play();



        Timeline timeline2 = new Timeline();
        timeline2.setCycleCount(Timeline.INDEFINITE);
        double rad = Math.sqrt(2)*400;
        double dx,dy;

        for (int i = 0; i <num ; i++) {
            nodes[i].setX(x1);
            nodes[i].setY(248);
            dx = Math.cos(alfa[i])*rad + x1;
            dy = Math.sin(alfa[i])*rad + 248;


            KeyValue kvx = new KeyValue(nodes[i].xProperty(), dx);
            KeyFrame kfx = new KeyFrame(Duration.millis(9000), kvx);
            timeline2.getKeyFrames().add(kfx);

            KeyValue kvy = new KeyValue(nodes[i].yProperty(), dy);
            KeyFrame kfy = new KeyFrame(Duration.millis(9000), kvy);
            timeline2.getKeyFrames().add(kfy);


        }


        timeline2.play();



        Timeline timeline3 = new Timeline();
        timeline3.setCycleCount(Timeline.INDEFINITE);
        double rad3 = Math.sqrt(2)*400;
        double dx31,dy31,dx32,dy32;

        for (int i = 0; i <num ; i++) {
            nodes21[i].setX(x2);
            nodes21[i].setY(248 - yD);
            nodes22[i].setX(x2);
            nodes22[i].setY(248 + yD);

            dx31 = Math.cos(alfa[i])*rad3 + x2;
            dy31 = Math.sin(alfa[i])*rad3 + 248-yD;

            dx32 = Math.cos(alfa[i])*rad3 + x2;
            dy32 = Math.sin(alfa[i])*rad3 + 248+yD;

            KeyValue kvy31 = new KeyValue(nodes21[i].yProperty(), dy31);
            KeyFrame kfy31 = new KeyFrame(Duration.millis(9000), kvy31);
            timeline3.getKeyFrames().add(kfy31);


            KeyValue kvx31 = new KeyValue(nodes21[i].xProperty(), dx31);
            KeyFrame kfx31 = new KeyFrame(Duration.millis(9000), kvx31);
            timeline3.getKeyFrames().add(kfx31);


            KeyValue kvy32 = new KeyValue(nodes22[i].yProperty(), dy32);
            KeyFrame kfy32 = new KeyFrame(Duration.millis(9000), kvy32);
            timeline3.getKeyFrames().add(kfy32);


            KeyValue kvx32 = new KeyValue(nodes22[i].xProperty(), dx32);
            KeyFrame kfx32 = new KeyFrame(Duration.millis(9000), kvx32);
            timeline3.getKeyFrames().add(kfx32);



        }


       timeline3.play();





    }







    private void drawShapes(GraphicsContext gc) {



       gc.setFill(Color.color(0.25,0.25, 0.25));
       gc.fillRect(x1, 100, 10,300);
       gc.fillRect(x2, 60 , 10 , 380);
       gc.fillRect(x3, 40, 10, 420);

       gc.setFill(Color.GREY);
       gc.fillRect(x1, 248, 10,4);
       gc.fillRect(x2, 248-yD, 10, 4 );
       gc.fillRect(x2 ,  248 + yD, 10 , 4);





    }


    public static void main(String[] args) {
        launch(args);
    }
}




















