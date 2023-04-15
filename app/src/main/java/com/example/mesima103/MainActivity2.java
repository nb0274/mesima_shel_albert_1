package com.example.mesima103;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.mesimashelalberto1.R;

public class MainActivity2 extends AppCompatActivity {
    String url = "https://www.mathpapa.com/quadratic-formula/?q=";
    WebView sel;
    Intent gi;
    Button return_to_main;
    double a;
    double b;
    double c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        return_to_main = (Button) findViewById(R.id.return_to_main);
        sel = (WebView) findViewById(R.id.selution);
        sel.getSettings().setJavaScriptEnabled(true);
        sel.setWebViewClient(new MyWebViewClient());
        gi = getIntent();
        a = gi.getIntExtra("a", -1);
        b = gi.getIntExtra("b", -1);
        c = gi.getIntExtra("c", -1);
        url = url + a + "x^2+" + b + "x+" + c + "%3D0";
        sel.loadUrl(url);

    }

    public void returnClicked(View view) {
        double x1 = 0;
        double x2 = 0;
        double descrim = b * b - (4 * a * c);
        if (descrim < 0) {
            gi.putExtra("descrim", 0);
        }
        if (descrim == 0) {
            gi.putExtra("descrim", 1);
            x1 = (-b + Math.sqrt(descrim)) / (2 * a);
        }
        if (descrim > 0) {
            gi.putExtra("descrim", 2);
            x1 = (-b + Math.sqrt(descrim)) / (2 * a);
            x2 = (-b - Math.sqrt(descrim)) / (2 * a);
        }
        gi.putExtra("x1", x1);
        gi.putExtra("x2", x2);
        setResult(RESULT_OK, gi);
        finish();
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}