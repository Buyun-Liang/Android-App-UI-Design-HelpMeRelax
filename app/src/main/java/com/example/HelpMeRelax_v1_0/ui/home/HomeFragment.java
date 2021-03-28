package com.example.HelpMeRelax_v1_0.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.HelpMeRelax_v1_0.R;
import com.example.HelpMeRelax_v1_0.ui.funding.FundingFragment;
import com.example.HelpMeRelax_v1_0.ui.health.HealthFragment;
import com.example.HelpMeRelax_v1_0.ui.job.JobFragment;
import com.example.HelpMeRelax_v1_0.ui.peer.PeerFragment;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        ImageView jobImageView=(ImageView) root.findViewById(R.id.job_icon);
        jobImageView.setImageResource(R.drawable.job);

        TextView jobText = (TextView) root.findViewById(R.id.job_text);
        jobText.setText(R.string.menu_job);


        ImageView fundImageView=(ImageView) root.findViewById(R.id.fund_icon);
        fundImageView.setImageResource(R.drawable.fund);

        TextView fundText = (TextView) root.findViewById(R.id.fund_text);
        fundText.setText(R.string.menu_funding);


        ImageView healthImageView = (ImageView) root.findViewById(R.id.health_icon);
        healthImageView.setImageResource(R.drawable.health);

        TextView healthText = (TextView) root.findViewById(R.id.health_text);
        healthText.setText(R.string.menu_health);

        ImageView peerImageView = (ImageView) root.findViewById(R.id.peer_icon);
        peerImageView.setImageResource(R.drawable.peer);

        TextView peerText = (TextView) root.findViewById(R.id.peer_text);
        peerText.setText(R.string.menu_peer);

        //////////////////////////////////////////////////////////////////

        ImageView jobButton = (ImageView) root.findViewById(R.id.job_icon);
        ImageView fundButton = (ImageView) root.findViewById(R.id.fund_icon);
        ImageView healthButton = (ImageView) root.findViewById(R.id.health_icon);
        ImageView peerButton = (ImageView) root.findViewById(R.id.peer_icon);

        jobButton.setOnClickListener(this);
        fundButton.setOnClickListener(this);
        healthButton.setOnClickListener(this);
        peerButton.setOnClickListener(this);


        return root;
    }


    @Override
    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.job_icon:
                fragment = new JobFragment(  );
                replaceFragment(fragment);

                break;

            case R.id.fund_icon:
                fragment = new FundingFragment();
                replaceFragment(fragment);
                break;

            case R.id.health_icon:
                fragment = new HealthFragment();
                replaceFragment(fragment);
                break;

            case R.id.peer_icon:
                fragment = new PeerFragment();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_host_fragment, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
