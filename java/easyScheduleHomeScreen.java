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

public class easyScheduleHomeScreen extends Activity {

    Button right;
    Button left;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home_screen);
         right = (Button) findViewById(R.id.right4schedule); // set the right button id
         left = (Button) findViewById(R.id.left4schedule); // set the left button id
        // set an actionlistener for the right button
        right.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(easyScheduleHomeScreen.this, easyMealsHomeScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.go, R.anim.to_the_right);
            }});
        // set an actionlistener for the left button
        left.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(easyScheduleHomeScreen.this, easyMapsHomeScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }});

        RelativeLayout press  = (RelativeLayout) findViewById(R.id.easySchedule); // set the left button id
        // set an actionlistener to enter to the about field
        press.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(easyScheduleHomeScreen.this, MyScheduleActivity.class);
                startActivity(intent);
            }});
    }
}
