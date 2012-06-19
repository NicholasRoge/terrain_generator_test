package roge.terraingeneratortest.terrain.terrains;

import roge.terraingeneratortest.terrain.Terrain;


public class Water implements Terrain{
	/*Begin Overridden Methods*/
	@Override public int chance(Terrain[][] surrounding){
		return 100;
	}
	
	@Override public String getName(){
		return "Water";
	}
	/*End Overridden Methods*/
}
