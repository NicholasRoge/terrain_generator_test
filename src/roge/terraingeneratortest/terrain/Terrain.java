package roge.terraingeneratortest.terrain;

public interface Terrain{
    int chance(Terrain[][] surrounding);
    
    String getName();
}
