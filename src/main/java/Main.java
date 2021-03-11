import algoritm.CompareAlgoritm;
import data.DataInput;
import draw.DrawGraphic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CompareAlgoritm alg = new CompareAlgoritm();
        DataInput input = new DataInput(100);
        int[] test = input.setNoise(input.getPlot3(), 100);
        //int[] test = input.setPeaks(input.getPlot3(), 1000);
        /*System.out.println("plot1 ");
        for (int i = 0; i<100; i++){
            System.out.print(input.getPlot3()[i] + ",");
        }*/
        System.out.println("Result is data" + (alg.compareRating(test)+1));
        DrawGraphic.drawGraph(test, alg.getPlots());
    }
}
