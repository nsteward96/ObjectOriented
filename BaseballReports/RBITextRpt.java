import java.util.*;
import java.io.*;

public class RBITextRpt extends HomeRunTextRpt {
  public RBITextRpt(String dataFile, String reportFile) {
    super(dataFile, reportFile);
  }

  // Create a report of RBIs as opposed to homeruns.
  @Override
  public List<DataPair> loadData() throws Exception {
    List<DataPair> dataList = new ArrayList<DataPair>();
    File textfile = new File(m_dataFile);
    Scanner fileReader = new Scanner(textfile);
    String line = "";
    while (fileReader.hasNextLine()) {
      line = fileReader.nextLine();
      String[] tokens = line.split(",", -1);
      for (int i = 0; i < tokens.length; i++) {
        if (tokens[i].equals("")) {
          tokens[i] = "0";
        }
      }
      // Token 0 = Baseball player's name
      // Token 1 = Baseball player's home runs
      // Token 2 = Baseball player's RBI
      DataPair dataPair = new DataPair(tokens[0], Integer.parseInt(tokens[2]));
      dataList.add(dataPair);
    }
    return dataList;
  }

  public void generateReport(List<DataPair> data) {
    super.generateReport(data);
  }
}
