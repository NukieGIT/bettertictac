package nuk.ui;

import com.formdev.flatlaf.FlatDarkLaf;
import nuk.events.Event;
import nuk.events.EventArg;
import nuk.events.EventManager;
import nuk.logic.BoardModel;
import nuk.logic.GameSettings;
import nuk.logic.Player;
import nuk.logic.SettingsManager;
import nuk.util.Vector2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.HashMap;

public class SwingBoardView implements IBoardView {

    private EventManager<EventArg<Vector2D>> onNewPosition;
    private GameSettings settings;

    private JFrame mainWindow;
    private HashMap<Vector2D, JButton> buttons;
    private BoardModel boardModel;


    public SwingBoardView(BoardModel boardModel) {
        FlatDarkLaf.setup();
        this.boardModel = boardModel;

        buttons = new HashMap<>();
        onNewPosition = new EventManager<>();
        settings = SettingsManager.getInstance().getSettings();

        Vector2D size = settings.getSize();

        mainWindow = new JFrame("Tic Tac Toe");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(500, 500);
        mainWindow.setLayout(new GridLayout((int) size.x, (int) size.y));

        for (int i = 0; i < size.y; i++) {
            for (int j = 0; j < size.x; j++) {
                JButton btn = new JButton();

                Vector2D pos = new Vector2D(j, i);
                buttons.put(pos, btn);
                mainWindow.add(btn);

                btn.addActionListener(e -> onNewPosition.invoke(this, new EventArg<>(pos)));

                mainWindow.addComponentListener(new ComponentListener() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        int width = btn.getWidth();
                        int height = btn.getHeight();

                        btn.setFont(btn.getFont().deriveFont((float) Math.min(width, height)));
                    }

                    @Override
                    public void componentMoved(ComponentEvent e) {}

                    @Override
                    public void componentShown(ComponentEvent e) {}

                    @Override
                    public void componentHidden(ComponentEvent e) {}
                });
            }
        }
    }

    @Override
    public void show() {
        mainWindow.setVisible(true);
    }

    @Override
    public void hide() {
        mainWindow.setVisible(false);
    }

    @Override
    public void update() {
        boardModel.getMap().forEach((pos, player) -> {
            JButton btn = buttons.get(pos);
            btn.setText(player.getPlayer());
            btn.setForeground(player.getClr());
        });
    }

    @Override
    public Event<EventArg<Vector2D>> getNewPositionEvent() {
        return onNewPosition.getEvent();
    }

    @Override
    public void handleWinEvent(Player player) {
        System.out.printf("wodater le łoter water a la le fishe au radzxiou %s%n", player.getPlayer().repeat((int) Math.floor(Math.random() * 9) + 1).toUpperCase());
    }
}
