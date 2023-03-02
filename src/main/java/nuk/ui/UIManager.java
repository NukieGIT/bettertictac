package nuk.ui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class UIManager {
    private ArrayList<JFrame> frames = new ArrayList<>();

    /**
     * <h1>ONLY FOR TESTS</h1>
     * @return all the created frames using UIManager
     */
    protected ArrayList<JFrame> getFrames() {
        return frames;
    }

    public void createWindow(JFrame frame) {
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frames.remove(frame);
                super.windowClosing(e);
            }
        });
        frames.add(frame);
    }

    public void closeWindow(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public void closeAllWindows() {
        for (Iterator<JFrame> it = frames.iterator(); it.hasNext();) {
            JFrame next = it.next();

            next.setVisible(false);
            next.dispose();

            it.remove();
        }
    }

}
