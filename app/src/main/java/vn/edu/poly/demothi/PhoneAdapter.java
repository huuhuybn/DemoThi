package vn.edu.poly.demothi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneHolder> {


    private Context context;
    private List<Phone> phones;

    public PhoneAdapter(Context context, List<Phone> phones) {
        this.context = context;
        this.phones = phones;
    }

    @NonNull
    @Override
    public PhoneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, viewGroup,
                false);

        return new PhoneHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneHolder holder, final int i) {
        final Phone phone = phones.get(i);

        holder.tvID.setText(phone.id);
        holder.tvName.setText(phone.name);
        holder.tvPrice.setText(phone.price);

        holder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SqliteHelper sqliteHelper = new SqliteHelper(context);
                DAOPhone daoPhone = new DAOPhone(sqliteHelper);

                daoPhone.deletePhone(phone);
                phones.remove(i);

                notifyDataSetChanged();


            }
        });
    }

    @Override
    public int getItemCount() {
        return phones.size();
    }
}
