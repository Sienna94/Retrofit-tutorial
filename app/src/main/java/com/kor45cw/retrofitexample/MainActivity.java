package com.kor45cw.retrofitexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.kor45cw.retrofitexample.Retrofit.ResponseBody.ResponseGet;
import com.kor45cw.retrofitexample.Retrofit.RetroCallback;
import com.kor45cw.retrofitexample.Retrofit.RetroClient;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String LOG = "MainActivity";

    @BindView(R.id.link) TextView mLink;
    @BindView(R.id.body_result) TextView bodyResultTextView;
    @BindView(R.id.code_result) TextView codeResultTextView;
    @BindView(R.id.id_result) TextView idResultTextView;
    @BindView(R.id.userid_result) TextView useridResultTextView;
    @BindView(R.id.title_result) TextView titleResultTextView;

    RetroClient retroClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        retroClient = RetroClient.getInstance(this).createBaseApi();
        mLink.setMovementMethod(LinkMovementMethod.getInstance());
    }


    @OnClick(R.id.get1)
    void get1() {
        Toast.makeText(this, "GET 1 Clicked", Toast.LENGTH_SHORT).show();
        retroClient.getFirst("1", new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                Log.e(LOG, t.toString());
                codeResultTextView.setText("Error");
                idResultTextView.setText("Error");
                titleResultTextView.setText("Error");
                useridResultTextView.setText("Error");
                bodyResultTextView.setText("Error");
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                codeResultTextView.setText(String.valueOf(code));
                idResultTextView.setText(String.valueOf(data.id));
                titleResultTextView.setText(data.title);
                useridResultTextView.setText(String.valueOf(data.userId));
                bodyResultTextView.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                codeResultTextView.setText(code);
                idResultTextView.setText("Failure");
                titleResultTextView.setText("Failure");
                useridResultTextView.setText("Failure");
                bodyResultTextView.setText("Failure");
            }
        });
    }

    @OnClick(R.id.get2)
    void get2() {
        Toast.makeText(this, "GET 2 Clicked", Toast.LENGTH_SHORT).show();
        retroClient.getSecond("1", new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                Log.e(LOG, t.toString());
                codeResultTextView.setText("Error");
                idResultTextView.setText("Error");
                titleResultTextView.setText("Error");
                useridResultTextView.setText("Error");
                bodyResultTextView.setText("Error");
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                List<ResponseGet> data = (List<ResponseGet>) receivedData;
                codeResultTextView.setText(String.valueOf(code));
                if (!data.isEmpty()) {
                    idResultTextView.setText(String.valueOf(data.get(0).id));
                    titleResultTextView.setText(data.get(0).title);
                    useridResultTextView.setText(String.valueOf(data.get(0).userId));
                    bodyResultTextView.setText(data.get(0).body);
                } else {
                    idResultTextView.setText("Empty");
                    titleResultTextView.setText("Empty");
                    useridResultTextView.setText("Empty");
                    bodyResultTextView.setText("Empty");
                }
            }

            @Override
            public void onFailure(int code) {
                codeResultTextView.setText(code);
                idResultTextView.setText("Failure");
                titleResultTextView.setText("Failure");
                useridResultTextView.setText("Failure");
                bodyResultTextView.setText("Failure");
            }
        });
    }

    @OnClick(R.id.post)
    void post() {
        Toast.makeText(this, "POST Clicked", Toast.LENGTH_SHORT).show();

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("title", "foo");
        parameters.put("body", "bar");
        parameters.put("userId", 1);

        retroClient.postFirst(parameters, new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                Log.e(LOG, t.toString());
                codeResultTextView.setText("Error");
                idResultTextView.setText("Error");
                titleResultTextView.setText("Error");
                useridResultTextView.setText("Error");
                bodyResultTextView.setText("Error");
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                codeResultTextView.setText(String.valueOf(code));
                idResultTextView.setText(String.valueOf(data.id));
                titleResultTextView.setText(data.title);
                useridResultTextView.setText(String.valueOf(data.userId));
                bodyResultTextView.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                codeResultTextView.setText(code);
                idResultTextView.setText("Failure");
                titleResultTextView.setText("Failure");
                useridResultTextView.setText("Failure");
                bodyResultTextView.setText("Failure");
            }
        });
    }

    @OnClick(R.id.put)
    void put() {
        Toast.makeText(this, "PUT Clicked", Toast.LENGTH_SHORT).show();

        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("title", "foo");
        parameters.put("body", "bar");
        parameters.put("userId", 1);
        parameters.put("id", 1);

        retroClient.putFirst(parameters, new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                Log.e(LOG, t.toString());
                codeResultTextView.setText("Error");
                idResultTextView.setText("Error");
                titleResultTextView.setText("Error");
                useridResultTextView.setText("Error");
                bodyResultTextView.setText("Error");
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                codeResultTextView.setText(String.valueOf(code));
                idResultTextView.setText(String.valueOf(data.id));
                titleResultTextView.setText(data.title);
                useridResultTextView.setText(String.valueOf(data.userId));
                bodyResultTextView.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                codeResultTextView.setText(code);
                idResultTextView.setText("Failure");
                titleResultTextView.setText("Failure");
                useridResultTextView.setText("Failure");
                bodyResultTextView.setText("Failure");
            }
        });
    }

    @OnClick(R.id.patch)
    void patch() {
        Toast.makeText(this, "PATCH Clicked", Toast.LENGTH_SHORT).show();

        retroClient.createBaseApi().patchFirst("foo", new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                Log.e(LOG, t.toString());
                codeResultTextView.setText("Error");
                idResultTextView.setText("Error");
                titleResultTextView.setText("Error");
                useridResultTextView.setText("Error");
                bodyResultTextView.setText("Error");
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                ResponseGet data = (ResponseGet) receivedData;
                codeResultTextView.setText(String.valueOf(code));
                idResultTextView.setText(String.valueOf(data.id));
                titleResultTextView.setText(data.title);
                useridResultTextView.setText(String.valueOf(data.userId));
                bodyResultTextView.setText(data.body);
            }

            @Override
            public void onFailure(int code) {
                codeResultTextView.setText(code);
                idResultTextView.setText("Failure");
                titleResultTextView.setText("Failure");
                useridResultTextView.setText("Failure");
                bodyResultTextView.setText("Failure");
            }
        });
    }

    @OnClick(R.id.delete)
    void delete() {
        Toast.makeText(this, "DELETE Clicked", Toast.LENGTH_SHORT).show();

        retroClient.deleteFirst(new RetroCallback() {
            @Override
            public void onError(Throwable t) {
                Log.e(LOG, t.toString());
                codeResultTextView.setText("Error");
                idResultTextView.setText("Error");
                titleResultTextView.setText("Error");
                useridResultTextView.setText("Error");
                bodyResultTextView.setText("Error");
            }

            @Override
            public void onSuccess(int code, Object receivedData) {
                codeResultTextView.setText(String.valueOf(code));
                idResultTextView.setText("");
                titleResultTextView.setText("");
                useridResultTextView.setText("");
                bodyResultTextView.setText("");
            }

            @Override
            public void onFailure(int code) {
                codeResultTextView.setText(code);
                idResultTextView.setText("Failure");
                titleResultTextView.setText("Failure");
                useridResultTextView.setText("Failure");
                bodyResultTextView.setText("Failure");
            }
        });
    }
}
