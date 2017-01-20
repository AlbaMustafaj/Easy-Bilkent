package the_debuggers.com.easybilkent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;

public class StudentInfo extends AppCompatActivity {

    String[] studentsName;
    ListView listView;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.about_uspage);

        listView = (ListView) findViewById(R.id.listview);

        TextView emricimit = (TextView) findViewById(R.id.emricimit);

        initList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                Log.d("############", "Items " + studentsName[arg2]);

                if (arg2 == 0)
                    startActivity(new Intent(StudentInfo.this, Alba_Display.class));
                if (arg2 == 1)
                    startActivity(new Intent(StudentInfo.this, Ndricim_Display.class));
                if (arg2 == 2)
                    startActivity(new Intent(StudentInfo.this, Skerd_Display.class));
                if (arg2 == 3)
                    startActivity(new Intent(StudentInfo.this, Mehmet_Display.class));
                if (arg2 == 4)
                    startActivity(new Intent(StudentInfo.this, Ahmet_Display.class));
                if (arg2 == 5)
                    startActivity(new Intent(StudentInfo.this, Evren_Display.class));
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


    public void initList() {

        studentsName = new String[]{"Alba Mustafaj", "Ndriçim Rrapi", "Skerd Xhafa", "Mehmet Furkan Doğan", "Ahmet Ensar",
                "Evren Bayram"};

        listItems = new ArrayList<>(Arrays.asList(studentsName));

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.txtitem, listItems);
        listView.setAdapter(adapter);

    }
}



