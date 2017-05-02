import javax.swing.*;
import java.awt.BorderLayout;
import java.util.*;

class StatusView extends JPanel implements IGameView
{
  private JLabel m_status = new JLabel();
  private String m_gameOverMessage = "";
  List<IGameObject> m_objects;
  public StatusView(List<IGameObject> objects)
  {
    m_objects = objects;
    setLayout(new BorderLayout());
    m_status.setText("");
    add(m_status, BorderLayout.CENTER);
  }

  @Override
  public void tick()
  {
    if (m_objects.get(0).getLives() <= 0) {
      m_gameOverMessage = "GAME OVER!";
    }
    if (m_objects.size() > 0)
    {
        m_status.setText(String.format("SCORE: %s -- LIFE: %s  %s",
          m_objects.get(0).getScore(),
            m_objects.get(0).getLives(),
              m_gameOverMessage));
    }
  }

  @Override
  public JPanel getJPanel()
  {
    return this;
  }
}
