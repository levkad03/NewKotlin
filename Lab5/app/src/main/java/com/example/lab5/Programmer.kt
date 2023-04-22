package com.example.lab5

import android.os.Parcel
import android.os.Parcelable

data class Programmer(
    val Name:String,
    val Age:Int,
    val ProgrammingLanguage:String
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeInt(Age)
        parcel.writeString(ProgrammingLanguage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Programmer> {
        override fun createFromParcel(parcel: Parcel): Programmer {
            return Programmer(parcel)
        }

        override fun newArray(size: Int): Array<Programmer?> {
            return arrayOfNulls(size)
        }
    }
}
