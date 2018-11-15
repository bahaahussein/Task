package com.example.android.task.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        editText = view.findViewById(R.id.edit_text_add);
        button = view.findViewById(R.id.button_add);
        button.setOnClickListener((v) -> {
            if(editText==null || editText.length()<=0)
                Toast.makeText(getContext(), "Missing fields", Toast.LENGTH_SHORT).show();
            else {
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
}
