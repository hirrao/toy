package com.hirrao.rockpaperscissors;

import com.hirrao.rockpaperscissors.mode.*;
import javafx.fxml.FXML;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class Controller {
    private static modeType mode = modeType.RANDOM;
    @FXML
    protected CheckMenuItem menuModeInherit;
    @FXML
    protected CheckMenuItem menuModeRandom;
    @FXML
    protected CheckMenuItem menuModeLeastMove;
    @FXML
    protected CheckMenuItem menuModeMostWin;
    @FXML
    protected ImageView computerPic;
    @FXML
    protected Label resultLabel;
    @FXML
    protected ImageView PaperImageView;
    @FXML
    protected ImageView RockImageView;
    @FXML
    protected ImageView ScissorsImageView;

    private void clearALL() {
        menuModeInherit.setSelected(false);
        menuModeRandom.setSelected(false);
        menuModeLeastMove.setSelected(false);
        menuModeMostWin.setSelected(false);
    }

    @FXML
    public void menuModeRandomClick() {
        clearALL();
        menuModeRandom.setSelected(true);
        mode = modeType.RANDOM;
    }

    @FXML
    public void menuModeInheritClick() {
        clearALL();
        menuModeInherit.setSelected(true);
        mode = modeType.INHERIT;
    }

    @FXML
    public void menuModeLeastMoveClick() {
        clearALL();
        menuModeLeastMove.setSelected(true);
        mode = modeType.LEASTMOVE;
    }

    @FXML
    public void menuModeMostWinClick() {
        clearALL();
        menuModeMostWin.setSelected(true);
        mode = modeType.MOSTWIN;
    }

    @FXML
    public void menuInfoExitClick() {
        System.exit(0);
    }

    private void play(Mode player) {
        Mode computer = new Mode();
        switch (mode) {
            case RANDOM -> computer = new Random();
            case INHERIT -> computer = new Inherit();
            case LEASTMOVE -> computer = new LeastMove();
            case MOSTWIN -> computer = new MostWin();
        }
        ResultType result = computer.result(player, computer);
        this.printComputerResult(computer);
        this.printResult(result);
    }

    public void printComputerResult(Mode computer) {
        switch (computer.getAction()) {
            case ROCK -> {
                Image image = new Image(Objects.requireNonNull(getClass().getResource("/com/hirrao/rockpaperscissors/Pics/RockPic.png")).toString());
                computerPic.setImage(image);
            }
            case PAPER -> {
                Image image = new Image(Objects.requireNonNull(getClass().getResource("/com/hirrao/rockpaperscissors/Pics/PaperPic.png")).toString());
                computerPic.setImage(image);
            }
            case SCISSORS -> {
                Image image = new Image(Objects.requireNonNull(getClass().getResource("/com/hirrao/rockpaperscissors/Pics/ScissorsPic.png")).toString());
                computerPic.setImage(image);
            }
        }
    }

    public void printResult(ResultType result) {
        switch (result) {
            case WIN -> resultLabel.setText("你赢了！");
            case LOSE -> resultLabel.setText("你输了！");
            case EQUAL -> resultLabel.setText("平局！");
        }
    }

    @FXML
    public void playerRockClick() {
        Mode player = new Mode();
        player.setAction(ActionType.ROCK);
        play(player);
    }

    @FXML
    public void playerPaperClick() {
        Mode player = new Mode();
        player.setAction(ActionType.PAPER);
        play(player);
    }

    @FXML
    public void playerScissorsClick() {
        Mode player = new Mode();
        player.setAction(ActionType.SCISSORS);
        play(player);
    }

    private enum modeType {
        RANDOM, INHERIT, LEASTMOVE, MOSTWIN,

    }
}
