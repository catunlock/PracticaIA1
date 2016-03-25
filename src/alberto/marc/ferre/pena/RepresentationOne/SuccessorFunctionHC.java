package alberto.marc.ferre.pena.RepresentationOne;

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

        //    public void move(Request r, int s1, int s2) {

        for (int i_sOrig = 0; i_sOrig < rep.servers.size(); ++i_sOrig)
        {
            for (Request req : rep.servers.get(i_sOrig).files)
            {
                Set<Integer> fileLocations = rep.serversDist.fileLocations(req.fileId);

                for (int i_sDest : fileLocations)
                {
                    if (i_sDest != i_sOrig && rep.canMove(req, i_sDest)) {
                        Representation newRep = new Representation(rep);
                        newRep.move(req, i_sOrig, i_sDest);

                        String actionStr = new String("MOVE " + req.fileId + " FROM: " + i_sOrig + " TO: " + i_sDest);

                        Successor successor = new Successor(newRep.toString(), newRep);
                        successors.add(successor);
                    }
                }
            }
        }

        return successors;
    }

}
