package com.github.TKWensday1115.Chart7ComplexBarChart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Grzegorz on 2016-04-20.
 */
public class ComplexBarChart extends StackedBarChart<String, Number> implements IComplexBarChart {

    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    private CategoriesManager categoriesManager;
    private SeriesManager seriesManager;


    public ComplexBarChart() {
        super(new CategoryAxis(), new NumberAxis());

        xAxis = (CategoryAxis) super.getXAxis();
        yAxis = (NumberAxis) super.getYAxis();

        categoriesManager = new CategoriesManager();
        seriesManager = new SeriesManager();

        xAxis.setLabel("Time");
        yAxis.setLabel("Value");

        xAxis.setCategories(categoriesManager.getCategories());  // FXCollections.<String>observableArrayList(Arrays.asList("czas1", "2", "3", "4"))
    }

    @Override
    public void AddData(String seriesName, String timeValue, Number number) {

        categoriesManager.AddCategory(timeValue);

        seriesManager.AddDataToSeries(seriesName, timeValue, number);

//        ObservableList<String> newCategories = xAxis.getCategories();
//        newCategories.add(timeValue);
//        xAxis.setCategories(newCategories);

    }

    @Override
    public void setHistoryLength(int length) {
        categoriesManager.setHistoryLength(length);
    }


    private class CategoriesManager {

        private ObservableList<String> categories;
        private int historyLength=10;

        public CategoriesManager() {
            categories = FXCollections.<String>observableArrayList(Arrays.asList());
        }

        public ObservableList<String> getCategories() {
            return categories;
        }

        public void AddCategory(String timeValue) {
            if (!categories.contains(timeValue)) {
                categories.add(timeValue);
                categories.sort(new Comparator(){
                    public int compare(Object o1, Object o2) {
                        return ((String)o1).compareTo(((String) o2));
                    }
                });
                if(categories.size()>historyLength) {
                    String categoryToDelete = categories.remove(0);
                    seriesManager.DeleteCategoryFromAllSeries(categoryToDelete);
                }
            }
        }

        public void setHistoryLength(int historyLength) {
            this.historyLength = historyLength;
        }
    }


    private class SeriesManager {

        private Map<String, XYChart.Series<String, Number>> seriesMap;

        public SeriesManager() {
            seriesMap = new HashMap<>();
        }

        public void AddDataToSeries(String seriesName, String timeValue, Number number) {

            XYChart.Series<String, Number> series = getSeriesByName(seriesName);
            series.getData().add(new XYChart.Data<String, Number>(timeValue, number));
        }

        private Series<String,Number> getSeriesByName(String seriesName) {
            XYChart.Series<String, Number> returnSeries = seriesMap.get(seriesName);
            if (returnSeries == null) {
                returnSeries = new XYChart.Series<String, Number>();
                returnSeries.setName(seriesName);
                seriesMap.put(seriesName, returnSeries);
                getData().add(returnSeries);

//            getData().sort(new Comparator(){
//                public int compare(Object o1, Object o2) {
//                    return ((Series<String,Number>)o1).getName().compareTo(((Series<String,Number>)o2).getName());
//                }
//            });
            }
            return returnSeries;
        }

        public void DeleteCategoryFromAllSeries(String categoryToDelete) {
            for (XYChart.Series<String, Number> series : seriesMap.values()) {
                series.getData().removeIf(data -> {
                    if(((String)(data.getXValue())).equals(categoryToDelete))
                        return true;
                    return false;
                });
            }
        }
    }
}
