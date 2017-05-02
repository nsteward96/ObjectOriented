public class Miner extends GameObject implements IHero {
  // Miner makes much more passive score but his controls are reversed!
  private int m_ticks = 0;
  private int m_lives = 3;
  private int m_score = 0;
  private java.util.Random m_rand = new java.util.Random();

  public Miner(int x, int y, int w, int h, int dX, int dY)
  {
    super("./miner.png", x, y, w, h, 0, 0);
  }

  @Override
  public int getLives() {
    return m_lives;
  }

  @Override
  public int getScore() {
    return m_score;
  }

  @Override
  public void loseLife() {
    m_lives -= 1;
  }

  @Override
  public void touchThing(IGameObject thing) {
    if (thing instanceof TreasureGoblin) {
      m_score += 5;
    } else {
      m_lives -= 1;
    }
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks++;
    m_score += 3;

    m_x += m_dX;
    m_y += m_dY;

    if (m_x > maxw)
      m_x = 0;
    else if (m_x < 0)
      m_x = maxw;

    if (m_y > maxh)
      m_y = 0;
    else if (m_y < 0)
      m_y = maxh;
  }

  @Override
  public void keyPressed(char ch)
  {
    System.out.println(ch);
    if (ch == 'a')
    {
      m_dX = 10;
      m_dY = 0;
    }
    else if (ch == 'd')
    {
      m_dX = -10;
      m_dY = 0;
    }
    else if (ch == 'w')
    {
      m_dX = 0;
      m_dY = 10;
    }
    else if (ch == 's')
    {
      m_dX = 0;
      m_dY = -10;
    }
    else
    {
      m_dX = 0;
      m_dY = 0;
    }
  }
}
