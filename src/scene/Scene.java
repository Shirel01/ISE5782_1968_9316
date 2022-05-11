package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.Color;

public class Scene {
	public final String _name;
	public final Color _background;
	public final AmbientLight _ambiantLight;
	public final Geometries _geometries;//=new Geometries();
	Scene(String name){
		_name=name;
	}
	
   

    public String getName() {
        return _name;
    }

}
