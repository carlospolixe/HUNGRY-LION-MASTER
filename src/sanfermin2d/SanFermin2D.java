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
    float groupVallaX1 = 700;
    float groupVallaX2 = 1200;
    float groupVallaX3 = 1700;
    float dificultad = 6;
    //--public boolean juegoFinalizado=false;

    Random randomValla = new Random();
        
    @Override
    public void start(Stage primaryStage) {
        
        //------------------------Creacion valla1--------------------------------------------------------------------------
        Pane root2 = new Pane();
        Polygon valla = new Polygon (new double[]{
            0, 40,
            0, 85,
            65, 65});
        valla.setFill(Color.DIMGRAY);
        
        valla.setLayoutY(575);
        randomValla = new Random();
        //--------------------------valla2--------------------------------------------------------
        Pane root3 = new Pane();
        Polygon valla2 = new Polygon (new double[]{
            0, 40,
            0, 85,
            65, 65});
        valla2.setFill(Color.DIMGRAY);
        
        valla2.setLayoutY(575);
         //--------------------------valla3--------------------------------------------------------
         Pane root4 = new Pane();
         Polygon valla3 = new Polygon (new double[]{
            0, 40,
            0, 85,
            65, 65});
        valla3.setFill(Color.DIMGRAY);
        
        valla3.setLayoutY(575);
        
        
        
        //------------------------grupo valla1--------------------------------------------------------------------
        Group groupvalla = new Group ();
            groupvalla.getChildren().addAll(valla);
            groupvalla.setRotate(-90);
            groupvalla.setScaleX(0.8);
            groupvalla.setScaleY(0.8);
        //------------------------grupo valla2--------------------------------------------------------------------  
        Group groupvalla2 = new Group ();
            groupvalla2.getChildren().addAll(valla2);
            groupvalla2.setRotate(-90);
            groupvalla2.setScaleX(0.8);
            groupvalla2.setScaleY(0.8);
         //------------------------grupo valla3--------------------------------------------------------------------   
        Group groupvalla3 = new Group ();
            groupvalla3.getChildren().addAll(valla3);
            groupvalla3.setRotate(-90);
            groupvalla3.setScaleX(0.8);
            groupvalla3.setScaleY(0.8);
            
            
           
            
       
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
                //-------------dificultad-------------------------------------
                groupVallaX1 = groupVallaX1 - dificultad;
                groupvalla.setLayoutX(groupVallaX1);
                groupVallaX2 = groupVallaX2 - dificultad;
                groupvalla2.setLayoutX(groupVallaX2);
                groupVallaX3 = groupVallaX3 - dificultad;
                groupvalla3.setLayoutX(groupVallaX3);
                
                 if (groupVallaX1<-30) {
                    groupVallaX1 = randomValla.nextInt(50) + 1500;
                }
                if (groupVallaX2<-30) {
                    groupVallaX2 = randomValla.nextInt(50) + 1500;
                }
                if (groupVallaX3<-30) {
                    groupVallaX3 = randomValla.nextInt(50) + 1500;
                }
            }
          };
            
        Pane root = new Pane();
            root.getChildren().addAll(imageviewfondo, imageviewfondo2,imageviewleon, groupvalla,groupvalla2,groupvalla3,groupMuñeco);
            
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
         //------------------------CHOQUE2----------------------------------------------------------------------------------
        AnimationTimer animationchoque2 = new AnimationTimer (){
           @Override
            public void handle (long now) { 
              Shape shapeColision = Shape.intersect(rectangleBoy , valla2);
              boolean colisionShapeA = shapeColision.getBoundsInLocal().isEmpty();
                       if(colisionShapeA == false){
                             root.getChildren().add(derrota);
                             this.stop();
                       }
            } 
         
        };
         //------------------------CHOQUE3----------------------------------------------------------------------------------
        AnimationTimer animationchoque3 = new AnimationTimer (){
           @Override
            public void handle (long now) { 
              Shape shapeColision = Shape.intersect(rectangleBoy , valla3);
              boolean colisionShapeA = shapeColision.getBoundsInLocal().isEmpty();
                       if(colisionShapeA == false){
                             root.getChildren().add(derrota);
                             this.stop();
                       }
            } 
         
        };
            
        animationDerrota.start();
        animationchoque.start();
        animationchoque2.start();
        animationchoque3.start();
        animacionTotal.start();
        animationvalla.start();
       // animationvalla2.start();
        //animationvalla3.start();
        animationcorredor.start();
        
        Scene scene = new Scene(root, 1366, 720);
        
        //------------------------PULSACION DE LA TECLA-------------------------------------------
        
        
        scene.setOnKeyPressed((KeyEvent teclapulsada) -> {
            
            switch(teclapulsada.getCode()) {
                
                case UP:
                        velocidad =  - 6;
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
   public void cargarvalla(String num){
       String nombre = ("valla" + num);
       //valla nombre = new valla();
   } 
}
