package sdk.tokinu.com.sampleapplicationforsdk;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import classes.Tokinu;


public class MainActivity extends Activity implements View.OnClickListener {

    Button btnLoginTokinu;
    String APP_ID = "73ffe2c3251845b5a0c290f3e9e3fe85";
    String APP_SECRET = "d2a9c45034534ce388213be1e65b5158";
    TextView txtUserId, txtAccessToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoginTokinu = (Button) findViewById(R.id.btnLoginTokinu);
        btnLoginTokinu.setOnClickListener(this);

        txtAccessToken = (TextView) findViewById(R.id.txtAccessToken);
        txtUserId = (TextView) findViewById(R.id.txtUserId);
    }

    @Override
    public void onClick(View v) {
        if (v == btnLoginTokinu) {

            Tokinu tokinu = new Tokinu(APP_ID, APP_SECRET);
            tokinu.authenticationForTokinu(this, new TokinuListener());
        }
    }

    public class TokinuListener implements Tokinu.TokinuRequestListener {

        @Override
        public void onComplete(String access_token, String user_id) {
            //Toast.makeText(MainActivity.this, "Access token is: "+access_token, Toast.LENGTH_LONG).show();
            txtUserId.setText("Email : "+user_id);
            txtAccessToken.setText("Access Token : " +access_token);
        }

        @Override
        public void onException(String exception) {
            Toast.makeText(MainActivity.this, exception, Toast.LENGTH_LONG).show();
        }
    }
}
