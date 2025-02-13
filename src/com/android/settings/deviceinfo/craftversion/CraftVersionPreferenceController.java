/*
 * Copyright (C) 2019 The Android Open Source Project
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

package com.android.settings.deviceinfo.craftversion;

import android.content.Context;
import android.os.Build;
import com.android.settings.R;
import android.os.SystemProperties;

import com.android.settings.core.BasePreferenceController;

public class CraftVersionPreferenceController extends BasePreferenceController {
	
	private static final String KEY_CRAFT_VERSION_PROP = "org.craftrom.version";
	
    public CraftVersionPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

@Override
public CharSequence getSummary() {
    String craftVersion = SystemProperties.get(KEY_CRAFT_VERSION_PROP, mContext.getString(R.string.unknown));
    String releaseOrPreviewDisplay = Build.VERSION.RELEASE_OR_PREVIEW_DISPLAY;
    if (!releaseOrPreviewDisplay.isEmpty()) {
        return mContext.getString(R.string.summary_with_version, craftVersion, releaseOrPreviewDisplay);
    } else {
        return craftVersion;
    }
}

}
