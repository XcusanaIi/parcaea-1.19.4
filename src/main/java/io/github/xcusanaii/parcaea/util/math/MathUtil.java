package io.github.xcusanaii.parcaea.util.math;

public class MathUtil {

    public static double mapFacing(double yaw) {
        yaw %= 360.0;
        if (yaw > 180.0) {
            yaw -= 360.0;
        }else if (yaw < -180.0){
            yaw += 360.0;
        }
        return yaw;
    }

    public static Facing getFacingEnum(double yaw) {
        double radians = Math.toRadians(yaw);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        return Math.abs(cos) > Math.abs(sin) ? Facing.Z : Facing.X;
    }

    public enum Facing {
        X,
        Z
    }
}
