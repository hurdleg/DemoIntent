package mad9132.demointent;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import static mad9132.demointent.Constants.ABOUT_DIALOG_TAG;
import static mad9132.demointent.Constants.DEFAULT_LETTER;
import static mad9132.demointent.Constants.LETTERS;
import static mad9132.demointent.Constants.LOG_TAG;
import static mad9132.demointent.Constants.THE_LETTER;
import static mad9132.demointent.Constants.THE_MESSAGE;

// TODO class PlainTextActivity
/**
 * Demo Android's Intent.
 *
 * Usage: enter some text, click the settings menu item and select the letter you wish to
 *        capitalize, and press the symbol in the FloatingActionBar (FAB).
 *        Click the Clear button to clear the text.
 *
 * Navigation: PlainTextActivity --- FAB ---> CapitalizedTextActivity
 *
 * TODOs
 *    Please review the TODOs
 *    View -> Tool Windows... -> TODO
 *
 * Features:
 *     two (multiple) activities
 *     an Intent
 *     passing Data
 *     CharacterPickerDialog (a specialized picker as a dialog)
 *     handling FAB events
 *     event handling by implementing an interface
 *     event handling with an anonymous inner class
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class PlainTextActivity extends AppCompatActivity {
    private DialogFragment        mAboutDialog;
    private CharacterPickerDialog mCapitalLettersDialog;
    private EditText              mPlainText;
    private char                  mTheCapitalLetter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plain_text);
        // TODO: remember the theme for this activity (PlainTextActivity) is: NoActionBar
        // TODO: add an action-bar to this activity
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plainText = mPlainText.getText().toString();
                // TODO :: prevent the user from capitalizing empty messages!
                // IF plainText is empty
                // THEN
                //     display a toast message: Empty Message!
                //     return

                // TODO: explicit Intent
                Intent intent = new Intent( getApplicationContext(), CapitalizedTextActivity.class );
                // TODO: FLAG_ACTIVITY_TOP - if set, and the activity being launched is already
                //       running in the current task, then instead of launching a new instance of
                //       that activity, all of the other activities on top of it will be closed
                //       and this Intent will be delivered to the (now on top) old activity as a new
                //       Intent.
                intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                // TODO: include the plainText string as extra to CapitalizedTextActivity
                intent.putExtra( THE_MESSAGE, plainText );
                // TODO: include the letter to capitalize as extra to CapitalizedTextActivity
                intent.putExtra( THE_LETTER, mTheCapitalLetter );
                Log.i( LOG_TAG, "PlainTextActivity -> CapitalizedTextActivity :: The Letter: " +
                        mTheCapitalLetter + "\tThe Plain Message: " + plainText );
                startActivity( intent );
            }
        });

        Log.i( LOG_TAG, "Plain Text Activity :: onCreate()" );

        // instantiate the dialog, but don't show it (yet)
        mAboutDialog = new AboutDialogFragment();
        mTheCapitalLetter = DEFAULT_LETTER;

        // TODO: instantiate a new CharacterPickerDialog (but do not show it)
        mCapitalLettersDialog = new CharacterPickerDialog( this, new View(this), null, LETTERS, false ) {
            @Override
            public void onClick(View v) {
                // TODO: which index position did User select in CharacterPickerDialog
                int index = LETTERS.indexOf( ((Button)v).getText().toString() );
                if ( index >= 0 ) {
                    // TODO: remembe which letter User wishes to capitialize
                    mTheCapitalLetter = LETTERS.charAt( index );
                }
                dismiss();
            }
        };

        Button clearButton = (Button) findViewById( R.id.bClearPlain );
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlainText.setText( "" );
            }
        });

        mPlainText = (EditText) findViewById( R.id.etPlain );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // TODO compare my new style of showing the About dialog box to my previous way.
        //      This way is more efficient: the dialog is instantiated once, and shown each time
        //      the user taps the About menu item.
        //      The previous way: a new dialog is created *each* time the user taps the About
        //      menu item.
        if ( id == R.id.action_about) {
            mAboutDialog.show( getFragmentManager(), ABOUT_DIALOG_TAG );
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mCapitalLettersDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // TODO Remaining lifecycle method overrides (in alphabetical order).

    @Override
    public void onDestroy() {
        Log.i( LOG_TAG, "onDestroy()" );

        super.onDestroy();
    }

    @Override
    public void onPause() {
        Log.i( LOG_TAG, "onPause()" );

        super.onPause();
    }

    @Override
    public void onRestart() {
        Log.i( LOG_TAG, "onRestart()" );

        super.onRestart();
    }

    @Override
    public void onResume() {
        Log.i( LOG_TAG, "onResume()");

        super.onResume();
    }

    @Override
    public void onStart() {
        Log.i( LOG_TAG, "onStart()" );

        super.onStart();
    }

    @Override
    public void onStop() {
        Log.i( LOG_TAG, "onStop()" );

        super.onStop();
    }
}
