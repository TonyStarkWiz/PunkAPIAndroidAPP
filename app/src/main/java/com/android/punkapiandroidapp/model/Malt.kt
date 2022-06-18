package com.android.punkapiandroidapp.model


import com.google.gson.annotations.SerializedName

data class Malt(
    @SerializedName("amount")
    val amount: AmountX,
    @SerializedName("name")
    val name: String
)