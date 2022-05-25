package com.example.chattingarea.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.chattingarea.Constant;
import com.example.chattingarea.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ChatDetailScreen extends Fragment {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mUserRef;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseStorage storage;
    private StorageReference storageReference;

    private View mRootView;
    private RecyclerView mRcv;
    private EditText mEdtChat;
    private Button mBtnSend;

    public ChatDetailScreen() {
    }

    public static ChatDetailScreen newInstance(String param1, String param2) {
        ChatDetailScreen fragment = new ChatDetailScreen();
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
        mRootView = inflater.inflate(R.layout.fragment_chat_detail_screen, container, false);
        initView();
        initAction();
        initData();
        return mRootView;
    }

    private void initView() {
        mDatabase = FirebaseDatabase.getInstance();
        mUserRef = mDatabase.getReference(Constant.MESSAGE_REF);
        mFirebaseAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();

        mRcv = mRootView.findViewById(R.id.chat_detail_rcv);
        mEdtChat = mRootView.findViewById(R.id.chat_detail_edt_chat_box);
        mBtnSend = mRootView.findViewById(R.id.chat_detail_btn_send);
    }

    private void initAction() {
        mBtnSend.setOnClickListener(view -> {
            String mess = mEdtChat.getText().toString();
            if (TextUtils.isEmpty(mess)) {
                return;
            }

        });
    }

    private void initData() {
        getHistoryMess();
    }

    private void getHistoryMess() {

    }

}