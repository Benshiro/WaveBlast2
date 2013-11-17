import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Benshiro
 * Date: 16/11/13
 * Time: 19:05
 * To change this template use File | Settings | File Templates.
 */
public class Entity implements Renderable {

    private int x;
    private int y;

    private Color c;

    public void setC(Color c) {
        this.c = c;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void render(Graphics2D g) {
        g.setColor(c);
        g.fillRect(x, y, 50, 50);
    }

    public void moveEntity(int direction) {
        switch (direction) {
            case 0:
                y -= 2;
                break;
            case 1:
                x += 2;
                break;
            case 2:
                y += 2;
                break;
            case 3:
                x -= 2;
                break;
        }
    }
}
