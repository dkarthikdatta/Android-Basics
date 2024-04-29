package com.example.myapplication.machinecoding.parkinglot.models.vm

import com.example.myapplication.machinecoding.parkinglot.models.ParkingLot
import com.example.myapplication.machinecoding.parkinglot.models.Slot
import com.example.myapplication.machinecoding.parkinglot.models.SlotCoordinates
import com.example.myapplication.machinecoding.parkinglot.models.ValidVehicleType
import com.example.myapplication.machinecoding.parkinglot.models.Vehicle

class Lot(val parkingLot: ParkingLot) {


    var mParkingLot: ParkingLot = parkingLot

    //    private var lot: MutableList<MutableList<Slot>> = mutableListOf()
    private lateinit var singleFloorSlots: Array<Slot>
    private var slotNoInFloor: Int = 0
    private var floorNo: Int = 0
    private var totalSlotsInEachFloor = 0
    private var totalFloor = 0
    private var currentMaxTruckSlot: SlotCoordinates = SlotCoordinates(0, 0)
    private var currentMaxCarSlot: SlotCoordinates = SlotCoordinates(0, 3)
    private var currentMaxBikeSlot: SlotCoordinates = SlotCoordinates(0, 1)
    lateinit var lot: Array<Array<Slot>>
    private var parkedCars: HashMap<String, SlotCoordinates> = hashMapOf()
    private var parkedBikes: HashMap<String, SlotCoordinates> = hashMapOf()
    private var parkedTrucks: HashMap<String, SlotCoordinates> = hashMapOf()

    init {
        totalFloor = mParkingLot.noOfFloors
        totalSlotsInEachFloor = mParkingLot.noOfSlotsPerFloor

        lot = Array(totalFloor) { row ->
            Array(totalSlotsInEachFloor) { column ->
                Slot(
                    type = ValidVehicleType.NONE,  // Change the type based on your requirements
                    vehicle = null,
                    floorNo = row,  // Assuming floor numbers start from 1
                    slotNo = column, // Assuming slot numbers start from 1
                    filled = false
                )
            }
        }
        floorNo = mParkingLot.noOfFloors - 1
        while (floorNo >= 0) {
            slotNoInFloor = mParkingLot.noOfSlotsPerFloor - 1
            singleFloorSlots = Array(totalSlotsInEachFloor) {
                Slot(
                    type = ValidVehicleType.NONE,  // Change the type based on your requirements
                    vehicle = null,
                    floorNo = 0,  // Assuming floor numbers start from 1
                    slotNo = it, // Assuming slot numbers start from 1
                    filled = false
                )
            }
            while (slotNoInFloor >= 0) {
                if (slotNoInFloor == 0) {
                    singleFloorSlots[slotNoInFloor] =
                        (Slot(ValidVehicleType.TRUCK, null, floorNo, slotNoInFloor, false))
                } else if (slotNoInFloor == 1 || slotNoInFloor == 2) {
                    singleFloorSlots[slotNoInFloor] =
                        (Slot(ValidVehicleType.BIKE, null, floorNo, slotNoInFloor, false))
                } else {
                    singleFloorSlots[slotNoInFloor] =
                        (Slot(ValidVehicleType.CAR, null, floorNo, slotNoInFloor, false))
                }
                slotNoInFloor--
            }
            lot[floorNo] = singleFloorSlots
            floorNo--
        }
    }

    fun parkVehicle(vehicle: Vehicle): String {
        return when (vehicle.type) {
            ValidVehicleType.CAR -> parkCar(vehicle)
            ValidVehicleType.TRUCK -> parkTruck(vehicle)
            ValidVehicleType.BIKE -> parkBike(vehicle)
            else -> {
                ""
            }
        }
    }

    private fun parkCar(vehicle: Vehicle): String {
        var parkingSlotNo: Int = 0
        var parkingFloor: Int = 0
        var parkedCoordinates: SlotCoordinates = SlotCoordinates(0, 0)
        if (currentMaxCarSlot.slotNo == totalSlotsInEachFloor - 1 && currentMaxCarSlot.floorNo == totalFloor - 1) {
            return "Slots are not available"
        } else {
            for (floorNo in currentMaxCarSlot.floorNo..totalFloor - 1) {
                for (slotNo in currentMaxCarSlot.slotNo..totalSlotsInEachFloor - 1) {
                    if (lot[floorNo][slotNo].filled == false && lot[floorNo][slotNo].type == ValidVehicleType.CAR) {
                        parkingSlotNo = slotNo
                        parkingFloor = floorNo
                        parkedCoordinates = SlotCoordinates(parkingFloor, parkingSlotNo)
                        lot[parkingFloor][parkingSlotNo] =
                            Slot(vehicle.type, vehicle, parkingFloor, parkingSlotNo, true)
                        parkedCars.put(vehicle.regNo, parkedCoordinates)
                        updateMaxOccupiedSlots(vehicle.type, parkedCoordinates)
                        return "Successfully parked in Floor " + parkingFloor + " slot " + parkingSlotNo
                    }
                }
            }
        }
        return "Slots are not available"
    }

