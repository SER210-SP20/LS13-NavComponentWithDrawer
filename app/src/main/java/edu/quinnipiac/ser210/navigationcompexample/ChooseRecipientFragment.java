package edu.quinnipiac.ser210.navigationcompexample;


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

import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChooseRecipientFragment extends Fragment implements View.OnClickListener {

    NavController navController = null;


    public ChooseRecipientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        view.findViewById(R.id.next_btn).setOnClickListener(this);
        view.findViewById(R.id.cancel_btn).setOnClickListener(this);
    }


  /*

}*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.next_btn:
                Bundle bundle = new Bundle();
                TextInputEditText ed = ((TextInputEditText)getView().findViewById(R.id.input_recipient));
                if (ed == null)
                    Log.e("TextInputEdit","cannot find TextInputEdit");
                String recipient = ed.getText().toString();
                if (!recipient.isEmpty()) {
                    bundle.putString("recipient", recipient);
                    Log.e("recipient","added to bundle");
                }
                else
                    Log.e("recipient","recipient empty");
                navController.navigate(R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle);
                break;
            case R.id.cancel_btn:
                getActivity().onBackPressed();
                break;
        }

    }
}
