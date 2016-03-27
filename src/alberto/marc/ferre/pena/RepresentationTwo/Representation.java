package alberto.marc.ferre.pena.RepresentationTwo;

import IA.DistFS.Requests;
import IA.DistFS.Servers;

import java.util.*;

/**
 * Created by sunlock on 25/03/16.
 */
public class Representation {

    Requests requestsDist;
    Servers serversDist;


    ArrayList<Integer> serverLoad;
    //Files<HashMap<IdServer, Treeset<UserId>>>
    ArrayList<HashMap<Integer,TreeSet<Integer>>> data;

    public void generateInitialState() {

        int numberOfFiles = 0;
        for (int j = 0; j < requestsDist.size(); ++j) {
            if (numberOfFiles < requestsDist.getRequest(j)[1]) {
                numberOfFiles = requestsDist.getRequest(j)[1];
            }
        }
        numberOfFiles++;

        data = new ArrayList<>(numberOfFiles);
        for (int i = 0; i < numberOfFiles; ++i) {
            data.add(new HashMap<Integer,TreeSet<Integer>>());
        }

        for (int i = 0; i < requestsDist.size(); ++i)
        {
            int[] req = requestsDist.getRequest(i);
            int userId = req[0];
            int fileId = req[1];


            Set<Integer> serversId = serversDist.fileLocations(fileId);
            for (int serverId : serversId) {
                data.get(fileId).put(serverId, new TreeSet<>());
            }

            Iterator<Integer> it = serversId.iterator();
            if (it.hasNext()) { // Never will be empty.
                int sId = it.next();

                data.get(fileId).get(sId).add(userId);

                incrementTransmissionTime(sId, userId);
            }
        }
    }

    public Representation(int nservers, Requests requestsDist, Servers serversDist) {

        this.requestsDist = requestsDist;
        this.serversDist = serversDist;

        this.data = new ArrayList<>();
        this.serverLoad = new ArrayList<>(nservers);

        for (int i = 0; i < nservers; ++i) {
            serverLoad.add(0);
        }
    }

    public Representation(Representation o) {
        requestsDist = o.requestsDist;
        serversDist = o.serversDist;

        data = new ArrayList<>(o.data.size());
        serverLoad = new ArrayList<>(o.serverLoad.size());

        for (int i = 0; i < o.data.size(); ++i)
        {
            HashMap<Integer, TreeSet<Integer>> newServers = new HashMap<>();
            HashMap<Integer, TreeSet<Integer>> servers = o.data.get(i);

            for (Map.Entry<Integer, TreeSet<Integer>> entry : servers.entrySet()) {
                TreeSet<Integer> newUsers = new TreeSet<>();
                for (Integer k : entry.getValue()) {
                    newUsers.add(new Integer(k));
                }
                newServers.put(entry.getKey(), newUsers);
            }

            data.add(newServers);
        }

        for (int i = 0; i < o.serverLoad.size(); ++i) {
            this.serverLoad.add(o.serverLoad.get(i));
        }
    }

    public boolean canMove(int fileId, int servDestId) {
        return serversDist.fileLocations(fileId).contains(servDestId);
    }

    public void move(int fileId, int serverId, int userId, int servDestId) {
        HashMap<Integer,TreeSet<Integer>> servers = data.get(fileId);
        TreeSet<Integer> users = servers.get(serverId);

        users.remove(userId);

        servers.get(servDestId).add(userId);

        decrementTransmissionTime(serverId,userId);
        incrementTransmissionTime(servDestId,userId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < serverLoad.size(); ++i) {
            sb.append("SERVER " + i + ": " + serverLoad.get(i)+"ms\n");
        }

        return sb.toString();
    }



    private void decrementTransmissionTime(int serverId, int userId) {
        int previousLoad = serverLoad.get(serverId);
        int ping = serversDist.tranmissionTime(serverId, userId);

        serverLoad.set(serverId, previousLoad - ping);
    }

    private void incrementTransmissionTime(int serverId, int userId) {
        int previousLoad = serverLoad.get(serverId);
        int ping = serversDist.tranmissionTime(serverId, userId);

        serverLoad.set(serverId, previousLoad + ping);
    }

}
