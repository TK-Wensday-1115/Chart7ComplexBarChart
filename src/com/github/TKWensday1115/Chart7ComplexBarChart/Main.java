package com.github.TKWensday1115.Chart7ComplexBarChart;

import javafx.application.Application;
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

        Scene scene = new Scene(sbc, 800, 600);
//        sbc.getData().addAll(series1, series2, series3);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
