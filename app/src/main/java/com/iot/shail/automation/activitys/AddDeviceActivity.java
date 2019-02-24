package com.iot.shail.automation.activitys;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iot.shail.automation.R;
import com.iot.shail.automation.adapters.SelectDeviceTypeAdapter;
import com.iot.shail.automation.models.SelectDeviceTypeModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class AddDeviceActivity extends AppCompatActivity {

    private ActionBar actionbar;
    RelativeLayout selectDeviceTypeRelativeLayout;
    TextView select_device_type_text_view;
    ImageView selected_device_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);

        //******* set action bar full screen **********
        actionbar = getSupportActionBar();
        assert actionbar != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("Shail Automation");

        selectDeviceTypeRelativeLayout= findViewById(R.id.selectDeviceTypeRelativeLayout);
        select_device_type_text_view = findViewById(R.id.select_device_type_text_view);
        selected_device_icon= findViewById(R.id.selected_device_icon);

        selectDeviceTypeRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectDeviceTypeDialog();
            }
        });

        //******* scan bar code click event **********
        FloatingTextButton scanQRCodeFloatingTextButton = (FloatingTextButton) findViewById(R.id.scan_qr_code_floating_text_button);
        scanQRCodeFloatingTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //******* add manually click event **********
        FloatingTextButton addDeviceManuallyFloatingTextButton = (FloatingTextButton) findViewById(R.id.add_device_manually_floating_text_button);
        addDeviceManuallyFloatingTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //******* done click event **********
        findViewById(R.id.done_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeActivity = new Intent(AddDeviceActivity.this, HomeActivity.class);
                homeActivity.setAction(Intent.ACTION_MAIN);
                homeActivity.addCategory(Intent.CATEGORY_HOME);
                homeActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                homeActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                homeActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(homeActivity);
                finish();
            }
        });
    }

    //******* menu bar created **********
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_icon, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home_icon:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    //******* menu bar end **********

    //******* select room type alert dialog created **********
    private void showSelectDeviceTypeDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.select_device_type_alert_dialog, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        ImageView close = dialogView.findViewById(R.id.close_button);
        GridView gridView = (GridView) dialogView.findViewById(R.id.select_device_type_grid_view);

        List<SelectDeviceTypeModel> selectRoomTypeModels = new ArrayList<SelectDeviceTypeModel>();
        SelectDeviceTypeAdapter selectDeviceTypeAdapter;

        final List<Integer> menuItemIcon = Arrays.asList(
                R.drawable.ic_led_bulb,R.drawable.ic_cfl,
                R.drawable.ic_bulb,R.drawable.ic_tube_light,
                R.drawable.ic_fan,R.drawable.ic_chandelier,
                R.drawable.ic_color_light,R.drawable.ic_down_lighter,
                R.drawable.ic_curtains,R.drawable.ic_geyser,R.drawable.ic_water_pump,
                R.drawable.ic_air_conditioner,R.drawable.ic_tv_room,
                R.drawable.ic_lamp,R.drawable.ic_plug
        );

        final List<String> menuItemValue = Arrays.asList(
                "LED Bulb","CFL","Bulb",
                "Tube Light","Fan","Chandelier",
                "Color Light","Downlighter","Curtains",
                "Geyser","Water Pump","AC",
                "TV", "Lamp", "Plug");

        for (int i = 0; i < 15; i++) {
            SelectDeviceTypeModel drawerMenuItemObject = new SelectDeviceTypeModel(menuItemValue.get(i),menuItemIcon.get(i));
            selectRoomTypeModels.add(drawerMenuItemObject);
        }

        selectDeviceTypeAdapter= new SelectDeviceTypeAdapter(this, selectRoomTypeModels);
        gridView.setAdapter(selectDeviceTypeAdapter);
        selectDeviceTypeAdapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                select_device_type_text_view.setText(menuItemValue.get(position));
                selected_device_icon.setImageResource(menuItemIcon.get(position));
                alertDialog.dismiss();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
    //******* select room type alert dialog end **********
}
