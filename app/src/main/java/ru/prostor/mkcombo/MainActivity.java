package ru.prostor.mkcombo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.prostor.mkcombo.mk10.MkxActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.open_mkx_activity)
    public void openMkxActivity(){
        Intent intent = new Intent(getApplicationContext(), MkxActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.open_mk11_activity)
    public void openMkxiActivity(){

    }
}
