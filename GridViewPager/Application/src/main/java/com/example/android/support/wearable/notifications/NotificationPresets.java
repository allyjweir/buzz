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

package com.example.android.support.wearable.notifications;

import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.view.Gravity;

/**
 * Collection of notification builder presets.
 */
public class NotificationPresets {
    private static final String EXAMPLE_GROUP_KEY = "example";
    public static final NotificationPreset GRAVITY = new GravityNotificationPreset();


    private static NotificationCompat.Builder applyBasicOptions(Context context,
            NotificationCompat.Builder builder, NotificationCompat.WearableExtender wearableOptions,
            NotificationPreset.BuildOptions options) {

        builder.setContentTitle(options.titlePreset)
                .setContentText(options.textPreset)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setDeleteIntent(NotificationUtil.getExamplePendingIntent(
                        context, R.string.example_notification_deleted));
        options.actionsPreset.apply(context, builder, wearableOptions);
        options.priorityPreset.apply(builder, wearableOptions);
        if (options.includeLargeIcon) {
            builder.setLargeIcon(BitmapFactory.decodeResource(
                    context.getResources(), R.drawable.example_large_icon));
        }
        if (options.isLocalOnly) {
            builder.setLocalOnly(true);
        }
        if (options.hasContentIntent) {
            builder.setContentIntent(NotificationUtil.getExamplePendingIntent(context,
                    R.string.content_intent_clicked));
        }
        if (options.vibrate) {
            builder.setVibrate(new long[] {0, 100, 50, 100} );
        }
        return builder;
    }

    private static class GravityNotificationPreset extends NotificationPreset {
        public GravityNotificationPreset() {
            super(R.string.gravity_example, R.string.example_content_title,
                R.string.example_content_text);
        }

        @Override
        public Notification[] buildNotifications(Context context, BuildOptions options) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

            NotificationCompat.WearableExtender wearableOptions =
                    new NotificationCompat.WearableExtender();

            applyBasicOptions(context, builder, wearableOptions, options);

            wearableOptions.setGravity(Gravity.NO_GRAVITY);
            builder.extend(wearableOptions);

            return new Notification[] { builder.build() };
        }
    }
}
