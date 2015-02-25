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

import com.example.android.wearable.gridviewpager.R;
import com.example.android.wearable.gridviewpager.user.Contact;
import com.example.android.wearable.gridviewpager.user.UserSettings;

public class DistanceFragment extends Fragment {

    private int contactNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        contactNumber = this.getArguments().getInt("contact_number");
        return inflater.inflate(R.layout.fragment_distance, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        Contact contact = UserSettings.getInstance(getActivity()).getContacList().get(contactNumber);
        ((ImageView) getView().findViewById(R.id.contact_image)).setBackground(contact.getPicture());
        ((TextView) getView().findViewById(R.id.distance_text)).setText(contact.getName() + " " + contact.getDistance());
    }
}
