package com.github.TKWensday1115.Chart7ComplexBarChart;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Grzegorz on 2016-04-20.
 */
public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Bar Chart Sample");

        ComplexBarChart sbc = new ComplexBarChart();
        sbc.setHistoryLength(7);
        sbc.setTitle("Inside Component Title");

        Scene scene = new Scene(sbc, 800, 600);
        stage.setScene(scene);
        stage.show();

        sbc.addData("seria1", "1", 100);
        sbc.addData("seria1", "2", 10);
        sbc.addData("seria1", "4", 10);
        sbc.addData("seria2", "1", 60);
        sbc.addData("seria2", "2", 20);
        sbc.addData("seria2", "3", 10);
        sbc.addData("seria3", "3", 90);
        sbc.addData("seria4", "3", 40);
        sbc.addData("seria1", "3", 10);

        new Thread(() -> {

            try {
                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.addData("seria5", "4", 40);
                    sbc.addData("seria5", "5", 40);
                    sbc.addData("seria5", "6", 40);
                });

                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.addData("seria3", "1", 60);
                    sbc.addData("seria3", "2", 60);
                    sbc.addData("seria3", "5", 60);
                });

                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.addData("seria6", "5", 70);
                    sbc.addData("seria7", "6", 70);
                    sbc.addData("seria6", "7", 70);
                    sbc.addData("seria6", "8", 70);
                    sbc.addData("seria6", "9", 70);
                });

                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.addData("seria6", "5", 70);
                    sbc.addData("seria7", "6", 70);
                    sbc.addData("seria7", "7", 70);
                    sbc.addData("seria7", "8", 70);
                    sbc.addData("seria8", "91", 70);
                });


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();


    }

    public static void main(String[] args) {
        launch(args);
    }

}
