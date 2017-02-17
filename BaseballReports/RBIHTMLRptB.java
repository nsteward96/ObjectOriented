import java.util.*;
import java.io.*;

public class RBIHTMLRptB extends RBITextRpt {
  
  public RBIHTMLRptB(String dataFile, String reportFile) {
    super(dataFile, reportFile);
  }

  public List<DataPair> loadData() throws Exception {
    return super.loadData();
  }

  // Generate an HTML report as opposed to a text report.
  @Override
  public void generateReport(List<DataPair> data) {
    try {
      PrintWriter fileWriter = new PrintWriter(m_reportFile, "UTF-8");
      fileWriter.println("<html>");
      fileWriter.println("<body>");
      fileWriter.println("<table>");
      for (DataPair dataPair : data) {
        String name = dataPair.getName();
        int stat = dataPair.getStat();
        fileWriter.printf("<tr><td>%s</td><td>%d</td></tr>%n", name, stat);
      }
      fileWriter.println("</table>");
      fileWriter.println("</body>");
      fileWriter.println("</html>");
      fileWriter.close();
    } catch (Exception e) {
      System.out.println("There was an error generating the report for RBIHTMLRptB!");
    }
  }
}
