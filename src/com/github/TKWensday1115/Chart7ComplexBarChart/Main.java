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

        Scene scene = new Scene(sbc, 800, 600);
//        sbc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();

        sbc.AddData("seria1","1", 100 );
        sbc.AddData("seria1","2", 10 );
        sbc.AddData("seria1","4", 10 );
        sbc.AddData("seria2","1", 60 );
        sbc.AddData("seria2","2", 20 );
        sbc.AddData("seria2","3", 10 );
        sbc.AddData("seria3","3", 90 );
        sbc.AddData("seria4","3", 40 );
        sbc.AddData("seria1","3", 10 );

        new Thread(() -> {

            try {
                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.AddData("seria5","4", 40 );
                    sbc.AddData("seria5","5", 40 );
                    sbc.AddData("seria5","6", 40 );
                });

                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.AddData("seria3", "1", 60);
                    sbc.AddData("seria3", "2", 60);
                    sbc.AddData("seria3", "5", 60);
                });

                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.AddData("seria6", "5", 70);
                    sbc.AddData("seria7", "6", 70);
                    sbc.AddData("seria6", "7", 70);
                    sbc.AddData("seria6", "8", 70);
                    sbc.AddData("seria6", "9", 70);
                });

                Thread.sleep(2000);

                Platform.runLater(() -> {
                    sbc.AddData("seria6", "5", 70);
                    sbc.AddData("seria7", "6", 70);
                    sbc.AddData("seria7", "7", 70);
                    sbc.AddData("seria7", "8", 70);
                    sbc.AddData("seria8", "91", 70);
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
