package com.example.myapplication.designpatterns.structural.adapter

class SocketAdapterImpl : SocketAdapter, Socket() {
    override fun get120Volts(): Volt {
        return getVolt()
    }

    override fun get60Volts(): Volt {
        return Volt(getVolt().volt / 2)
    }

    override fun get30Volts(): Volt {
        return Volt(getVolt().volt / 4)
    }
}