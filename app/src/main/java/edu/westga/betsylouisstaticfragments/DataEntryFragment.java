package edu.westga.betsylouisstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataEntryFragment extends Fragment {


    private EditText etNumber1;
    private EditText etNumber2;
    private DataEntryListener listener;

    public DataEntryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_entry, container, false);

        this.etNumber1 = (EditText) theView.findViewById(R.id.number1);
        this.etNumber2 = (EditText) theView.findViewById(R.id.number2);

        Button multiplyButton = (Button) theView.findViewById(R.id.btnMultiply);
        multiplyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                multiplyButtonClicked(v);
            }
        });

        return theView;
    }

    public interface DataEntryListener {
        void onDataEntry(double number1, double number2);
    }

    private void multiplyButtonClicked(View v) {

        boolean isError = false;
        if (this.etNumber2.getText().toString().trim().length() == 0) {
            isError = true;
            this.etNumber2.setError("Please enter a number");
            this.etNumber2.requestFocus();
        }
        if (this.etNumber1.getText().toString().trim().length() == 0) {
            isError = true;
            this.etNumber1.setError("Please enter a number");
            this.etNumber1.requestFocus();
        }
        if (!isError) {
            double number1 = Double.parseDouble(this.etNumber1.getText().toString());
            double number2 = Double.parseDouble(this.etNumber2.getText().toString());
            this.listener.onDataEntry(number1, number2);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataEntryListener)context;
    }
}
