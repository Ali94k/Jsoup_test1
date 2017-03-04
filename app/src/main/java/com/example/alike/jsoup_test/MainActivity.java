package com.example.alike.jsoup_test;

import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;

public class MainActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.tex1);
        Button but = (Button)findViewById(R.id.but1);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DoIt().execute();

            }
        });
    }
    public class DoIt  extends AsyncTask<Void ,Void , Void>
    {
        String words;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                org.jsoup.nodes.Document doc = Jsoup.connect("https://www.google.az").get();

              //  Document doc = (Document) Jsoup.connect("https://www.google.az").get();

                words = doc.text();

            }catch (Exception e){e.printStackTrace();}

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            text.setText(words);
        }
    }

}
