/**
 * 
 */
package primitives;

/**
 * @author *
 */
public class Vector extends Point {

	/**
	 * constructor
	 */
	public Vector(double n, double n1, double n2) {
		super(n, n1, n2);
		if (n == 0 && n1 == 0 && n2 == 0) {
			throw new IllegalArgumentException("zero vector");
		}
	}

	public Vector(Double3 xyz) {
		super(xyz);
		if (xyz.d1 == 0 && xyz.d2 == 0 && xyz.d3 == 0) {
			throw new IllegalArgumentException("zero vector");
		}
	}

	public Vector add(Vector v) {
		return new Vector(super.add(v).xyz);
	}

	public Vector scale(double n) {
		return new Vector(this.xyz.d1 * n, this.xyz.d2 * n, this.xyz.d3 * n);
	}

	public double dotProduct(Vector other) {
		return xyz.d1 * other.xyz.d1 + xyz.d2 * other.xyz.d2 + xyz.d3 * other.xyz.d3;
	}

	public Vector crossProduct(Vector other) {
		double ax = xyz.d1;
		double ay = xyz.d2;
		double az = xyz.d3;

		double bx = other.xyz.d1;
		double by = other.xyz.d2;
		double bz = other.xyz.d3;

		double cx = ay * bz - az * by;
		double cy = az * bx - ax * bz;
		double cz = ax * by - ay * bx;

		return new Vector(cx, cy, cz);
	}

	public double lengthSquared() {
		return xyz.d1 * xyz.d1 + xyz.d2 * xyz.d2 + xyz.d3 * xyz.d3;
	}

	public double length() {
		return Math.sqrt(lengthSquared());
	}

	public Vector normalize() {
		double len = length();
		return new Vector(xyz.reduce(len));
	}
	
/*
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Point))
			return false;
		Point other = (Point) obj;
		return super.equals(other);
	}*/

	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
	return (this.xyz.equals(((Vector)obj).xyz ));
		//return true;
	}

	@Override
	public String toString() {
		return "->" + super.toString();
	}

}
