import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MainFrame extends JFrame
{
  public static void main(String args[]) throws FileNotFoundException
  {
    JFrame frame = new MainFrame();
    frame.setVisible(true);
  }

  public MainFrame() throws FileNotFoundException
  {
    super("Game Engine Example");
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    int interval = 100;

    // model
    List<IGameObject> objects = new ArrayList<IGameObject>();
    File config = new File("settings.txt");
    Scanner fileReader = new Scanner(config);
    String line = "";
    while (fileReader.hasNextLine()) {
      line = fileReader.nextLine();
      if (line.substring(0, 2) != "//") {
        switch (line.toUpperCase()) {
          case "HERO":            objects.add(Factory.getInstance().createHero(10, 100, 40, 40, 5, 5));
                                  break;
          case "PIXLMAN":         objects.add(Factory.getInstance().createPixlMan(10, 100, 40, 40, 5, 5));
                                  break;
          case "MINER":           objects.add(Factory.getInstance().createMiner(10, 100, 40, 40, 5, 5));
                                  break;
          case "OGRE":            objects.add(Factory.getInstance().createOgre(150, 100, 40, 40, 5, 5));
                                  break;
          case "WIZARD":          objects.add(Factory.getInstance().createWizard(150, 120, 40, 40, 5, 5));
                                  break;
          case "TREASUREGOBLIN":  objects.add(Factory.getInstance().createTreasureGoblin(150, 140, 40, 40, 5, 5));
                                  break;
          case "QUARTERBACK":     objects.add(Factory.getInstance().createQuarterback(150, 160, 40, 40, 5, 5));
                                  break;
        }
      }
    }
    // view
    IGameView view = Factory.getInstance().createMainView(objects);
    IGameView statusView = Factory.getInstance().createStatusView(objects);
    List<IGameView> views = new ArrayList<IGameView>();
    views.add(view);
    views.add(statusView);

    // controller
    IGameController controller = Factory.getInstance().createController(interval, objects, views);

    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(view.getJPanel(), BorderLayout.CENTER);
    getContentPane().add(statusView.getJPanel(), BorderLayout.SOUTH);

    controller.startGame();
  }
}
