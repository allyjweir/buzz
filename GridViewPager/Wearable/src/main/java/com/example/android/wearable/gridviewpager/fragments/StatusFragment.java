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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.wearable.gridviewpager.R;
import com.example.android.wearable.gridviewpager.user.UserSettings;

public class StatusFragment extends Fragment {

    private ImageView statusButton;
    private TextView statusText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_status, container, false);
    }

    @Override
    public void onViewCreated(View v, Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);
        statusButton = (ImageView) getView().findViewById(R.id.status_button);
        statusText = (TextView) getView().findViewById(R.id.status_text);
        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserSettings.getInstance(getActivity()).isAvailable())
                    setBusy();
                else setAvailable();
            }
        });
        if (UserSettings.getInstance(getActivity()).isAvailable())
            setBusy();
        else setAvailable();
    }

    private void setBusy() {
        UserSettings.getInstance(getActivity()).setAvailable(false);
        //statusButton.setImageResource(R.drawable.close_button);
        statusButton.setBackground(getResources().getDrawable(R.drawable.selector_status_busy));
        statusText.setText("Busy");
    }

    private void setAvailable() {
        UserSettings.getInstance(getActivity()).setAvailable(true);
        //statusButton.setImageResource(R.drawable.close_button);
        statusButton.setBackground(getResources().getDrawable(R.drawable.selector_status_available));
        statusText.setText("Available");
    }
}
