package com.example.user.auth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user == null){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
        setContentView(R.layout.activity_main);

        TextView nameUser = findViewById(R.id.txtNameUser);
        CircleImageView mCircleImageView = findViewById(R.id.fotoDePerfil);

        if (user != null)
            Glide.with(this).load(user.getPhotoUrl()).into(mCircleImageView);
            nameUser.setText(user.getDisplayName());
    }

    public void LogOut(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }
}
