package com.iot.shail.automation.activitys;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iot.shail.automation.R;
import com.iot.shail.automation.adapters.SelectRoomTypeAdapter;
import com.iot.shail.automation.models.SelectRoomTypeModel;
import com.iot.shail.automation.adapters.AddedRoomAdapter;
import com.iot.shail.automation.models.AddedRoomModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class RegisterStepThirdActivity extends AppCompatActivity {

    private ActionBar actionbar;

    private List<AddedRoomModel> addedUserModels = new ArrayList<AddedRoomModel>();
    private ListView listView;
    private AddedRoomAdapter addedUserAdapter;
    public static final List<Integer> roomTypeIcon = Arrays.asList(R.drawable.ic_bed_room,R.drawable.ic_drawing_room);
    public static final List<String> roomName = Arrays.asList("Drawing Room","Living Room");
    public static final List<String> roomPriority = Arrays.asList("Admin","User");

    public TextView selected_room_name_text_view;
    ImageView selected_room_icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step_third);

        //******* set action bar full screen **********
        actionbar = getSupportActionBar();
        assert actionbar != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("Registration Step 3");

        //******* list view with room name, room icon and its priority **********
        listView = (ListView) findViewById(R.id.added_room_list);

        AddedRoomModel addedRoomModel = new AddedRoomModel(roomName.get(0),roomTypeIcon.get(0),roomPriority.get(0));
        AddedRoomModel addedRoomModel1 = new AddedRoomModel(roomName.get(1),roomTypeIcon.get(1),roomPriority.get(1));
        addedUserModels.add(addedRoomModel);
        addedUserModels.add(addedRoomModel1);

        addedUserAdapter= new AddedRoomAdapter(this, addedUserModels);
        listView.setAdapter(addedUserAdapter);
        addedUserAdapter.notifyDataSetChanged();

        //******* reset click event **********
        findViewById(R.id.reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "All user and location delete", Toast.LENGTH_LONG).show();
            }
        });

        //******* next click event **********
        findViewById(R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addDeviceActivity = new Intent(RegisterStepThirdActivity.this, AddDeviceActivity.class);
                startActivity(addDeviceActivity);
            }
        });

        //******* add room click event **********
        FloatingTextButton addRoomFloatingTextButton = (FloatingTextButton) findViewById(R.id.add_room_floating_text_button);
        addRoomFloatingTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddRoomDialog();
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

    //******* add new room alert dialog created **********
    private void showAddRoomDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.add_new_room_alert_dialog, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        TextInputEditText roomNameTextInputEditText= dialogView.findViewById(R.id.roomNameTextInputEditText);
        RelativeLayout selectRoomTypeRelativeLayout= dialogView.findViewById(R.id.selectRoomTypeRelativeLayout);

        selected_room_name_text_view = dialogView.findViewById(R.id.selected_room_name_text_view);
        selected_room_icon= dialogView.findViewById(R.id.selected_room_icon);

        selectRoomTypeRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSelectRoomTypeDialog();
            }
        });

        MaterialSpinner select_assigned_user_material_better_spinner= (MaterialSpinner)  dialogView.findViewById(R.id.select_assigned_users_material_better_spinner);
        String[] SPINNER_DATA = {"Rohit","Lucky"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterStepThirdActivity.this, android.R.layout.simple_dropdown_item_1line, SPINNER_DATA);
        select_assigned_user_material_better_spinner.setAdapter(adapter);

        select_assigned_user_material_better_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button add = dialogView.findViewById(R.id.add_button);
        Button close =dialogView.findViewById(R.id.close_button);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }
    //******* add new room alert dialog end **********

    //******* select room type alert dialog created **********
    private void showSelectRoomTypeDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.select_room_type_alert_dialog, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        ImageView close = dialogView.findViewById(R.id.close_button);
        GridView gridView = (GridView) dialogView.findViewById(R.id.select_room_type_grid_view);

        List<SelectRoomTypeModel> selectRoomTypeModels = new ArrayList<SelectRoomTypeModel>();
        SelectRoomTypeAdapter selectRoomTypeAdapter;

        final List<Integer> menuItemIcon = Arrays.asList(
                R.drawable.ic_bed_room,R.drawable.ic_drawing_room,
                R.drawable.ic_living_room,R.drawable.ic_tv_room,
                R.drawable.ic_dining_room,R.drawable.ic_study_room,
                R.drawable.ic_kitchen,R.drawable.ic_toilet,
                R.drawable.ic_store_room,R.drawable.ic_balcony,
                R.drawable.ic_washing_area,R.drawable.ic_office_room,
                R.drawable.ic_bar,R.drawable.ic_meeting,
                R.drawable.ic_conference,R.drawable.ic_theatre
        );

        final List<String> menuItemValue = Arrays.asList(
                "Bed Room","Drawing Room","Living Room",
                "TV Room","Dining Room","Study Room",
                "Kitchen","Toilet","Store Room",
                "Balcony", "Wash Area", "Office",
                "Bar","Meeting Room", "Conference",
                "Theatre");

        for (int i = 0; i < 16; i++) {
            SelectRoomTypeModel drawerMenuItemObject = new SelectRoomTypeModel(menuItemIcon.get(i),menuItemValue.get(i));
            selectRoomTypeModels.add(drawerMenuItemObject);
        }

        selectRoomTypeAdapter= new SelectRoomTypeAdapter(this, selectRoomTypeModels);
        gridView.setAdapter(selectRoomTypeAdapter);
        selectRoomTypeAdapter.notifyDataSetChanged();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_room_name_text_view.setText(menuItemValue.get(position));
                selected_room_icon.setImageResource(menuItemIcon.get(position));
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
