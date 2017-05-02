public class TreasureGoblin extends GameObject implements IEnemy {
  private java.util.Random m_rand = new java.util.Random();
  private int m_ticks = 0;
  private boolean countingCoin = false;
  public TreasureGoblin(int x, int y, int w, int h, int dX, int dY)
  {
    super("./treasuregoblin.jpg", x, y, w, h, dX, dY);
  }

  // Sprints around the room, rare, touching it is helpful! Stops to count its loot every short while.
  @Override
  public void tick(int maxw, int maxh)
  {
    if (m_ticks >= 150) {
      countingCoin = true;
    } else if (m_ticks < 5) {
      countingCoin = false;
    }
    if (!countingCoin) {
      m_ticks += m_rand.nextInt(5);
      m_x = m_x + m_dX;
      m_y = m_y + m_dY;
    } else {
      m_ticks -= m_rand.nextInt(10);
    }
    if (m_x > maxw)
      m_x = 0;
    else if (m_x < 0)
      m_x = maxw;

    if (m_y > maxh)
      m_y = 0;
    else if (m_y < 0)
      m_y = maxh;

  }
}
