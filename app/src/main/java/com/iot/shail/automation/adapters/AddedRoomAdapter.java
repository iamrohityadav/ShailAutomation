package com.iot.shail.automation.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.iot.shail.automation.models.AddedRoomModel;
import com.iot.shail.automation.R;
import java.util.List;

public class AddedRoomAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<AddedRoomModel> drawerMenuItems;

    public AddedRoomAdapter(Activity activity, List<AddedRoomModel> item) {
        this.activity = activity;
        this.drawerMenuItems = item;
    }

    @Override
    public int getCount() {
        return drawerMenuItems.size();
    }

    @Override
    public Object getItem(int location) {
        return drawerMenuItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) convertView = inflater.inflate(R.layout.added_room_list_item, null);

        TextView room_name = convertView.findViewById(R.id.room_name_text_view);
        ImageView room_icon = convertView.findViewById(R.id.room_icon);
        TextView role = convertView.findViewById(R.id.role_text_view);
        ImageView edit_product = convertView.findViewById(R.id.edit_product);
        ImageView delete_product = convertView.findViewById(R.id.delete_product);

        AddedRoomModel addedRoomModel = drawerMenuItems.get(position);
        room_name.setText(addedRoomModel.getRoomType());
        room_icon.setImageResource(addedRoomModel.getIcon());
        role.setText(addedRoomModel.getPriority());

        edit_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "position"+position, Toast.LENGTH_LONG).show();
            }
        });

        delete_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewGroup viewGroup = v.findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(activity).inflate(R.layout.delete_added_room_alert_dialog, viewGroup, false);

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(dialogView);
                builder.setCancelable(false);
                final AlertDialog alertDialog = builder.create();
                alertDialog.show();

                Button no = dialogView.findViewById(R.id.no_button);
                Button yes =dialogView.findViewById(R.id.yes_button);

                no.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });

                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
            }
        });

        return convertView;
    }
}

