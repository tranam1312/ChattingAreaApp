package com.example.chattingarea.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chattingarea.MainActivity;
import com.example.chattingarea.R;

public class HomeScreen extends Fragment {

    private TextView tvChatFriend;
    private TextView tvChatGroup;
    private TextView tvProfile;
    private TextView tvSignOut;
    private View mRootView;

    public HomeScreen() {
    }

    public static HomeScreen newInstance(String param1, String param2) {
        HomeScreen fragment = new HomeScreen();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_home_screen, container, false);
        initView();
        initAction();
        return mRootView;
    }

    private void initView() {
        tvChatFriend = mRootView.findViewById(R.id.home_btn_chat_friend);
        tvChatGroup = mRootView.findViewById(R.id.home_btn_chat_group);
        tvSignOut = mRootView.findViewById(R.id.home_btn_sign_out);
        tvProfile = mRootView.findViewById(R.id.home_btn_profile);
    }

    private void initAction() {
        tvSignOut.setOnClickListener(view -> ((MainActivity)getActivity()).openLoginScreen());

        tvProfile.setOnClickListener(view -> ((MainActivity)getActivity()).openProfileScreen());

        tvChatFriend.setOnClickListener(view -> ((MainActivity)getActivity()).openChatScreen());
    }



}