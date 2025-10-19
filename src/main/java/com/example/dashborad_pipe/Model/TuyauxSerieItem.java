package com.example.dashborad_pipe.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TuyauxSerieItem {
   private String name;
   private String type;
   private LineStyle lineStyle;
   private Emphasis emphasis;
   private MarkPoint markPoint;
   private List<Double> data = new ArrayList<>();
}
