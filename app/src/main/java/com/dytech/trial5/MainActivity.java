package com.dytech.trial5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dytech.trial5.R;
import com.dytech.trial5.auth.GoogleSignInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private TextView textName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            Intent main = new Intent(MainActivity.this, ChooserActivity.class);
            startActivity(main);
        }
        setContentView(R.layout.activity_main);
        String name = getIntent().getStringExtra("name");
        //String name = user.getDisplayName();

        textName = (TextView)findViewById(R.id.name);
        textName.setText(name);
    }

}
