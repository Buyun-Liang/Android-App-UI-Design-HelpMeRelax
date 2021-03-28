package com.example.HelpMeRelax_v1_0;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) throws InterruptedException {
//        Intent intent = new Intent(this, DisplayMessageActivity.class);
        //        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();

        TextView text = (TextView) findViewById(R.id.textView3);
        text.setText(message);
        text.setBackgroundResource(R.drawable.back);

        ImageView user_img = (ImageView)findViewById(R.id.imageView2);
        user_img.setImageResource(R.drawable.user_me);

        //////////////////////////////////////////////////////////////

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String message_reply = "This is a reply!";
                TextView text_reply = (TextView) findViewById(R.id.textView4);
                text_reply.setText(message_reply);
                text_reply.setBackgroundResource(R.drawable.back);

                ImageView user_img = (ImageView)findViewById(R.id.imageView3);
                user_img.setImageResource(R.drawable.user1);
            }
        }, 2000);


        //////////////////////////////////////////////////////////////
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                String message_reply_2 = "This is another reply!";
                TextView text_reply = (TextView) findViewById(R.id.textView5);
                text_reply.setText(message_reply_2);
                text_reply.setBackgroundResource(R.drawable.back);

                ImageView user_img = (ImageView)findViewById(R.id.imageView4);
                user_img.setImageResource(R.drawable.user1);

            }
        }, 3000);

    }

}
