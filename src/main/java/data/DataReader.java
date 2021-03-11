package data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataReader {
    InputStream inputStream;
    private String plotNum;
    private String plotLength;
    private String plot1;
    private String plot2;
    private String plot3;

    private static DataReader instance = null;

    public static DataReader getInstance() throws IOException {
        if (instance == null) {
            instance = new DataReader();
        }
        return instance;
    }

    private DataReader() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "" +
                    "data.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            plotNum = prop.getProperty("plotNum");
            plotLength = prop.getProperty("plotLength");
            plot1 = prop.getProperty("plot1");
            plot2 = prop.getProperty("plot2");
            plot3 = prop.getProperty("plot3");


        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            inputStream.close();
        }
    }

    private int[] parse (String str){
        String[] items = str.replaceAll("\\s", "").split(",");
        int[] results = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            try {
                results[i] = Integer.parseInt(items[i]);
            } catch (NumberFormatException nfe) {
                //NOTE: write something here if you need to recover from formatting errors
            };
        }
            return  results;
    }

    public int[] getPlot1() {
        return parse(plot1);
    }

    public int[] getPlot2() {
        return parse(plot2);
    }

    public int[] getPlot3() {
        return parse(plot3);
    }

    public int getPlotNum() {
        return Integer.parseInt(plotNum);
    }

    public int getPlotLength() {
        return Integer.parseInt(plotLength);
    }

    public int[] getPlots() {
        return parse(plot1 + "," + plot2 + "," + plot3);
    }
}
