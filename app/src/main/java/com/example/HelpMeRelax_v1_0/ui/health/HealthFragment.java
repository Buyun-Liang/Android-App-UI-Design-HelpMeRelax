package com.example.HelpMeRelax_v1_0.ui.health;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.HelpMeRelax_v1_0.PostDBHelper;
import com.example.HelpMeRelax_v1_0.MainActivity;
import com.example.HelpMeRelax_v1_0.MakePost;
import com.example.HelpMeRelax_v1_0.PostSessionActivity;
import com.example.HelpMeRelax_v1_0.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

public  class HealthFragment extends Fragment {
    private HealthViewModel healthViewModel;

    ListView listView;
    String[] from = {"username", "ItemTitle", "ItemText", "PostID","user_name_authentication" };
    int[] to = {R.id.replyText, R.id.ItemTitle, R.id.ItemText, 0 , 1};
    int postSessionID = 3;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        healthViewModel = ViewModelProviders.of(this).get(HealthViewModel.class);
        View root = inflater.inflate(R.layout.fragment_health, container, false);
        final TextView textView= root.findViewById(R.id.text_health);
        healthViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>(){
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        /** Set title bar
         */
        super.onResume();
        ((MainActivity) getActivity())
                .setActionBarTitle("Health Concerns");


        /** show listView of posts
         */
        listView = (ListView) root.findViewById(R.id.list_views2);
        final PostDBHelper postDBHelper = new PostDBHelper(getContext());
        final SimpleAdapter listItemAdapter = new SimpleAdapter(getContext(),  postDBHelper.getEveryoneMap(postSessionID), R.layout.list_items,from,to);
        listView.setAdapter(listItemAdapter);

        /** Click each list item of post listview
         */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                System.out.println("clicked to postsactivity");
                HashMap<String, String> map = (HashMap<String, String>) listItemAdapter.getItem(position);
                String title = map.get("ItemTitle");
                String content = map.get("ItemText");
                String poster_name = map.get("username");
                String post_ID = map.get("PostID");
                String poster_name_authentication = map.get("user_name_authentication");
                Intent intent = new Intent(getActivity(), PostSessionActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("content", content);
                intent.putExtra("poster_name", poster_name);
                intent.putExtra("post_ID", post_ID);
                intent.putExtra("user_name_authentication", poster_name_authentication);
                startActivity(intent);
            }
        });

        /** Make new post
         */
        FloatingActionButton btn_post = root.findViewById(R.id.btn_post);

        btn_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这段的username也从数据库里找，登录的时候应该也存到数据库里
                Intent intent = new Intent(getActivity(), MakePost.class);

                intent.putExtra("postSessionID", String.valueOf(postSessionID));
                startActivity(intent);
            }
        });

        return root;
    }
}

