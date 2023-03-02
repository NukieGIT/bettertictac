package nuk.logic;

import nuk.ui.BoardController;
import nuk.ui.ConsoleBoardView;
import nuk.ui.IBoardView;

public class GameManager {

    private BoardController boardController;

    public GameManager() {
    }

    public void newGame() {
        BoardModel boardModel = new BoardModel();
        IBoardView boardView = new ConsoleBoardView(boardModel);
        ITurnService turnService = new TurnService();
        boardController = new BoardController(boardView, boardModel, turnService);
    }

    public void startGame() {
        boardController.showView();
    }

}
