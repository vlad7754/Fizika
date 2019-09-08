package sample;

import javafx.animation.Animation;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public abstract class Spam extends Animation {

    final  int num = 5;
    final Rectangle[] nodes = new Rectangle[num];
    final double[] alfa = new double[num];
    final Random random = new Random();

   public void spamStart(){

   }


}
