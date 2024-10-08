package com.example.myapplication.machinecoding.parkinglot.models.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ParkingLotVMFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ParkingLotViewModel() as T
    }

}