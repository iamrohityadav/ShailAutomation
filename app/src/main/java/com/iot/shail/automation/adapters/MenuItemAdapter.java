package com.iot.shail.automation.adapters;

import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.iot.shail.automation.R;
import com.iot.shail.automation.models.DrawerMenuItemModel;

public class MenuItemAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<DrawerMenuItemModel> drawerMenuItems;

    public MenuItemAdapter(Activity activity, List<DrawerMenuItemModel> item) {
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
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) convertView = inflater.inflate(R.layout.drawer_menu_item, null);

        ImageView icon = convertView.findViewById(R.id.icon_image_view);
        TextView item = convertView.findViewById(R.id.item_text_view);

        DrawerMenuItemModel drawerMenuItemModel = drawerMenuItems.get(position);
        icon.setImageResource(drawerMenuItemModel.getIcon());;
        item.setText(drawerMenuItemModel.getItem());
        return convertView;
    }
}