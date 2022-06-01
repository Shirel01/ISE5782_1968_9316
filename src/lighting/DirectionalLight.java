package lighting;
import primitives.Color;
import primitives.Point;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{

    private Vector _direction;

    public DirectionalLight(Color color,Vector direction) {
        super(color);
        _direction = direction.normalize();
    }

    @Override
    public Color getIntensity(Point p) {
        return null;
    }

    @Override
    public Vector getL(Point p) {
        return _direction;
    }

	@Override
	public double getDistance(Point point) {
		
		return Double.POSITIVE_INFINITY;
	}
	
}