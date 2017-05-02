public class Hero extends GameObject implements IHero {
  // Your typical hero elf, when you press W A S or D he will start to move in that direction and continue until given a different command.
  private int m_ticks = 0;
  private int m_lives = 30;
  private int m_score = 0;
  private java.util.Random m_rand = new java.util.Random();

  public Hero(int x, int y, int w, int h, int dX, int dY)
  {
    super("./elf.png", x, y, w, h, 0, 0);
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
      m_score += 150;
    } else {
      m_lives -= 1;
    }
  }

  @Override
  public void tick(int maxw, int maxh)
  {
    m_ticks++;
    m_score += 1;

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
    if (ch == 'a')
    {
      m_dX = -10;
      m_dY = 0;
    }
    else if (ch == 'd')
    {
      m_dX = 10;
      m_dY = 0;
    }
    else if (ch == 'w')
    {
      m_dX = 0;
      m_dY = -10;
    }
    else if (ch == 's')
    {
      m_dX = 0;
      m_dY = 10;
    }
    else
    {
      m_dX = 0;
      m_dY = 0;
    }
  }

}
