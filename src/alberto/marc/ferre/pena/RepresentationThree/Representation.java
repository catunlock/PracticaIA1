package alberto.marc.ferre.pena.RepresentationThree;

import IA.DistFS.Requests;
import IA.DistFS.Servers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * Created by sunlock on 31/03/16.
 */
public class Representation {
    Requests requestsDist;
    Servers serversDist;

    ArrayList<Integer> requests;
    ArrayList<Integer> serverLoad;
    Random rand;
    int nservers;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < serverLoad.size(); ++i) {
            sb.append("SERVER " + i + ": " + serverLoad.get(i) + "ms\n");
        }

        return sb.toString();
    }

    public void generateInitialState() {
        for(int i = 0; i < requestsDist.size(); ++i)
        {
            int[] req = requestsDist.getRequest(i);
            int userId = req[0];
            int fileId = req[1];

            Set<Integer> serversId = serversDist.fileLocations(fileId);
            Iterator<Integer> it = serversId.iterator();
            if (it.hasNext()) { // Never will be empty.
                int sId = it.next();

                requests.set(i, sId);

                int prevLoad = serverLoad.get(sId);
                int transTime = serversDist.tranmissionTime(sId, userId);
                serverLoad.set(sId, prevLoad + transTime);
            }
        }
    }

    public void generateInitialState3()
    {
        for(int i = 0; i < requestsDist.size(); ++i)
        {
            int[] req = requestsDist.getRequest(i);
            int userId = req[0];
            int fileId = req[1];

            Set<Integer> serversId = serversDist.fileLocations(fileId);
            int times = rand.nextInt(serversId.size());

            Iterator<Integer> it = serversId.iterator();
            for (int k = 1; k < times; k++) it.next();

            int sId = it.next();
            requests.set(i, sId);

            int prevLoad = serverLoad.get(sId);
            int transTime = serversDist.tranmissionTime(sId, userId);
            serverLoad.set(sId, prevLoad + transTime);

        }
    }



    public void generateInitialState2() {
        for(int i = 0; i < requestsDist.size(); ++i)
        {
            int[] req = requestsDist.getRequest(i);
            int userId = req[0];
            int fileId = req[1];

            Set<Integer> serversId = serversDist.fileLocations(fileId);
            Iterator<Integer> it = serversId.iterator();
            int minPing, minSId;

            if (it.hasNext()) {
                int sId = it.next();
                minPing = serverLoad.get(sId);
                minSId = sId;

                while (it.hasNext()) { // Never will be empty.
                    sId = it.next();
                    if (minPing > serverLoad.get(sId)) {
                        minPing = serverLoad.get(sId);
                        minSId = sId;
                    }

                }

                requests.set(i, minSId);

                int prevLoad = serverLoad.get(minSId);
                int transTime = serversDist.tranmissionTime(minSId, userId);
                serverLoad.set(minSId, prevLoad + transTime);
            }
        }
    }

    private void decrementTransmissionTime(int serverId, int request) {
        int[] req = requestsDist.getRequest(request);
        int userId = req[0];

        int previousLoad = serverLoad.get(serverId);
        int ping = serversDist.tranmissionTime(serverId, userId);

        serverLoad.set(serverId, previousLoad - ping);
    }

    private void incrementTransmissionTime(int serverId, int request) {
        int[] req = requestsDist.getRequest(request);
        int userId = req[0];

        int previousLoad = serverLoad.get(serverId);
        int ping = serversDist.tranmissionTime(serverId, userId);

        serverLoad.set(serverId, previousLoad + ping);
    }

    public boolean canMove(int request, int servDest) {
        int[] req = requestsDist.getRequest(request);
        int fileId = req[1];

        return serversDist.fileLocations(fileId).contains(servDest);
    }

    public void move(int request, int servDest) {
        int servOrigin = requests.get(request);

        decrementTransmissionTime(servOrigin, request);
        incrementTransmissionTime(servDest, request);
    }

    public Representation(Representation rep) {
        requestsDist = rep.requestsDist;
        serversDist = rep.serversDist;
        rand = rep.rand;
        this.nservers = rep.nservers;

        requests = new ArrayList<>(rep.requests.size());
        serverLoad = new ArrayList<>(rep.serverLoad.size());

        for (int i = 0; i < nservers; ++i) {
            serverLoad.add(rep.serverLoad.get(i));
        }

        for (int i = 0; i < requestsDist.size(); ++i) {
            requests.add(rep.requests.get(i));
        }
    }

    public Representation(Random rand, int nservers, Requests requestsDist, Servers serversDist) {

        this.requestsDist = requestsDist;
        this.serversDist = serversDist;
        this.rand = rand;
        this.nservers = nservers;

        this.requests = new ArrayList<>(requestsDist.size());
        this.serverLoad = new ArrayList<>(nservers);

        for (int i = 0; i < nservers; ++i) {
            serverLoad.add(0);
        }

        for (int i = 0; i < requestsDist.size(); ++i) {
            requests.add(0);
        }
    }

}