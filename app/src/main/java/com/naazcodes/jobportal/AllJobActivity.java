package com.naazcodes.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.naazcodes.jobportal.Model.Data;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.naazcodes.jobportal.Model.Data;

import org.w3c.dom.Text;

public class AllJobActivity extends AppCompatActivity {

    private Toolbar toolbar;

    //Recycler
    private RecyclerView recyclerView;

    //Firebase

    private DatabaseReference mAllJobPost;
    private FirebaseRecyclerOptions<Data> options;
    private FirebaseRecyclerAdapter<Data,viewHolder> adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_job);

        toolbar = findViewById(R.id.all_job_post);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("All Job Post");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Database

        mAllJobPost = FirebaseDatabase.getInstance().getReference().child("Public database");

        recyclerView = findViewById(R.id.recycler_all_job);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        options = new FirebaseRecyclerOptions.Builder<Data>().setQuery(mAllJobPost,Data.class).build();
        adapter = new FirebaseRecyclerAdapter<Data, viewHolder>(options) {
            @SuppressLint("SetTextI18n")
            @Override
            protected void onBindViewHolder(@NonNull viewHolder viewHolder, int i, @NonNull Data data) {
                viewHolder.title.setText(""+data.getTitle());
                viewHolder.date.setText(""+data.getDate());
                viewHolder.desc.setText(""+data.getDescription());
                viewHolder.salary.setText(""+data.getSalary());
                viewHolder.skills.setText(""+data.getSkills());
            }

            @NonNull
            @Override
            public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

               View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.alljobpost,parent,false);
                return new viewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);

    }









}