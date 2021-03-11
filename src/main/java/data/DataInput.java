package data;

public class DataInput {
    public int[] plot1;
    public int[] plot2;
    public int[] plot3;
    public int[][] plots;

    public DataInput(int size) {
        int[] plot1 = new int[size];
        int[] plot2 = new int[size];
        int[] plot3 = new int[size];
        int[][] plots = new int[3][size];
        for (int i = 0; i < size; i ++){
            plot1[i] = (int) ((Math.sin(3*i - 1) + 2) *1000);
            plot2[i] = (int) ((Math.sin(2*i) + Math.cos(3*i) + 2) *1000);
            plot3[i] = (int) ((Math.sin(i) + Math.cos(5*i - 4) + 2) *1000);
            plots[0][i] = plot1[i];
            plots[1][i] = plot2[i];
            plots[2][i] = plot3[i];
        }
        this.plot1 = plot1;
        this.plot2 = plot2;
        this.plot3 = plot3;
        this.plots = plots;
    }

    public int[] getPlot1() {
        return plot1;
    }

    public int[] getPlot2() {
        return plot2;
    }

    public int[] getPlot3() {
        return plot3;
    }

    public int[][] getPlots() {
        return plots;
    }

    public int[] setNoise(int[] in, int noise) {
        for(int i = 0; i<in.length; i++){
            if(i % 2 == 0){
                in[i]+= noise;
            } else {
                in[i]-= noise;
            }
        }
        return in;
    }

    public int[] setPeaks(int[] in, int peak) {
        for(int i = 0; i<in.length; i++){
            if(i % 20 == 0){
                in[i]+= peak;
            }
            if(i % 30 == 0){
                in[i]+= -2* peak;
            }
        }
        return in;
    }

}
