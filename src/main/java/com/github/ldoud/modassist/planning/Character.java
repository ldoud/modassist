package com.github.ldoud.modassist.planning;

import com.github.ldoud.modassist.data.Mod;
import com.github.ldoud.modassist.data.ModType;
import com.github.ldoud.modassist.data.StatName;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.HashMap;
import java.util.Map;

@PlanningEntity
public class Character {
    private Map<ModType, Mod> modsByType = new HashMap<>();

    @PlanningVariable(valueRangeProviderRefs = {"transmitter"}, nullable = true)
    public Mod getTransmitter() {
        return modsByType.get(ModType.Transmitter);
    }
    public void setTransmitter(Mod transmitter) {
        modsByType.put(ModType.Transmitter, transmitter);
    }

    @PlanningVariable(valueRangeProviderRefs = {"receiver"}, nullable = true)
    public Mod getReceiver() {
        return modsByType.get(ModType.Receiver);
    }
    public void setReceiver(Mod receiver) {
        modsByType.put(ModType.Receiver, receiver);
    }

    @PlanningVariable(valueRangeProviderRefs = {"processor"}, nullable = true)
    public Mod getProcessor() {
        return modsByType.get(ModType.Processor);
    }
    public void setProcessor(Mod processor) {
        modsByType.put(ModType.Processor, processor);
    }

    @PlanningVariable(valueRangeProviderRefs = {"holoArray"}, nullable = true)
    public Mod getHoloArray() {
        return modsByType.get(ModType.HoloArray);
    }
    public void setHoloArray(Mod holoArray) {
        modsByType.put(ModType.HoloArray, holoArray);
    }

    @PlanningVariable(valueRangeProviderRefs = {"dataBus"}, nullable = true)
    public Mod getDataBus() {
        return modsByType.get(ModType.DataBus);
    }
    public void setDataBus(Mod dataBus) {
        modsByType.put(ModType.DataBus, dataBus);
    }

    @PlanningVariable(valueRangeProviderRefs = {"multiplexer"}, nullable = true)
    public Mod getMultiplexer() {
        return modsByType.get(ModType.Multiplexer);
    }
    public void setMultiplexer(Mod multiplexer) {
        modsByType.put(ModType.Multiplexer, multiplexer);
    }

    public int getSpeed() {
        double speed = modsByType.values().stream()
                .filter(mod -> mod != null)
                .flatMap(mod -> mod.getStats().stream())
                .filter(stat -> stat.getName() == StatName.Speed)
                .mapToDouble(stat -> stat.getValue())
                .sum();

        return (int)speed;
    }
}
