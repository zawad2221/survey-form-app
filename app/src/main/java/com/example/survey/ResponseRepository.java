package com.example.survey;

import android.content.Context;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import com.example.survey.model.Response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResponseRepository {

    private static final String DIBAGING_TAG = "DIBAGING_TAG";
    private static ResponseRepository instance;
    public static ResponseRepository getInstance(){
        if(instance==null){
            instance = new ResponseRepository();

        }
        return instance;
    }

    public void saveResponse(Context context, Response response){
        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/form/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();
        Api api=retrofit.create(Api.class);
        Call<Response> call = api.saveResponse(response);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.isSuccessful()){
                    Toast.makeText(context,"saved",Toast.LENGTH_LONG).show();
                }
                else {
                    Log.d("MainActivity","failed1");
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.d("MainActivity","failed"+t.getMessage());

            }
        });

    }
}
