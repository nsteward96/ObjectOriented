import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Rectangle;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class GameController implements ActionListener, IGameController, KeyListener
{
  private Timer m_timer;
  private List<IGameObject> m_objects;
  private List<IGameView> m_views;

  public GameController(int interval, List<IGameObject> objects, List<IGameView> views)
  {
    m_objects = objects;
    m_views = views;
    m_timer = new Timer(interval, this);
    views.get(0).getJPanel().addKeyListener(this);
  }

  @Override
  public void startGame()
  {
    m_timer.start();
  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
    for (IGameObject obj : m_objects)
    {
      obj.tick(m_views.get(0).getWidth(), m_views.get(0).getHeight());
    }

    for (IGameView obj : m_views)
    {
      obj.tick();
    }

    boolean removeObject = false;
    IGameObject objToBeRemoved = null;
    int heroWidth = m_objects.get(0).getW();
    int heroHeight = m_objects.get(0).getH();
    int heroXPos = m_objects.get(0).getX();
    int heroYPos = m_objects.get(0).getY();
    // Loop through all objects to see if anything is touching
    for (IGameObject obj : m_objects) {
      if (obj instanceof IEnemy) {
        int monsterWidth = obj.getW();
        int monsterHeight = obj.getH();
        int monsterXPos = obj.getX();
        int monsterYPos = obj.getY();
        if (heroXPos + heroWidth >= monsterXPos && heroYPos + heroHeight >= monsterYPos && heroXPos <= monsterXPos + monsterWidth && heroYPos <= monsterYPos + monsterHeight) {
          // Hero touches this object
          m_objects.get(0).touchThing(obj);
          if (obj instanceof TreasureGoblin) {
            removeObject = true;
            objToBeRemoved = obj;
          } else {
            m_objects.get(0).loseLife();
          }
        }
      }
    }
    if (removeObject) {
      m_objects.remove(objToBeRemoved);
    }
    if (m_objects.get(0).getLives() <= 0) {
      m_timer.stop();
      System.out.println("GAME OVER! You got a score of " + m_objects.get(0).getScore());
    }
  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    for (IGameObject obj : m_objects)
    {
      obj.keyPressed(e.getKeyChar());
    }
  }

  @Override
  public void keyTyped(KeyEvent e)
  {

  }

  @Override
  public void keyReleased(KeyEvent e)
  {

  }
}
