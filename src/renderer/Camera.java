package renderer;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.isZero;

public class Camera {
	
	private Point _p0;       //camera eye
    private Vector _vUp,_vTo,_vRight;    
    private double _distance;        // camera's distance from View Plane
    private double _width;           // ViewPlane's width
    private double _height;          // ViewPlane's height
    
    
    /***********getters************/
    
	public Point getP0() {
		return _p0;
	}
	
	
	public Vector getvUp() {
		return _vUp;
	}
	
	public Camera(Point p0,Vector vTo,Vector vUp){
		if(!isZero(vTo.dotProduct(vUp))) {
			throw new IllegalArgumentException("vTo and vUp should be orthogonal");
		}
		
		 _p0 = p0;

	        // normalizing the positional vectors
	        _vTo = vTo.normalize();
	        _vUp = vUp.normalize();

	        _vRight = _vTo.crossProduct(_vUp);

	}
	
	public Vector getvTo() {
		return _vTo;
	}
	
	public Vector getvRight() {
		return _vRight;
	}
	
	public double getDistance() {
		return _distance;
	}
	
	public double getWidth() {
		return _width;
	}
	
	public double getHeight() {
		return _height;
	}
	public Camera setVPSize(double width,double height) {
		_width=width;
		_height=height;
		return this;
		
	}
	public Camera setVPDistance(double distance) {
		_distance=distance;
		return this;
		
	}
	/**
	 * 
	 * @param nX
	 * @param nY
	 * @param j
	 * @param i
	 * @return
	 */
	public Ray constructRay(int nX, int nY, int j, int i) {
		// Image center
        Point Pc = _p0.add(_vTo.scale(_distance));

        // Ratio (pixel width & height)
        double Ry = _height/ nY;
        double Rx = _width/ nX;

        // Pixel [i,j] center
        Point Pij= Pc;

        // delta values for going to Pixel[i,j] from Pc
        double yI= -(i - (nY-1)/2d)*Ry;
        double xJ= (j - (nX-1)/2d)*Rx;
        if(! isZero(xJ) ) {
            Pij = Pij.add(_vRight.scale(xJ));
        }

        if (! isZero(yI) ) {
            Pij= Pij.add(_vUp.scale(yI));
        }

        return new Ray(_p0, Pij.subtract(_p0));



	}
	

    
    

    

}
