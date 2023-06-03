package io.github.xcusanaii.parcaea.render.gui;

import dev.isxander.yacl.api.ConfigCategory;
import dev.isxander.yacl.api.Option;
import dev.isxander.yacl.api.OptionGroup;
import dev.isxander.yacl.api.YetAnotherConfigLib;
import dev.isxander.yacl.gui.controllers.ColorController;
import dev.isxander.yacl.gui.controllers.TickBoxController;
import dev.isxander.yacl.gui.controllers.string.number.FloatFieldController;
import dev.isxander.yacl.gui.controllers.string.number.IntegerFieldController;
import io.github.xcusanaii.parcaea.Parcaea;
import io.github.xcusanaii.parcaea.event.TickHandler;
import io.github.xcusanaii.parcaea.model.config.ModConfig;
import io.github.xcusanaii.parcaea.model.label.APLabel;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

import java.awt.*;

public class ModConfigMenu {
    public static Screen getScreen(Screen parent) {
        return YetAnotherConfigLib.createBuilder()
                .title(Text.literal("Parcaea Config"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("General"))
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("General"))
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.literal("Disable All Labels"))
                                        .binding(false, () -> TickHandler.disableAllLabels, newVal -> TickHandler.disableAllLabels = newVal)
                                        .controller(TickBoxController::new)
                                        .build())
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.literal("Enable Global Label Config"))
                                        .binding(true, () -> Parcaea.getConfig().cfgGeneral.enGlobalLabelConfig, newVal -> Parcaea.getConfig().cfgGeneral.enGlobalLabelConfig = newVal)
                                        .controller(TickBoxController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Theme Color"))
                                        .binding(new Color(ModConfig.Colors.AQUA), () -> new Color(Parcaea.getConfig().colorGeneral.themeColor), newVal -> Parcaea.getConfig().colorGeneral.themeColor = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Global Label Config"))
                                .option(Option.createBuilder(Float.class)
                                        .name(Text.literal("Scale"))
                                        .binding(1.0F, () -> Parcaea.getConfig().globalLabel.scale, newVal -> {
                                            if (newVal > 0 && newVal <= 10.0F){
                                                Parcaea.getConfig().globalLabel.scale = newVal;
                                            }
                                        })
                                        .controller(FloatFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("DecimalCount"))
                                        .binding(3, () -> Parcaea.getConfig().globalLabel.decimalCount, newVal -> {
                                            if (newVal >= 0 && newVal <= 16) {
                                                Parcaea.getConfig().globalLabel.decimalCount = newVal;
                                            }
                                        })
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Name Color"))
                                        .binding(new Color(ModConfig.Colors.AQUA), () -> new Color(Parcaea.getConfig().globalLabel.colorKey), newVal -> Parcaea.getConfig().globalLabel.colorKey = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Value Color"))
                                        .binding(new Color(ModConfig.Colors.WHITE), () -> new Color(Parcaea.getConfig().globalLabel.colorValue), newVal -> Parcaea.getConfig().globalLabel.colorValue = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .build())
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Text.literal("Labels"))
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("X"))
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.literal("Visible"))
                                        .binding(true, () -> Parcaea.getConfig().labels.x.visible, newVal -> Parcaea.getConfig().labels.x.visible = newVal)
                                        .controller(TickBoxController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("X Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.x.posX, newVal -> Parcaea.getConfig().labels.x.posX = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("Y Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.x.posY, newVal -> Parcaea.getConfig().labels.x.posY = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Name Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.x.colorKey), () -> new Color(Parcaea.getConfig().labels.x.colorKey), newVal -> Parcaea.getConfig().labels.x.colorKey = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Value Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.x.colorValue), () -> new Color(Parcaea.getConfig().labels.x.colorValue), newVal -> Parcaea.getConfig().labels.x.colorValue = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("DecimalCount"))
                                        .binding(3, () -> Parcaea.getConfig().labels.x.decimalCount, newVal -> {
                                            if (newVal >= 0 && newVal <= 16) {
                                                Parcaea.getConfig().labels.x.decimalCount = newVal;
                                            }
                                        })
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Float.class)
                                        .name(Text.literal("Scale"))
                                        .binding(1.0F, () -> Parcaea.getConfig().labels.x.scale, newVal -> {
                                            if (newVal > 0 && newVal <= 10.0F){
                                                Parcaea.getConfig().labels.x.scale = newVal;
                                            }
                                        })
                                        .controller(FloatFieldController::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Y"))
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.literal("Visible"))
                                        .binding(true, () -> Parcaea.getConfig().labels.y.visible, newVal -> Parcaea.getConfig().labels.y.visible = newVal)
                                        .controller(TickBoxController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("X Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.y.posX, newVal -> Parcaea.getConfig().labels.y.posX = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("Y Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.y.posY, newVal -> Parcaea.getConfig().labels.y.posY = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Name Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.y.colorKey), () -> new Color(Parcaea.getConfig().labels.y.colorKey), newVal -> Parcaea.getConfig().labels.y.colorKey = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Value Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.y.colorValue), () -> new Color(Parcaea.getConfig().labels.y.colorValue), newVal -> Parcaea.getConfig().labels.y.colorValue = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("DecimalCount"))
                                        .binding(3, () -> Parcaea.getConfig().labels.y.decimalCount, newVal -> {
                                            if (newVal >= 0 && newVal <= 16) {
                                                Parcaea.getConfig().labels.y.decimalCount = newVal;
                                            }
                                        })
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Float.class)
                                        .name(Text.literal("Scale"))
                                        .binding(1.0F, () -> Parcaea.getConfig().labels.y.scale, newVal -> {
                                            if (newVal > 0 && newVal <= 10.0F){
                                                Parcaea.getConfig().labels.y.scale = newVal;
                                            }
                                        })
                                        .controller(FloatFieldController::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Z"))
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.literal("Visible"))
                                        .binding(true, () -> Parcaea.getConfig().labels.z.visible, newVal -> Parcaea.getConfig().labels.z.visible = newVal)
                                        .controller(TickBoxController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("X Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.z.posX, newVal -> Parcaea.getConfig().labels.z.posX = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("Y Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.z.posY, newVal -> Parcaea.getConfig().labels.z.posY = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Name Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.z.colorKey), () -> new Color(Parcaea.getConfig().labels.z.colorKey), newVal -> Parcaea.getConfig().labels.z.colorKey = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Value Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.z.colorValue), () -> new Color(Parcaea.getConfig().labels.z.colorValue), newVal -> Parcaea.getConfig().labels.z.colorValue = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("DecimalCount"))
                                        .binding(3, () -> Parcaea.getConfig().labels.z.decimalCount, newVal -> {
                                            if (newVal >= 0 && newVal <= 16) {
                                                Parcaea.getConfig().labels.z.decimalCount = newVal;
                                            }
                                        })
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Float.class)
                                        .name(Text.literal("Scale"))
                                        .binding(1.0F, () -> Parcaea.getConfig().labels.z.scale, newVal -> {
                                            if (newVal > 0 && newVal <= 10.0F){
                                                Parcaea.getConfig().labels.z.scale = newVal;
                                            }
                                        })
                                        .controller(FloatFieldController::new)
                                        .build())
                                .build())
                        .group(OptionGroup.createBuilder()
                                .name(Text.literal("Facing"))
                                .option(Option.createBuilder(Boolean.class)
                                        .name(Text.literal("Visible"))
                                        .binding(true, () -> Parcaea.getConfig().labels.facing.visible, newVal -> Parcaea.getConfig().labels.facing.visible = newVal)
                                        .controller(TickBoxController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("X Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.facing.posX, newVal -> Parcaea.getConfig().labels.facing.posX = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("Y Position"))
                                        .binding(50, () -> Parcaea.getConfig().labels.facing.posY, newVal -> Parcaea.getConfig().labels.facing.posY = newVal)
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Name Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.facing.colorKey), () -> new Color(Parcaea.getConfig().labels.facing.colorKey), newVal -> Parcaea.getConfig().labels.facing.colorKey = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Color.class)
                                        .name(Text.literal("Value Color"))
                                        .binding(new Color(Parcaea.getConfig().labels.facing.colorValue), () -> new Color(Parcaea.getConfig().labels.facing.colorValue), newVal -> Parcaea.getConfig().labels.facing.colorValue = newVal.getRGB())
                                        .controller(ColorController::new)
                                        .build())
                                .option(Option.createBuilder(Integer.class)
                                        .name(Text.literal("DecimalCount"))
                                        .binding(3, () -> Parcaea.getConfig().labels.facing.decimalCount, newVal -> {
                                            if (newVal >= 0 && newVal <= 16) {
                                                Parcaea.getConfig().labels.facing.decimalCount = newVal;
                                            }
                                        })
                                        .controller(IntegerFieldController::new)
                                        .build())
                                .option(Option.createBuilder(Float.class)
                                        .name(Text.literal("Scale"))
                                        .binding(1.0F, () -> Parcaea.getConfig().labels.facing.scale, newVal -> {
                                            if (newVal > 0 && newVal <= 10.0F){
                                                Parcaea.getConfig().labels.facing.scale = newVal;
                                            }
                                        })
                                        .controller(FloatFieldController::new)
                                        .build())
                                .build())
                        .build())
                .save(APLabel::reloadLabelsFromConfig)
                .build()
                .generateScreen(parent);
    }
}
