package com.example.lab_2;

import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import androidx.fragment.app.Fragment;

public class ResultFragment extends Fragment {
    TextView resultText;
    Button buttonBack;

    OnCancelListener listener;

    public interface OnCancelListener {
        void onCancel();
    }

    public static ResultFragment newInstance(String resultText) {
        ResultFragment resultFragment = new ResultFragment();
        Bundle b = new Bundle();
        b.putString("text", resultText);
        resultFragment.setArguments(b);
        return resultFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnCancelListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_result, container, false);

        resultText = v.findViewById(R.id.textResult);
        buttonBack = v.findViewById(R.id.buttonBack);

        resultText.setText(
                getArguments().getString("text")
        );

        buttonBack.setOnClickListener(view -> listener.onCancel());
        return v;
    }
}