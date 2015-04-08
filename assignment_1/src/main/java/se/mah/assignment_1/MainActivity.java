package se.mah.assignment_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView randomQuote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.nextButton);
        randomQuote = (TextView) findViewById(R.id.ranQuote);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyAPP", "Button pressed.. randomizing quote..");
                String textQuote;
                switch((int) (4 * Math.random())+ 1){
                    case 1:
                    textQuote = "Don't Panic.";
                    break;

                    case 2:
                    textQuote = "The ships hung in the sky in much the same way that bricks don't.";
                    break;

                    case 3:
                    textQuote = "I'd far rather be happy than right any day.";
                    break;

                    case 4:
                    textQuote = "So long, and thanks for all the fish.";
                    break;

                    default:
                    textQuote = "This is supposed to be a random quote";
                }
                randomQuote.setText(textQuote);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
