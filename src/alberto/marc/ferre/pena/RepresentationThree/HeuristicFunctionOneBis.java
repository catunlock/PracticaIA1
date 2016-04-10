package alberto.marc.ferre.pena.RepresentationThree;

/**
 * Created by SuNLoCK on 10/04/2016.
 */
public class HeuristicFunctionOneBis implements aima.search.framework.HeuristicFunction{
    @Override
    public double getHeuristicValue(Object state) {
        int maxTime = 0;
        Representation rep = (Representation) state;

        for (int time : rep.serverLoad){
            maxTime = Math.max(maxTime,time);
        }

        return maxTime;
    }
}
