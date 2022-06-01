package scene;

import geometries.Geometries;
import lighting.*;
import primitives.Color;
import java.util.LinkedList;
import java.util.List;

//according to Dan Zilberstein's directives

/**
 * Class for implementation of the picture's scene
 */
public class Scene {

    /**
     * Sccene's Name
     */
    private final String name;
    /**
     * Background's color
     */
    public final Color background;

    public Scene setAmbientlight(AmbientLight ambientlight) {
        this.ambientlight = ambientlight;
        return this;
    }

    /**
     * Ambient light of the scene
     */
    public AmbientLight ambientlight;
    /**
     * Geometries in the scene
     */
    public final Geometries geometries;

    /**
     * Light sources of the scene
     */
    public List<LightSource> lights ;

    //Getters
    public String getName() {
        return name;
    }

    public Color getBackground() {
        return background;
    }

    public AmbientLight getAmbientlight() {
        return ambientlight;
    }

    public Geometries getGeometries() {
        return geometries;
    }

    /**
     * private constructor as part of the builder pattern
     *
     * @param builder the SceneBuilder
     */
    private Scene(SceneBuilder builder) {
        name = builder.name;
        background = builder.background;
        ambientlight = builder.ambientLight;
        geometries = builder.geometries;
        lights = builder.lights;
    }

    public Scene setLights(List<LightSource> lights) {
        this.lights = lights;
        return this;
    }

    public List<LightSource> getLights() {
        return lights;
    }

    /**
     * Builder of the scene
     */
    public static class SceneBuilder {
        private final String name;
        private Color background = Color.BLACK;
        private AmbientLight ambientLight = new AmbientLight();
        private Geometries geometries = new Geometries();
        private List<LightSource> lights = new LinkedList<>();

        public SceneBuilder(String name) {
            this.name = name;
        }

        //chaining set methods (this NOT a builder pattern)

        //Setters

        /**
         * setter for background color
         *
         * @param background the new background color
         * @return this scene
         */
        public SceneBuilder setBackground(Color background) {
            this.background = background;
            return this;
        }

        /**
         * setter for ambient Light
         *
         * @param ambientLight the new ambientLight for the scene
         * @return this scene
         */
        public SceneBuilder setAmbientLight(AmbientLight ambientLight) {
            this.ambientLight = ambientLight;
            return this;
        }

        /**
         * setter for the geometries
         *
         * @param geometries the new geometries for the scene
         * @return this scene
         */
        public SceneBuilder setGeometries(Geometries geometries) {
            this.geometries = geometries;
            return this;
        }

        public Scene build() {
            Scene scene = new Scene(this);
            return scene;
        }

    }
}