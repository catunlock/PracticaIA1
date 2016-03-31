/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alberto.marc.ferre.pena.RepresentationThree;

/**
 *
 * @author marc.ferre.monne
 */
public class HeuristicFunctionOne implements aima.search.framework.HeuristicFunction {

    @Override
    public double getHeuristicValue(Object state) {
        Representation rep = (Representation) state;
        
        int maxTime = 0;
        
        for (Integer load : rep.serverLoad) {
            maxTime = Math.max(maxTime,load);
        }
        
        return maxTime;
    }
    
}
