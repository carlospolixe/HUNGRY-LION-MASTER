/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanfermin2d;

import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author C.Diaz
 */
public class SanFermin2D extends Application {
        
    // Variables usadas en el movimiento de la valla
    int movimientovallaX = 0;
    int movimientovallaY = 0;
    int cambioEjeX = 0;
    int cambioEjeY = 0;
    double animationfondo = 0;
    double animationfondo2 = 1366;
    int corredorEjeX = 0;
    int corredorEjeY = 0;
    int velocidad = 0;
    //--------------------------
  
    //--public boolean juegoFinalizado=false;

    
    @Override
    public void start(Stage primaryStage) {
        //------------------------valla--------------------------------------------------------------------------
        Pane root2 = new Pane();
        Polygon valla = new Polygon (new double[]{
            0, 40,
            0, 85,
            60, 60});
        valla.setFill(Color.BLUEVIOLET);
        
        
        valla.setLayoutX(1000);
        valla.setLayoutY(575);
        Random vallaaleatoria = new Random();
        
        //------------------------grupo valla--------------------------------------------------------------------
        Group groupvalla = new Group ();
            groupvalla.getChildren().addAll(valla);
            groupvalla.setRotate(-90);
            groupvalla.setScaleX(0.8);
            groupvalla.setScaleY(0.8);
            
           
            
       
        //--------------------------------imagen fondo----------------------------------------------------------------------
        Image imagefondo = new Image(getClass().getResourceAsStream("imagen/fondo.jpg"));
        ImageView imageviewfondo = new ImageView(imagefondo);
        imageviewfondo.setFitHeight(768); 
        imageviewfondo.setFitWidth(1370);
        ImageView imageviewfondo2 = new ImageView(imagefondo);
        imageviewfondo2.setFitHeight(768); 
        imageviewfondo2.setFitWidth(1370);
        imageviewfondo2 .setX(-1366);
   
        // ---------------------------imagen corredor en movimiento--------------------------------------------------------
        Image imagecorredor = new Image(getClass().getResourceAsStream("imagen/corriendo.gif"));
        ImageView imageviewcorredor = new ImageView(imagecorredor);
        imageviewcorredor.setFitHeight(170); 
        imageviewcorredor.setFitWidth(170);
        imageviewcorredor .setX(200);
        imageviewcorredor .setY(520);
        
        
                  

            
        //------------------------------------animacion fondo--------------------------------------------------------------
          AnimationTimer animacionTotal = new AnimationTimer (){
            
            @Override
            public void handle (long now) {
                if (imageviewfondo.getX()<-1365){
                    animationfondo = 1366;
                    imageviewfondo.setX(animationfondo);
                    
               }
                else {
                    animationfondo = animationfondo - 2;
                    imageviewfondo.setX(animationfondo);
                };
                if (imageviewfondo2.getX()<-1365){
                    animationfondo2 = 1366;
                    imageviewfondo2.setX(animationfondo2);
                    
               }
                else {
                    animationfondo2 = animationfondo2 - 2;
                    imageviewfondo2.setX(animationfondo2);
                };
                
                
            }
            
          };
          //------------------------------------animacion corredor--------------------------------------------------------------
          AnimationTimer animationcorredor = new AnimationTimer (){
            
            @Override
            public void handle (long now) {
                corredorEjeY = velocidad + corredorEjeY;
                imageviewcorredor.setLayoutY(corredorEjeY);
                
                if (corredorEjeY <= -100){
                    
                    velocidad=1;
                    
                }
                if (corredorEjeY == 0){
                    
                    velocidad=0;
                    
                }
            }     
        };
        //------------------------------------animacion valla--------------------------------------------------------------
          AnimationTimer animationvalla = new AnimationTimer (){
            
            @Override
            public void handle (long now) { 
                //------------valla aletoria----------------
                movimientovallaX --;
                groupvalla.setLayoutY(movimientovallaY);
                 
                if (cambioEjeX == 0) {
                    groupvalla.setLayoutX(movimientovallaX);
                    movimientovallaX--;
                    if (movimientovallaX > 900) {
                        cambioEjeX = 1;
                    };
                }
                else {
                    groupvalla.setLayoutX(movimientovallaX);
                    movimientovallaX++;
                    if (movimientovallaX < 1) {
                        cambioEjeX = 0;
                    };                        
                };
               
            };
        };
          
            
        Pane root = new Pane();
            root.getChildren().addAll(imageviewfondo, imageviewfondo2, imageviewcorredor, groupvalla );
        
       
        animacionTotal.start();
        animationvalla.start();
        animationcorredor.start();
        
        Scene scene = new Scene(root, 1366, 720);
        
        //------------------------PULSACION DE LA TECLA-------------------------------------------
        
        scene.setOnKeyReleased((KeyEvent teclasoltada) -> {
            
            //velocidad = 0;           
        });
        scene.setOnKeyPressed((KeyEvent teclapulsada) -> {
            
            switch(teclapulsada.getCode()) {
                
                case UP:
                        velocidad =  - 2;
                    break;
               
               
            }
        });
   
        
        primaryStage.setTitle("HUNGRY LION 2D");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
   
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
