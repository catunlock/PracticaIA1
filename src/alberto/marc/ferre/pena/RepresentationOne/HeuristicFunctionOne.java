/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberto.marc.ferre.pena.RepresentationOne;

/**
 *
 * @author marc.ferre.monne
 */
public class HeuristicFunctionOne implements aima.search.framework.HeuristicFunction {

    @Override
    public double getHeuristicValue(Object state) {
        Representation rep = (Representation) state;
        
        int totalTime = 0;
        for (int time : rep.serverLoad) {
            totalTime += time;
        }

        return totalTime;
    }
    
}
