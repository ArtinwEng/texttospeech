package com.wildapps.texttospeech;

//Robert Wildman 
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	public TextToSpeech ttobj;
	public EditText etinput;
	public String inputtext;
	public Button bready;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Setting up the Button and Edittext 
		etinput = (EditText)findViewById(R.id.etInput);
		bready = (Button)findViewById(R.id.bready);
		
		//Set up Button Click Listener
		bready.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Start a text to speech function
				 texttospeech(etinput.getText().toString());
				
			}
		});
		
		
		ttobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
			
			@Override
			public void onInit(int status) {
			
				if(status != TextToSpeech.ERROR)
				{
					//Can pick what language you want 
					ttobj.setLanguage(Locale.UK);
				}
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void texttospeech(String input)
	{
		//Will speak the input
		ttobj.speak(input, TextToSpeech.QUEUE_FLUSH, null);
	}

}
