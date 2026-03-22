package com.example.lab_2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity
        implements InputFragment.OnInputListener, ResultFragment.OnCancelListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, new InputFragment())
                .commit();
    }

    @Override
    public void onSendResult(String text) {
        ResultFragment fragment = ResultFragment.newInstance(text);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, fragment)
                .commit();
    }

    @Override
    public void onCancel() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main, new InputFragment())
                .commit();
    }
}