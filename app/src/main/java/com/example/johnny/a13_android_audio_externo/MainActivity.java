package com.example.johnny.a13_android_audio_externo;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    Spinner spnCanciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnCanciones = (Spinner) findViewById(R.id.spnListSong);
        cargarCanciones();
    }

    public void cargarCanciones() {
        String[] canciones = { "conflict - Disturbed",
                "Indestructible - Disturbed" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, canciones);

        spnCanciones.setAdapter(adapter);
    }

    public void playSong(View v) {

        try {
            mp.reset();
        } catch (Exception e) {

        }

        String cancion = spnCanciones.getSelectedItem().toString();
        Uri datos;

        if (cancion.equals("conflict - Disturbed")) {
            datos = Uri.parse(Environment.getExternalStorageDirectory()
                    .getPath() + "/in.mp3");
        } else {
            datos = Uri.parse(Environment.getExternalStorageDirectory()
                    .getPath() + "/on.mp3");
        }

        mp = MediaPlayer.create(this, datos);
        mp.start();
    }

    public void pauseSong(View v) {
        mp.pause();
    }

    public void resumeSong(View view) {
        mp.start();
    }

    public void stopSong(View v) {
        mp.stop();
    }

    public void muteSong(View v) {
        mp.setVolume(0, 0);// volumen parlante izquierdo y derecho
    }

    public void noMuteSong(View view) {
        mp.setVolume(1, 1);// volumen parlante izquierdo y derecho
    }
}