    private fun parkTruck(vehicle: Vehicle): String {
        var parkingSlotNo: Int = 0
        var parkingFloor: Int = 0
        var parkedCoordinates: SlotCoordinates = SlotCoordinates(0, 0)
        if (currentMaxTruckSlot.floorNo == totalFloor - 1) {
            return "Slots are not available"
        } else {
            for (floorNo in currentMaxTruckSlot.floorNo..totalFloor - 1) {
                for (slotNo in currentMaxTruckSlot.slotNo..totalSlotsInEachFloor - 1) {
                    if (lot[floorNo][slotNo].filled == false && lot[floorNo][slotNo].type == ValidVehicleType.TRUCK) {
                        parkingSlotNo = slotNo
                        parkingFloor = floorNo
                        parkedCoordinates = SlotCoordinates(parkingFloor, parkingSlotNo)
                        lot[parkingFloor][parkingSlotNo] =
                            Slot(vehicle.type, vehicle, parkingFloor, parkingSlotNo, true)
                        parkedTrucks.put(vehicle.regNo, parkedCoordinates)
                        updateMaxOccupiedSlots(vehicle.type, parkedCoordinates)
                        return "Successfully parked in Floor " + parkingFloor + " slot " + parkingSlotNo
                    }
                }
            }
        }
        return "Slots are not available"
    }

    private fun parkBike(vehicle: Vehicle): String {
        var parkingSlotNo: Int = 0
        var parkingFloor: Int = 0
        var parkedCoordinates: SlotCoordinates = SlotCoordinates(0, 0)
        if (currentMaxBikeSlot.floorNo == totalFloor - 1 && currentMaxBikeSlot.slotNo == 2) {
            return "Slots are not available"
        } else {
            for (floorNo in currentMaxBikeSlot.floorNo..totalFloor - 1) {
                for (slotNo in currentMaxBikeSlot.slotNo..totalSlotsInEachFloor - 1) {
                    if (lot[floorNo][slotNo].filled == false && lot[floorNo][slotNo].type == ValidVehicleType.BIKE) {
                        parkingSlotNo = slotNo
                        parkingFloor = floorNo
                        parkedCoordinates = SlotCoordinates(parkingFloor, parkingSlotNo)
                        lot[parkingFloor][parkingSlotNo] =
                            Slot(vehicle.type, vehicle, parkingFloor, parkingSlotNo, true)
                        parkedBikes.put(vehicle.regNo, parkedCoordinates)
                        updateMaxOccupiedSlots(vehicle.type, parkedCoordinates)
                        return "Successfully parked in Floor " + parkingFloor + " slot " + parkingSlotNo
                    }
                }
            }
        }
        return "Slots are not available"
    }

    public fun unParkVehicle(regNo: String): String {
        if (parkedCars.containsKey(regNo)) {
            val coordinates: SlotCoordinates? = parkedCars.get(regNo)
            coordinates?.let {
                parkedCars.remove(regNo)
                lot[it.floorNo][it.slotNo] =
                    Slot(ValidVehicleType.NONE, null, it.floorNo, it.slotNo, false)
                updateMaxOccupiedSlotsWhileUnPark(ValidVehicleType.CAR, it)
                return "Sucessfully removed vehicle: " + regNo
            }
        } else if (parkedBikes.containsKey(regNo)) {
            val coordinates: SlotCoordinates? = parkedBikes.get(regNo)
            coordinates?.let {
                parkedBikes.remove(regNo)
                lot[it.floorNo][it.slotNo] =
                    Slot(ValidVehicleType.NONE, null, it.floorNo, it.slotNo, false)
                updateMaxOccupiedSlotsWhileUnPark(ValidVehicleType.BIKE, it)
                return "Sucessfully removed vehicle: " + regNo
            }
        } else if (parkedTrucks.containsKey(regNo)) {
            val coordinates: SlotCoordinates? = parkedTrucks.get(regNo)
            coordinates?.let {
                parkedTrucks.remove(regNo)
                lot[it.floorNo][it.slotNo] =
                    Slot(ValidVehicleType.NONE, null, it.floorNo, it.slotNo, false)
                updateMaxOccupiedSlotsWhileUnPark(ValidVehicleType.TRUCK, it)
                return "Sucessfully removed vehicle: " + regNo
            }
        }
        return "Could not find the vehicle"
    }
    private fun updateMaxOccupiedSlots(type: ValidVehicleType, parkedCoordinates: SlotCoordinates) {
        when (type) {
            ValidVehicleType.CAR -> currentMaxCarSlot = parkedCoordinates
            ValidVehicleType.BIKE -> currentMaxBikeSlot = parkedCoordinates
            ValidVehicleType.TRUCK -> currentMaxTruckSlot = parkedCoordinates
            else -> {

            }
        }
    }

    private fun updateMaxOccupiedSlotsWhileUnPark(
        type: ValidVehicleType,
        slotCoordinates: SlotCoordinates
    ) {
        when (type) {
            ValidVehicleType.CAR -> {
                if (slotCoordinates.floorNo <= currentMaxCarSlot.floorNo) {
                    if (slotCoordinates.slotNo < currentMaxCarSlot.floorNo) {
                        currentMaxCarSlot =
                            SlotCoordinates(slotCoordinates.floorNo, slotCoordinates.slotNo)
                    }
                }
            }

            ValidVehicleType.BIKE -> {
                if (slotCoordinates.floorNo <= currentMaxBikeSlot.floorNo) {
                    if (slotCoordinates.slotNo < currentMaxBikeSlot.floorNo) {
                        currentMaxBikeSlot =
                            SlotCoordinates(slotCoordinates.floorNo, slotCoordinates.slotNo)
                    }
                }
            }

            ValidVehicleType.TRUCK -> {
                if (slotCoordinates.floorNo <= currentMaxTruckSlot.floorNo) {
                    if (slotCoordinates.slotNo < currentMaxTruckSlot.floorNo) {
                        currentMaxTruckSlot =
                            SlotCoordinates(slotCoordinates.floorNo, slotCoordinates.slotNo)
                    }
                }
            }

            else -> {}
        }
    }
}