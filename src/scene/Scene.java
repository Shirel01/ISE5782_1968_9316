package scene;
import geometries.Geometries;
import lighting.*;
import primitives.Color;


import java.util.LinkedList;
import java.util.List;

public class Scene {
    private final String name;

    public final Color _background ;
    public final AmbientLight _ambientlight ;
    public final Geometries _geometries;

    List<LightSource> lights=new LinkedList<>();

    public String getName() {
        return name;
    }
    public Scene(SceneBuilder builder) {
        name = builder.name;
        _background=builder.background;
        _ambientlight=builder.ambientLight;
        _geometries= builder.geometries;
        lights=builder.lights;
    }

    public Color getBackground() {
        return _background;
    }
    public AmbientLight getAmbientlight() {
        return _ambientlight;
    }
    public Geometries getGeometries() {
        return _geometries;
    }
    public static class SceneBuilder{
        private final String name;
        private Color background=Color.BLACK;
        private AmbientLight ambientLight=new AmbientLight();
        private Geometries geometries=new Geometries();
        private  List<LightSource> lights=new LinkedList<>();

        public SceneBuilder(String name) {
            this.name = name;
        }
        //chaining set methods (this NOT a builder pattern)
    public SceneBuilder setBackground(Color background) {
        this.background = background;
        return  this;
    }
    public SceneBuilder setAmbientLight(AmbientLight ambientlight) {
        this.ambientLight = ambientlight;
        return this;
    }
    public SceneBuilder setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return  this;
    }
    public String getName() {
        return name;
    }
    public Scene build()
    {
        Scene scene =new Scene(this);
      
        return scene;
    }
    }
}