package br.com.emerson.aulaactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PrimeiraActivity extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);

        button = findViewById(R.id.button_primeira_activity);

        int cont = 0;

        Intent intent = getIntent();
        Bundle param = intent.getExtras();

        if(param!=null) {
            cont = param.getInt("CONTADOR");
        }

        button.setText(String.valueOf(cont));

        Log.i("myapp","onCreate()");
    }

    public void next(View v){
        int cont = Integer.parseInt(button.getText().toString());
        cont+=1;
        Intent intent = new Intent(this, SegundaActivity.class);
        intent.putExtra("CONTADOR",cont);
        System.out.println("CONTADOR: " + cont);
        startActivityForResult(intent,5);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 5){
            int cont = data.getIntExtra("CONTADOR",0);
            button.setText(String.valueOf(cont));
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("myapp","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("myapp","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("myapp","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("myapp","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("myapp","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("myapp","onRestart()");
    }
}
















