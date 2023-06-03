package io.github.xcusanaii.parcaea.model.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.CollapsibleObject;
import me.shedaniel.autoconfig.annotation.ConfigEntry.Gui.Tooltip;

import static io.github.xcusanaii.parcaea.Parcaea.MOD_ID;

@SuppressWarnings("FieldMayBeFinal")
@Config(name = MOD_ID)
public class ModConfig implements ConfigData {

    @CollapsibleObject
    public CfgGeneral cfgGeneral = new CfgGeneral();

    @CollapsibleObject
    public ColorGeneral colorGeneral = new ColorGeneral();

    @CollapsibleObject
    public Labels labels = new Labels();

    @CollapsibleObject
    public GlobalLabel globalLabel = new GlobalLabel();

    public static class GlobalLabel {
        @Tooltip
        public float scale = 1.0F;
        @Tooltip
        public int colorKey = Colors.AQUA;
        @Tooltip
        public int colorValue = Colors.WHITE;
        @Tooltip
        public int decimalCount = 3;
    }

    public static class Labels {
        @CollapsibleObject
        public Label x = new Label(100, 100);
        @CollapsibleObject
        public Label y = new Label(100, 130);
        @CollapsibleObject
        public Label z = new Label(100, 110);
        @CollapsibleObject
        public Label facing = new Label(320, 180);

        public static class Label {
            @Tooltip
            public int posX;
            @Tooltip
            public int posY;
            @Tooltip
            public float scale = 1.0F;
            @Tooltip
            public int colorKey = Colors.AQUA;
            @Tooltip
            public int colorValue = Colors.WHITE;
            @Tooltip
            public boolean visible = true;
            @Tooltip
            public int decimalCount = 3;

            public Label(int posX, int posY) {
                this.posX = posX;
                this.posY = posY;
            }
        }
    }

    public static class CfgGeneral {
        @Tooltip
        public boolean enGlobalLabelConfig = true;
    }

    public static class ColorGeneral {
        @Tooltip
        public int themeColor = Colors.AQUA;
        @Tooltip
        public int white = Colors.WHITE;
    }

    public static class Colors {
        public static int BARRIER = 0xFFFF4500;
        public static int COORD_MARKER_BG = 0x3F000000;
        public static int LABEL = 16777120;
        public static int BTN_ENABLE = 0xFF00DD00;
        public static int BTN_DISABLE = 0xFFDD0000;
        public static int YELLOW_ALPHA = 0xBBF2EEA2;
        public static int BLUE_ALPHA = 0xBB9CCDFC;
        public static int PINK_ALPHA = 0xBBFD84A1;
        public static int BLUE = 0xFF9CCDFC;
        public static int AQUA = 0xFF00DDDD;
        public static int WHITE = 0xFFFFFFFF;
        public static int PINK = 0xFFFD84A1;
        public static int ORANGE = 0xFFFE7C03;
        public static int YELLOW = 0xFFF2EEA2;
        public static int MAGENTA = 0xFFE24BE4;
        public static int BORDER_BLACK = 0xCC000000;
        public static int ALL_PERFECT = 0xFFFEFBBE;
        public static int FULL_COMBO = 0xFFB7EDFB;
        public static int A_MISS = 0xFFF8F8FA;
        public static int ALL_PERFECT_BORDER = 0xCCFEFBBE;
        public static int FULL_COMBO_BORDER = 0xCCB7EDFB;
        public static int A_MISS_BORDER = 0xCCF8F8FA;
        public static int UNPRESSED_KEY = 0x44FFFFFF;
        public static int PRESSED_KEY = 0x88FFFFFF;
        public static int PRESSED_KEY_BORDER = 0x88FFFFFF;
        public static int BG_UNSTABLE = 0x88F08080;
        public static int BUTTON_COLOR = 0x88000000;
        public static int BUTTON_COLOR_HOVER = 0x88444444;
    }

}
