public class VowelMash implements ICrypto {
  // Singleton
  private static VowelMash m_instance;
  private VowelMash () {}
  public static VowelMash getInstance() {
    if (m_instance == null)
      m_instance = new VowelMash();
    return m_instance;
  }

  public String encrypt(String message) {
    // Turn message into one aliens can understand.
    // A -> E, E -> I, I -> O, O -> U, U -> A
    IMessageParser parser = Factory.getInstance().createParser(message);
    String finalMessage = "";
    for (int i = 0; i < parser.getCharCount(); i++) {
      char character = parser.getChar(i);
      switch (character) {
        case 'A': character = 'U';
                  break;
        case 'E': character = 'A';
                  break;
        case 'I': character = 'E';
                  break;
        case 'O': character = 'I';
                  break;
        case 'U': character = 'O';
                  break;
      }
      finalMessage += character;
    }
    return finalMessage;
  }

  public String decrypt(String message) {
    // Turns alien message into one humans can understand.
    // A -> U, U -> O, O -> I, I -> E, E -> A
    IMessageParser parser = Factory.getInstance().createParser(message);
    String finalMessage = "";
    for (int i = 0; i < parser.getCharCount(); i++) {
      char character = parser.getChar(i);
      switch (character) {
        case 'A': character = 'U';
                  break;
        case 'E': character = 'A';
                  break;
        case 'I': character = 'E';
                  break;
        case 'O': character = 'I';
                  break;
        case 'U': character = 'O';
                  break;
      }
      finalMessage += character;
    }
    return finalMessage;
  }
}
