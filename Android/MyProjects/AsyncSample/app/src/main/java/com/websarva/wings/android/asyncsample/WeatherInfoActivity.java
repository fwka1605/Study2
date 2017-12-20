package com.websarva.wings.android.asyncsample;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WeatherInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);

        Intent intent = getIntent();  // （1）
        String cityName = intent.getStringExtra("cityName");  // （1）
        String cityId = intent.getStringExtra("cityId");  // （1）

        TextView tvCityName = (TextView) findViewById(R.id.tvCityName);
        TextView tvWeatherTelop = (TextView) findViewById(R.id.tvWeatherTelop);
        TextView tvWeatherDesc = (TextView) findViewById(R.id.tvWeatherDesc);

        WeatherInfoReceiver receiver = new WeatherInfoReceiver(cityName, tvCityName, tvWeatherTelop, tvWeatherDesc);

        receiver.execute(cityId);  // （3）
    }

    private class WeatherInfoReceiver extends AsyncTask<String,String,String>{

        private String _cityName;
        private TextView _tvCityName;
        private TextView _tvWeatherTelop;
        private TextView _tvWeatherDesc;
        public WeatherInfoReceiver(String cityName, TextView tvCityName, TextView tvWeatherTelop, TextView tvWeatherDesc) {
            _cityName = cityName;
            _tvCityName = tvCityName;
            _tvWeatherTelop = tvWeatherTelop;
            _tvWeatherDesc = tvWeatherDesc;
        }


        @Override
        public String doInBackground(String... params){
            String id = params[0];  // （1）
            String urlStr = "http://weather.livedoor.com/forecast/webservice/json/v1?city=" + id;  // （2）

            HttpURLConnection con = null;  // （3）
            InputStream is = null;  // （3）
            String result = "";  // （3）

            try{
                URL url = new URL(urlStr);  // （4）
                con = (HttpURLConnection) url.openConnection();  // （5）
                con.setRequestMethod("GET");  // （6）
                con.connect();  // （7）
                is = con.getInputStream();  // （8）
                result = is2String(is);  // （9）
            }
            catch(MalformedURLException ex){

            }
            catch(IOException ex){

            }
            finally {
                if(con != null) {
                    con.disconnect();  // （10）
                }
                if(is != null) {
                    try {
                        is.close();  // （11）
                    }
                    catch(IOException ex) {
                    }
                }
            }
            return result;  // （12）
        }

        @Override
        public void onPostExecute(String result){
            String desc = "";
            String dateLabel = "";
            String telop = "";

            try {
                JSONObject rootJSON = new JSONObject(result);  // （1）
                JSONObject descriptionJSON = rootJSON.getJSONObject("description");  // （2）
                desc = descriptionJSON.getString("text");  // （3）
                JSONArray forecasts = rootJSON.getJSONArray("forecasts");  // （4）
                JSONObject forecastNow = forecasts.getJSONObject(0);
                dateLabel = forecastNow.getString("dateLabel");  // （3）
                telop = forecastNow.getString("telop");  // （3）
            }
            catch(JSONException ex) {
            }

            _tvCityName.setText(_cityName + "の" + dateLabel + "の天気: ");  // （5）
            _tvWeatherTelop.setText(telop);  // （5）
            _tvWeatherDesc.setText(desc);  // （5）

        }

        /**
         * InputStreamオブジェクトを文字列に変換するメソッド。変換文字コードはUTF-8。
         *
         * @param is 変換対象のInputStreamオブジェクト。
         * @return 変換された文字列。
         * @throws IOException 変換に失敗した時に発生。
         */
        private String is2String(InputStream is) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuffer sb = new StringBuffer();
            char[] b = new char[1024];
            int line;
            while(0 <= (line = reader.read(b))) {
                sb.append(b, 0, line);
            }
            return sb.toString();
        }


    }
}

