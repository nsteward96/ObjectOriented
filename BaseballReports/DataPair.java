/*
   DataPairs hold the name of a baseball player and 
   their stat, which varies between their homeruns
   and their RBI.
*/
public class DataPair {
  private String m_name;
  private int m_stat;

  public DataPair(String name, int stat) {
    m_name = name;
    m_stat = stat;
  }

  public String getName() {
    return m_name;
  }

  public int getStat() {
    return m_stat;
  }
}
