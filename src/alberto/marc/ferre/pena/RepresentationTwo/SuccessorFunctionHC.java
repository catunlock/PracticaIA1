package alberto.marc.ferre.pena.RepresentationTwo;

import aima.search.framework.Successor;

import java.util.*;

/**
 * Created by sunlock on 25/03/16.
 */
public class SuccessorFunctionHC implements aima.search.framework.SuccessorFunction {

    @Override
    public List getSuccessors(Object state) {
        ArrayList successors = new ArrayList();

        Representation rep = (Representation) state;

        // public void move(int fileId, int serverId, int userId, int servDestId) {
        // ArrayList<HashMap<Integer,TreeSet<Integer>>> data;

        for (int i_file = 0; i_file < rep.data.size(); ++ i_file)
        {
            HashMap<Integer,TreeSet<Integer>> servers = rep.data.get(i_file);

            for (Map.Entry<Integer, TreeSet<Integer>> serv : servers.entrySet()) {
                int serverId = serv.getKey();

                for (Integer userId : serv.getValue()) {

                    for (Map.Entry<Integer, TreeSet<Integer>> servDest : servers.entrySet())
                    {
                        if (serv != servDest && rep.canMove(i_file, servDest.getKey())){
                            Representation newRep = new Representation(rep);
                            newRep.move(i_file, serverId, userId, servDest.getKey());

                            Successor successor = new Successor(rep.toString(), newRep);
                            successors.add(successor);
                        }
                    }

                }
            }
        }

        return successors;
    }

}