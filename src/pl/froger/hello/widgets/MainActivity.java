package pl.froger.hello.widgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button btnUpdateWidget;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btnUpdateWidget = (Button) findViewById(R.id.btnUpdateWidget);
        btnUpdateWidget.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				updateWidget();
			}
		});
    }
    
    private void updateWidget() {
		Intent intent = new Intent();
		intent.setAction(MyAppWidget.UPDATE_ON_DEMAND);
		sendBroadcast(intent);
    }
}