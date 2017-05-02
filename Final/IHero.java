public interface IHero {
  public int getLives();
  public int getScore();
  public void loseLife();
  public void touchThing(IGameObject thing);
}
