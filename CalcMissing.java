// package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcMissing {
    public static void calcMissing(List<String> readings) {
        List<Integer> missingValues = new ArrayList<>();

        for (String reading : readings) {
            if (reading.contains("Missing")) {
                // int missingIndex = Integer.parseInt(reading.split()[1]);

                // double prevReading = Double.parseDouble(readings.get(missingIndex));
            }
        }
    }

    public static void main(String[] args) {
        List<String> readings = Arrays.asList(
                "5",
                "1/3/2012 16:00:00     26.96",
                "1/4/2012 16:00:00     27.47",
                "1/5/2012 16:00:00     27.728",
                "1/6/2012 16:00:00     28.19",
                "1/9/2012 16:00:00     28.1");
        CalcMissing.calcMissing(readings);

    }
}
