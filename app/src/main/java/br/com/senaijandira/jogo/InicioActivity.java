package br.com.senaijandira.jogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

public class InicioActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inicio);

    }

    public void inicio(View v){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        finish();

    }
}
