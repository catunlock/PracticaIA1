package alberto.marc.ferre.pena.RepresentationThree;

import aima.search.framework.Successor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by sunlock on 23/03/16.
 */
public class SuccessorFunctionHC implements aima.search.framework.SuccessorFunction {

    @Override
    public List getSuccessors(Object state) {
        ArrayList successors = new ArrayList();

        Representation rep = (Representation) state;

        //      public boolean canMove(int request, int servDest) {

        for (int r = 0; r < rep.requests.size(); ++r)
        {
            int[] req = rep.requestsDist.getRequest(r);
            int fileId = req[1];

            Set<Integer> serversIds = rep.serversDist.fileLocations(fileId);

            for (int sDest : serversIds)
            {
                if (sDest != rep.requests.get(r)) {
                    Representation newRep = new Representation(rep);
                    newRep.move(r, sDest);

                    //String paso = newRep.toString();
                    String paso = String.valueOf(newRep.totalTransmissionTime);

                    Successor successor = new Successor(newRep.toString(), newRep);
                    successors.add(successor);
                }
            }
        }

        return successors;
    }

}
