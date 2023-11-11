package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetTVSeries {
    public static List<String> showsInProduction(int startYear, int endYear) {
        List<String> result = new ArrayList<>();
        int currentPage = 1;
        int totalPage= Integer.MAX_VALUE;

        try {
        while(currentPage <= totalPage) {
            URL url = new URL("https://jsonmock.hackerrank.com/api/tvseries?page=" + currentPage);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
           
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
            reader.close();

//            Map<String, Object> map = JsonParser
            
            
            currentPage++;
        }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int startYear = Integer.parseInt(bufferedReader.readLine().trim());
        int endYear = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = GetTVSeries.showsInProduction(startYear, endYear);

        result.stream().forEach(System.out::println);
    }
}
