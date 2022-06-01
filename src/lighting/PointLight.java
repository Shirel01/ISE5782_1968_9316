package lighting;
import primitives.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * This class implements the Point Light source of the scene and inherits from Light
 */
public class PointLight extends Light implements LightSource {

    /**
     * Protected field of the class named _position
     * Position of the light
     */
    protected Point _position;

    /**
     * Protected field of the class named _radius
     */
    protected double _radius;

    /**
     * Parameters of the light :Three protected fields of the class
     * kC - Its purpose is to ensure that the light is not strengthened but weakened
     * kL - reduce factor of attenuation of light linear dependence
     * kQ - reduce factor of attenuation of light quadratic dependence
     */
    protected double kC = 1;
    protected double kL = 0;
    protected double kQ = 0;


    /**
     * constructor for PointLight
     *
     * @param c the light intensity
     * @param pos  Light start location
     */
    public PointLight(Color c, Point pos) {
        super(c);
        _position = pos;
    }

    /**
     * second constructor for PointLight with three parameters
     *
     * @param c the light intensity
     * @param pos  Light start location
     * @param radius
     */
    public PointLight(Color c, Point pos, double radius) {
        super(c);
        _position = pos;
        _radius = radius;
    }
    // Setters functions
    /**
     * Setter for kC reduce factor
     *
     * @param kC new kC
     * @return this PointLight
     */
    public PointLight setkC(double kC) {
        this.kC = kC;
        return this;
    }

    /**
     * Setter for kL reduce factor
     *
     * @param kL new kL
     * @return this PointLight
     */
    public PointLight setkL(double kL) {
        this.kL = kL;
        return this;
    }

    /**
     * Setter for kQ reduce factor
     *
     * @param kQ new kQ
     * @return this PointLight
     */
    public PointLight setkQ(double kQ) {
        this.kQ = kQ;
        return this;
    }



    /**
     * Get the intensity of the light at the point the light strikes
     *
     * @param p point where the light strikes
     * @return the color of the point
     */
    @Override
    public Color getIntensity(Point p) {
        double factor =kC;
        double distance;
        try {
            distance = _position.distance(p);
            factor += kL * distance + kQ * distance * distance;
        } catch (Exception exception) {
        }

        return _intensity.scale(1 / factor);
    }

    /**
     * Get the the direction of the light to the point where its strikes
     *
     * @param p point where the light strikes
     * @return the direction (normalized) and if not null
     */
    @Override
    public Vector getL(Point p) {
        try {
            return p.subtract(this._position).normalize();
        } catch (Exception exception) {
            return null;
        }
    }

    /**
     * Get the distance between the starting point of the light source to some point
     *
     * @param point the point to calculate the distance from
     * @return the distance between and the point
     */
    public double getDistance(Point point) {
        return this._position.distance(point);

    }

    /**
     * Get the list of directions of the light to the point where it strikes
     * @param p the point
     * @return list of vectors
     */
    /**@Override
    public List<Vector> getListL(Point p) {
        Random r = new Random();
        List<Vector> vectors = new LinkedList();
        for (double i = -_radius; i < _radius; i += _radius / 10) {
            for (double j = -_radius; j < _radius; j += _radius / 10) {
                if (i != 0 && j != 0) {
                    Point point = _position.add(new Vector(i, 0.1d, j));
                    if (point.equals(_position)){
                        vectors.add(p.subtract(point).normalize());
                    }
                    else{
                        try{
                            if (point.subtract(_position).dotProduct(point.subtract(_position)) <= _radius * _radius){
                                vectors.add(p.subtract(point).normalize());
                            }
                        }
                        catch (Exception e){
                            vectors.add(p.subtract(point).normalize());
                        }

                    }
                }

            }
        }
        vectors.add(getL(p));
        return vectors;
    }*/
}