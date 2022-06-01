package primitives;

public class Material {
    public Double3 kD = Double3.ZERO;
    public Double3 kS = Double3.ZERO;

    public int nShininess = 0;

    /**
     * Transparency ratio
     */
    public Double3 kT =Double3.ZERO;

    /**
     * Reflection ratio ratio
     */
    public Double3 kR = Double3.ZERO;

    /**
     * Setter for kD
     * @param kD
     * @return
     */
    public Material setkD(Double3 kD) {
        this.kD = kD;
        return this;
    }

    /**
     * Setter for kS
     * @param kS
     * @return
     */
    public Material setkS(Double3 kS) {
        this.kS = kS;
        return this;
    }

    /**
     * Setter for nShininess
     * @param nShininess
     * @return
     */
    public Material setnShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    /**
     * Setter for kD
     * @param kD
     * @return
     */
    public Material setkD(double kD) {

        this.kD = new Double3(kD);
        return this;
    }

    /**
     * Setter for kS
     * @param kS
     * @return
     */
    public Material setkS(double kS) {
        this.kS = new Double3(kS);
        return this;
    }


    public Double3 getkD() {
        return kD;
    }

    public Double3 getkS() {
        return kS;
    }

    public int getnShininess() {
        return nShininess;
    }

    public Double3 getkT() {
        return kT;
    }

    public Double3 getkR() {
        return kR;
    }

    public Material setkT(double kT) {
        this.kT = new Double3(kT);
        return this;
    }

    public Material setkR(double kR) {
        this.kR = new Double3(kR);
        return this;
    }
}