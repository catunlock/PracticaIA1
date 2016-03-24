package alberto.marc.ferre.pena;

import IA.DistFS.Requests;
import IA.DistFS.Servers;

/**
 * Created by sunlock on 24/03/16.
 */
public class MainSet {

    public static final int USERS_REQUESTS = 10;
    public static final int MAXIMUN_REQUESTS_PER_USER = 3;
    public static final int SEED = 1;

    public static final int NUMBER_OF_SERVERS = 4;
    public static final int MINIMUM_REPLICATIONS = 1;

    public void run() {

        try {
            Requests requestsDist = new Requests(USERS_REQUESTS, MAXIMUN_REQUESTS_PER_USER,SEED);
            Servers serversDist = new Servers(NUMBER_OF_SERVERS, MINIMUM_REPLICATIONS, SEED);

            Representation rep = new Representation(NUMBER_OF_SERVERS, requestsDist, serversDist);
            rep.servers.get(0).files.add(new Request(1,1));
            rep.servers.get(0).files.add(new Request(1,2));

            Representation rep2 = new Representation(rep);
            rep2.servers.get(0).files.add(new Request(1,3));

            rep2.servers.get(0).files.remove(new Request(1,2));

        } catch (Servers.WrongParametersException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MainSet().run();
    }
}
