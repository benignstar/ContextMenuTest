package benignstar.kr.hs.emirim.contextmenutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button but1=(Button)findViewById(R.id.but1);
        Button but2=(Button)findViewById(R.id.but2);
        registerForContextMenu(but1);
        registerForContextMenu(but2);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater=getMenuInflater();
        if(v.getId()==R.id.but1){
            menu.setHeaderTitle("Background Color");
            menuInflater.inflate(R.menu.menu1, menu);
            menu.setHeaderIcon(R.drawable.santaclaus);
        }
        if(v.getId()==R.id.but2){
            menuInflater.inflate(R.menu.menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        LinearLayout linear=(LinearLayout)findViewById(R.id.linear);
        ImageView img1=(ImageView)findViewById(R.id.img1);
        switch (item.getItemId()){
            case R.id.menu1_item_green :
                linear.setBackgroundColor(Color.rgb(183, 240, 177));
                return true;
            case R.id.menu1_item_red :
                linear.setBackgroundColor(Color.rgb(255, 167, 167));
                return true;
            case R.id.menu1_item_sky :
                linear.setBackgroundColor(Color.rgb(178, 235, 244));
                return true;
            case R.id.menu2_item_rotation :
                img1.setRotation(img1.getRotation()+15);
                return true;
            case R.id.menu2_item_size :
                img1.setScaleX(img1.getScaleX()*1.2f);
                img1.setScaleY(img1.getScaleY()*1.2f);
                return true;
           /* case R.id.menu2_item_replace :
                if(img1.get==R.drawable.snowglobe)
                 img1.setImageResource(R.drawable.santaclaus2);
                else img1.setImageResource(R.drawable.snowglobe);
                return true;*/
            case R.id.menu2_item_backagain :
                img1.setImageResource(R.drawable.snowglobe);
       //         img1.setScaleX(imgView_X);
        //        img1.setScaleY(imgView_Y);
                img1.setRotation(0);
                return true;
        }
        return false;
    }
}
