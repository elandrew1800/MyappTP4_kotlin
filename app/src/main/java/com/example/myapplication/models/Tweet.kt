package com.example.myapplication.models

import android.os.Parcel
import android.os.Parcelable

data class Tweet(
    val user: String?,
    val tweet: String?,




    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(user)
        parcel.writeString(tweet)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Tweet> {
        override fun createFromParcel(parcel: Parcel): Tweet {
            return Tweet(parcel)
        }

        override fun newArray(size: Int): Array<Tweet?> {
            return arrayOfNulls(size)
        }
    }
}