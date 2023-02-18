package numberbaseballgame;

public class Ball {

  private int position;
  private int num;


  public Ball(int position, int num) {
    this.position = position;
    this.num = num;
  }

  public int isStrike(Ball ball) {
    if(this.equals(ball)) {
      return 1;
    }
    return 0;
  }

  public int isBall(Ball ball) {
    if(this.position != ball.position && this.num == ball.num) {
      return 1;
    }
    return 0;
  }

  @Override
  public boolean equals(Object obj) {
    if(this == obj) {
      return true;
    }
    if(!(obj instanceof Ball)) {
      return false;
    }
    Ball ball = (Ball) obj;
    if(this.position != ball.position || this.num != ball.num) {
      return false;
    }
    return true;
  }

  //equals 주석에서 hashCode 재정의 하라고 함.
  //Object hashCode 쓰면 값 다르게 나옴.
  @Override
  public int hashCode() {
    int result = Integer.hashCode(position);
    result = 31 * result + Integer.hashCode(num);
    return result;
  }
}
