package roge.terraingeneratortest.terrain.terrains;

import roge.terraingeneratortest.terrain.Terrain;


public class Plains implements Terrain{
	/*Begin Overridden Methods*/
	@Override public int chance(Terrain[][] surrounding){
		int num_null=0;
		int num_plains=0;
		int num_others=0;
		
		
		for(int x=0;x<surrounding.length;x++){  //Should always be 3, but we don't want to be wrong, eh?
			for(int y=0;y<surrounding[x].length;y++){
				if(surrounding[x][y]!=null){
					if(surrounding[x][y] instanceof Plains){
						num_plains++;
					}else{
						num_others++;
					}
				}else{
					num_null++;
				}
			}
		}
		
		if(num_plains==8-num_null){
			return 100;
		}else if(num_plains>num_others){
			return 60;
		}else{
			return 40;
		}
	}
	
	@Override public String getName(){
		return "P";
	}
	/*End Overridden Methods*/
}
