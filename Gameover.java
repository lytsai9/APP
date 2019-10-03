package example.com.blockgame_net;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class Gameover extends Activity {
    ImageButton replayb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        replayb=findViewById(R.id.replayb);
        final Intent intent=new Intent(this,BreakoutGame.class);
        final Intent intent1=new Intent(this,MyService.class);
        startService(intent1);
        replayb.setOnClickListener(new View.OnClickListener() {
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
            Intent intent = new Intent(Gameover.this, MyService.class);
            stopService(intent);
            finish();
        }
        return true;
    }
}

