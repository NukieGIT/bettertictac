package nuk.ui;

import nuk.logic.BoardModel;
import nuk.logic.ITurnService;

public class BoardController {
    private IBoardView boardView;
    private BoardModel boardModel;
    private ITurnService turnService;

    public BoardController(IBoardView boardView, BoardModel boardModel, ITurnService turnService) {
        this.boardView = boardView;
        this.boardModel = boardModel;
        this.turnService = turnService;

        boardView.getNewPositionEvent().subscribe((s, pos) -> {
            boardModel.setPosition(pos, turnService.getCurrentTurn());
            turnService.next();
        });
        boardModel.getOnWinEvent().subscribe((s, player) -> {
            boardView.handleWinEvent(player);
        });
    }

    public void showView() {
        boardView.show();
    }

    public void hideView() {
        boardView.hide();
    }

}
