package vn.edu.poly.demothi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class PhoneHolder extends RecyclerView.ViewHolder {


    public TextView tvID;
    public TextView tvName;
    public TextView tvPrice;
    public Button btnDel;

    public PhoneHolder(@NonNull View itemView) {
        super(itemView);

        btnDel = itemView.findViewById(R.id.btnDel);
        tvID = itemView.findViewById(R.id.tvID);
        tvName = itemView.findViewById(R.id.tvName);
        tvPrice = itemView.findViewById(R.id.tvPrice);

    }
}
