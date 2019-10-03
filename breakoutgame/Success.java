package example.com.blockgame_net;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class Success extends Activity {
    Button bkhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        bkhome=findViewById(R.id.bkhome);
        final Intent intent=new Intent(this,MainActivity.class);
        final Intent intent1=new Intent(this,MyService.class);
        startService(intent1);
        bkhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
                stopService(intent1);
                finish();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK || keyCode == KeyEvent.KEYCODE_HOME) {
            Intent intent = new Intent(Success.this, MyService.class);
            stopService(intent);
            finish();
        }
        return true;
    }
}

