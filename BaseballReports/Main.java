import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException, Exception
    {
        new Main().go();
    }

    public void go() throws IOException, Exception
    {
        List<HomeRunTextRpt> reports = new ArrayList<HomeRunTextRpt>();
        reports.add(new HomeRunTextRpt("players.txt", "r1.txt"));
        reports.add(new HomeRunHTMLRpt("players.txt", "r2.txt"));
        reports.add(new RBITextRpt("players.txt", "r3.txt"));
        reports.add(new RBIHTMLRptA("players.txt", "r4.txt"));
        reports.add(new RBIHTMLRptB("players.txt", "r5.txt"));
        makeReports(reports);
    }

    private void makeReports(List<HomeRunTextRpt> reports) throws IOException, Exception
    {
        for (HomeRunTextRpt rpt : reports)
        {
            List<DataPair> data = rpt.loadData();
            rpt.generateReport(data);
        }
    }
}
