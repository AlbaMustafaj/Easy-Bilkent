package the_debuggers.com.easybilkent;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
/*
  Description  : BuildingsActivity
  Function     : Contains  the searchview for searching through the list which shortens when you wirte
  @Author      : Ndricim Rrapi
  Last UPDATED : 01/05/2016
 */

    public class BuildingListActivity extends Activity   {
    ListView listView ;
    SearchView searcher;

    // Defined Array values to show in ListView
    String values [] = new String[] { "79 Faculty House", "80 Faculty House ", "A Building",
            "B Building", "Bilkent Stadium", "Bus Stop Dorm 76", "Bus Stop Nizamiye",
            "Bus Stop Rektorluk", "Cafe Alis ", "Cafe In", "Career Center", "Coffee Break L",
            "Coffee Break Library", "Coffee Break T ", "Dorm 50", "Dorm 51 ", "Dorm 52 ", "Dorm 54",
            "Dorm 55 ", "Dorm 60", "Dorm 61 ", "Dorm 62 ", "Dorm 63", "Dorm 64 ", "Dorm 69",
            "Dorm 70 ", "Dorm 71 ", "Dorm 72",  "Dorm 73 ", "Dorm 74", "Dorm 75 ", "Dorm 76 ",
            "Dorm 77", "Dorm 78 ", "Dorm Cafeteria", "Dorm Sports Center", "Dorm Sports Field 1 ",
            "Dorm Sports Field 2 ", "Dormitories Management ", "EA Building",
            "EB Building ", "EE Building", "Express Cafe", "FA Building", "FB Building",
            "FC Building", "FD Building", "FF Building", "G Building ", "H Building",
            "Health Center", "Ihsan Dogramaci Square", "Int.Children Center",
            "International Center", "LA Building", "LB Building", "LC Building",
            "M Building ", "Main Campus Library", "Marmara", "Mescit ", "Meteksan Bookstore",
            "Meteksan Market", "Mozart Caffee EE", "PTT ", "Pharmacy ", "Rector's Office ",
            "Registrar's Office", "SA Building", "SB Building", "SL Building", "SM Building",
            "SN Building", "ST Building", "SU Building", "Security & Civil Defense Office",
            "Speed Restaurant", "Sports Center F", "Starbucks Coffee", "T Building",
            "U Building", "V Building", "Yapi Kredi Bank"
    };
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building_list);

        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        searcher=(SearchView) findViewById(R.id.searchView);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

         adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
        searcher.setOnQueryTextListener(new OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String text)
            {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text)
            {
                adapter.getFilter().filter(text);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String building_name = String.valueOf(parent.getItemAtPosition(position));
                Intent intent = new Intent(BuildingListActivity.this, MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("building", building_name);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);
        return true;
    }
}