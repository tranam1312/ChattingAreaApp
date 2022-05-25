package com.example.chattingarea.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chattingarea.R;

public class AddPeopleChatGroupScreen extends Fragment {


    public static AddPeopleChatGroupScreen newInstance(String param1, String param2) {
        AddPeopleChatGroupScreen fragment = new AddPeopleChatGroupScreen();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_people_chat_group_screen, container, false);
    }
}