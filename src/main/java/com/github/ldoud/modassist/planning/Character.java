package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Character {
    private Mod transmitter;
    private Mod receiver;
    private Mod processor;
    private Mod holoArray;
    private Mod dataBus;
    private Mod multiplexer;

    @PlanningVariable(valueRangeProviderRefs = {"transmitter"}, nullable = true)
    public Mod getTransmitter() {
        return transmitter;
    }

    public void setTransmitter(Mod transmitter) {
        this.transmitter = transmitter;
    }

    @PlanningVariable(valueRangeProviderRefs = {"receiver"}, nullable = true)
    public Mod getReceiver() {
        return receiver;
    }

    public void setReceiver(Mod receiver) {
        this.receiver = receiver;
    }

    @PlanningVariable(valueRangeProviderRefs = {"processor"}, nullable = true)
    public Mod getProcessor() {
        return processor;
    }

    public void setProcessor(Mod processor) {
        this.processor = processor;
    }

    @PlanningVariable(valueRangeProviderRefs = {"holoArray"}, nullable = true)
    public Mod getHoloArray() {
        return holoArray;
    }

    public void setHoloArray(Mod holoArray) {
        this.holoArray = holoArray;
    }

    @PlanningVariable(valueRangeProviderRefs = {"dataBus"}, nullable = true)
    public Mod getDataBus() {
        return dataBus;
    }

    public void setDataBus(Mod dataBus) {
        this.dataBus = dataBus;
    }

    @PlanningVariable(valueRangeProviderRefs = {"multiplexer"}, nullable = true)
    public Mod getMultiplexer() {
        return multiplexer;
    }

    public void setMultiplexer(Mod multiplexer) {
        this.multiplexer = multiplexer;
    }

    // TODO
    public int getSpeed() {
        return 1;
    }
}
