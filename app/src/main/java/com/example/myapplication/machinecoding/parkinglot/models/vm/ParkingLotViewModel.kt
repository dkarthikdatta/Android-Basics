package com.example.myapplication.machinecoding.parkinglot.models.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.machinecoding.parkinglot.models.Constants.Bike
import com.example.myapplication.machinecoding.parkinglot.models.Constants.Car
import com.example.myapplication.machinecoding.parkinglot.models.Constants.CreateParkingLot
import com.example.myapplication.machinecoding.parkinglot.models.Constants.Display
import com.example.myapplication.machinecoding.parkinglot.models.Constants.ParkVehicle
import com.example.myapplication.machinecoding.parkinglot.models.Constants.Truck
import com.example.myapplication.machinecoding.parkinglot.models.Constants.UnParkVehicle
import com.example.myapplication.machinecoding.parkinglot.models.ParkingLot
import com.example.myapplication.machinecoding.parkinglot.models.ValidVehicleType
import com.example.myapplication.machinecoding.parkinglot.models.Vehicle

class ParkingLotViewModel : ViewModel() {

    private val outputResponse = MutableLiveData<String>()
    private lateinit var lot: Lot
    val onOutputChange: LiveData<String>
        get() = outputResponse

    val isLotCreated: Boolean = false
    fun onInput(userInput: String?) {
        userInput?.let { input ->
            input.split(" ").let { listOfInput ->
                listOfInput[0].let {
                    when (it) {
                        CreateParkingLot -> createParkingLot(listOfInput)
                        Display -> display(listOfInput)
                        ParkVehicle -> parkVehicle(listOfInput)
                        UnParkVehicle -> unParkVehicle(listOfInput)
                    }
                }
            }
        }
    }

    private fun unParkVehicle(listOfInput: List<String>) {
        if (!isLotInitalized()) {
            outputResponse.value = "Initialze Parking Lot First"
            return
        }
        if (listOfInput.size != 2) {
            outputResponse.value = "Enter Valid Input to UnPark Vehicle"
        } else {
            outputResponse.value = lot.unParkVehicle(listOfInput[1])
        }
    }

    private fun parkVehicle(listOfInput: List<String>) {
        if (!isLotInitalized()) {
            outputResponse.value = "Initialze Parking Lot First"
            return
        }
        if (listOfInput.size != 4) {
            outputResponse.value = "Enter Valid Input to Park Vehicle"
        } else {
            val type: String = listOfInput[1]
            var validVehicleType: ValidVehicleType = ValidVehicleType.CAR
            when (type) {
                Car -> validVehicleType = ValidVehicleType.CAR
                Bike -> validVehicleType = ValidVehicleType.BIKE
                Truck -> validVehicleType = ValidVehicleType.TRUCK
            }
            val vehicle = Vehicle(validVehicleType, listOfInput[2], listOfInput[3])
            outputResponse.value = lot.parkVehicle(vehicle)
        }

    }

    private fun isLotInitalized(): Boolean {
        if (this::lot.isInitialized) {
            outputResponse.value = "First initalize the Lot"
            return true
        }
        return false
    }

    private fun display(listOfInput: List<String>) {

    }

    private fun createParkingLot(listOfInput: List<String>) {
        if (isLotCreated) {
            outputResponse.value = "Parking lot already created. Input exit to terminate this"
        } else if (listOfInput.size != 4) {
            outputResponse.value = "Enter Valid Input to Create Parking Lot"
        } else {
            val lotDetails =
                ParkingLot(listOfInput.get(1), listOfInput[2].toInt(), listOfInput[3].toInt())
            lot = Lot(lotDetails)
            outputResponse.value = "Successfully Created Parking Lot"
        }
    }


}