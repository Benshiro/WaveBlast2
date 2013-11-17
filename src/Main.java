/**
 * Created with IntelliJ IDEA.
 * User: Benshiro
 * Date: 16/11/13
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
     new Main();
    }

    public Main() {

       GameWindow gw = new GameWindow();
        Thread thread = new Thread(gw);
        thread.start();



    }


}
