package com.tione.tiona.Models.AdminInbox;

import com.tione.tiona.Models.User;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class UserVBox extends User {
    private String user_id,first_name,last_name,title,email;

    public UserVBox(String user_id, String first_name, String last_name, String email) {
        super(user_id,first_name,last_name,email);

    }
    public VBox getContent(){
        VBox vBox=new VBox();
        vBox.setMargin(vBox,new Insets(0,0,0,10));
        HBox hBox=new HBox();
        Group group=new Group();
        VBox innerVbox=new VBox();
        Label label=new Label(getFirst_name()+" "+getLast_name());
        Label title=new Label("Test");
        label.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 19));
        label.setTextFill(Color.WHITE);
        label.getStyleClass().add("shadow");
        label.setPadding(new Insets(10,10,10,10));
        title.setTextFill(Color.WHITE);
        title.setPadding(new Insets(10,10,10,10));
        title.getStyleClass().add("shadow");
        title.setFont(Font.font("Tw Cen MT Condensed", FontWeight.BOLD, 19));
        innerVbox.getChildren().add(label);
        innerVbox.getChildren().add(title);
        group.getStyleClass().add("shadow");
        Circle innerCircle=new Circle(0,0,30);
        innerCircle.getStyleClass().add("innercircle-color");
        Circle outerCircle=new Circle(0,0,35);
        outerCircle.getStyleClass().add("outercircle-color");
        group.getChildren().add(outerCircle);
        group.getChildren().add(innerCircle);
        hBox.getChildren().add(group);
        hBox.getChildren().add(innerVbox);
        hBox.setMargin(group,new Insets(0,0,0,10));
        hBox.setSpacing(20);
        Line line=new Line();
        vBox.setMargin(line,new Insets(10,0,10,20));
        line.setStartX(-130);
        line.setEndX(138.9595489501953);
        line.setStartY(0);
        line.setEndY(0);
        line.getStyleClass().add("line-separator");
        vBox.getStyleClass().add("button-container-mouse-moved");
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(line);
        return vBox;
    }
}
