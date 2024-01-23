package com.example.mp3app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class PlaylistController implements Initializable {



    @FXML
    private Label welcomeText;
    @FXML
    private Label apptext;
    @FXML
    private ProgressBar progressbar;
    @FXML
    private ButtonBar searchbar;
    private Media media;
    private MediaPlayer mediaPlayer;
    private TimerTask task;
    private Timer timer;

    @FXML
    private Button searchbutton ,homebutton , librarybutton , playlistbutton, playbutton,Pausebutton,nextbutton ,previousbutton,shufflebutton ,newplaylistbutton ,
            shuffleandplaybutton  ;
    @FXML
    private SplitPane split;
    @FXML
    private Slider volumeslider;
    @FXML
    private ArrayList<File> songs;
    @FXML
    private File directory;
    private File[] files;
    private int songNumber;
    private boolean running;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        songs = new ArrayList<>();

        directory = new File("src/main/java/com/example/mp3app/music");
        files = directory.listFiles();
        if(files != null){
            songs.addAll(Arrays.asList(files));
        }

        if (!songs.isEmpty() && songNumber < songs.size()) {
            media = new Media(songs.get(songNumber).toURI().toString());
            // Rest of your code related to media initialization
        } else {
            // Handle the case when the songs list is empty or songNumber is out of bounds
            System.out.println("Error: No songs available or invalid songNumber");
        }
        mediaPlayer = new MediaPlayer(media);

        volumeslider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mediaPlayer.setVolume(volumeslider.getValue() *0.01);
            }
        });


    }


    @FXML
    protected void searchtrack (){

    }
    @FXML
    protected void tohome (){

    }
    @FXML
    protected void tolibrary() throws IOException {

    }
    @FXML
    protected void toplaylist(){

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("playlist.fxml"));


    }


    @FXML
    protected void playtrack(){
        beginTimer();
        mediaPlayer.play();
        mediaPlayer.setVolume(volumeslider.getValue() *0.01);

    }
    @FXML
    protected void pausetrack(){
        cancelTimer();
       mediaPlayer.pause();
    }
    @FXML
    protected void nexttrack(){
        if(songNumber < songs.size() - 1){
            songNumber++;
            mediaPlayer.stop();

            if(running){
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            playtrack();
        }
        else{
            songNumber = 0;
            mediaPlayer.stop();

            if(running){
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            playtrack();
        }

    }
    @FXML
    protected void previoustrack(){
        if(songNumber > songs.size() - 1){
            songNumber--;
            mediaPlayer.stop();

            if(running){
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            playtrack();
        }
        else{
            songNumber = songs.size() - 1;
            mediaPlayer.stop();
            if(running){
                cancelTimer();
            }

            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);

            playtrack();
        }


    }
    @FXML
    protected void shuffletrack(){

        Collections.shuffle(songs);

    }
    @FXML
    protected void createplaylist(){

    }
    @FXML
    protected void beginTimer(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                progressbar.setProgress(current/end);

                if(current/end == 1){
                    cancelTimer();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);


    }
    @FXML
    protected void cancelTimer(){

        running = false;
        timer.cancel();

    }


}

///BIGOUAWE EFFOUDOU NIGUEL CLARK ICTU20223125
