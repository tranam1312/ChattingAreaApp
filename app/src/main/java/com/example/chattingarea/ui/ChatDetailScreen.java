package com.example.chattingarea.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.chattingarea.Constant;
import com.example.chattingarea.R;
import com.example.chattingarea.Utils;
import com.example.chattingarea.adapter.FriendChatAdapter;
import com.example.chattingarea.model.MessageDetailDto;
import com.example.chattingarea.model.UserDto;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ChatDetailScreen extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String uIdOther;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mMessRef;
    private DatabaseReference mUserRef;
    private DatabaseReference mRoomRef;
    private FirebaseAuth mFirebaseAuth;

    private View mRootView;
    private RecyclerView mRcv;
    private EditText mEdtChat;
    private ImageView mBtnSend;
    private AppCompatImageView back;

    FriendChatAdapter friendChatAdapter;

    UserDto currentUser;
    private ArrayList<MessageDetailDto> listData;

    public ChatDetailScreen() {
    }

    public static ChatDetailScreen newInstance(String param1) {
        ChatDetailScreen fragment = new ChatDetailScreen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            uIdOther = getArguments().getString(ARG_PARAM1);
        }
        Log.d("tientm", uIdOther);
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
        mMessRef = mDatabase.getReference(Constant.MESSAGE_REF);
        mRoomRef = mDatabase.getReference(Constant.ROOM_REF);
        mUserRef = mDatabase.getReference(Constant.USER_REF);
        mFirebaseAuth = FirebaseAuth.getInstance();

        mRcv = mRootView.findViewById(R.id.chat_detail_rcv);
        mEdtChat = mRootView.findViewById(R.id.chat_detail_edt_chat_box);
        mBtnSend = mRootView.findViewById(R.id.chat_detail_btn_send);
        back = mRootView.findViewById(R.id.back);

        friendChatAdapter = new FriendChatAdapter(getContext(), listData, currentUser);
        mRcv.setLayoutManager(new LinearLayoutManager(getContext()));
        mRcv.setAdapter(friendChatAdapter);
    }

    private void initAction() {
        back.setOnClickListener(view -> requireActivity().onBackPressed());
        
        mBtnSend.setOnClickListener(view -> {
            String mess = mEdtChat.getText().toString();
            if (TextUtils.isEmpty(mess)) {
                return;
            } else {
                addChat(mEdtChat.getText().toString());
            }

        });
    }

    private void getCurrentUserData() {
        mUserRef.child(mFirebaseAuth.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserDto value = dataSnapshot.getValue(UserDto.class);
                currentUser = value;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("ProfileScreen", "Failed to read value.", error.toException());
            }
        });
    }

    private void addChat(String mess) {
        String key = Utils.generateString();
        MessageDetailDto messDto = new MessageDetailDto(
                key, mess, "date", true, currentUser.getId()
        );
        mMessRef.child(key).setValue(messDto).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Log.d("tientm", "addChat oke");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("tientm", "addChat fail");
            }
        });

        mRoomRef.child(currentUser.getId()).child(uIdOther).child(Utils.generateString()).setValue(key);
        mRoomRef.child(uIdOther).child(currentUser.getId()).child(Utils.generateString()).setValue(key);
    }

    private void initData() {
        getCurrentUserData();
        getHistoryMess();
    }

    private void getHistoryMess() {
        mRoomRef.child(mFirebaseAuth.getUid()).child(uIdOther).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("tientm", "ok: " + snapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("tientm", "Fail ");

            }
        });

    }

}