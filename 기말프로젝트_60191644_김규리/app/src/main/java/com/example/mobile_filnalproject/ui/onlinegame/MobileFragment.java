package com.example.mobile_filnalproject.ui.onlinegame;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.mobile_filnalproject.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MobileFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MobileFragment() {
        // Required empty public constructor
    }

    public static MobileFragment newInstance(String param1, String param2) {
        MobileFragment fragment = new MobileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private String getJSONString(){
        String json = "";

        try{
            InputStream is = getResources().getAssets().open("mobilegame.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        } catch (IOException e) { e.printStackTrace(); }

        return json;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mobile, container, false);

        ListView listView = root.findViewById(R.id.listView);
        MobileGameAdapter listAdapter = new MobileGameAdapter();

        String json = getJSONString();

        try{
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("mobilegames");
            for ( int i = 0; i < jsonArray.length(); i++ ){
                JSONObject listObject = jsonArray.getJSONObject(i);

                MobileGameList item = new MobileGameList();

                int imgID = getContext().getResources().getIdentifier(listObject.getString("fileName"), "drawable", getContext().getPackageName());
                item.setImage(ContextCompat.getDrawable(getContext(),imgID));
                item.setName(listObject.getString("title"));
                listAdapter.addItem(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listView.setAdapter(listAdapter);

        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
