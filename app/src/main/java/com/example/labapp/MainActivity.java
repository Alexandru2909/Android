package com.example.labapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends AppCompatActivity {

    public boolean logInMenuClick(MenuItem  v){
        DialogFragment newFragment = new LogInFragment();
        newFragment.show(getSupportFragmentManager(), "LogIn");
        return true;
    }
    public boolean newCarMenuClick(MenuItem  v){
        Intent intent = new Intent(this, AddCar.class);
        startActivity(intent);
        return true;
    }
    public boolean findNearMenuClick(MenuItem  v){
        Intent intent = new Intent(this, AddCar.class);
        startActivity(intent);
        return true;
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//        if (id == R.id.addCar) {
//            Intent intent = new Intent(this, AddCar.class);
//            startActivity(intent);
//        }
//        if (id == R.id.logIn){
//            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//// ...Irrelevant code for customizing the buttons and title
//            LayoutInflater inflater = this.getLayoutInflater();
//            View dialogView = inflater.inflate(R.layout.fragment_login, null);
//            dialogBuilder.setView(dialogView);
//            AlertDialog alertDialog = dialogBuilder.create();
//            alertDialog.show();
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private View.OnClickListener myOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LinearLayout linearLayout = findViewById(R.id.my_list);
            int par = v.getId();
            par++;
            for (int i = 0; mycars.length > i; i++){
                TextView t = findViewById(R.id.parent+i*2+1);
                t.setText(mycars[i]);
            }
            TextView text = findViewById(par);
            text.setText("Selected");
        }
    };

    @Override
    protected  void onSaveInstanceState(Bundle state){
        super.onSaveInstanceState(state);
        int saved = 0;
        for (int i = 0; mycars.length > i; i++){
            TextView t = findViewById(R.id.parent+i*2+1);
            if ("Selected" == t.getText())
                saved = i;

        }
        state.putSerializable("selItem",saved);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appmenu, (android.view.Menu) menu);
        return super.onCreateOptionsMenu((android.view.Menu) menu);
    }
    public String[] mycars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.my_list);
//        //add textView
//        TextView textView = new TextView(this);
//        textView.setText("The developer world is yours");
//        textView.setId(R.id.parent+1);
//        textView.setLayoutParams(params);

        mycars = new String[]{"Opel", "audi","vw"};
        for (int i = 0; mycars.length > i; i++){
            TextView textView = new TextView(this);
            textView.setText(mycars[i]);
            textView.setId(R.id.parent+i*2+1);
            Button x = new Button(this);
            x.setId(R.id.parent+i*2);
            x.setOnClickListener(myOnClick);

            linearLayout.addView((textView));
            linearLayout.addView(x);
        }

        if ((savedInstanceState != null) && (savedInstanceState.getSerializable("selItem") != null)) {
            int sel = (int) savedInstanceState.getSerializable("selItem");
            for (int i = 0; mycars.length > i; i++) {
                TextView t = findViewById(R.id.parent + i * 2 + 1);
                if ( sel == i ) {
                    t.setText("Selected");
                }
            }
        }


//        // added Button
//        Button button = new Button(this);
//        button.setText("h");
//        button.setId(R.id.parent+2);
//        button.setOnClickListener();
//        Button button2 = new Button(this);
//        button2.setText("astra");
//        button2.setId(R.id.parent+2);
//        Button button3 = new Button(this);
//        button3.setText("opel");
//        button3.setId(R.id.parent+2);
//
//        //added the textView and the Button to LinearLayout
////        linearLayout.addView(textView);
//        linearLayout.addView(button);
//        linearLayout.addView(button2);
//        linearLayout.addView(button3 );
//        final String[] myStringArray = {"Opel","VW","Audi"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myStringArray);
//        final ListView listView1 = (ListView) findViewById(R.id.list_view);
//        listView1.setAdapter(adapter);
//        AdapterView.OnItemClickListener msg = new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                System.out.println("CLICK!");
//                Toast.makeText(MainActivity.this, myStringArray[position], Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        listView1.setOnItemClickListener(msg);

    }


    public void newNearYou(MenuItem item) {
        Intent intent = new Intent(this, NearYou.class);
        startActivity(intent);
    }
}
