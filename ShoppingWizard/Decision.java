import java.util.*;

public class Decision implements IDecision {
  
  private String m_question;
  private IDecision m_yes;
  private IDecision m_no;
  private String m_yesTerminal;
  private String m_noTerminal;

  public Decision(String question, IDecision yes, IDecision no, String yesT, String noT) {
    m_question = question;
    m_yes = yes;
    m_no = no;
    m_yesTerminal = yesT;
    m_noTerminal = noT;
  }

  public void setYes(IDecision yes) {
    m_yes = yes;
  }

  public void setNo(IDecision no) {
    m_no = no;
  }

  public void setYesTerminal(String terminal) {
    m_yesTerminal = terminal;
  }

  public void setNoTerminal(String terminal) {
    m_noTerminal = terminal;
  }

  public IDecision ask() {
    Scanner keyboard = new Scanner(System.in);
    boolean improperUserInput = true;
    String input = "";

    while (improperUserInput) {
      System.out.print(m_question);
      input = keyboard.nextLine();
      if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
        improperUserInput = false;
      } else {
        System.out.println("Your input was wrong. Please enter \"yes\" or \"no\".");
      }
    }

    if (input.equalsIgnoreCase("yes")) {
      if (m_yesTerminal != null) {
        System.out.println(m_yesTerminal);
      }
      return m_yes;
    } else if (input.equalsIgnoreCase("no")) {
      if (m_noTerminal != null) {
        System.out.println(m_noTerminal);
      }
      return m_no;
    }

    return null;
  }
}
