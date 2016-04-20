package com.github.TKWensday1115.Chart7ComplexBarChart;

import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;

/**
 * Created by Grzegorz on 2016-04-20.
 */
public class ComplexBarChart extends StackedBarChart<String, Number> implements IComplexBarChart {

    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    public ComplexBarChart() {
        super(new CategoryAxis(), new NumberAxis());

        xAxis = (CategoryAxis) super.getXAxis();
        yAxis = (NumberAxis) super.getYAxis();

        xAxis.setLabel("Time");
        yAxis.setLabel("Value");

    }

    @Override
    public void AddData(String seriesName, String timeValue, Number number) {

    }

    @Override
    public void setHistoryLength(int length) {

    }
}
