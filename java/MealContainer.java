package the_debuggers.com.easybilkent;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by vdk on 01.05.2016.
 */

public class MealContainer
{
    private FilteredContent f;
    private String[][] container;
    private final int days = 7;
    private final int meals = 22;
    private ArrayList<String> foods;
    private Calendar calendar;
    private int day;

    public MealContainer()
    {
        calendar = Calendar.getInstance();
        day = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % days;
        f = new FilteredContent();
        foods = f.getMealContents();
        container = new String[days][meals + 1];
        fillContainer();
    }
    private void fillContainer()
    {
        this.container[0][0] = "Pazartesi";
        this.container[1][0] = "Salı";
        this.container[2][0] = "Çarşamba";
        this.container[3][0] = "Perşembe";
        this.container[4][0] = "Cuma";
        this.container[5][0] = "Cumartesi";
        this.container[6][0] = "Pazar";

        for ( int i = 1; i <= days; i++)
        {
            for( int j  = 1; j <= meals; j++)
            {
                if ( j <= 10)
                    this.container[i-1][j] = this.foods.get((i-1)*10 + j - 1);
                else
                    this.container[i-1][j] = this.foods.get(i*12 + j + 47);
            }
        }
    }
    public String[][] getMealPlan()
    {
        return this.container;
    }
    public String[] getTodaysMeals()
    {
        int j = 0;
        String[] today = new String[meals + 3];
        for ( int i = 0; i < meals + 3; i++)
        {
            if (i == 0)
            {
                today[i] = "Öğlen Yemeği";
                j--;
            }
            else if (i == 6)
            {
                today[i] = "Akşam Yemeği";
                j--;
            }
            else if (i == 12)
            {
                today[i] = "Seçmeli";
                j--;
            }
            else
                today[i] = this.container[this.day][j + 1];
            j++;
        }
        return today;
    }
}