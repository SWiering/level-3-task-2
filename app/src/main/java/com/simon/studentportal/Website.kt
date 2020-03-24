package com.simon.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Website (
    var name: String,
    var url: String
): Parcelable