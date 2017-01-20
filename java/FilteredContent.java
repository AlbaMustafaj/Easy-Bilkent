package the_debuggers.com.easybilkent;

/**
 * Created by vdk on 01.05.2016.
 */
import java.util.ArrayList;

public class FilteredContent extends MealURLReader
{
    private ArrayList<String> foods;
    private int[] willRemoved = {179, 166, 153, 140, 127, 114, 101, 100, 99, 98, 97, 96, 95, 89, 83, 82, 81, 75, 69, 68, 67, 61, 55, 54, 53, 47, 41, 40, 39, 33, 27, 26, 25, 19, 13, 12, 11, 5};
    private final int[] willFixed = {102, 115, 128, 141, 154, 167, 180};

    public FilteredContent()
    {
        foods = new ArrayList<String>();

        foods.add("");
        foods.add("");
    }
    public ArrayList<String> getMealContents()
    {
        String unfiltered = super.getPageContents();
        String temp;
        String tempV = "";
        int start1;
        int start2;
        int end;
        boolean condition = true;
        boolean vej = false;

        if (unfiltered.indexOf("<br>") != -1)
        {
            while ( condition )
            {
                start1 = unfiltered.indexOf("<br>");
                start2 = unfiltered.indexOf("<br>", start1 + 3);

                if (start1 != -1 && start2 != -1)
                {
                    unfiltered = unfiltered.substring(start1 + 4);
                    end = unfiltered.indexOf("<br>");
                    temp = getIndexContents(unfiltered.substring(0, end));

                    if (temp.indexOf("Vejetaryen") != -1)
                    {
                        tempV = temp.substring(temp.indexOf("Vejetaryen"), temp.indexOf("/", temp.indexOf("Vejetaryen")));
                        vej = true;
                    }

                    if (temp.indexOf("/") != -1)
                        temp = temp.substring(0, temp.indexOf("/"));

                    if ( this.foods.size() > 0)
                    {
                        if ( temp.compareTo(this.foods.get(this.foods.size() - 1)) != 0 )
                            this.foods.add(temp);
                    }
                    else
                        this.foods.add(temp);

                    //vejetaryen kısmı için
                    if (vej)
                    {
                        if ( this.foods.size() > 0)
                        {
                            if ( tempV.compareTo(this.foods.get(this.foods.size() - 1)) != 0 )
                                this.foods.add(tempV);
                        }
                        else
                            this.foods.add(tempV);
                        vej = false;
                    }
                    unfiltered = unfiltered.substring(end - 1);
                }
                else
                {
                    condition = false;
                }
            }
            return finalChecker( adjustArray( this.foods ) );
        }
        else
        {
            for (int i = 0; i < 154; i++)
            {
                this.foods.add(unfiltered);
            }
            return this.foods;
        }
    }
    public String getIndexContents( String index)
    {
        String pureText = index;
        String filteredText = "";
        boolean pass = false;

        for ( int checker = 0; checker < pureText.length(); checker++ )
        {
            if ( pureText.charAt( checker ) == '<' )
            {
                pass = true;
                while ( pass )
                {
                    if ( pureText.charAt( checker ) == '>' )
                        pass = false;
                    else
                        checker++;
                }
            }
            else
                filteredText += pureText.charAt( checker );
        }
        return filteredText;
    }
    public ArrayList<String> adjustArray(ArrayList<String> x)
    {
        String temp;
        int index;
        for ( int adjust1 = 0; adjust1 < x.size(); adjust1++)
        {
            temp = x.get(adjust1);
            x.set(adjust1, turnToNormalString(temp));
        }
        for ( int adjust2 = 0; adjust2 < x.size(); adjust2++) {
            if (x.get(adjust2).equals("") || x.get(adjust2).indexOf("Enerji") != -1 ||
                    x.get(adjust2).indexOf("Karbonhidrat") != -1 || x.get(adjust2).indexOf("Protein") != -1) {
                x.remove(adjust2);
                adjust2--;
            }
        }
        for ( int adjust3 = 0; adjust3 < x.size(); adjust3++){
            if (x.get(adjust3).indexOf("nbsp") != -1) {
                temp = x.get(adjust3);
                index = x.get(adjust3).indexOf("nbsp");
                temp = (String) temp.substring(0, index) + temp.substring(index + 4);
                x.set(adjust3, temp);
            }
        }
        for ( int i = 0; i < 8; i++)
            x.remove(0);

        return x;
    }
    //string bir harfle mi başlıyo onu kontrol eder
    private boolean isLetter( char c)
    {
        String alphabet = "qwertyuıopğüasdfghjklşizxcvbnmöçÇİ/() ";
        for (int counter = 0; counter < alphabet.length(); counter++)
            if ( c == alphabet.charAt(counter) || c == Character.toUpperCase(alphabet.charAt(counter)))
                return true;
        return false;
    }
    public String turnToNormalString( String x)
    {
        int blank;
        x = x.trim();
        String temp = "";
        for ( int i = 0; i < x.length(); i++)
            if ( isLetter(x.charAt(i)))
                temp += x.charAt(i);
        while (temp.indexOf("  ") != -1 )
        {
            blank = temp.indexOf("  ");
            temp = temp.substring(0, blank) + temp.substring(blank + 1);
        }
        return temp;
    }
    private ArrayList<String> finalChecker( ArrayList<String> x )
    {
        String temp;
        for ( int j = 0; j < this.willFixed.length; j++)
        {
            temp = x.get(willFixed[j]);
            x.set(willFixed[j], temp.substring( temp.indexOf(" ") + 1));
        }
        for ( int i = 0; i < this.willRemoved.length; i++)
            x.remove( this.willRemoved[i] );
        return x;
    }
}