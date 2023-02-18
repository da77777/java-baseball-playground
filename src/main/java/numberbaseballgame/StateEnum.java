package numberbaseballgame;

public enum StateEnum {

  NEW("NEW")
  , END("END")
  , KEEP("KEEP")
  ;

  private String state;

  StateEnum(String state) {
    this.state = state;
  }
}
