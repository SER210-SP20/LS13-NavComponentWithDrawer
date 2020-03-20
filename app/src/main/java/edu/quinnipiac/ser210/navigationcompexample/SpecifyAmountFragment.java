package edu.quinnipiac.ser210.navigationcompexample;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * create an instance of this fragment.
 */
public class SpecifyAmountFragment extends Fragment implements View.OnClickListener {

    NavController navController = null;
    String recipient;
    public SpecifyAmountFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            recipient = getArguments().getString("recipient");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.send_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
        ((TextView)view.findViewById(R.id.recipient)).setText("Sending money to " + recipient);
    }


  /*

}*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.send_btn:
                EditText amountTv = (EditText) getView().findViewById(R.id.input_amount);
                float amount = Float.parseFloat(amountTv.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putFloat("amount", amount);

                bundle.putString("recipient", recipient);
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment,bundle);
                break;
            case R.id.cancel_btn:
                getActivity().onBackPressed();
                break;
        }

    }


}
