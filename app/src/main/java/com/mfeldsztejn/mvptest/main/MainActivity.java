package com.mfeldsztejn.mvptest.main;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mfeldsztejn.mvptest.R;
import com.mfeldsztejn.mvptest.base.BaseActivity;
import com.mfeldsztejn.mvptest.main.behaviours.PullUpBehaviour;
import com.mfeldsztejn.mvptest.navigation.Router;
import com.mfeldsztejn.mvptest.repositories.HistoryRepository;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    private String num1 = "";
    private String num2 = "";
    private String operation;
    private TextView resultTv;
    private TextView num1Tv;
    private TextView num2Tv;
    private TextView operationTv;
    private ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        MenuItem item = menu.getItem(0);
        item.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_history));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.history) {
            getPresenter().showHistory();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initViews() {
        root = (ViewGroup) findViewById(R.id.activity_main);
        num1Tv = (TextView) findViewById(R.id.num_1);
        num2Tv = (TextView) findViewById(R.id.num_2);
        operationTv = (TextView) findViewById(R.id.operation);
        resultTv = (TextView) findViewById(R.id.result);
        LinearLayout numbersContainer = (LinearLayout) findViewById(R.id.numbers_container);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) numbersContainer.getLayoutParams();
        params.setBehavior(new PullUpBehaviour());
    }

    public void onNumberClick(View v) {
        setNumber(((Button) v).getText().toString());
    }

    public void onOperationClick(View v) {
        operation = ((Button) v).getText().toString();
        operationTv.setText(operation);
    }

    public void onDecimalClick(View v) {
        if (operation == null) {
            if (!num1.contains(".") && num1.length() > 0)
                num1 += ".";
            num1Tv.setText(num1);
        } else {
            if (!num2.contains(".") && num2.length() > 0)
                num2 += ".";
            num2Tv.setText(num2);
        }
    }

    public void calculate(View v) {
        getPresenter().calculate(Float.valueOf(num1), Float.valueOf(num2), operation);
    }

    private void setNumber(String text) {
        if (operation == null) {
            num1 += text;
            num1Tv.setText(num1);
        } else {
            num2 += text;
            num2Tv.setText(num2);
        }
    }

    public void clean(View v) {
        num1 = "";
        num2 = "";
        operation = null;
        if (v != null) {
            num1Tv.setText(null);
            num2Tv.setText(null);
            operationTv.setText(null);
            resultTv.setText(null);
        }
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(new HistoryRepository(this), new Router(this));
    }

    @Override
    protected MainView getView() {
        return this;
    }

    @Override
    public void setResult(float result) {
        resultTv.setText(String.valueOf(result));
        getPresenter().saveResult(num1, num2, operation, result);
        clean(null);
    }

    @Override
    public void setSnackBarError(String error) {
        Snackbar.make(root, error, Snackbar.LENGTH_SHORT).show();
    }
}
