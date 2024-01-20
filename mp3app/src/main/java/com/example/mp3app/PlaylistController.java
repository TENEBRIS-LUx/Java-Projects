package com.example.mp3app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;


public class PlaylistController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label apptext;
    @FXML
    private ProgressBar progressbar;
    @FXML
    private ButtonBar searchbar;
    @FXML
    private Button searchbutton ,homebutton , librarybutton , playlistbutton, playbutton,Pausebutton,nextbutton ,previousbutton,shufflebutton ,newplaylistbutton ,
            shuffleandplaybutton  ;
    @FXML
    private SplitPane split;
    @FXML
    private Slider volumeslider;

    @FXML
    protected void searchtrack (){

    }
    @FXML
    protected void tohome (){

    }
    @FXML
    protected void tolibrary(){

    }
    @FXML
    protected void toplaylist(){

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist.fxml"));


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
    protected void createplaylist(){

    }
}
