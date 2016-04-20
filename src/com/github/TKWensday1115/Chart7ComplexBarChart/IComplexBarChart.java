package com.github.TKWensday1115.Chart7ComplexBarChart;


/**
 * Created by Grzegorz on 2016-04-20.
 */
public interface IComplexBarChart {
    void AddData(String seriesName, String timeValue, Number number);
    void setHistoryLength(int length);
    void setTitle(String title);

}
