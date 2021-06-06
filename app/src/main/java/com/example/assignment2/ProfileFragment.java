package com.example.assignment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    private Submission.Attachment attachment;
    TextView textView;
    TextView bioView;
    TextView nameView;
    TextView jobView;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment with the ProfileFragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        textView = view.findViewById(R.id.submission);
        bioView = view.findViewById(R.id.bio);
        nameView = view.findViewById(R.id.name);
        jobView = view.findViewById(R.id.job);

        bioView.setText(this.attachment.bio);
        nameView.setText(this.attachment.name);
        jobView.setText(this.attachment.job);

        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    void setAttachment(Submission.Attachment attach) {
        this.attachment = attach;
    }
}

