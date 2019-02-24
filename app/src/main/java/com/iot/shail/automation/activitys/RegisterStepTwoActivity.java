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
import android.widget.ListView;
import android.widget.Toast;

import com.iot.shail.automation.R;
import com.iot.shail.automation.adapters.AddedUserAdapter;
import com.iot.shail.automation.models.AddedUserModel;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class RegisterStepTwoActivity extends AppCompatActivity {

    private List<AddedUserModel> addedUserModels = new ArrayList<AddedUserModel>();
    private ListView listView;
    private AddedUserAdapter addedUserAdapter;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_step_two);

        //******* set action bar full screen **********
        actionbar = getSupportActionBar();
        assert actionbar != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle("Registration Step 2");

        //******* list view with user and its priority **********
        listView = (ListView) findViewById(R.id.added_user_list);

        AddedUserModel addedUserModel = new AddedUserModel("Rohit","Admin");
        AddedUserModel addedUserModel1 = new AddedUserModel("Lucky","User");
        addedUserModels.add(addedUserModel);
        addedUserModels.add(addedUserModel1);

        addedUserAdapter= new AddedUserAdapter(this, addedUserModels);
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
                Intent registerStepThirdActivity = new Intent(RegisterStepTwoActivity.this, RegisterStepThirdActivity.class);
                startActivity(registerStepThirdActivity);
            }
        });

        //******* add location click event **********
        FloatingTextButton addLocationFloatingTextButton = (FloatingTextButton) findViewById(R.id.add_location_floating_text_button);
        addLocationFloatingTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //******* add user click event **********
        FloatingTextButton addUserFloatingTextButton = (FloatingTextButton) findViewById(R.id.add_user_floating_text_button);
        addUserFloatingTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddNewUserDialog();
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

    //******* add new user alert dialog created **********
    private void showAddNewUserDialog() {

        ViewGroup viewGroup = findViewById(android.R.id.content);
        View dialogView = LayoutInflater.from(this).inflate(R.layout.add_new_user_alert_dialog, viewGroup, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);
        builder.setCancelable(false);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();

        TextInputEditText nameTextInputEditText= dialogView.findViewById(R.id.nameTextInputEditText);
        TextInputEditText userNameTextInputEditText=  dialogView.findViewById(R.id.userNameTextInputEditText);
        TextInputEditText emailTextInputEditText=  dialogView.findViewById(R.id.emailTextInputEditText);
        TextInputEditText phoneNumberTextInputEditText=  dialogView.findViewById(R.id.phoneNumberTextInputEditText);

        MaterialSpinner select_role_material_better_spinner= (MaterialSpinner)  dialogView.findViewById(R.id.select_role_material_better_spinner);
        String[] SPINNER_DATA = {"Admin","User"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(RegisterStepTwoActivity.this, android.R.layout.simple_dropdown_item_1line, SPINNER_DATA);
        select_role_material_better_spinner.setAdapter(adapter);

        select_role_material_better_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
    //******* add new user alert dialog end **********
}
