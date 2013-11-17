import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * User: Benshiro
 * Date: 16/11/13
 * Time: 18:56
 * To change this template use File | Settings | File Templates.
 */
public class InputHandler extends KeyAdapter {

    private boolean upPress;
    private boolean downPress;
    private boolean leftPress;
    private boolean rightPress;

    public boolean isUpPress() {
        return upPress;
    }

    public boolean isDownPress() {
        return downPress;
    }

    public boolean isLeftPress() {
        return leftPress;
    }

    public boolean isRightPress() {
        return rightPress;
    }

    public void keyTyped(KeyEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                upPress = true;
                break;

            case KeyEvent.VK_DOWN:
                downPress = true;
                break;

            case KeyEvent.VK_LEFT:
                leftPress = true;
                break;

            case KeyEvent.VK_RIGHT:
                rightPress = true;
                break;
        }


        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        upPress = false;
                        break;

                    case KeyEvent.VK_DOWN:
                        downPress = false;
                        break;

                    case KeyEvent.VK_LEFT:
                        leftPress = false;
                        break;

                    case KeyEvent.VK_RIGHT:
                        rightPress = false;
                        break;
                }
    }
}
