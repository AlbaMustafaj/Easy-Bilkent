package the_debuggers.com.easybilkent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MealsMainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meals_main_activity);

        MealContainer container = new MealContainer();
        String[] foods = container.getTodaysMeals();
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        ListView test = (ListView) findViewById(R.id.myList);
        test.setAdapter(adapter);
    }
}
