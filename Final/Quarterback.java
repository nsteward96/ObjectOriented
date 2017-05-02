public class Quarterback extends GameObject implements IEnemy {
  // Chases down the player more accurately than the Ogre
  private int m_ticks = 0;
  private int m_difficultyTicks = 0;
  private boolean alternate = false;
  private java.util.Random m_rand = new java.util.Random();
  public Quarterback(int x, int y, int w, int h, int dX, int dY)
  {
    super("./quarterback.jpg", x, y, w, h, 0, 0);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks += m_rand.nextInt(1)+1;
    if (m_ticks > 10) {
      if (alternate) {
        m_dX -= 3 + m_difficultyTicks;
        m_dY -= m_rand.nextInt(5 + m_difficultyTicks) - (2 + (m_difficultyTicks / 2));
      } else {
        m_dX += 3 + m_difficultyTicks;
        m_dY += m_rand.nextInt(5 + m_difficultyTicks) - (2 + (m_difficultyTicks / 2));
      }
      m_x += m_dX;
      m_y += m_dY;
    }

    if (m_x > maxw - m_w || m_x < 0)
    {
      if (alternate) {
        m_difficultyTicks += 1;
        m_x = 0;
        alternate = false;
      } else {
        m_difficultyTicks += 1;
        m_x = maxw - m_w;
        alternate = true;
      }
      m_ticks = 0;
      m_dX = 0;
      m_dY = 0;
    }

    if (m_y > maxh - m_h || m_y < 0)
      m_dY = -m_dY;
  }
}
