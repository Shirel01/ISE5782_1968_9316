package scene;

import geometries.Geometries;
import lighting.AmbientLight;
import primitives.Color;
import primitives.Double3;

public class Scene {
	public final String _name;
	public Color _background;
	public AmbientLight _ambiantLight;
	public final Geometries _geometries;//=new Geometries();

	
	public Color get_background() {
		return _background;
	}



	public Scene setBackground(Color _background) {
		this._background = _background;
		return this;
	}



	public AmbientLight get_ambiantLight() {
		return _ambiantLight;
	}



	public Scene setAmbientLight(AmbientLight _ambiantLight) {
		this._ambiantLight = _ambiantLight;
		return this;
	}
	
	public Scene(String name){
		this._name=name;
		this._background = Color.BLACK;
		this._ambiantLight = new AmbientLight(Color.BLACK, new Double3(1.0,1.0,1.0));
		this._geometries= new Geometries();
	}
	
   

    public String getName() {
        return _name;
    }

}
