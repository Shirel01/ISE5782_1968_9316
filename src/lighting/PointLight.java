package lighting;


import primitives.*;
import static java.lang.Math.pow;


public class PointLight extends Light implements LightSource{

	protected Point position;
    protected double kC=1;
    protected double kL=0;
    protected double kQ=0;

    protected PointLight(Color intensity,Point position) {
        super(intensity);
      }


    @Override
    public Color getIntensity(Point p) {
        Color iO=getIntensity();
        double d= p.distance(position);
        double iL1= iO.rgb.d1/ (kC + (kL*d) + pow(kQ * d, 2));
        double iL2= iO.rgb.d2/ (kC + (kL*d) + pow(kQ * d, 2));
        double iL3= iO.rgb.d3/ (kC + (kL*d) + pow(kQ * d, 2));
        Double3 iLd=new Double3(iL1,iL2,iL3);
        Color iL=new Color(iL1,iL2,iL3);
        return iL;
    }

    @Override
    public Vector getL(Point p) {
        return null;
    }

    public PointLight setkC(double kC) {
        this.kC = kC;
        return this;
    }

    public PointLight setkL(double kL) {
        this.kL = kL;
        return this;
    }

    public PointLight setkQ(double kQ) {
        this.kQ = kQ;
        return this;
    }
}