package alberto.marc.ferre.pena;

import IA.DistFS.Requests;
import IA.DistFS.Servers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sunlock on 23/03/16.
 */
public class Representation {

    Requests requestsDist;
    Servers serversDist;



    public class Server {
        public TreeSet<Request> files;
    }

    ArrayList<Server> servers;
    ArrayList<Integer> serverLoad;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < servers.size(); ++i) {
            sb.append("SERVER " + i + ":");
            for (Request r : servers.get(i).files) {
                sb.append(" " + r.fileId);
            }
            sb.append("--> " + serverLoad.get(i) + "ms\n");
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
                servers.get(sId).files.add(new Request(userId,fileId));

                int prevLoad = serverLoad.get(sId);
                int transTime = serversDist.tranmissionTime(sId, userId);
                serverLoad.set(sId, prevLoad + transTime);
            }
        }
    }

    private void decrementTransmissionTime(int serverId, Request r) {
        int previousLoad = serverLoad.get(serverId);
        int ping = serversDist.tranmissionTime(serverId, r.userId);

        serverLoad.set(serverId, previousLoad - ping);
    }

    private void incrementTransmissionTime(int serverId, Request r) {
        int previousLoad = serverLoad.get(serverId);
        int ping = serversDist.tranmissionTime(serverId, r.userId);

        serverLoad.set(serverId, previousLoad + ping);
    }


    public boolean isExchangeable(Request r1, Request r2, int s1, int s2) {
        return servers.get(s1).files.contains(r1) && servers.get(s2).files.contains(r2);
    }

    public boolean canMove(Request r, int servDest) {
        return serversDist.fileLocations(r.fileId).contains(servDest);
    }

     public void exchange(Request r1, Request r2, int s1, int s2) {
        servers.get(s2).files.remove(r2);
        decrementTransmissionTime(s2, r2);

        servers.get(s2).files.add(r1);
        incrementTransmissionTime(s2,r1);

        servers.get(s1).files.remove(r1);
        decrementTransmissionTime(s1,r1);

        servers.get(s1).files.add(r2);
        incrementTransmissionTime(s1,r2);
    }

    public void move(Request r, int s1, int s2) {
        boolean b = servers.get(s1).files.remove(r);
        if (!b) {
            System.out.println("Not Removed " + r.fileId + " FROM " + s1);
        }
        servers.get(s2).files.add(r);

        decrementTransmissionTime(s1,r);
        incrementTransmissionTime(s2,r);
    }

    public Representation(Representation r) {
        requestsDist = r.requestsDist;
        serversDist = r.serversDist;

        servers = new ArrayList<>(r.servers.size());
        serverLoad = new ArrayList<>(serversDist.size());

        for (int i = 0; i < r.servers.size(); ++i) {
            servers.add(r.servers.get(i));
            servers.get(i).files = new TreeSet<>();

            for (Request req : r.servers.get(i).files) {
                servers.get(i).files.add(new Request(req));
            }
            serverLoad.add(r.serverLoad.get(i));
        }
    }

    public Representation(int nservers, Requests requestsDist, Servers serversDist) {

        this.requestsDist = requestsDist;
        this.serversDist = serversDist;

        this.servers = new ArrayList<>(nservers);
        this.serverLoad = new ArrayList<>(nservers);

        for (int i = 0; i < nservers; ++i) {
            servers.add(new Server());
            servers.get(i).files = new TreeSet<>();
            serverLoad.add(0);
        }
    }



}
