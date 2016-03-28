package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PracticalTest01Var02SecondaryActivity extends AppCompatActivity {

    private IntentFilter intentFilter = new IntentFilter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_secondary);

        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<Integer> values = intent.getIntegerArrayListExtra("values");
            GridLayout grid = (GridLayout)findViewById(R.id.secondaryGridLayout);
            for (int i = 0; i < grid.getChildCount(); ++i) {
                TextView tv = (TextView)grid.getChildAt(i);
                tv.setText(values.get(i).toString());
            }
        }

    }

    List<Integer> getValues()
    {
        ArrayList<Integer> values = new ArrayList<Integer>();
        GridLayout grid = (GridLayout)findViewById(R.id.secondaryGridLayout);

        for (int i = 0; i < grid.getChildCount(); ++i) {
            TextView tv = (TextView)grid.getChildAt(i);
            String text = tv.getText().toString();

            values.add(Integer.parseInt(text));
        }
        return values;
    }

    public void onProductClick(View view) {
        Integer product = 1;
        for (Integer i : getValues()) {
            product *= i;
        }
        Toast.makeText(getApplicationContext(), product.toString(), Toast.LENGTH_SHORT)
                .show();

    }

    public void onSumClick(View view) {
        Integer sum = 0;

        for (Integer i : getValues()) {
            sum += i;
        }
        Toast.makeText(getApplicationContext(), sum.toString(), Toast.LENGTH_SHORT)
                .show();
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(messageBroadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Var02Service.class);
        stopService(intent);
        super.onDestroy();
    }

    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private class MessageBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
        }
    }
    */
}
