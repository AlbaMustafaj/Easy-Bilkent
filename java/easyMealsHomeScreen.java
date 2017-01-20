package the_debuggers.com.easybilkent;
/*
  Description: easySchedule
  Functions  : redirects to the schedule if clicked
  @Author    : Ndricim Rrapi
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class easyMealsHomeScreen extends Activity {
    Button left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        left = (Button) findViewById(R.id.left4meals); // set the left button id
        // set an actionlistener for the left button
        left.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(easyMealsHomeScreen.this, easyScheduleHomeScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }});
        RelativeLayout press  = (RelativeLayout) findViewById(R.id.easy_meal_layout); // set the left button id
        // set an actionlistener to enter to the meals field
        press.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(easyMealsHomeScreen.this, MealsMainActivity.class);
                startActivity(intent);
            }});
    }
}
