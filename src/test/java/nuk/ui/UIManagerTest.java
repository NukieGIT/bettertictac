package nuk.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class UIManagerTest {

    private final UIManager uiManager = new UIManager();

    @AfterEach
    void tearDown() {
        uiManager.getFrames().clear();
    }

    @Test
    void create1Window() {
        JFrame f1 = new JFrame();
        uiManager.createWindow(f1);

        assertTrue(uiManager.getFrames().contains(f1));
        assertEquals(1, uiManager.getFrames().size());
    }

    @Test
    void create3Windows() {
        JFrame f1 = new JFrame();
        JFrame f2 = new JFrame();
        JFrame f3 = new JFrame();
        uiManager.createWindow(f1);
        uiManager.createWindow(f2);
        uiManager.createWindow(f3);

        assertTrue(uiManager.getFrames().contains(f1));
        assertTrue(uiManager.getFrames().contains(f2));
        assertTrue(uiManager.getFrames().contains(f3));
        assertEquals(3, uiManager.getFrames().size());
    }

    @Test
    void close1Window() {
        JFrame f1 = new JFrame();
        uiManager.createWindow(f1);

        uiManager.closeWindow(f1);

        assertFalse(uiManager.getFrames().contains(f1));
        assertEquals(0, uiManager.getFrames().size());
    }

    @Test
    void close1WindowWith2OPen() {
        JFrame f1 = new JFrame();
        JFrame f2 = new JFrame();
        uiManager.createWindow(f1);
        uiManager.createWindow(f2);

        uiManager.closeWindow(f1);

        assertFalse(uiManager.getFrames().contains(f1));
        assertTrue(uiManager.getFrames().contains(f2));
        assertEquals(1, uiManager.getFrames().size());
    }

    @Test
    void closeAllWindows() {
        JFrame f1 = new JFrame();
        JFrame f2 = new JFrame();
        JFrame f3 = new JFrame();
        uiManager.createWindow(f1);
        uiManager.createWindow(f2);
        uiManager.createWindow(f3);

        uiManager.closeAllWindows();

        assertEquals(0, uiManager.getFrames().size());
    }
}