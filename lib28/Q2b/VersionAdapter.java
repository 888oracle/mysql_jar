package com.example.slips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class VersionAdapter extends ArrayAdapter<Version> {
    private List<Version> versions;

    public VersionAdapter(@NonNull Context context, List<Version> versions) {
        super(context, 0, versions);
        this.versions = versions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView != null ? convertView : LayoutInflater.from(getContext()).inflate(R.layout.list_item_version, parent, false);

        Version currentVersion = versions.get(position);

        TextView name = view.findViewById(R.id.tv_name);
        name.setText(currentVersion.getName());

        TextView number = view.findViewById(R.id.tv_number);
        number.setText(currentVersion.getNumber());

        return view;
    }
}