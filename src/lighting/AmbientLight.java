package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {
	Color _intensity;
	
	public AmbientLight(Color Ia,Double3 Ka){
		_intensity=Ia.scale(Ka);
	}
	
	public Color getIntensity() {
		return _intensity;
	}
}
