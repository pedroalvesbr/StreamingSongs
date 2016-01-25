package com.prgguru.example;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MusicAndroidActivity extends Activity {

	static MediaPlayer mPlayer;
	Button buttonPlay;
    Button buttonNext;
	Button buttonStop;
	String url1 = "http://soundfox.me/audio/2015/11/10-Amy-Winehouse-Tears-Dry-On-Their-Own.mp3";
    String url2 = "http://soundfox.net/audio/21.%20Pink%20Floyd%20-%20Nervana.mp3";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		buttonPlay = (Button) findViewById(R.id.play);
		buttonPlay.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				mPlayer = new MediaPlayer();
				mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
				try {
					mPlayer.setDataSource(url1);
				} catch (IllegalArgumentException e) {
					Toast.makeText(getApplicationContext(), "Verifique sua conexao com a rede!", Toast.LENGTH_LONG).show();
				} catch (SecurityException e) {
					Toast.makeText(getApplicationContext(), "Você ainda nao possui essa playlist!", Toast.LENGTH_LONG).show();
				} catch (IllegalStateException e) {
					Toast.makeText(getApplicationContext(), "Verifique sua conexao com a rede!", Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					mPlayer.prepare();
				} catch (IllegalStateException e) {
					Toast.makeText(getApplicationContext(), "Verifique sua conexao", Toast.LENGTH_LONG).show();
				} catch (IOException e) {
					Toast.makeText(getApplicationContext(), "Verifique sua conexaov", Toast.LENGTH_LONG).show();
				}
				mPlayer.start();


			}
		});
        //Botão Next
        buttonNext = (Button) findViewById(R.id.next);
        buttonNext.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mPlayer.isPlaying()){
                    mPlayer.stop();
                }
                mPlayer = new MediaPlayer();
                mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mPlayer.setDataSource(url2);
                } catch (IllegalArgumentException e) {
                    Toast.makeText(getApplicationContext(), "Verifique sua conexao com a rede!", Toast.LENGTH_LONG).show();
                } catch (SecurityException e) {
                    Toast.makeText(getApplicationContext(), "Você ainda nao possui essa playlist!", Toast.LENGTH_LONG).show();
                } catch (IllegalStateException e) {
                    Toast.makeText(getApplicationContext(), "Verifique sua conexao com a rede!", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mPlayer.prepare();
                } catch (IllegalStateException e) {
                    Toast.makeText(getApplicationContext(), "Verifique sua conexao", Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(getApplicationContext(), "Verifique sua conexaov", Toast.LENGTH_LONG).show();
                }
                mPlayer.start();

            }
        });


    //botão Parar
        buttonStop = (Button) findViewById(R.id.stop);
		buttonStop.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(mPlayer!=null && mPlayer.isPlaying()){
					mPlayer.stop();
				}
			}
		});
	}
    //metodo para botão Sair
	protected void onDestroy() {
		super.onDestroy();
		// TODO Auto-generated method stub
		if (mPlayer != null) {
			mPlayer.release();
			mPlayer = null;
		}
	}

    //metodo do botão Voltar
    public void Voltar (View view){
        Intent back = new Intent (this, LoginActivity.class);
        startActivity(back);
    }

}
