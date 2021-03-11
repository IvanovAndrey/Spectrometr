package algoritm;

import data.DataReader;

import java.io.IOException;

public class CompareAlgoritm {
    private static int plotNum;
    private static int plotLength;
    private static int[] plotsStr;
    private static int[][] plots;

    public CompareAlgoritm() throws IOException {
        DataReader data = DataReader.getInstance();
        plotNum =data.getPlotNum();
        plotLength =data.getPlotLength();
        plotsStr = data.getPlots();
        plots = new int[plotNum][plotLength]; //будущая матрица
        int count = 0;
        for (int i = 0; i < plots.length; i++) {
            for (int j = 0; j < plots[i].length; j++) {
                plots[i][j] = plotsStr[count++]; //перенос элементов из донора в матрицу
            }
        }
    }

    public int compareRating (int[] inputArr){
        int[] raitings = new int[plotNum];
        int minRes = 0;
        int resPlot = 0;
        for (int i =0; i<plotNum; i++){
            raitings[i] = setRating(inputArr, plots[i]);
            if(i == 0) {
                minRes = raitings[i];
            } else {
                if (minRes > raitings[i]){
                    minRes = raitings[i];
                    resPlot = i;
                }
            }
        }
        return resPlot;
    }

    private int setRating (int[] inputArr, int[] targetArr){
        int length = inputArr.length;
        int[] deviations = new int[length];
        int sum = 0;
        for (int i=0; i<length; i++){
            deviations[i] = Math.abs(targetArr[i] - inputArr[i]);
            sum+= deviations[i];
        }
        int average = sum / length;
        int[] avgDeviations = new int[length];
        int res = 0;
        for (int i=0; i<length; i++){
            avgDeviations[i] =  Math.abs(deviations[i] - average);
            res += avgDeviations[i];
        }
        return res;
    }

    public int[][] getPlots (){
        return plots;
    }
}
