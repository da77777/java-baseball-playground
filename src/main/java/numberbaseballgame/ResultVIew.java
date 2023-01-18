package numberbaseballgame;

public class ResultVIew {

    public void outputValueBallStrike(int ballCount, int strikeCount) {
        if(strikeCount == 3) {
            printResult(strikeCount, ResultEnum.STRIKE);
            printResult(ResultEnum.NOTICE_END);
            return;
        }
        if(ballCount == 0) {
            printResult(ResultEnum.NOTHING);
            return;
        }
        if(ballCount == strikeCount) {
            printResult(strikeCount, ResultEnum.STRIKE);
            return;
        }
        if(ballCount > strikeCount && strikeCount != 0) {
            printResult((ballCount - strikeCount), ResultEnum.BALL, " ");
            printResult(strikeCount, ResultEnum.STRIKE);
            return;
        }
        if(ballCount > 0 && strikeCount == 0) {
            printResult(ballCount, ResultEnum.BALL);
            return;
        }
    }

    public void printResult(ResultEnum kind) {
        System.out.println(kind.result());
    }

    public void printResult(int count, ResultEnum kind) {
        System.out.println(count + kind.result());
    }

    public void printResult(int count, ResultEnum kind, String concatStr) {
        System.out.print(count + kind.result() + concatStr);
    }


}
