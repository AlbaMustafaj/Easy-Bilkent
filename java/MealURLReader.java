package the_debuggers.com.easybilkent;

import android.os.StrictMode;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MealURLReader
{
    //variables
    private final String url = "http://kafemud.bilkent.edu.tr/monu_tr.html";
    private String urlContent;

    //constructor
    public MealURLReader()
    {
        //super( enteredUrl );
        urlContent = filterContent();
    }
    //gets contents of the page
    public String getPageContents()
    {
        return urlContent;
    }
    public String filterContent()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(this.url).build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No Internet Connection";
    }
}
