package com.hirrao.rockpaperscissors.mode;

public class MostWin extends Mode {
    private static int scissorsWin = 0;
    private static int rockWin = 0;
    private static int paperWin = 0;

    public MostWin() {
        if (scissorsWin >= 2 && rockWin >= 2 && paperWin >= 2) {
            if (scissorsWin >= rockWin && scissorsWin >= paperWin) action = ActionType.ROCK;
            else if (rockWin >= scissorsWin && rockWin >= paperWin) action = ActionType.PAPER;
            else action = ActionType.SCISSORS;
        } else action = ActionType.values()[(int) (Math.random() * 3) + 1];
    }

    public ResultType result(Mode player, MostWin computer) {
        ResultType nowResult = super.result(player, computer);
        if (nowResult == ResultType.WIN) {
            switch (computer.getAction()) {
                case ROCK -> rockWin++;
                case PAPER -> paperWin++;
                case SCISSORS -> scissorsWin++;
            }
        }
        return nowResult;
    }
}
