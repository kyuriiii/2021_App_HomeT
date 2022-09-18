package com.example.mobile_filnalproject.ui.hometraining;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_filnalproject.R;
import com.example.mobile_filnalproject.ui.home.HomeViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class HomeTrainingFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hometraining, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.youtubers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));

        YoutuberAdapter youtuberAdapter = new YoutuberAdapter();
        youtuberAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.youtuber_1),"힙으뜸", "https://www.youtube.com/channel/UC4yq3FWEWqMvFNFBsV3gbKQ");
        youtuberAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.youtuber_2),"땅끄부부", "https://www.youtube.com/channel/UCpg89Ys3E4BaLGgEEWVmI9g");
        youtuberAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.youtuber_3),"요가소년","https://www.youtube.com/channel/UCkTRKCuFrRiXQm_gMG1uDvg");
        youtuberAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.youtuber_4),"피지컬갤러리","https://www.youtube.com/channel/UCdtRAcd3L_UpV4tMXCw63NQ");
        youtuberAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.youtuber_5),"핏블리","https://www.youtube.com/channel/UC3hRpIQ4x5niJDwjajQSVPg");
        youtuberAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.youtuber_6),"매미킴","https://www.youtube.com/channel/UCXVhGNDrOfVUYEvuRdM0OXA");
        youtuberAdapter.addItem(ContextCompat.getDrawable(getContext(),R.drawable.youtuber_7),"강하나 스트레칭","https://www.youtube.com/channel/UCxHcczukcG21up2MBe8yP_Q");

        recyclerView.setAdapter(youtuberAdapter);

        ListView listView = root.findViewById(R.id.listView);
        ListViewAdapter listAdapter = new ListViewAdapter();

        String json = getJSONString();

        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("trainings");
            for ( int i = 0; i < jsonArray.length(); i++ ){
                JSONObject listObject = jsonArray.getJSONObject(i);

                ListItem item = new ListItem();

                int imgID = getContext().getResources().getIdentifier(listObject.getString("fileName"), "drawable", getContext().getPackageName());
                item.setImage(ContextCompat.getDrawable(getContext(),imgID));
                item.setTitle(listObject.getString("title"));
                item.setYoutuber(listObject.getString("youtuber"));
                item.setInformation(listObject.getString("information"));
                item.setLink(listObject.getString("code"));

                listAdapter.addItem(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView.setAdapter(listAdapter);

        return root;
    }

    private String getJSONString(){
        String json = "";

        try{
            InputStream is = getResources().getAssets().open("training.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) { e.printStackTrace(); }

        return json;
    }
}