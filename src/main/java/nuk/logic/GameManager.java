package nuk.logic;

import nuk.ui.BoardController;
import nuk.ui.IBoardView;
import nuk.ui.SwingBoardView;

public class GameManager {

    private BoardController boardController;

    public GameManager() {
    }

    public void newGame() {
        BoardModel boardModel = new BoardModel();
        IBoardView boardView = new SwingBoardView(boardModel);
        ITurnService turnService = new TurnService();
        boardController = new BoardController(boardView, boardModel, turnService);
    }

    public void startGame() {
        boardController.showView();
    }

}
