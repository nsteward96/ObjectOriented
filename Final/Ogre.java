public class Ogre extends GameObject implements IEnemy {
  // Stamps around the room. Touching it hurts!
  private int m_ticks = 0;
  public Ogre(int x, int y, int w, int h, int dX, int dY)
  {
    super("./ogre.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks += 1;
    if (m_ticks % 50 == 0) {
      if (m_dX > 0) {
        m_dX += 2;
        if (m_dX > 25) {
          m_dX = 25;
        }
      } else {
        m_dX -= 2;
        if (m_dX < -25) {
          m_dX = -25;
        }
      }
      if (m_dY > 0) {
        m_dY += 2;
        if (m_dY > 25) {
          m_dY = 25;
        }
      } else {
        m_dY -= 2;
        if (m_dY < -25) {
          m_dY = -25;
        }
      }
    }
    m_x = m_x + m_dX;
    m_y = m_y + m_dY;

    if (m_x > maxw - m_w || m_x < 0)
      m_dX = -m_dX;

    if (m_y > maxh - m_h || m_y < 0)
      m_dY = -m_dY;
  }

}
