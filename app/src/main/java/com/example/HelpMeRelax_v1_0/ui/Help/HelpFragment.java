package com.example.HelpMeRelax_v1_0.ui.Help;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.HelpMeRelax_v1_0.HelpActivity;
import com.example.HelpMeRelax_v1_0.R;

public class HelpFragment extends Fragment implements View.OnClickListener {

    private HelpViewModel helpViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        helpViewModel =
                ViewModelProviders.of(this).get(HelpViewModel.class);
        View root = inflater.inflate(R.layout.fragment_help, container, false);

//        final TextView textView = root.findViewById(R.id.text_help);
//        helpViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        TextView textDial = (TextView)  root.findViewById(R.id.textDial);
        SpannableString content = new SpannableString("123-456-7890");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textDial.setText(content);

        textDial.setOnClickListener(this);

        TextView FAQ1 = (TextView)  root.findViewById(R.id.textView11);
        TextView FAQ2 = (TextView)  root.findViewById(R.id.textView12);
        TextView FAQ3 = (TextView)  root.findViewById(R.id.textView13);

        FAQ1.setOnClickListener(this);
        FAQ2.setOnClickListener(this);
        FAQ3.setOnClickListener(this);


        return root;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textDial: {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1234567890"));
                startActivity(intent);
                break;
            }
            case R.id.textView11:
            case R.id.textView12:
            case R.id.textView13: {
                Intent intent = new Intent( getActivity(), HelpActivity.class);
                startActivity(intent);
                break;

            }

        }

    }
}
