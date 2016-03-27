package alberto.marc.ferre.pena.RepresentationOne;

import aima.search.framework.Successor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by sunlock on 27/03/16.
 */
public class SuccessorFunctionSA implements aima.search.framework.SuccessorFunction {

    private static final Random random = new Random();

    @Override
    public List getSuccessors(Object state) {
        ArrayList successors = new ArrayList();

        Representation rep = (Representation) state;

        // public void move(Request r, int s1, int s2) {

        int i_sOrig = random.nextInt(rep.servers.size());

        Object[] requests = rep.servers.get(i_sOrig).files.toArray();
        while (requests.length == 0) {
            i_sOrig++;
            requests = rep.servers.get(i_sOrig).files.toArray();
        }

        int i_request = random.nextInt(requests.length);
        Request req = (Request) requests[i_request];

        Object[] fileLocations = rep.serversDist.fileLocations(req.fileId).toArray();
        int i_fileLoc = random.nextInt(fileLocations.length);

        int i_sDest = (int) fileLocations[i_fileLoc];


        if (i_sDest != i_sOrig && rep.canMove(req, i_sDest)) {
                Representation newRep = new Representation(rep);
                newRep.move(req, i_sOrig, i_sDest);

                Successor successor = new Successor(newRep.toString(), newRep);
                successors.add(successor);
        }


        return successors;
    }
}
