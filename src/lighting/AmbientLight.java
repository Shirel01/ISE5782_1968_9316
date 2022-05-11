package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight {
	Color _intensity;
	AmbientLight(Color Ia,Double3 Ka){
		_intensity=Ia.scale(Ka);
	}
	
	AmbientLight(){
		_intensity=Color.BLACK;
	}
	
	Color getIntensity() {
		return _intensity;
	}
}
