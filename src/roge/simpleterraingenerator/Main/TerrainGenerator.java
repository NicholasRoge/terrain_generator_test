/**
 * 
 */
package roge.simpleterraingenerator.Main;

import java.awt.Dimension;
import java.util.Random;

/**
 * @author Nicholas Rogé
 *
 */
public class TerrainGenerator{
    public interface Terrain{
        double chance(Terrain[][] surrounding);
        
        String getName();
    }
    
    private int __num_tiles_horizontal;
    private int __num_tiles_vertical;
    
    
    
    /*Begin Constructors*/
    public TerrainGenerator(int num_vertical_tiles,int num_horizontal_tiles){
        this.__num_tiles_horizontal=num_horizontal_tiles;
        this.__num_tiles_vertical=num_vertical_tiles;
    }
    /*End Constructors*/
    
    /*Begin Other Essential Methods*/
    public void addTerrainType(Terrain terrain){
        
    }
    
    public int[][] generate(){
        Random  random=null;
        int[][] terrain=null;
        
        
        terrain=new int[this.__num_tiles_vertical][this.__num_tiles_horizontal];
        random=new Random(System.currentTimeMillis());
        
        for(int x=0;x<this.__num_tiles_horizontal;x++){
            for(int y=0;y<this.__num_tiles_vertical;y++){
                if(random.nextInt(1000)>=900){
                    
                }
            }
        }
        
        return terrain;
    }
    /*End Other Essential Methods*/
}
