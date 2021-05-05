package com.graillsain.graillsain.OrderDetailsPage;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;
        import android.widget.SeekBar;
        import android.widget.Spinner;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

        import com.graillsain.graillsain.CartPage.CartAdapter;
        import com.graillsain.graillsain.Models.Order;
        import com.graillsain.graillsain.Models.Storage;
        import com.graillsain.graillsain.R;

        import java.util.ArrayList;

public class OrderDetails extends Fragment {
    private Order order;

    public OrderDetails(Order order) {
        this.order = order;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.page_order_details, container, false);

        ((TextView) rootView.findViewById(R.id.text_panier_id)).setText("Panier #"+this.order.getId());
        ((SeekBar) rootView.findViewById(R.id.seekBar)).setProgress(1);
        ((TextView) rootView.findViewById(R.id.text_order_details)).setText(this.order.toString());
        ((Button) rootView.findViewById(R.id.back_button_orderdetails)).setOnClickListener(click -> {
            getActivity().onBackPressed();
        });

        /*
        CartAdapter cartAdapter = new CartAdapter(getContext(), Storage.cartElements);
        ListView listView = rootView.findViewById(R.id.list_cart_consumer);
        listView.setAdapter(cartAdapter);

        Spinner sp = rootView.findViewById(R.id.availableSlots);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.support_simple_spinner_dropdown_item, Storage.availableSlotsForTakingOrder);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp.setAdapter(adapter);
        */


        return rootView;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }


}
