package alberto.marc.ferre.pena.RepresentationThree;

import static java.lang.Math.sqrt;

/**
 * Created by sunlock on 23/03/16.
 */
public class HeuristicFunctionTwo implements aima.search.framework.HeuristicFunction {

    @Override
    public double getHeuristicValue(Object state)
    {
        Representation rep = (Representation) state;

        double mean = 0;
        double variancy = 0;

        for (int i = 0; i < rep.serverLoad.size(); ++i) {
            mean += rep.serverLoad.get(i);
        }
        mean = mean / rep.serverLoad.size();
        for (int j = 0; j < rep.serverLoad.size();++j) {
            variancy += Math.pow(rep.serverLoad.get(j) - mean,2);
        }

        variancy = variancy/rep.serverLoad.size();
        return rep.totalTransmissionTime  - rep.totalTransmissionTime/ variancy;
        //return variancy;
    }
}
