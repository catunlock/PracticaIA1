package IA.Electrica;

import aima.search.framework.HeuristicFunction;

public class ElectricaHeuristicFunction3 implements HeuristicFunction{
//		combinaci� dels dos objectius anteriors (+ecol�gica, + barata pel consumidor)
		 	  
	public double getHeuristicValue(Object state) 
	{
	   Electrica board= (Electrica) state;
	   return (board.obteValHeuristic(3));
	}
		 	  
	public boolean equals(Object obj) 
	{
		boolean retValue;
		retValue = super.equals(obj);
		return retValue;
	}
}
