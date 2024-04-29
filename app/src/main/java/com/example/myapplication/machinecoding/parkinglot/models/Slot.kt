package com.example.myapplication.machinecoding.parkinglot.models


data class Slot(
    val type: ValidVehicleType,
    val vehicle: Vehicle?,
    val floorNo: Int,
    val slotNo: Int,
    val filled: Boolean
)