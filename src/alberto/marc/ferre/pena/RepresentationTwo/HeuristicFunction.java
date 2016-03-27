package alberto.marc.ferre.pena.RepresentationTwo;

/**
 * Created by sunlock on 25/03/16.
 */
public class HeuristicFunction implements aima.search.framework.HeuristicFunction {

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

        return variancy/rep.serverLoad.size();

    }
}