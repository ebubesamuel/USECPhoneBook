package com.usec.usecphonebook.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contacts(val stringResourceId : Int) : Parcelable {
    var name:String? = null
    var number:String? = null
    var email:String? = null
}