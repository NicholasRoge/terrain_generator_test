/**
 * 
 */
package roge.terraingeneratortest.terrain;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Nicholas Rogé
 *
 */
public class TerrainGenerator{    
    private int              __num_tiles_horizontal;
    private int              __num_tiles_vertical;
    private Terrain[][]      __terrain_map;
    
    private Terrain[] __available_terrain_types;
    
    
    /*Begin Constructors*/
    public TerrainGenerator(int num_vertical_tiles,int num_horizontal_tiles,Terrain[] terrain_types){
        this.__num_tiles_horizontal=num_horizontal_tiles;
        this.__num_tiles_vertical=num_vertical_tiles;
        
        if(terrain_types==null || terrain_types.length==0){
        	throw new IllegalArgumentException("There must be at least one terrain type available.");
        }        
        this.__available_terrain_types=terrain_types;
        
        this._generate();
    }
    /*End Constructors*/
    
    /*Begin Getter Methods*/
    public int getNumTilesHorizontal(){
    	return this.__num_tiles_horizontal;
    }
    
    public int getNumTilesVertical(){
    	return this.__num_tiles_vertical;
    }
    
    public Terrain getTerrainAt(int row,int column){
    	if(row<0||row>this.__num_tiles_vertical){
    		throw new IndexOutOfBoundsException();
    	}
    	if(column<0||column>this.__num_tiles_horizontal){
    		throw new IndexOutOfBoundsException();
    	}
    	
    	
    	return this.__terrain_map[row][column];
    }
    
    public Terrain[][] getTerrainMap(){
    	return this.__terrain_map;
    }
    /*End Getter Methods*/
    
    /*Begin Other Essential Methods*/    
    protected void _generate(){
        Random   random=null;
        double   random_number=0;
        List<Terrain> spawn_chance_list=null;
        int      spawn_chance=0;
        Terrain[][] surrounding=null;
        Terrain  terrain=null;
        
        
        this.__terrain_map=new Terrain[this.__num_tiles_horizontal][this.__num_tiles_vertical];
        random=new Random(System.currentTimeMillis());
        
        spawn_chance_list=new ArrayList<Terrain>();
        for(int x=0;x<this.__num_tiles_horizontal;x++){
            for(int y=0;y<this.__num_tiles_vertical;y++){
            	for(int i=0;i<this.__available_terrain_types.length;i++){
            		surrounding=new Terrain[3][3];
            		for(int x_inner=0;x_inner<surrounding.length;x_inner++){
            			for(int y_inner=0;y_inner<surrounding[x_inner].length;y_inner++){
            				if((x_inner+x)-1<0||(x_inner+x)-1>=this.__num_tiles_horizontal||(y_inner+y)-1<0||(y_inner+y)-1>=this.__num_tiles_vertical){
            					surrounding[x_inner][y_inner]=null;
            				}else{
            					surrounding[x_inner][y_inner]=this.__terrain_map[(x_inner+x)-1][(y_inner+y)-1];
            				}
            				
            				if(x_inner==1&&y_inner==1){
            					surrounding[1][1]=null;  //Center element is the one we're calcuately the spawn chance for.
            				}
            			}
            		}
            		
            		spawn_chance=this.__available_terrain_types[i].chance(new Terrain[][]{});
            		for(int n=0;n<spawn_chance;n++){
            			spawn_chance_list.add(this.__available_terrain_types[i]);
            		}
            	}
            	
            	this.__terrain_map[x][y]=spawn_chance_list.get(random.nextInt(spawn_chance_list.size()));
            }
        }
    }
    /*End Other Essential Methods*/
}
