package com.hirrao.rockpaperscissors.mode;


public class Mode {
    protected ActionType action;

    public Mode() {
        action = ActionType.ERROR;
    }

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    public ResultType result(Mode player, Mode computer) {
        if (player.getAction() == ActionType.ERROR || computer.getAction() == ActionType.ERROR) return ResultType.ERROR;
        if (player.getAction() == computer.getAction()) return ResultType.EQUAL;
        return switch (player.getAction()) {
            case ROCK -> {
                if (computer.getAction() == ActionType.SCISSORS) yield ResultType.WIN;
                yield ResultType.LOSE;
            }
            case PAPER -> {
                if (computer.getAction() == ActionType.ROCK) yield ResultType.WIN;
                yield ResultType.LOSE;
            }
            case SCISSORS -> {
                if (computer.getAction() == ActionType.PAPER) yield ResultType.WIN;
                yield ResultType.LOSE;
            }
            default -> ResultType.ERROR;
        };
    }
}
