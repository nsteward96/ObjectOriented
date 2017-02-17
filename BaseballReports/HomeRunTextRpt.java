import java.util.*;
import java.io.*;

public class HomeRunTextRpt {
  protected String m_dataFile; // Filename containing the players
  protected String m_reportFile; // Filename containing the report

  public HomeRunTextRpt(String dataFile, String reportFile) {
    m_dataFile = dataFile;
    m_reportFile = reportFile;
  }

  // Loads all of the datapairs into the list.
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
      DataPair dataPair = new DataPair(tokens[0], Integer.parseInt(tokens[1]));
      dataList.add(dataPair);
    }
    return dataList;
  }

  // Generates the text report.
  public void generateReport(List<DataPair> data) {
    try {
      PrintWriter fileWriter = new PrintWriter(m_reportFile, "UTF-8");
      for (DataPair dataPair : data) {
        String name = String.format("%-32s", dataPair.getName());
        int stat = dataPair.getStat();
        fileWriter.println(name + stat);
      }
      fileWriter.close();
    } catch (IOException e) {
      System.out.println("There was an error generating the report for HomeRunTextRpt!");
    }
  }
}
