package engineTester;

import org.lwjgl.opengl.Display;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {

		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		float[] vertices = { 
				//Left Bottom Triangle
				-0.5f, 0.5f, 0,   //V0
				-0.5f, -0.5f, 0,  //V1
				0.5f, -0.5f, 0,   //V2
				0.5f,0.5f, 0      //V3
		};
		int[] indices = {
				0,1,3, // top left triangle
				3,1,2 //bottom right triangle
		};
		
		RawModel model = loader.loadToVAO(vertices,indices);
		
		while(!Display.isCloseRequested()){
			renderer.prepare();
			//game logic
			renderer.render(model);
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
