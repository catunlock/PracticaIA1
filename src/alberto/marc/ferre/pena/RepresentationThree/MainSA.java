package alberto.marc.ferre.pena.RepresentationThree;

import IA.DistFS.Requests;
import IA.DistFS.Servers;
import aima.search.framework.Problem;
import aima.search.framework.SearchAgent;
import aima.search.informed.SimulatedAnnealingSearch;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by sunlock on 24/03/16.
 */
public class MainSA {
    public static Random rand = new Random();

    public static int USERS_REQUESTS;
    public static int MAXIMUN_REQUESTS_PER_USER;
    public static int NUMBER_OF_SERVERS;
    public static int MINIMUM_REPLICATIONS;

    private static void generateValors() {
        USERS_REQUESTS = rand.nextInt(500);
        MAXIMUN_REQUESTS_PER_USER = rand.nextInt(15);
        NUMBER_OF_SERVERS = rand.nextInt(200);
        MINIMUM_REPLICATIONS = rand.nextInt(max(1,NUMBER_OF_SERVERS/2));

        System.out.println("Users Requests: " + USERS_REQUESTS);
        System.out.println("Maximum Requests per user: " + MAXIMUN_REQUESTS_PER_USER);
        System.out.println("Number of Servers: " + NUMBER_OF_SERVERS);
        System.out.println("Minimum replications: " + MINIMUM_REPLICATIONS);
    }

    public static final int STEPS = 1050000;
    public static final int STITER = 100;
    public static final int K = 8;
    public static final double LAMB = 0.0001;

    public static void main(String[] args) throws FileNotFoundException
    {
        if (args.length == 0 || (args[0] == "1" || args[0] == "2")) {
            System.out.println("Has d'indicar amb un numero quina aproximacio vols fer servir (1 o 2)");
            System.exit(1);
        }

        generateValors();
        long tStart = System.currentTimeMillis();

        try {
            Requests requestsDist = new Requests(USERS_REQUESTS, MAXIMUN_REQUESTS_PER_USER, rand.nextInt());
            Servers serversDist = new Servers(NUMBER_OF_SERVERS, MINIMUM_REPLICATIONS, rand.nextInt());

            Representation rep = new Representation(rand, NUMBER_OF_SERVERS, requestsDist, serversDist);
            rep.generateInitialState2();

            System.out.printf("Initial Total Transmision Time: " + rep.toString() + "ms");

            Problem problem;
            if (args[0] == "1") {
                problem = new Problem(rep, new SuccessorFunctionHC(), new GoalTest(), new HeuristicFunctionOneBis());
            }else {
                problem = new Problem(rep, new SuccessorFunctionHC(), new GoalTest(), new HeuristicFunctionTwo());
            }

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
