package renderer;
import primitives.*;

import java.util.MissingResourceException;

import static primitives.Util.isZero;

/**
 * Camera producing rays through a View Plane
 */
public class Camera {

    //Private variables
    private Point p0;       //camera eye
    private Vector vUp;     // vector pointing upwards : Y axis
    private Vector vTo;     // vector pointing towards the scene
    private Vector vRight;  // vector pointing towards the right : X axis

    private double distance = 10;        // camera's distance from View Plane
    private double width = 500;           // ViewPlane's width
    private double height = 500;          // ViewPlane's height

    private ImageWriter _imageWriter;
    private RayTracerBase _rayTracer;

    //Getter functions of the privates variables

    public Point getP0() {
        return p0;
    }

    public Vector getVUp() {
        return vUp;
    }

    public Vector getVTo() {
        return vTo;
    }

    public Vector getVRight() {
        return vRight;
    }

    public double getDistance() {
        return distance;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }
    // chaining methods

    //setters Variables

    public void setP0(Point p0) {
        this.p0 = p0;
    }

    public void setvUp(Vector vUp) {
        this.vUp = vUp;
    }

    public void setvTo(Vector vTo) {
        this.vTo = vTo;
    }

    public void setvRight(Vector vRight) {
        this.vRight = vRight;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * @param p0  origin point in 3D space
     * @param vUp vector pointing upwards
     * @param vTo vector pointing towards
     */
    public Camera(Point p0, Vector vTo, Vector vUp) {
        if (!isZero(vTo.dotProduct(vUp))) {
            throw new IllegalArgumentException("vTo and vUp should be orthogonal");

        }

        this.p0 = p0;
        // normalizing the positional vectors
        this.vTo = vTo.normalize();
        this.vUp = vUp.normalize();

        this.vRight = this.vTo.crossProduct(this.vUp);


    }

    public Camera setCamera() {
        return this;
    }
    //getters


    /**
     * Sets distance between the camera and it's view plane
     *
     * @param distance the distance for the view plane
     * @return instance of the Camera for chaining
     */
    public Camera setVPDistance(double distance) {
        this.distance = distance;
        return this;
    }

    /**
     * Setting View Plane's size
     *
     * @param width  "physical" width
     * @param height "physical" height
     * @return instance of camera for chaining
     */
    public Camera setVPSize(double width, double height) {
        this.width = width;
        this.height = height;
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
    public Ray constructRay(int Nx, int Ny, int j, int i) {
        // Image center
        Point Pc = p0.add(vTo.scale(distance));

        // Ratio (pixel width & height)
        double Ry = height / Ny;
        double Rx = width / Nx;

        // Pixel [i,j] center
        Point Pij = Pc;

        // delta values for going to Pixel[i,j] from Pc
        double yI = -(i - (Ny - 1) / 2d) * Ry;
        double xJ = (j - (Nx - 1) / 2d) * Rx;


        if (!isZero(xJ)) {
            Pij = Pij.add(vRight.scale(xJ));
        }

        if (!isZero(yI)) {
            Pij = Pij.add(vUp.scale(yI));
        }

        return new Ray(p0, Pij.subtract(p0));
    }


    /**
     * @param up    delta for _vUp vector
     * @param right delta for _vRight vector
     * @param to    delta for _vTo vector
     * @return
     */
    public Camera moveCamera(double up, double right, double to) {
        if (up == 0 && right == 0 && to == 0) return this;
        if (up != 0) this.p0.add(vUp.scale(up));
        if (right != 0) this.p0.add(vRight.scale(right));
        if (to != 0) this.p0.add(vTo.scale(to));
        return this;
    }

    /**
     * @param axis  turning axis
     * @param theta angle to turn the camera
     * @return
     */
    public Camera turnCamera(Vector axis, double theta) {
        if (theta == 0) return this;
        this.vUp.rotateVector(axis, theta);
        this.vRight.rotateVector(axis, theta);
        this.vTo.rotateVector(axis, theta);
        return this;
    }

    public Camera setImageWriter(ImageWriter imageWriter) {
        this._imageWriter = imageWriter;
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