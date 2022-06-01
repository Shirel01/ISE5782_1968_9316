package lighting;

import primitives.Color;
import primitives.Double3;

public class AmbientLight extends Light{
	Color _intensity;
	
	public AmbientLight(Color Ia,double Ka){
		super(Ia.scale(Ka));
	}
	
	public AmbientLight()
    {
        super(Color.BLACK);
        
    }
}
