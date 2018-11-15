package com.example.android.task.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.task.R;
import com.example.android.task.database.entity.Task;
import com.example.android.task.view_models.AddViewModel;

/**
 * Created by Professor on 11/15/2018.
 */

public class AddFragment extends Fragment {

    private EditText editText;
    private Button button;
    private AddViewModel viewModel;
    private TextInputLayout inputLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        editText = view.findViewById(R.id.edit_text_add);
        button = view.findViewById(R.id.button_add);
        inputLayout = view.findViewById(R.id.input_addd);
        button.setOnClickListener((v) -> {
            if(validate()) {
                viewModel.addTask(new Task(editText.getText().toString()));
                getFragmentManager().popBackStack();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(AddViewModel.class);
        super.onActivityCreated(savedInstanceState);
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validate() {
        if(editText==null || editText.getText().toString().trim().isEmpty()) {
            inputLayout.setError("please enter a task");
            requestFocus(editText);
            return false;
        }
        inputLayout.setErrorEnabled(false);
        return true;
    }

    private class MyTextWatcher implements TextWatcher {
        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }


        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            if(view.getId()==R.id.input_addd) {
                validate();
            }
        }
    }
}
