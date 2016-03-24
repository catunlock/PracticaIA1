package alberto.marc.ferre.pena;

import static java.lang.Math.max;

/**
 * Created by sunlock on 23/03/16.
 */
public class HeuristicFunction implements aima.search.framework.HeuristicFunction {

    @Override
    public double getHeuristicValue(Object state)
    {
        Representation rep = (Representation) state;

        int maxTransmissionTime = 0;
        int sumTransmissionTime = 0;

        for (int i = 0; i < rep.serverLoad.size(); ++i) {
            int ttsi = rep.serverLoad.get(i);

            maxTransmissionTime = max(maxTransmissionTime, ttsi);
            sumTransmissionTime += (ttsi*ttsi);
        }

        return sumTransmissionTime / (maxTransmissionTime / rep.serverLoad.size());

    }
}
