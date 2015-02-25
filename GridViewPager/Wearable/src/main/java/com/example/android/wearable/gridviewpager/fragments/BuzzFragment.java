/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.wearable.gridviewpager.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.wearable.gridviewpager.R;
import com.example.android.wearable.gridviewpager.user.Contact;
import com.example.android.wearable.gridviewpager.user.UserSettings;

public class BuzzFragment extends Fragment {

    private Contact contact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        int contactNumber = this.getArguments().getInt("contact_number");
        contact = UserSettings.getInstance(getActivity()).getContacList().get(contactNumber);
        return inflater.inflate(R.layout.fragment_buzz, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        ((ImageView) getView().findViewById(R.id.buzz_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contact.isAvailable())
                Toast.makeText(getActivity(), "Buzz sent", Toast.LENGTH_SHORT).show();
            else Toast.makeText(getActivity(), contact.getName()+" is busy", Toast.LENGTH_SHORT).show();}
        });
    }
}
