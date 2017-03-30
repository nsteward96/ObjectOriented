import java.util.*;

public class MessageParser implements IMessageParser {
  // Used by Factory

  private List<String> m_words;
  private String m_msg;

  public MessageParser(String msg) {
    m_msg = msg;
    List<String> words = new ArrayList<String>(Arrays.asList(msg.split(" ")));
    m_words = words;
  }

  public int getCharCount() {
    char[] charCount = m_msg.toCharArray();
    return charCount.length;
  }

  public int getWordCount() {
    return m_words.size();
  }

  public char getChar(int i) {
    char[] charArray = m_msg.toCharArray();
    return charArray[i];
  }

  public String getWord(int i) {
    return m_words.get(i);
  }
}
