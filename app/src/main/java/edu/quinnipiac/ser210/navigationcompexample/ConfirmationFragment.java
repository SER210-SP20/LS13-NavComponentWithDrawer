package edu.quinnipiac.ser210.navigationcompexample;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmationFragment extends Fragment {


    private float money;
    private String recipient;

    public ConfirmationFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String confirmationMessag =  "You sent " + money + " to " + recipient;
        ((TextView) view.findViewById(R.id.confirmation_message)).setText(confirmationMessag);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        money = getArguments().getFloat("amount");
        recipient = getArguments().getString("recipient");
    }
}
