/*
 * Copyright (c) 2023 Qualcomm Innovation Center, Inc. All rights reserved.
 * SPDX-License-Identifier: BSD-3-Clause-Clear
 */

package com.qti.extphone;

import android.os.Parcel;
import android.os.Parcelable;

public class CiwlanConfig implements Parcelable {

    private static final String TAG = "CiwlanConfig";

    public static final int INVALID = -1;
    public static final int ONLY = 0;
    public static final int PREFERRED = 1;

    private int mHomeMode = INVALID;
    private int mRoamMode = INVALID;

    public CiwlanConfig(int homeMode, int roamMode) {
        mHomeMode = homeMode;
        mRoamMode = roamMode;
    }

    public CiwlanConfig(Parcel in) {
        mHomeMode = in.readInt();
        mRoamMode = in.readInt();
    }

    public String getHomeCiwlanMode() {
        switch (mHomeMode) {
            case ONLY:
                return "ONLY";
            case PREFERRED:
                return "PREFERRED";
            default:
                return "INVALID";
        }
    }

    public String getRoamCiwlanMode() {
        switch (mRoamMode) {
            case ONLY:
                return "ONLY";
            case PREFERRED:
                return "PREFERRED";
            default:
                return "INVALID";
        }
    }

    public boolean isCiwlanOnlyInHome() {
        return mHomeMode == ONLY;
    }

    public boolean isCiwlanOnlyInRoam() {
        return mRoamMode == ONLY;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mHomeMode);
        out.writeInt(mRoamMode);
    }

    public static final Parcelable.Creator<CiwlanConfig> CREATOR = new Parcelable.Creator() {
        @Override
        public CiwlanConfig createFromParcel(Parcel in) {
            return new CiwlanConfig(in);
        }

        @Override
        public CiwlanConfig[] newArray(int size) {
            return new CiwlanConfig[size];
        }
    };

    @Override
    public String toString() {
        return TAG + " homeMode = " + getHomeCiwlanMode() + ", roamMode = " + getRoamCiwlanMode();
    }
}
