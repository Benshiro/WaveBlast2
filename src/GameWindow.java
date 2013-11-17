import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * Created with IntelliJ IDEA.
 * User: Benshiro
 * Date: 16/11/13
 * Time: 17:58
 * To change this template use File | Settings | File Templates.
 */
public class GameWindow extends JFrame implements Runnable {

    private BufferStrategy buffer;

    private InputHandler input;

    private ConcurrentLinkedQueue<Entity> entities;

    private Entity player;

    public GameWindow() {

        this.setMinimumSize(new Dimension(640, 480));
        this.setIgnoreRepaint(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        input = new InputHandler();
        this.addKeyListener(input);
        player = new Entity();

        entities = new ConcurrentLinkedQueue<Entity>();


        Canvas c = new Canvas();
        c.setBounds(0, 0, 640, 480);
        this.add(c, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);

        c.createBufferStrategy(2);
        c.setIgnoreRepaint(true);
        buffer = c.getBufferStrategy();


    }

    private void render() {
        Graphics2D g = (Graphics2D) buffer.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 640, 480);

        g.setColor(Color.PINK);
        player.render(g);

        for(Entity e : entities)
        {
            e.render(g);
        }
        buffer.show();
    }

    private void logic() {

        if (Math.random() > 0.9) {
            Entity e = new Entity();
            e.setC(Color.BLUE);
            e.setY((int) (Math.random() * 480));
            e.setX(640);
            entities.add(e);
        }

        for(Entity e : entities)
        {
            e.moveEntity(3);
        }

        if (input.isUpPress()) {
            player.moveEntity(0);
        } else if (input.isRightPress()) {
            player.moveEntity(1);

        } else if (input.isDownPress()) {
            player.moveEntity(2);
        } else if (input.isLeftPress()) {
            player.moveEntity(3);
        }
    }

    private void input() {

    }

    public void run() {
        while (true) {
            input();
            logic();
            render();
            LockSupport.parkNanos(16666667);
        }

    }
}
