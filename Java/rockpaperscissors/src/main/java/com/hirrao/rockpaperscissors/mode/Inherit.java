package com.hirrao.rockpaperscissors.mode;

public class Inherit extends Mode {
    private static ActionType lastWinAction = ActionType.values()[(int) (Math.random() * 3) + 1];

    public Inherit() {
        super();
        action = lastWinAction;
    }

    public void setLastWinAction(ActionType lastWinActions) {
        lastWinAction = lastWinActions;
    }

    public ResultType result(Mode player, Inherit computer) {
        ResultType nowResult = super.result(player, computer);
        if (nowResult == ResultType.WIN) computer.setLastWinAction(player.getAction());
        return nowResult;
    }
}
