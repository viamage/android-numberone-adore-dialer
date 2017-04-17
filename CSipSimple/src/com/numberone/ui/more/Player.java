package com.numberone.ui.more;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.numberone.R;

public class Player extends Activity implements Runnable, OnClickListener, OnSeekBarChangeListener{
	
	 private SeekBar seekBar;
	 private Button startMedia;
	 private MediaPlayer mediaPlayer; 
	 private Boolean playing=false;
	private TextView name;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playing);
		mediaPlayer = new MediaPlayer();
		 AudioControl();
	}
	public void onPause(){
		super.onPause();
		mediaPlayer.stop();
	}
	public void onResume(){
		super.onResume();
		String str=getIntent().getStringExtra("media-file");
		play(str);
		name.setText(str);
	}
	private void play(String name) {

		try {
	//		findViewById(R.id.controls).setVisibility(View.VISIBLE);
			playing=true;
			startMedia.setBackgroundResource(R.drawable.ic_pause);
		//	stopped=false;
			String PATH_TO_FILE = Environment.getExternalStorageDirectory()
					.getPath() + "/AdoreSoftphone/records/"+name;
			Log.e(Environment.getExternalStorageDirectory().getPath()
					+ "/AdoreSoftphone/records" + name,PATH_TO_FILE);
			mediaPlayer.setDataSource(PATH_TO_FILE);
			mediaPlayer.prepare();
			mediaPlayer.start();
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());
            new Thread(this).start();
		//	Toast.makeText(this, PATH_TO_FILE, Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void AudioControl(){
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        startMedia = (Button) findViewById(R.id.play);
        name= (TextView) findViewById(R.id.name);
        startMedia.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);
    }

    public void run() {
        int currentPosition= 0;
        int total = mediaPlayer.getDuration();
        while (mediaPlayer!=null && currentPosition<total) {
            try {
                Thread.sleep(100);
                currentPosition= mediaPlayer.getCurrentPosition();
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }            
            seekBar.setProgress(currentPosition);
        }
    }
    public void onClick(View v) {
        if (v.equals(startMedia)) {
        	if(!playing)
        	{startMedia.setBackgroundResource(R.drawable.ic_pause);
        		playing=true;
            if (mediaPlayer != null && mediaPlayer.isPlaying()) return;
            if(seekBar.getProgress() > 0) {
                mediaPlayer.start();
                return;
            }
            mediaPlayer.start();                     
            seekBar.setProgress(0);
            seekBar.setMax(mediaPlayer.getDuration());
            new Thread(this).start();
        
        }
        	else
        	{
        		startMedia.setBackgroundResource(R.drawable.ic_play);
        		mediaPlayer.pause();
        	//	stopped=true;
        		playing=false;
        	//	findViewById(R.id.controls).setVisibility(View.GONE);
        	}
        	}
  

    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public void onProgressChanged(SeekBar seekBar, int progress,
            boolean fromUser) {
        if(fromUser) mediaPlayer.seekTo(progress);

    }
}
