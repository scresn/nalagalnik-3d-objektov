package edu.SimonCresnjovnjak.nalagalnik;

import com.badlogic.gdx.backends.jogl.JoglApplication;
import com.badlogic.gdx.files.FileHandle;

public class KockaNamizje 
{
	
	public static void main(String[] args) 
	{
        //new JoglApplication(new Kocka(), "Kocka", 480, 320, false);  
        new JoglApplication(new ObjLoaderProg(), "Kocka", 480, 320, false);  
	}

}
