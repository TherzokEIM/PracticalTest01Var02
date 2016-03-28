package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        if (savedInstanceState != null) {
            ArrayList<Integer> values = savedInstanceState.getIntegerArrayList("values");
            GridLayout grid = (GridLayout) findViewById(R.id.mainGridLayout);
            for (int i = 0; i < grid.getChildCount(); ++i) {
                EditText editText = (EditText) grid.getChildAt(i);
                editText.setText(values.get(i).toString());
            }
        }

        //getApplicationContext().startService(new Intent(getApplicationContext(), PracticalTest01Var02Service.class));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_practical_test01_var02_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    boolean getValues(List<Integer> arrayToFill)
    {
        GridLayout grid = (GridLayout)findViewById(R.id.mainGridLayout);
        boolean toRet = true;
        for (int i = 0; i < grid.getChildCount(); ++i) {
            EditText editText = (EditText)grid.getChildAt(i);
            String text = editText.getText().toString();

            if (text.isEmpty()) {
                arrayToFill.add(0);
                toRet = false;
            } else {
                // Guaranteed to be an integer.
                arrayToFill.add(Integer.parseInt(text));
            }
        }
        return toRet;
    }

    public void onSetClick(View view) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        if (!getValues(values))
            return;

        Intent intent = new Intent(this, PracticalTest01Var02SecondaryActivity.class);
        intent.putIntegerArrayListExtra("values", values);

        startActivity(intent);
    }
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        getValues(values);
        savedInstanceState.putIntegerArrayList("values", values);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        ArrayList<Integer> values = savedInstanceState.getIntegerArrayList("values");
        GridLayout grid = (GridLayout) findViewById(R.id.mainGridLayout);
        for (int i = 0; i < grid.getChildCount(); ++i) {
            EditText editText = (EditText) grid.getChildAt(i);
            editText.setText(values.get(i).toString());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //stopService(new Intent(getApplicationContext(), PracticalTest01Var02Service.class));
    }
}
