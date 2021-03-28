package com.example.HelpMeRelax_v1_0.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.HelpMeRelax_v1_0.HelpActivity;
import com.example.HelpMeRelax_v1_0.PostSessionActivity;
import com.example.HelpMeRelax_v1_0.R;
import com.example.HelpMeRelax_v1_0.Welcome;

public class LogoutFragment extends Fragment {

    private LogoutViewModel logoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Toast.makeText(getContext(), "Successful Logout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent( getActivity(), Welcome.class);
        startActivity(intent);



        return root;
    }
}
