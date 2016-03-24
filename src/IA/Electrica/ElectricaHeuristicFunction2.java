package IA.Electrica;

import aima.search.framework.HeuristicFunction;

public class ElectricaHeuristicFunction2 implements HeuristicFunction
{
//	 energica m�s barates pel consumdior
	 	  
	public double getHeuristicValue(Object state) 
	{
	   Electrica board= (Electrica) state;
	   return(board.obteValHeuristic(2));	
	 
	}
	 	  
	public boolean equals(Object obj) 
	{
		boolean retValue;
	 	retValue = super.equals(obj);
	 	return retValue;
	}
}
