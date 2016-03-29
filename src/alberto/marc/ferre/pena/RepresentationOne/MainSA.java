package alberto.marc.ferre.pena.RepresentationOne;

import IA.DistFS.Requests;
import IA.DistFS.Servers;
import aima.search.framework.Problem;
import aima.search.framework.SearchAgent;
import aima.search.informed.SimulatedAnnealingSearch;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
/**
 * Created by sunlock on 24/03/16.
 */
public class MainSA {
    public static  int USERS_REQUESTS = 200;
    public static  int MAXIMUN_REQUESTS_PER_USER = 5;
    public static  int SEED = 1234;

    public static int NUMBER_OF_SERVERS = 50;
    public static  int MINIMUM_REPLICATIONS = 5;
    /*
    public static final int USERS_REQUESTS = 10;
    public static final int MAXIMUN_REQUESTS_PER_USER = 3;
    public static final int SEED = 1;

    public static final int NUMBER_OF_SERVERS = 4;
    public static final int MINIMUM_REPLICATIONS = 1;
    */
    // SIMULATING ANNEALING Variables
    public static final int STEPS = 1000000;
    public static final int STITER = 100000;
    public static final int K = 100000;
    public static final int LAMB = 10;

    public static void main(String[] args)
    {
        long tStart = System.currentTimeMillis();
        try {

            Requests requestsDist = new Requests(USERS_REQUESTS, MAXIMUN_REQUESTS_PER_USER,SEED);
            Servers serversDist = new Servers(NUMBER_OF_SERVERS, MINIMUM_REPLICATIONS, SEED);

            Representation rep = new Representation(NUMBER_OF_SERVERS, requestsDist, serversDist);
            rep.generateInitialState();

            System.out.printf(rep.toString());

            Problem problem = new Problem(rep, new SuccessorFunctionSA(), new GoalTest(), new HeuristicFunction());

            SimulatedAnnealingSearch search = new SimulatedAnnealingSearch(STEPS, STITER, K, LAMB);

            SearchAgent agent = new SearchAgent(problem, search);

            printActions(agent.getActions());
            printInstrumentation(agent.getInstrumentation());

        } catch (Servers.WrongParametersException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        long tEnd = System.currentTimeMillis();

        System.out.println("Elapsed time: " + (tEnd - tStart) + "ms.");

    }

    private static void generateRandomScenario () {
        Random r = new Random(SEED);
        USERS_REQUESTS = r.nextInt(600);
        MAXIMUN_REQUESTS_PER_USER = r.nextInt(100);
        NUMBER_OF_SERVERS = r.nextInt(1000);
        MINIMUM_REPLICATIONS = r.nextInt(NUMBER_OF_SERVERS/2);
    }
    private static void printInstrumentation(Properties properties) {
        Iterator keys = properties.keySet().iterator();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            String property = properties.getProperty(key);
            System.out.println(key + " : " + property);
        }

    }

    private static void printActions(List actions) {
        if (! actions.isEmpty()) {
            for (int i = 0; i < actions.size(); i++) {
                Representation rep = (Representation) actions.get(i);
                System.out.println(rep.toString());
            }
        }
        else {
            System.out.println("No se ha realitzat cap accio.");
        }

    }
}
