public class PixlMan extends GameObject implements IHero {
  // Pixlman moves a fixed distance on keydown, but has no velocity. Moves as fast as you can mash the keys!
  private int m_ticks = 0;
  private int m_lives = 3;
  private int m_score = 0;
  private java.util.Random m_rand = new java.util.Random();

  public PixlMan(int x, int y, int w, int h, int dX, int dY)
  {
    super("./pixlman.jpg", x, y, w, h, 0, 0);
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
    m_score += 1;

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
      m_x -= 30;
    }
    else if (ch == 'd')
    {
      m_x += 30;
    }
    else if (ch == 'w')
    {
      m_y -= 30;
    }
    else if (ch == 's')
    {
      m_y += 30;
    }
  }
}
