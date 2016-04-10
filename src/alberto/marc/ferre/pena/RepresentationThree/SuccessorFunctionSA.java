package alberto.marc.ferre.pena.RepresentationThree;

import aima.search.framework.Successor;

import java.util.*;

/**
 * Created by sunlock on 27/03/16.
 */
public class SuccessorFunctionSA implements aima.search.framework.SuccessorFunction {

    private static final Random random = new Random();

    @Override
    public List getSuccessors(Object state) {
        ArrayList successors = new ArrayList();
        Representation rep = (Representation) state;

        // public boolean canMove(int request, int servDest) {
        int r = random.nextInt(rep.requests.size());
        int[] req = rep.requestsDist.getRequest(r);
        int fileId = req[1];

        Set<Integer> serversIds = rep.serversDist.fileLocations(fileId);


        int n = random.nextInt(serversIds.size());

        Iterator<Integer> it = serversIds.iterator();
        for (int i = 1; i < n && it.hasNext(); ++i) {
            it.next();
        }

        int sDest = it.next();
        if (sDest == rep.requests.get(r)) {
            sDest = (sDest+1) % rep.nservers;
        }

        if (sDest != rep.requests.get(r)) {
            Representation newRep = new Representation(rep);
            newRep.move(r, sDest);

            //String paso = newRep.toString();
            String paso = String.valueOf(newRep.totalTransmissionTime);
            //System.out.println(newRep.totalTransmissionTime);

            Successor successor = new Successor(newRep.toString() , newRep);
            successors.add(successor);
        }

        return successors;
    }
}
