package the_debuggers.com.easybilkent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;



public class MainActivityLogin extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private Button btnSimpleTabs, btnScrollableTabs, btnIconTextTabs, btnAboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnIconTextTabs = (Button) findViewById(R.id.btnIconTextTabs);
        btnAboutUs = (Button) findViewById(R.id.btnAboutUs);
        btnAboutUs.setOnClickListener(this);
        btnIconTextTabs.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.btnIconTextTabs:
                startActivity(new Intent(MainActivityLogin.this, IconTextTabsActivity.class));

                break;
            case R.id.btnAboutUs:
                startActivity(new Intent(MainActivityLogin.this, AboutUsActivity.class));
                break;
        }
    }
}
