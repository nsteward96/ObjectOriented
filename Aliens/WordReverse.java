public class WordReverse implements ICrypto {
  // Singleton
  private static WordReverse m_instance;
  private WordReverse () {}
  public static WordReverse getInstance() {
    if (m_instance == null)
      m_instance = new WordReverse();
    return m_instance;
  }

  public String encrypt(String message) {
    // Turns message into one that aliens can understand.
    // SUNSHINE -> ENIHSNUS
    IMessageParser parser = Factory.getInstance().createParser(message);
    String finalMessage = "";
    for (int i = 0; i < parser.getWordCount(); i++) {
      String word = parser.getWord(i);
      finalMessage += new StringBuilder(word).reverse().toString();
      if (i != parser.getWordCount() - 1) {
        finalMessage += " ";
      }
    }
    return finalMessage;
  }

  public String decrypt(String message) {
    // Turns alien message into one that humans can understand.
    // ENIHSNUS -> SUNSHINE
    IMessageParser parser = Factory.getInstance().createParser(message);
    String finalMessage = "";
    for (int i = 0; i < parser.getWordCount(); i++) {
      String word = parser.getWord(i);
      finalMessage += new StringBuilder(word).reverse().toString();
      if (i != parser.getWordCount() - 1) {
        finalMessage += " ";
      }
    }
    return finalMessage;
  }
}
