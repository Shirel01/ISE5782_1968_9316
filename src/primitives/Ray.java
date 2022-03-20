package primitives;

public class Ray {
	final Vector dir;
	final Point p0;

	public Ray(Point newP,Vector newVec) {
		dir=newVec.normalize();	
		p0=newP;
	}
 public Vector getVector() {
	  return dir;
 }
  public Point getPoint() {
	  return p0;
  }
  @Override
  public String toString() {
	  return dir.toString()+p0.toString();
  }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Double3))
			return false;
		Ray other = (Ray) obj;
		return other.dir.equals(this.dir) && other.p0.equals(this.p0);
	}
}
