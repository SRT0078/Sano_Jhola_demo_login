package com.example.nestedrecyclerview.View;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nestedrecyclerview.Presenter.ContactsAdapter;
import com.example.nestedrecyclerview.Model.ContactModel;
import com.example.nestedrecyclerview.R;

import java.util.ArrayList;
import java.util.Objects;

public class ContactsFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<ContactModel> contactModelArrayList;
    View viewContacts;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return viewContacts = inflater.inflate(R.layout.contacts_fragment, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstenceState) {
        super.onViewCreated(view, savedInstenceState);
        recyclerView = viewContacts.findViewById(R.id.rv_contactsContener);

        // used the divider
        @SuppressLint("UseRequireInsteadOfGet")
        RecyclerView.ItemDecoration divider = new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.HORIZONTAL);
        recyclerView.addItemDecoration(divider);

        contactModelArrayList = new ArrayList<>();
        contactModelArrayList.add(new ContactModel("Facebook", "9808765123"));
        contactModelArrayList.add(new ContactModel("Google", "9710509875"));
        contactModelArrayList.add(new ContactModel("Learn Coding", "980126833"));
        contactModelArrayList.add(new ContactModel("Twitter", "9811250109"));
        contactModelArrayList.add(new ContactModel("Alarms", "9812345670"));
        contactModelArrayList.add(new ContactModel("Tik Tok", "9701375013"));
        contactModelArrayList.add(new ContactModel("Messenger", "9835012344"));
        contactModelArrayList.add(new ContactModel("Instragram", "98025225"));
        contactModelArrayList.add(new ContactModel("Audio", "9876893210"));
        contactModelArrayList.add(new ContactModel("Youtube", "9713093422"));
        contactModelArrayList.add(new ContactModel("Java", "9705764392"));
        contactModelArrayList.add(new ContactModel("Meets", "9812345601"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ContactsAdapter adapter = new ContactsAdapter(getActivity(), contactModelArrayList);
        recyclerView.setAdapter(adapter);

    }
}