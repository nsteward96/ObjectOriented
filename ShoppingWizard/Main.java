// Shopping Wizard
// Nate Steward
// 3-2-17
// Essentially a 'Flowchart' in program form.
// Go through the questions to find the best-suited solution!
public class Main {

  public static void main(String[] args) {
    IDecision next = Builder.getInstance().buildWizard();
    do {
      next = next.ask();
    } while (next != null);
  }

}
