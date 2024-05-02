package com.dxc.di.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@lombok.Data
@AllArgsConstructor
@Builder
public class Data
{
    private String text;
    private int number;

}
