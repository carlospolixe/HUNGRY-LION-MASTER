/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanfermin2d;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Carlos Diaz Jimenez
 */
public class valla extends Group {
    public valla(){
    Group nombre = new Group();
    Polygon valla = new Polygon (new double[]{
            0, 40,
            0, 85,
            65, 65});
        valla.setFill(Color.DARKGREY);
        
        
        valla.setLayoutX(1000);
        valla.setLayoutY(575);
        this.getChildren().add(valla);
        
}
    
    
}
