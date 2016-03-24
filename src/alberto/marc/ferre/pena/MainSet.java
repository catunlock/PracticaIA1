package alberto.marc.ferre.pena;

import java.util.TreeSet;

/**
 * Created by sunlock on 24/03/16.
 */
public class MainSet {

    TreeSet<Request> requests = new TreeSet<>();

    public void run() {
        requests.add(new Request(1,1));

        if (requests.remove(new Request(1,1))) {
            System.out.println("Eliminado");
        }else {
            System.out.println("No.");
        }
    }

    public static void main(String[] args) {
        new MainSet().run();
    }
}
