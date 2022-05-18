package lighting;

import primitives.Color;

/**
 * Abstract class to implement a light source
 */
abstract class Light {
    /**
     * Color's intensity
     */
     private Color _intensity;

    /**
     * Constructor
     * @param color color of the color
     */
    protected Light(Color color) {
        this._intensity = color;
    }

    /**
     * Get intensity color of the light
     * @return the intensity color
     */
    public Color getIntensity() {
        return _intensity;
    }
}