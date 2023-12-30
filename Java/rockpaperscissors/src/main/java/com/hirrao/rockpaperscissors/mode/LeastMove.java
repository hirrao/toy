package com.hirrao.rockpaperscissors.mode;

public class LeastMove extends Mode {
    private static int scissorsUse = 0;
    private static int rockUse = 0;
    private static int paperUse = 0;

    public LeastMove() {
        super();
        if (scissorsUse <= 2 || rockUse <= 2 || paperUse <= 2)
            action = ActionType.values()[(int) (Math.random() * 3) + 1];
        else {
            if (scissorsUse <= rockUse && scissorsUse <= paperUse) action = ActionType.ROCK;
            else if (rockUse <= scissorsUse && rockUse <= paperUse) action = ActionType.PAPER;
            else action = ActionType.SCISSORS;
        }
    }

    public ResultType result(Mode player, LeastMove computer) {
        ResultType nowResult = super.result(player, computer);
        switch (computer.getAction()) {
            case ROCK -> rockUse++;
            case PAPER -> paperUse++;
            case SCISSORS -> scissorsUse++;
        }
        return nowResult;
    }
}
