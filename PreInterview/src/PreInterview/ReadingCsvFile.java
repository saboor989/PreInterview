package PreInterview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadingCsvFile {

	 static Map<Integer, Integer> setValue = new HashMap<>();
     static Map<Integer, Integer> weight = new HashMap<>();
     static Map<Integer, Integer> finalWeight = new HashMap<>();
     
    public static void main(String[] args) {

        String csvFile = "C:\\Users\\sas_s\\Desktop\\social.csv";
        String line = "";
        String cvsSplitBy = ",";
       
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
        	int i = 0;
            while ((line = br.readLine()) != null) {
                if(i == 0) {
                	i++;
                }else {
                    String[] social = line.split(cvsSplitBy);
                    int value0 = Integer.parseInt(social[0]);
                    int value1 = Integer.parseInt(social[1]);
                    int value2 = Integer.parseInt(social[2]);
                    setValue.put(value0, value1);
                    weight.put(value0, value2);
                    FindAndAddWeight(value0, value1, value2);
                }
            }
            System.out.println(finalWeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	private static void FindAndAddWeight(int value0, int value1, int weightValue) {
		if(setValue.get(value0) == -1) {
			if(finalWeight.get(value0) != null) {
				int we1 = finalWeight.get(value0);
				finalWeight.put(value0, weightValue+we1);
			} else {
				finalWeight.put(value0, weightValue);
			}
		} else {
			int val = setValue.get(value1);
			FindAndAddWeight(value1, val, weightValue);
		}
	}   
}
