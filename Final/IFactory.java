import java.util.*;

public interface IFactory
{
  public IGameObject createQuarterback(int x, int y, int w, int h, int dX, int dY);
  public IGameObject createWizard(int x, int y, int w, int h, int dX, int dY);
  public IGameObject createOgre(int x, int y, int w, int h, int dX, int dY);
  public IGameObject createTreasureGoblin(int x, int y, int w, int h, int dX, int dY);
  public IGameObject createHero(int x, int y, int w, int h, int dX, int dY);
  public IGameObject createPixlMan(int x, int y, int w, int h, int dX, int dY);
  public IGameObject createMiner(int x, int y, int w, int h, int dX, int dY);
  public IGameView createMainView(List<IGameObject> objects);
  public IGameView createStatusView(List<IGameObject> objects);
  public IGameController createController(int interval, List<IGameObject> objects, List<IGameView> views);
}
