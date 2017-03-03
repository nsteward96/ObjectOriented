// Builds the flowchart.
// Follows the "Singleton" design pattern.
public class Builder {

  private static Builder m_instance;
  public static Builder getInstance() {
    if (m_instance == null) {
      m_instance = new Builder();
    }
    return m_instance;
  }
  private Builder() {};

  public IDecision buildWizard() {
    // Build the flowchart
    IDecision d = new Decision("Question", null, null, "Yes", "No");
    IDecision YYY = new Decision("Do you like to go fast? ", null, null, "Buy the XG300 model", "Buy the XG200 model");
    IDecision YY = new Decision("Are you an expert? ", YYY, null, null, "Buy the XG200 model");
    IDecision Y = new Decision("Have you snowboarded before? ", YY, null, null, "Buy the XG100 model");
    IDecision NYYY = new Decision("Do you like to jump? ", null, null, "Buy the ZR300 model", "Buy the ZR200 model");
    IDecision NYY = new Decision("Are you an expert? ", NYYY, null, null, "Buy the ZR200 model");
    IDecision NY = new Decision("Have you gone skiing before? ", NYY, null, null, "Buy the ZR100 model");
    IDecision N = new Decision("Do you want to buy downhill skis? ", NY, null, null, "Try skiing someday!");
    IDecision initialQuestion = new Decision("Do you want to buy a snowboard? ", Y, N, null, null);
    return initialQuestion;
  }
}
