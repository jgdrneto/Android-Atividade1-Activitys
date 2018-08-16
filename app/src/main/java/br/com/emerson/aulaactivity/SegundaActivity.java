package br.com.emerson.aulaactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends Activity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        button = findViewById(R.id.button_segunda_activity);

        Intent intent = getIntent();
        Bundle param = intent.getExtras();

        int cont = param.getInt("CONTADOR");

        button.setText(String.valueOf(cont));

    }

    public void next(View v){

        int cont = Integer.parseInt(button.getText().toString());
        cont+=1;
        Intent intent = new Intent(this, PrimeiraActivity.class);
        intent.putExtra("CONTADOR",cont);
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

}

















