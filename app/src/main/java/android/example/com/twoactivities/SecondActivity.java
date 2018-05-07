package android.example.com.twoactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply = findViewById(R.id.editText_second);
        // get the intent that activated this activity:
        Intent intent = getIntent();
        // Get the string containing the message from the intent extras using the static variable as the key
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        Intent replayIntent = new Intent();
        // Add the reply string from the EditText to the new intent as an intent extra.
        replayIntent.putExtra(EXTRA_REPLY, reply);
        // Set the result - tRESULT_OK to indicate the response was successful.
        setResult(RESULT_OK, replayIntent);
        finish();
    }
}
