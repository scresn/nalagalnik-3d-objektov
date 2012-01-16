package edu.SimonCresnjovnjak.nalagalnik;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.loaders.obj.ObjLoader;

public class ObjLoaderProg implements ApplicationListener
{
    String torus;
    Mesh model;
//    private PerspectiveCamera camera;
    private OrthographicCamera camera;
    private Texture texture = null;
    
    @Override
    public void create()
    {
    	rotationSpeed = 0.8f;
        InputStream stream = null;
        
        try 
        {
            stream = new FileInputStream(Gdx.files.internal("trashbin.obj").path());
            
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        
        model = ObjLoader.loadObj(stream, true);
        FileHandle imageFileHandle = Gdx.files.internal("brick01.jpg"); 
        texture = new Texture(imageFileHandle);
        Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
        Gdx.gl10.glTranslatef(0.0f,0.0f,-3.0f);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void pause() {
    }

    protected float rotateZ=0.01f;
    protected float increment=0.01f;
    private float rotationSpeed;
    
    @Override
    public void render() 
    {
    	
        Gdx.gl.glEnable(GL10.GL_DEPTH_TEST);
        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        Gdx.graphics.getGL10().glEnable(GL10.GL_TEXTURE_2D);
        camera.update();
        camera.apply(Gdx.gl10);
    
        Gdx.gl10.glTranslatef(0.0f,0.0f,-3.0f);
        Gdx.gl10.glRotatef(rotateZ, rotateZ, 5.0f, rotateZ);
        model.render(GL10.GL_TRIANGLES);
        
        Navigacijske_tipke();
    }

    @Override
    public void resize(int arg0, int arg1) 
    {
    	
       float aspectRatio = (float) arg0 / (float) arg1;
        camera = new OrthographicCamera(2f * aspectRatio, 2f);
        camera.near=0.1f;
        camera.translate(0, 0f, 0);

    }

    
    private void Navigacijske_tipke() 
    {        	
    	  if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
    	         camera.rotate(-rotationSpeed, 0,0 , 1);
    	        }
    	        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
    	                camera.rotate(rotationSpeed, 0, 0, 1);
    	        }
    	        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
    	            camera.rotate(rotationSpeed, 0, 1, 0);
    	        }
    	        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
    	            camera.rotate(rotationSpeed, 0, -1, 0);
    	        }
    	        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
    	            camera.rotate(rotationSpeed, 1, 0, 0);
    	        }
    	        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
    	            camera.rotate(-rotationSpeed, 1, 0, 0);
    	        }
    	        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
    	            camera.zoom += 0.02;
    	        }
    	        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
    	            camera.zoom-=0.02;
    	        }
    }
    @Override
    public void resume() {
    }
}
