package com.example.lab_2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class InputFragment extends Fragment {
    private RadioGroup radioGroup;
    private CheckBox checkBox, checkBox2, checkBox3;
    private Button buttonOk;

    private OnInputListener listener;

    public interface OnInputListener {
        void onSendResult(String text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnInputListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);

        radioGroup = v.findViewById(R.id.radioGroup);
        checkBox = v.findViewById(R.id.checkBox);
        checkBox2 = v.findViewById(R.id.checkBox2);
        checkBox3 = v.findViewById(R.id.checkBox3);
        buttonOk = v.findViewById(R.id.buttonOk);

        buttonOk.setOnClickListener(view -> {
            int id = radioGroup.getCheckedRadioButtonId();

            if (id == -1) {
                Toast.makeText(getContext(), "Оберіть діаметр!", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton rb = v.findViewById(id);

            StringBuilder res = new StringBuilder("Діаметр: ").append(rb.getText()).append("\n");

            res.append("\nДодаткові опції:\n");

            boolean hasOption = false;

            if (checkBox.isChecked()) {
                res.append("- Додатковий сир\n");
                hasOption = true;
            }

            if (checkBox2.isChecked()) {
                res.append("- Безглютенове тісто\n");
                hasOption = true;
            }

            if (checkBox3.isChecked()) {
                res.append("- Борт хот-дог\n");
            }

            if (!hasOption) {
                res.append("Не обрано\n");
            }

            listener.onSendResult(res.toString());
        });

        return v;
    }
}