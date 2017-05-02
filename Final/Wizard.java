public class Wizard extends GameObject implements IEnemy {
  private java.util.Random m_rand = new java.util.Random();
  private int m_ticks = 0;
  private int m_tickMod = 0;
  // Teleports randomly, touching it hurts!
  public Wizard(int x, int y, int w, int h, int dX, int dY)
  {
    super("./wizard.png", x, y, w, h, dX, dY);
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks += m_rand.nextInt(5);
    if (m_ticks >= 100 - m_tickMod)
    {
      m_tickMod += 5;
      if (m_tickMod > 80) {
        m_tickMod = 80;
      }
      m_x = m_rand.nextInt(maxw);
      m_y = m_rand.nextInt(maxh);
      m_ticks = 0;
    }
  }
}
