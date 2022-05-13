package renderer;

import primitives.Color;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import static primitives.Util.isZero;

import java.util.MissingResourceException;

public class Camera {
	
	private Point _p0;       //camera eye
    private Vector _vUp,_vTo,_vRight;    
    private double _distance=10;        // camera's distance from View Plane
    private double _width=500;           // ViewPlane's width
    private double _height=500;        // ViewPlane's height
    private ImageWriter _imageWriter;
    private RayTracerBase _rayTracer;
    
    /***********getters************/                   /******     Add setters????,,****/
    
	public Point getP0() {
		return _p0;
	}

	public Vector getvUp() {
		return _vUp;
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
	public Camera setCamera() {
        return this;
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

	
	public ImageWriter getImageWriter() {
		return _imageWriter;
	}
	
	public Camera setImageWriter(ImageWriter _imageWriter) {
		this._imageWriter = _imageWriter;
		return this;
	}
	

	/**
	 * Constructing a ray through a pixel
     *
	 * @param Nx = number of columns
     * @param Ny = number of rows
     * @param j  = pixel's column
     * @param i  = pixel's row
     * @return ray for the camera to Pixel[i,j]
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
	 /**
     * @param up    delta for _vUp vector
     * @param right delta for _vRight vector
     * @param to    delta for _vTo vector
     * @return
     */
    public Camera moveCamera(double up, double right, double to) {
        if (up == 0 && right == 0 && to == 0) return this;
        if (up != 0) this._p0.add(_vUp.scale(up));
        if (right != 0) this._p0.add(_vRight.scale(right));
        if (to != 0) this._p0.add(_vTo.scale(to));
        return this;
    }

    /**
     * @param axis  turning axis
     * @param theta angle to turn the camera
     * @return
     */
    public Camera turnCamera(Vector axis, double theta) {
        if (theta == 0) return this;
        this._vUp.rotateVector(axis, theta);
        this._vRight.rotateVector(axis, theta);
        this._vTo.rotateVector(axis, theta);
        return this;
    }

   

    public Camera setRayTracer(RayTracerBasic rayTracerBase) {
        this._rayTracer = rayTracerBase;
        return this;
    }



    public void renderImage() {
        try {
            if (_imageWriter == null) {
                throw new MissingResourceException("missing resource", ImageWriter.class.getName(), "");
            }

            // if (this== null) {
            //      throw new MissingResourceException("missing resource", Camera.class.getName(), "");
            //  }
            if (_rayTracer == null) {
                throw new MissingResourceException("missing resource", RayTracerBase.class.getName(), "");
            }
            //rendering the image
            int nX = _imageWriter.getNx();
            int nY = _imageWriter.getNy();
            for (int i = 0; i < nX; i++) {
                for (int j = 0; j < nY; j++) {
                    Ray ray = constructRay(nX, nY, j, i);
                    Color pixelColor = _rayTracer.traceRay(ray,true);
                    _imageWriter.writePixel(j, i, pixelColor);
                }
            }
            
        } catch (MissingResourceException e) {
            throw new UnsupportedOperationException("Not implemented yet" + e.getClassName());
        }
    }

    /**
     * Produces a pixel-sized matrix of the view plane and colors rows and columns
     *
     * @param interval the space between the rows and columns
     * @param color    the color of the grid
     * @throws MissingResourceException if image writer for the render is missing
     */
    public void printGrid(int interval, Color color) {
        if (_imageWriter == null) {
            throw new MissingResourceException("missing resource", ImageWriter.class.getName(), "");
        }
        int nX = _imageWriter.getNx();
        int nY = _imageWriter.getNy();
        for (int i = 0; i < nY; i++) {
            for (int j = 0; j < nX; j++) {
                if (i % interval == 0 || j % interval == 0) {
                    _imageWriter.writePixel(j, i, color);
                }
            }
        }
    }

    /**
     * produces unoptimized png file of the image according
     * to pixel color matrix in the directory of the project
     *
     * @throws MissingResourceException if image writer for the render is missing
     */
    public void writeToImage() {
        if (_imageWriter == null) {
            throw new MissingResourceException("missing resource", ImageWriter.class.getName(), "");
        }
        _imageWriter.writeToImage();
    }


}

    
    

    


