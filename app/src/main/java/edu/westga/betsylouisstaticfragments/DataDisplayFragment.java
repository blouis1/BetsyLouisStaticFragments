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
public class DataDisplayFragment extends Fragment {


    private TextView tvProduct;
    private double number1;
    private double number2;
    private double product;

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    public DataDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View theView = inflater.inflate(R.layout.fragment_data_display, container, false);

        this.tvProduct = (TextView)theView.findViewById(R.id.tvProduct);


        return theView;
    }

    public void multiply() {
        this.product = this.number1 * this.number2;
    }

    public void displayProduct() {
        this.tvProduct.setText(String.valueOf(this.product));
    }

}
