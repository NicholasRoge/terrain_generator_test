/**
 * 
 */
package roge.simpleterraingenerator.Main;

/**
 * @author Nicholas Rog�
 */
public class Main{
    public static void main(String[] arguments){
        int[] terrain=null;
        TerrainGenerator generator=new TerrainGenerator(10,5);
        
        terrain=generator.generate();
    }
}
