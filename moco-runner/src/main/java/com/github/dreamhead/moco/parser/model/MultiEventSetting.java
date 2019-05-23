package com.github.dreamhead.moco.parser.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.github.dreamhead.moco.Moco;
import com.github.dreamhead.moco.MocoEventTrigger;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

import static com.google.common.collect.ImmutableList.of;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public final class MultiEventSetting {
    private List<CompleteEventSetting> completeList;

    public ImmutableList<MocoEventTrigger> triggers() {
        if (completeList != null) {
            List<MocoEventTrigger> mocoEventTriggerList = Lists.newArrayList();
            for (CompleteEventSetting completeEventSetting : completeList){
                MocoEventTrigger mocoEventTrigger = Moco.complete(completeEventSetting.createTrigger());
                mocoEventTriggerList.add(mocoEventTrigger);
            }
            return ImmutableList.copyOf(mocoEventTriggerList);
        }

        return of();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .omitNullValues()
                .add("completeList", completeList)
                .toString();
    }
}
