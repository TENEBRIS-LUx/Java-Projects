package com.example.mp3app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


public class libraryController implements Initializable {
    @FXML
    private Pane pane;
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
    private Media media;
    private MediaPlayer mediaPlayer;
    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private  int songNumber;
    private boolean running;
    private Timer timer;
    private TimerTask task;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        songs = new ArrayList<File>();
        directory = new File("music");
        files = directory.listFiles();
        if(files != null){
            for(File file: files){
                songs.add(file);
            }
        }
        media  = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        volumeslider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mediaPlayer.setVolume(volumeslider.getValue() * 0.01);
            }
        });

        progressbar.setStyle("-fx-accent: #00ff00");
    }
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
        mediaPlayer.play();
        beginmtimer();

    }
    @FXML
    protected void pausetrack(){
        mediaPlayer.pause();
        canceltimer();

    }
    @FXML

    protected void nexttrack(){
        if(songNumber < songs.size() - 1){
            songNumber++;
            mediaPlayer.stop();
            if(running == true){
                canceltimer();
            }
            media  = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playtrack();

        }
        else{
            songNumber = 0;
            mediaPlayer.stop();
            if(running == true){
                canceltimer();
            }
            media  = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playtrack();
        }

    }
    @FXML
    protected void previoustrack(){
        if(songNumber > 0){
            songNumber--;
            mediaPlayer.stop();
            if(running == true){
                canceltimer();
            }
            media  = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playtrack();

        }
        else{
            songNumber = songs.size() - 1;
            mediaPlayer.stop();
            if(running == true){
                canceltimer();
            }
            media  = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            playtrack();
        }

    }
    @FXML
    protected void shuffletrack(){
        Collections.shuffle(songs);

    }
    @FXML
    protected void shuflleandplay(){
        shuffletrack();
        songNumber = 0;
        mediaPlayer.stop();
        if (running) {
            canceltimer();
        }
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        playtrack();

    }
    @FXML
    protected void sorttrack(){

    }

    @FXML
    protected void beginmtimer(){
        timer = new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double ending = mediaPlayer.getTotalDuration().toSeconds();
                progressbar.setProgress(current/ending);
                if(current/ending == 1){
                    canceltimer();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);

    }

    @FXML
    protected void canceltimer(){
        running = false;
        timer.cancel();

    }
}
