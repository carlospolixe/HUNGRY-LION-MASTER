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
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author C.Diaz
 */
public class SanFermin2D extends Application {
        
    // ---------------------------Variables usadas 
    int movimientovallaX = 0;
    int movimientovallaY = 0;
    int cambioEjeX = 0;
    int cambioEjeY = 0;
    double animationfondo = 0;
    double animationfondo2 = 1366;
    int corredorEjeX = 0;
    int corredorEjeY = 0;
    int velocidad = 0;
    //--public boolean juegoFinalizado=false;

    
    @Override
    public void start(Stage primaryStage) {
        //------------------------Creacion valla--------------------------------------------------------------------------
        Pane root2 = new Pane();
        Polygon valla = new Polygon (new double[]{
            0, 40,
            0, 85,
            65, 65});
        valla.setFill(Color.DARKGREY);
        
        
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
        Image imagefondo = new Image(getClass().getResourceAsStream("imagen/fondo.png"));
        ImageView imageviewfondo = new ImageView(imagefondo);
        imageviewfondo.setFitHeight(768); 
        imageviewfondo.setFitWidth(1380);
        ImageView imageviewfondo2 = new ImageView(imagefondo);
        imageviewfondo2.setFitHeight(768); 
        imageviewfondo2.setFitWidth(1370);
        imageviewfondo2 .setX(-1366);
   
        // ---------------------------imagen corredor en movimiento--------------------------------------------------------
        Image imagecorredor = new Image(getClass().getResourceAsStream("imagen/corriendo.gif"));
        ImageView imageviewcorredor = new ImageView(imagecorredor);
        Rectangle rectangleBoy = new Rectangle (32, 111);
        rectangleBoy.setX(200);
        rectangleBoy.setY(540);
        rectangleBoy.setVisible(false);
        rectangleBoy.setFill(Color.BLACK);
        imageviewcorredor.setFitHeight(175); 
        imageviewcorredor.setFitWidth(170);
        imageviewcorredor .setX(120);
        imageviewcorredor .setY(520);
        
        Group groupMuñeco = new Group ();
            groupMuñeco.getChildren().addAll(rectangleBoy, imageviewcorredor);
        
        // ---------------------------imagen leon en movimiento--------------------------------------------------------
        Image imagenleon = new Image(getClass().getResourceAsStream("imagen/leon.gif"));
        ImageView imageviewleon = new ImageView(imagenleon);
        imageviewleon.setFitHeight(175); 
        imageviewleon.setFitWidth(170);
        imageviewleon .setX(-100);
        imageviewleon .setY(520);
        imageviewleon.setScaleX(2);
        

            
        //------------------------------------animacion fondo--------------------------------------------------------------
          AnimationTimer animacionTotal = new AnimationTimer (){
            
            @Override
            public void handle (long now) {
                if (imageviewfondo.getX()<-1365){
                    animationfondo = 1366;
                    imageviewfondo.setX(animationfondo);
                    
               }
                else {
                    animationfondo = animationfondo - 6;
                    imageviewfondo.setX(animationfondo);
                };
                if (imageviewfondo2.getX()<-1365){
                    animationfondo2 = 1366;
                    imageviewfondo2.setX(animationfondo2);
                    
               }
                else {
                    animationfondo2 = animationfondo2 - 6;
                    imageviewfondo2.setX(animationfondo2);
                };
                
                
            }
            
          };
          //------------------------------------animacion corredor--------------------------------------------------------------
          AnimationTimer animationcorredor = new AnimationTimer (){
            
            @Override
            public void handle (long now) {
                corredorEjeY = velocidad + corredorEjeY;
                groupMuñeco.setLayoutY(corredorEjeY);
                
                if (corredorEjeY <= -100){
                    
                    velocidad=2;
                    
                }
                if (corredorEjeY == 0){
                    
                    velocidad=0;
                    
                }
            }     
        }; 
        Text derrota = new Text ("GAME OVER");
        derrota.setFont(Font.font(160));
        derrota.setX(220);
        derrota.setY(400);
            derrota.setFill(Color.BLACK);
       
                  
         
        //------------------------------------animacion valla--------------------------------------------------------------
          AnimationTimer animationvalla = new AnimationTimer (){
            
            @Override
            public void handle (long now) { 
                //-----------------------------valla aletoria---------------------------------------------------
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
            root.getChildren().addAll(imageviewfondo, imageviewfondo2,imageviewleon, groupvalla,groupMuñeco);
            
         AnimationTimer animationDerrota = new AnimationTimer (){
           @Override
            public void handle (long now) { 
                
            }
         
        };
            
        //------------------------CHOQUE----------------------------------------------------------------------------------
        AnimationTimer animationchoque = new AnimationTimer (){
           @Override
            public void handle (long now) { 
              Shape shapeColision = Shape.intersect(rectangleBoy , valla);
              boolean colisionShapeA = shapeColision.getBoundsInLocal().isEmpty();
                       if(colisionShapeA == false){
                             root.getChildren().add(derrota);
                             this.stop();
                       }
            } 
         
        };
            
        animationDerrota.start();
        animationchoque.start();
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
                        velocidad =  - 3;
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
    
    public void reinicio (){
        movimientovallaX = 0;
        movimientovallaY = 0;
        cambioEjeX = 0;
        cambioEjeY = 0;
        corredorEjeX = 0;
        corredorEjeY = 0;
        velocidad = 0;
    }
    
}
