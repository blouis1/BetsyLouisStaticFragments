package edu.westga.betsylouisstaticfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DataDisplayFragment extends Fragment {


    private TextView tvProduct;
    private double number1;
    private double number2;
    private double product;
    private DataAddListener listener;

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

        Button addButton = (Button) theView.findViewById(R.id.btnAdd);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addButtonClicked(v);
            }
        });

        return theView;
    }

    private void addButtonClicked(View v) {
        this.listener.onDataAdd();
    }

    public interface DataAddListener {
        void onDataAdd();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (DataAddListener)context;
    }

    public void multiply() {
        this.product = this.number1 * this.number2;
    }

    public void displayProduct() {
        this.tvProduct.setText(String.valueOf(this.product));
    }

}
