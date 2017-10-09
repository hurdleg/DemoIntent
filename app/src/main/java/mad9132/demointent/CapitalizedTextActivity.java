package mad9132.demointent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import util.StringUtil;

import static mad9132.demointent.Constants.LOG_TAG;
import static mad9132.demointent.Constants.THE_LETTER;
import static mad9132.demointent.Constants.THE_MESSAGE;

// TODO class CapitalizedTextActivity
/**
 * Display plainMessage with all occurrences of letter in upper-case.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class CapitalizedTextActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText              mCapitalizedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitalized_text);

        Log.i( LOG_TAG, "Capitalized Text Activity :: onCreate()" );

        Button clearButton = (Button) findViewById( R.id.bClearCapitalized );
        // TODO a new way to register the clearButton's event handler for onClick( ).
        //      Notice: the meta-variable 'this'
        //      In context, 'this' refers to *this* class: CapitalizedTextActivity.
        //      CapitalizedTextActivity is-a View.OnClickListener.
        //      Here's my proof:
        //      (to see: View -> Tool Windows -> Android Monitor)
        //      Set the Log level to: Info
        //      Filter: the value for the "LOG_TAG" constant (go and find it :)
        if ( this instanceof View.OnClickListener ) {
            Log.i( LOG_TAG, "Is class CapitalizedTextActivity an OnClickListener? " +
                    // Java's ternary operator.
                    // Pro-tip: to quickly have the String value of a primitive: "" + <primitive>
                    (this instanceof View.OnClickListener ? "" + true : "" + false) );
        }
        clearButton.setOnClickListener( this );

        mCapitalizedText = (EditText) findViewById( R.id.etCapitalized );
        Bundle bundle = getIntent().getExtras();
        // TODO Get the bundle of extras that was sent to this activity.
        if ( bundle != null ) {
            // GET the Plain Message and the Letter to capitalize
            String plainMessage = bundle.getString( THE_MESSAGE );
            char letter = bundle.getChar( THE_LETTER );
            // Capitalize Plain Message and display to user
            mCapitalizedText.setText(StringUtil.capitalize(plainMessage, letter) );

            Log.i( LOG_TAG, "CapitalizedTextActivity :: The Letter: "
                    + letter + "\tThe Plain Message: " + plainMessage );
        }
    }

    @Override
    public void onClick(View v) {
        //TODO this strategy --- where multiple buttons are handled by the same method --- requires
        //     you to figure out which button was click. This step is called: detect. As in, detect
        //     which <Button> was the one just clicked by the user.
        //     In Android, we can detect by the <Button>'s Id.
        //     After detection, then do what you need to do for that button click.
        switch ( v.getId() ) {
            case R.id.bClearCapitalized:
                mCapitalizedText.setText( "" );
                break;

            //TODO suppose there was another <Button> object registered to this activity.
            //case R.id.bOther:
            //    //do stuff
            //    break;
        }
    }

    @Override
    public void onDestroy() {
        Log.i( LOG_TAG, "onDestroy() 2" );

        super.onDestroy();
    }

    @Override
    public void onPause() {
        Log.i( LOG_TAG, "onPause() 2" );

        super.onPause();
    }

    @Override
    public void onRestart() {
        Log.i( LOG_TAG, "onRestart() 2" );

        super.onRestart();
    }

    @Override
    public void onResume() {
        Log.i( LOG_TAG, "onResume() 2");

        super.onResume();
    }

    @Override
    public void onStart() {
        Log.i( LOG_TAG, "onStart() 2" );

        super.onStart();
    }

    @Override
    public void onStop() {
        Log.i( LOG_TAG, "onStop() 2" );

        super.onStop();
    }
}
