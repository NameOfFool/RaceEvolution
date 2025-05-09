package com.raev.screen;

import com.raev.RaceEvolution;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;

public class ChooseRaceScreen extends Screen {

    private static final Identifier WINDOW_BACKGROUND = Identifier.of(RaceEvolution.MOD_ID,"textures/gui/chooseracemenu.png");
    private static final int TEXTURE_WIDTH = 256;
    private static final int TEXTURE_HEIGHT = 256;

    public ChooseRaceScreen(Text title) {
        super(title);

    }

    @Override
    protected void init() {

        ButtonWidget buttonWidget = ButtonWidget.builder(Text.of("ДжокирИзПсехушк"), (btn) -> {
        }).build();


        super.init();
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {

        super.render(context, mouseX, mouseY, delta);
        float scale = Math.min(
                (float)this.width/TEXTURE_WIDTH,(float)this.height/TEXTURE_HEIGHT
        );
        int scaledWidth = (int)(TEXTURE_WIDTH*scale);
        int scaledHeight = (int)(TEXTURE_HEIGHT*scale);
        int x = (this.width-scaledWidth)/2;
        int y = (this.height-scaledHeight)/2;

        context.drawTexture(WINDOW_BACKGROUND,x,y,0,0,scaledWidth,scaledHeight,TEXTURE_WIDTH,TEXTURE_HEIGHT);

    }
}
