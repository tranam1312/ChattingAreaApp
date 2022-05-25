package com.example.chattingarea.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.example.chattingarea.R;
import com.example.chattingarea.model.UserChatOverview;
import com.example.chattingarea.model.UserDto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChatGroup_Screen extends Fragment {
    private AppCompatImageView back;
    private View mRootView;
    private FloatingActionButton floatingActionButton;


    private ArrayList<UserDto> listUserDto = new ArrayList();
    private ArrayList<UserChatOverview> listData = new ArrayList();
    private UserDto currentUserDto = new UserDto();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return mRootView = inflater.inflate(R.layout.fragment_chat_gruop_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initAction();
        initData();
    }

    private void initView() {
        back = mRootView.findViewById(R.id.back);
        floatingActionButton = mRootView.findViewById(R.id.add_float);

    }

    private void initAction() {
        back.setOnClickListener(view -> requireActivity().onBackPressed());

//        floatingActionButton.setOnClickListener(view-> );
    }

    private void initData() {
    }
}