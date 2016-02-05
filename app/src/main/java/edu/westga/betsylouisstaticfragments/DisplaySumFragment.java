package edu.westga.betsylouisstaticfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplaySumFragment extends Fragment {


    private TextView tvSum;
    private double sum;
    private double number1;
    private double number2;

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public DisplaySumFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_display_sum, container, false);

        this.tvSum = (TextView)theView.findViewById(R.id.tvSum);

        return theView;
    }

    public void add() {
        this.sum = this.number1 + this.number2;
    }

    public void displaySum() {
        this.tvSum.setText(String.valueOf(this.sum));
    }

}
