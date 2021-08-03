package com.naazcodes.jobportal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class viewHolder extends RecyclerView.ViewHolder {

    TextView title,date,desc,skills,salary;
    public viewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.all_job_post_title);
        date = itemView.findViewById(R.id.all_job_post_date);
        desc = itemView.findViewById(R.id.all_job_post_description);
        skills = itemView.findViewById(R.id.all_job_post_skills);
        salary = itemView.findViewById(R.id.all_job_post_salary);
    }
}
