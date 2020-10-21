package sample;


import javafx.application.Application;
import javafx.scene.media.AudioSpectrumListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Visualizer extends Main implements AudioSpectrumListener {

    private float[] cMag;
    private short power = 5;

    private Rectangle[] rect = new Rectangle[40];

    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
        System.out.println("s");
        for (int i = 0; i < magnitudes.length; i++) {
            cMag = magnitudes;
            cMag[i] = (int) cMag[i] * power;
            System.out.println("cMag (" + i + "): " + cMag[i]);
        }

        for (int i = 0; i < rect.length; i++) {
            rect[i].setY(500 + ((cMag[i] + (60 * power)) * -1));
            rect[i].setHeight(50 + (cMag[i] + (60 * power)));
        }

    }
}

    /*private MediaPlayer audioMP;
    private float[] cMag;
    private short power = 5;

    private Rectangle[] rect = new Rectangle[40];

    @Override
    public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
        for (int i = 0; i < magnitudes.length; i++) {
            cMag = magnitudes;
            cMag[i] = (int) cMag[i] * power;
            System.out.println("cMag (" + i + "): " + cMag[i]);
        }

        for(int i = 0; i < rect.length; i++) {
            rect[i].setY(500 + ((cMag[i] + (60 * power)) * -1));
            rect[i].setHeight(50 + (cMag[i] + (60 * power)));
        }

    }*/

