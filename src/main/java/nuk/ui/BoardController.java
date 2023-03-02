package nuk.ui;

import nuk.logic.BoardModel;
import nuk.logic.Figure;

import java.awt.*;

public class BoardController {
    private IBoardView boardView;
    private BoardModel boardModel;

    public BoardController(IBoardView boardView, BoardModel boardModel) {
        this.boardView = boardView;
        this.boardModel = boardModel;
        Figure testFigure = new Figure("x", Color.MAGENTA);
        boardView.getNewPositionEvent().subscribe((s, pos) -> {
            boardModel.setPosition(pos, testFigure);
        });
        boardModel.getOnWinEvent().subscribe((s, figure) -> {
            boardView.handleWinEvent(figure);
        });
    }

    public void showView() {
        boardView.show();
    }

    public void hideView() {
        boardView.hide();
    }

}
