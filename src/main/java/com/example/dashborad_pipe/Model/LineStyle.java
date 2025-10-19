package com.example.dashborad_pipe.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LineStyle {
    private Integer width = 4;
    private String shadowColor;
    private Integer shadowBlur;
    private Integer shadowOffsetY;
    private String color;
}
