package com.example.mp3app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class libraryController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label apptext;
    @FXML
    private ProgressBar progressbar;
    @FXML
    private ButtonBar searchbar;
    @FXML
    private Button searchbutton ,homebutton , librarybutton , playlistbutton, playbutton,Pausebutton,nextbutton ,previousbutton,shuffleandplaybutton , sortbutton;
    @FXML
    private SplitPane split;
    @FXML
    private Slider volumeslider;
    @FXML
    protected  ListView musiclist;
    @FXML
    protected void searchtrack (){

    }
    @FXML
    protected void tohome (){

    }
    @FXML
    protected void tolibrary() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("MP3  APPLICATION!");
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    protected void toplaylist() throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("MP3  APPLICATION!");
        stage.setScene(scene);
        stage.show();





    }


    @FXML
    protected void playtrack(){

    }
    @FXML
    protected void pausetrack(){

    }
    @FXML

    protected void nexttrack(){

    }
    @FXML
    protected void previoustrack(){

    }
    @FXML
    protected void shuffletrack(){

    }
    @FXML
    protected void shuflleandplay(){

    }
    @FXML
    protected void sorttrack(){

    }
}
