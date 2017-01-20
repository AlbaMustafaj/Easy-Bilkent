package the_debuggers.com.easybilkent;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
  Description  : MapsActivity
  Function     : This class creates a grid of buttons which form a table which tends to implement a schedule like structure
                 for students to enter their weekly schedule
  @Author      : Alba Mustafaj
  Last UPDATED : 01/05/2016
 */

public class MyScheduleActivity extends AppCompatActivity {
    private GoogleApiClient client;
    GridView G1;
    EditText classInput, teacherInput, buildingInput;
    String  classInputString, teacherInputString, buildingInputString;
    public  Boolean popUp;
  //  public  String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "aTutorial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_schedule_activity);
        G1 = (GridView) findViewById(R.id.grid1);

        // set Adapter
        G1.setAdapter(new ButtonAdapter(this));
       // set column width
        G1.setColumnWidth(10);

       Log.i("INFO POSITION", "clicked at:" + G1.getCount());

        // assign EditText boxes
        classInput = (EditText) findViewById(R.id.edit_class_name);
        buildingInput = (EditText) findViewById(R.id.edit_teacher_name);
        teacherInput = (EditText)findViewById(R.id.edit_building_name);

        // set them to False ( User has to press on the table first to activate them)
        classInput.setEnabled(false);
        buildingInput.setEnabled(false);
        teacherInput.setEnabled(false);

        classInputString = classInput.getText().toString();
        teacherInputString = teacherInput.getText().toString();
        buildingInputString = buildingInput.getText().toString();

        // set floating action button to popup the edit bar
        final View v = (View) findViewById(R.id.On_Screen_Editor_Layout);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (View.GONE == v.getVisibility())
                {
                    v.setVisibility(View.VISIBLE);
               }
                else {
                    v.setVisibility(View.GONE);
                }
            }
        });
        // save Data to save the input the user types in the boxes
        Button saveDATA = (Button) findViewById(R.id.saveButton);
        saveDATA.setOnClickListener(new View.OnClickListener() {
          @Override
           public void onClick(View view) {
           }
        });
        // cancels the users operation
        Button cancel = (Button) findViewById(R.id.cancelButton);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.setVisibility(View.GONE);
            }
        });

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, "Main Page", Uri.parse("http://host/path"),
                Uri.parse("android-app://appspacekr.com.myapplication/http/host/path")
        );

    }

    // creating an adapter for the button grid view
    class ButtonAdapter extends BaseAdapter {
        private Context mContext;
        int     pos;
        Button  btn;
        // contains buttons assigned fixed text
        final  String[] mylist = {
                "Hour", "MON", "TUE", "WED", "THU", "FRI", "8:40\n9:30",
                " ", " ", " ", " ", " ", "9:40\n10:30",
                " ", " ", " ", " ", " ", "10:40\n11:30",
                " ", " ", " ", " ", " ", "11:40\n12:30",
                " ", " ", " ", " ", " ", "Break",
                " ", " ", " ", " ", " ", "13:40\n14:30",
                " ", " ", " ", " ", " ", "14:40\n15:30",
                " ", " ", " ", " ", " ", "15:40\n16:30",
                " ", " ", " ", " ", " ", "16:40\n17:30",
                " ", " ", " ", " ", " ",};

        // Gets the context
        public ButtonAdapter(Context c) {
            mContext = c;
        }

        //things contained within the adapter
        public int getCount() {
            return mylist.length;
        }

        public Object getItem(int position) {            return btn;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position,
                            View convertView, ViewGroup parent) {
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                btn = new Button(mContext);
                btn.setLayoutParams(new GridView.LayoutParams(150, 150));
                btn.setPadding(0, 0, 0, 0);
                pos = position;
                btn.setText(mylist[position]);
            } else {
                btn = (Button) convertView;
            }
            int textSize      = 10;
            int fontStyle     = Typeface.ITALIC;
            int textColor     = Color.BLACK;
            int rowHeight     = 150;
            int colorDrawable = R.drawable.button_hour;

            if ((position == 0)) {
                rowHeight = 50;
                colorDrawable = R.drawable.button_top_left;
            }
            if ((position > 0) && (position < 6)) {
                rowHeight = 50;
                colorDrawable = R.drawable.button_week_day;
            }

            // EDIT (8:40-9:30 Empty Fields) First Hour
            if ((position >= 7) && (position < 12)) {
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
            }
            // EDIT (9:40-10:30 Empty Fields) Second Hour
            if ((position >= 13) && (position < 18)) {
                fontStyle = Typeface.NORMAL;
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
            }
            // EDIT (10:40-11:30 Empty Fields) Third Hour
            if ((position >= 19) && (position < 24)) {
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
            }
            // EDIT (11:40-12:30 Empty Fields) Fourth Hour
            if ((position >= 25) && (position < 30)) {
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
            }
            // EDIT (12:40-13:30 Empty Fields) BREAK (MARMARA)
            if ((position >= 30) && (position < 36)) {
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_break;
            }
            // EDIT (13:40-14:30 Empty Fields) Fifth Hour
            if ((position >= 37) && (position < 42)) {
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
                //
            }
            // EDIT (14:40-15:30 Empty Fields) Sixth Hour
            if ((position >= 43) && (position < 48)) {
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
            }
            // EDIT (15:40-16:30 Empty Fields) Seventh Hour
            if ((position >= 49) && (position < 54)) {
                fontStyle = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
            }
            // EDIT (16:40-17:30 Empty Fields) Eight Hour
            if ((position >= 49) && (position < 54)) {
                fontStyle  = Typeface.NORMAL;
                colorDrawable = R.drawable.button_hour;
            }

            //  Edit Hour Line Only
            if ((position == 6) || (position == 12) || (position == 18) || (position == 24) || (position == 30) || (position == 36) || (position == 42) || (position == 48) || (position == 54)) {
                textSize = 7;
                //color = Color.rgb(85, 209, 237);// Opaque Blue
                colorDrawable = R.drawable.button_hours_column;
            }

            // filenames is an array of strings
            btn.setTextColor(Color.WHITE);
            btn.setBackgroundResource(colorDrawable);
            btn.setId(position);
            btn.setOnClickListener(new MyOnClickListener(btn.getId()));
            Log.i("INFO POSITION", "ID=" + btn.getId());
            return btn;
        }

        class MyOnClickListener implements View.OnClickListener {
            private final int position;
            public MyOnClickListener(int position) {
                this.position = position;
            }
            public void onClick(View v) {
                // sets the edit buttons to editable
                classInput.setEnabled(true);
                buildingInput.setEnabled(true);
                teacherInput.setEnabled(true);
                mylist[position]="user input here";
                // the string assigned here to mylist will be then saved to a file
                // and then accessed locally and updated each time the user sets values
                // will be using online server or local storage
            }
        }
    }
        @Override
    public void onStop() {
        super.onStop();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW,  "Main Page",
                Uri.parse("http://host/path"),
                Uri.parse("android-app://appspacekr.com.myapplication/http/host/path")
        );

        client.disconnect();
    }

    // a method that reads from a txt File
    private String readFromFile() {
        String returnText = "";
        try {
            InputStream inputStream = openFileInput("saveArray.txt");

            if ( inputStream != null )
            {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }
                inputStream.close();
                returnText = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("Status", "Not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Status", "Error , couldn't read: " + e.toString());
        }

        return returnText;
    }

    // writes a certain user string to the txt file
    private void writeToFile(String data) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(getApplicationContext().openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "failed due to : " + e.toString());
        }
    }
}
