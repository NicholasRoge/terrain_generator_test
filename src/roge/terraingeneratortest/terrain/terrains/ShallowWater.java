package roge.terraingeneratortest.terrain.terrains;

import roge.terraingeneratortest.terrain.Terrain;


public class ShallowWater implements Terrain{
	/*Begin Overridden Methods*/
	@Override public int chance(Terrain[][] surrounding){
		int num_shallow_water=0;
		int num_others=0;
		
		
		for(int x=0;x<surrounding.length;x++){  //Should always be 3, but we don't want to be wrong, eh?
			for(int y=0;y<surrounding[x].length;y++){
				if(surrounding[x][y]!=null){
					if(surrounding[x][y] instanceof Plains){
						num_shallow_water++;
					}else{
						num_others++;
					}
				}
			}
		}
		
		if(num_shallow_water>num_others){
			return 100;
		}else{
			return 20;
		}
	}
	
	@Override public String getName(){
		return "W";
	}
	/*End Overridden Methods*/
}
