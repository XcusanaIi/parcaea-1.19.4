package io.github.xcusanaii.parcaea.model;

import net.minecraft.text.MutableText;

import java.util.ArrayList;
import java.util.List;

public class PInfo {

    public static List<PInfo> pInfos = new ArrayList<>();

    public double xPercent;
    public double yPercent;
    public float scale;
    public int color;
    public int life;
    public MutableText info;

    public PInfo(double xPercent, double yPercent, float scale, int color, int life, MutableText info) {
        this.xPercent = xPercent;
        this.yPercent = yPercent;
        this.scale = scale;
        this.color = color;
        this.life = life;
        this.info = info;
    }
}
