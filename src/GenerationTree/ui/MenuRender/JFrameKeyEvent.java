package GenerationTree.ui.MenuRender;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;

public class JFrameKeyEvent implements KeyEventManager {

    private static Queue<KeyEvent> queue;
    private boolean keyIsPressed;

    public JFrameKeyEvent() {
        queue = new LinkedList<>();
        keyIsPressed = false;
    }

    public int start() {
        int keyCode = 0;
        var frame = new JFrame("Key capture");
        var keManager = new JFrameKeyEvent();
        frame.addKeyListener(keManager);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setFocusable(true);
        var keyEventRun = true;
        while (keyEventRun) {
            KeyEvent event = null;
            synchronized (queue) {
                if (!queue.isEmpty()) {
                    event = queue.poll();
                }
            }
            if (event != null) {
                keyCode = event.getKeyCode();
                keyEventRun = false;
            } else {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        frame.dispose();
        return keyCode;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.keyIsPressed = true;
        eventToQueue(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        eventToQueue(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.keyIsPressed = false;
    }

    private void eventToQueue(KeyEvent e) {
        if (this.keyIsPressed) {
            synchronized (queue) {
                queue.offer(e);
            }
            this.keyIsPressed = false;
        }
    }
}