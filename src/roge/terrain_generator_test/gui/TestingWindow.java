package roge.terrain_generator_test.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import roge.gui.RWindow;
import roge.terraingeneratortest.terrain.TerrainGenerator;
import roge.terraingeneratortest.terrain.Terrain;
import roge.terraingeneratortest.terrain.terrains.*;

public class TestingWindow extends RWindow {
	private Terrain[][] __terrain_map;
	
	
	/*Begin Constructors*/
	public TestingWindow(){
		super("Terrain Generator Test");
	}
	/*End Constructors*/
	
	@Override protected void _addContent(JPanel arg0) {
		TerrainGenerator generator=null;
	
	
		generator=new TerrainGenerator(100,100,new Terrain[]{new Plains(),new ShallowWater()});
		this.__terrain_map=generator.getTerrainMap();
		
		JPanel panel=new JPanel(){
			@Override public void paint(Graphics g){
				for(int x=0;x<TestingWindow.this.__terrain_map.length;x++){
					for(int y=0;y<TestingWindow.this.__terrain_map[x].length;y++){
						if(TestingWindow.this.__terrain_map[x][y] instanceof Plains){
							g.setColor(Color.GREEN);
						}else{
							g.setColor(Color.BLUE);
						}
						
						g.drawRect(x*4,y*4,2,2);
					}
				}
				
			}
		};
		
		
		arg0.setLayout(new GridLayout(1,1));
		arg0.add(panel);
		this.setSize(new Dimension(400,400));
	}

}
