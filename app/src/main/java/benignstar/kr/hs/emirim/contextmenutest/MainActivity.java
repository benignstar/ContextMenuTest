package benignstar.kr.hs.emirim.contextmenutest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
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


}
