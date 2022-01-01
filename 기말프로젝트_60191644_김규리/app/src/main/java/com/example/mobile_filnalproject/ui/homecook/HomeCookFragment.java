package com.example.mobile_filnalproject.ui.homecook;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobile_filnalproject.R;
import com.example.mobile_filnalproject.ui.hometraining.HomeTrainingViewModel;
import com.example.mobile_filnalproject.ui.hometraining.ListItem;
import com.example.mobile_filnalproject.ui.hometraining.YoutuberAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class HomeCookFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_homecook, container, false);

        RecyclerView recyclerView = root.findViewById(R.id.cooks);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new ItemDecoration(getActivity()));

        CookAdapter cookAdapter = new CookAdapter();

        String json = getJSONString();

        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("cooks");
            for ( int i = 0; i < jsonArray.length(); i++ ){
                JSONObject listObject = jsonArray.getJSONObject(i);

                Cook item = new Cook();

                int imgID = getContext().getResources().getIdentifier(listObject.getString("fileName"), "drawable", getContext().getPackageName());
                item.setImage(ContextCompat.getDrawable(getContext(),imgID));
                item.setName(listObject.getString("title"));
                item.setMaterial(listObject.getString("material"));
                item.setRecipe(listObject.getString("recipe"));

                cookAdapter.addItem(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        recyclerView.setAdapter(cookAdapter);

        return root;
    }

    private String getJSONString(){
        String json = "";

        try{
            InputStream is = getResources().getAssets().open("cooks.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) { e.printStackTrace(); }

        return json;
    }
}