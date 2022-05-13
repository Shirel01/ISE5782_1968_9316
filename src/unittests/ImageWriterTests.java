package unittests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import primitives.Color;
import renderer.ImageWriter;
import static primitives.Color.BLACK;

class ImageWriterTests {

	 @Test
	    void testWriteToImage() {
	        ImageWriter imageWriter = new ImageWriter("testblue", 800, 500);
	        Color blue = new Color(0, 0, 255);
	        for (int i = 0; i < imageWriter.getNy(); i++) {
	            for (int j = 0; j < imageWriter.getNx(); j++) {
	                if (i % 50 == 0 || j % 50 == 0) {
	                    imageWriter.writePixel(j, i, BLACK);
	                } else {
	                    imageWriter.writePixel(j, i, blue);
	                }

	            }
	        }

	        imageWriter.writeToImage();
	    }

}
