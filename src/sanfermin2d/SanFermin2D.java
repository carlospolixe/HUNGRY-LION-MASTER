/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanfermin2d;

import java.io.File;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
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
    float dificultad = 8;
    int paneScores = 0;
    int marcador = -1;
    boolean IsOnjump ;
    

    Random randomValla = new Random();
        
    @Override
    public void start(Stage primaryStage) {
        //----------------------------------------------
      
        
        
        //-------------------------Creacion Barra marcaje-----------------------------------------------------------------
        Rectangle rectaglebarra = new Rectangle (0, 0 , 200, 50);
        rectaglebarra.setFill(Color.TRANSPARENT);
        Text puntacion = new Text ("Score:");
        puntacion.setFont(Font.font(30));
        puntacion.setX(0);
        puntacion.setY(25);
            puntacion.setFill(Color.BLACK);
        //---------------------------------------------------------------
        
        Text marcadorText = new Text ("0");
        marcadorText.setFont(Font.font(25));
        marcadorText.setX(95);
        marcadorText.setY(25);
            marcadorText.setFill(Color.BLACK);
            
        Group groupMarcador = new Group ();
        groupMarcador.getChildren().addAll(rectaglebarra,puntacion,marcadorText);
        //-------------------MARCADOR GRANDE-----------------------------------------------------
        Text puntacion2 = new Text ("MAXSCORE:");
        puntacion2.setX(490);
        puntacion2.setY(200);
        puntacion2.setFont(Font.font(50));
        puntacion2.setFill(Color.BLACK);
        puntacion2.setVisible(false);
        
        Text marcadorText2 = new Text ("0");
        marcadorText2.setFont(Font.font(60));
        marcadorText2.setX(780);
        marcadorText2.setY(200);
        marcadorText2.setFill(Color.BLACK);
        marcadorText2.setVisible(false);
        

        //-----------------------------introduccion sonido al juego -----------------------------------
        Media media = new Media(getClass().getResource("imagen/sound.mp3").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();



        
        //------------------------Creacion valla1--------------------------------------------------------------------------
       
      
        Rectangle valla = new Rectangle (30, 40, 100, 50);
        valla.setLayoutY(575);
        valla.setFill(Color.SADDLEBROWN);
        
        Rectangle ladrillo = new Rectangle (30, 60, 47, 2);
        ladrillo.setLayoutY(575);
        ladrillo.setRotate(90);
        ladrillo.setFill(Color.WHITE);
        
        Rectangle ladrillo2 = new Rectangle (50, 60, 47, 2);
        ladrillo2.setLayoutY(575);
        ladrillo2.setRotate(90);
        ladrillo2.setFill(Color.WHITE);
        
        Rectangle ladrillo3 = new Rectangle (80, 60, 47, 2);
        ladrillo3.setLayoutY(575);
        ladrillo3.setRotate(90);
        ladrillo3.setFill(Color.WHITE);
        
        Rectangle ladrillo4 = new Rectangle (104, 58, 24, 2);
        ladrillo4.setLayoutY(575);
        ladrillo4.setRotate(180);
        ladrillo4.setFill(Color.WHITE);
        
        Rectangle ladrillo5 = new Rectangle (74, 68, 30, 2);
        ladrillo5.setLayoutY(575);
        ladrillo5.setRotate(180);
        ladrillo5.setFill(Color.WHITE);
        
        Rectangle ladrillo6 = new Rectangle (54, 48, 20, 2);
        ladrillo6.setLayoutY(575);
        ladrillo6.setRotate(180);
        ladrillo6.setFill(Color.WHITE);
        

        
      
        randomValla = new Random();
        //--------------------------valla2--------------------------------------------------------
        
        Rectangle valla2 = new Rectangle (30, 40, 100, 50);
        valla2.setLayoutY(575);
        valla2.setFill(Color.SADDLEBROWN);
        
        Rectangle ladrillo7 = new Rectangle (30, 60, 47, 2);
        ladrillo7.setLayoutY(575);
        ladrillo7.setRotate(90);
        ladrillo7.setFill(Color.WHITE);
        
        Rectangle ladrillo8 = new Rectangle (50, 60, 47, 2);
        ladrillo8.setLayoutY(575);
        ladrillo8.setRotate(90);
        ladrillo8.setFill(Color.WHITE);
        
        Rectangle ladrillo9 = new Rectangle (80, 60, 47, 2);
        ladrillo9.setLayoutY(575);
        ladrillo9.setRotate(90);
        ladrillo9.setFill(Color.WHITE);
        
        Rectangle ladrillo10 = new Rectangle (104, 58, 24, 2);
        ladrillo10.setLayoutY(575);
        ladrillo10.setRotate(180);
        ladrillo10.setFill(Color.WHITE);
        
        Rectangle ladrillo11 = new Rectangle (74, 68, 30, 2);
        ladrillo11.setLayoutY(575);
        ladrillo11.setRotate(180);
        ladrillo11.setFill(Color.WHITE);
        
        Rectangle ladrillo12 = new Rectangle (54, 48, 20, 2);
        ladrillo12.setLayoutY(575);
        ladrillo12.setRotate(180);
        ladrillo12.setFill(Color.WHITE);
        
         //--------------------------valla3--------------------------------------------------------
        
        Rectangle valla3 = new Rectangle (30, 40, 100, 50);
        valla3.setLayoutY(575);
        valla3.setFill(Color.SADDLEBROWN);
        
        Rectangle ladrillo13 = new Rectangle (30, 60, 47, 2);
        ladrillo13.setLayoutY(575);
        ladrillo13.setRotate(90);
        ladrillo13.setFill(Color.WHITE);
        
        Rectangle ladrillo14 = new Rectangle (50, 60, 47, 2);
        ladrillo14.setLayoutY(575);
        ladrillo14.setRotate(90);
        ladrillo14.setFill(Color.WHITE);
        
        Rectangle ladrillo15 = new Rectangle (80, 60, 47, 2);
        ladrillo15.setLayoutY(575);
        ladrillo15.setRotate(90);
        ladrillo15.setFill(Color.WHITE);
        
        Rectangle ladrillo16 = new Rectangle (104, 58, 24, 2);
        ladrillo16.setLayoutY(575);
        ladrillo16.setRotate(180);
        ladrillo16.setFill(Color.WHITE);
        
        Rectangle ladrillo17 = new Rectangle (74, 68, 30, 2);
        ladrillo17.setLayoutY(575);
        ladrillo17.setRotate(180);
        ladrillo17.setFill(Color.WHITE);
        
        Rectangle ladrillo18 = new Rectangle (54, 48, 20, 2);
        ladrillo18.setLayoutY(575);
        ladrillo18.setRotate(180);
        ladrillo18.setFill(Color.WHITE);
        
        
        
        //------------------------grupo valla1--------------------------------------------------------------------
        Group groupvalla = new Group ();
            groupvalla.getChildren().addAll(valla);
            groupvalla.getChildren().addAll(ladrillo);
            groupvalla.getChildren().addAll(ladrillo2);
            groupvalla.getChildren().addAll(ladrillo3);
            groupvalla.getChildren().addAll(ladrillo4);
            groupvalla.getChildren().addAll(ladrillo5);
            groupvalla.getChildren().addAll(ladrillo6);
            groupvalla.setRotate(-90);
            groupvalla.setScaleX(0.8);
            groupvalla.setScaleY(0.8);
        //------------------------grupo valla2--------------------------------------------------------------------  
        Group groupvalla2 = new Group ();
            groupvalla2.getChildren().addAll(valla2);
            groupvalla2.getChildren().addAll(ladrillo7);
            groupvalla2.getChildren().addAll(ladrillo8);
            groupvalla2.getChildren().addAll(ladrillo9);
            groupvalla2.getChildren().addAll(ladrillo10);
            groupvalla2.getChildren().addAll(ladrillo11);
            groupvalla2.getChildren().addAll(ladrillo12);
            groupvalla2.setRotate(-90);
            groupvalla2.setScaleX(0.8);
            groupvalla2.setScaleY(0.8);
         //------------------------grupo valla3--------------------------------------------------------------------   
        Group groupvalla3 = new Group ();
            groupvalla3.getChildren().addAll(valla3);
            groupvalla3.getChildren().addAll(ladrillo13);
            groupvalla3.getChildren().addAll(ladrillo14);
            groupvalla3.getChildren().addAll(ladrillo15);
            groupvalla3.getChildren().addAll(ladrillo16);
            groupvalla3.getChildren().addAll(ladrillo17);
            groupvalla3.getChildren().addAll(ladrillo18);
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
                marcador ++;
                marcadorText.setText(String.valueOf(marcador));
                marcadorText2.setText(String.valueOf(marcador));
                
                
                
                if (corredorEjeY <= -100){
                    
                    velocidad=3;
                    
                }
                if (corredorEjeY == 0){
                    
                    velocidad=0;
                    IsOnjump = false;
                }
            }     
        }; 
        Text derrota = new Text ("¡¡GAME OVER!!");
        derrota.setFont(Font.font(160));
        derrota.setX(150);
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
                
                // Variable  que genera una posicion aleatoria de las vallaa  de forma que si es <-30 genera una posicion aleatoria entre 200  y 1300
                 if (groupVallaX1<-30) {
                    groupVallaX1 = randomValla.nextInt(40) + 1400;
                    
                }
                if (groupVallaX2<-30) {
                    groupVallaX2 = randomValla.nextInt(40) + 1400;
                    
                }
                if (groupVallaX3<-30) {
                    groupVallaX3 = randomValla.nextInt(40) + 1400;
                    
                }
            }
          };
        //----------------------PANE GENERAL-------------------------------------------    
        Pane root = new Pane();
            root.getChildren().addAll(imageviewfondo, imageviewfondo2,
                    imageviewleon, groupvalla,groupvalla2,groupvalla3,
                    groupMuñeco,groupMarcador,puntacion2,marcadorText2);
            
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
       //--------------------------Colision Primera valla------------------------------------------------------
              boolean colisionShapeA = shapeColision.getBoundsInLocal().isEmpty();
              if(colisionShapeA == false){
                    System.out.println("Colisión 1");
                    root.getChildren().add(derrota);
                    this.stop();
                    animacionTotal.stop();
                    animationvalla.stop();
                    animationcorredor.stop();
                    groupMuñeco.setVisible(false);
                    groupvalla.setVisible(false);
                    groupvalla2.setVisible(false);
                    groupvalla3.setVisible(false);
                    imageviewleon.setVisible(false);
                    groupMarcador.setVisible(false);
                    marcadorText2.setVisible(true);
                    puntacion2.setVisible(true);
                    mediaPlayer.stop();

                }
        //--------------------------Colision segunda valla------------------------------------------------------
              Shape shapeColision2 = Shape.intersect(rectangleBoy , valla2);
              boolean colisionShapeB = shapeColision2.getBoundsInLocal().isEmpty();
              if(colisionShapeB == false){
                    root.getChildren().add(derrota);
                    this.stop();
                    animacionTotal.stop();
                    animationvalla.stop();
                    animationcorredor.stop();
                    groupMuñeco.setVisible(false);
                    groupvalla.setVisible(false);
                    groupvalla2.setVisible(false);
                    groupvalla3.setVisible(false);
                    imageviewleon.setVisible(false);
                    groupMarcador.setVisible(false);
                    marcadorText2.setVisible(true);
                    puntacion2.setVisible(true);
                    mediaPlayer.stop();


                  
                }
        //--------------------------Colision Primera valla------------------------------------------------------
                Shape shapeColision3 = Shape.intersect(rectangleBoy , valla3);
                boolean colisionShapeC = shapeColision3.getBoundsInLocal().isEmpty();
                if(colisionShapeC == false){
                    root.getChildren().add(derrota);
                    this.stop();
                    animacionTotal.stop();
                    animationvalla.stop();
                    animationcorredor.stop();
                    groupMuñeco.setVisible(false);
                    groupvalla.setVisible(false);
                    groupvalla2.setVisible(false);
                    groupvalla3.setVisible(false);
                    imageviewleon.setVisible(false);
                    groupMarcador.setVisible(false);
                    marcadorText2.setVisible(true);
                    puntacion2.setVisible(true);
                    mediaPlayer.stop();

  
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
        
        
        scene.setOnKeyPressed((KeyEvent teclapulsada) -> {
            
            switch(teclapulsada.getCode()) {
                
                case UP:
                    if (IsOnjump == false){
                        velocidad = -6;
                        IsOnjump = true;
                    }
                    break;
                    
                case SPACE:
                    
                    root.getChildren().remove(derrota);
                    this.reinicio();
                    animacionTotal.start();
                    animationvalla.start();
                    animationcorredor.start();
                    animationchoque.start();
                    groupMuñeco.setVisible(true);
                    groupvalla.setVisible(true);
                    groupvalla2.setVisible(true);
                    groupvalla3.setVisible(true);
                    imageviewleon.setVisible(true);
                    groupMarcador.setVisible(true);
                    marcadorText2.setVisible(false);
                    puntacion2.setVisible(false);
                    mediaPlayer.play();
                   
                    
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
        groupVallaX1 = 700;
        groupVallaX2 = 1200;
        groupVallaX3 = 1700;
        marcador = -1;
        paneScores = 0;
        
        
    }

}
