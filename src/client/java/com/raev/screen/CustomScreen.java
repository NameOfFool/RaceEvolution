package com.raev.screen;


import com.raev.RaceEvolution;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class CustomScreen extends Screen {
    //Конструктор
    public CustomScreen(Text title) {
        //super используется для того, чтобы обратиться к родителю(Screen) и проделать действия, прописанные в его конструкторе
        super(title);
    }



    //Вызывается при инициализации
    @Override
    protected void init() {

        //Создаём кнопку, пихаем в неё текст и задаём действия, которые происходят при её нажатии
        ButtonWidget buttonWidget = ButtonWidget.builder(Text.of("Example"), (btn) -> {

            //При нажатии на кнопку окно закрывается
            this.close();

        }).dimensions(40, 40, 120, 20).build();//Задаём положение и размеры кнопки

        this.addDrawableChild(buttonWidget);//Добавляем кнопку на экран
    }

    //Вызывается каждый кадр
    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        //Вызываем, чтобы обратиться к родительскому render, без этого задники не прогрузятся
        super.render(context, mouseX, mouseY, delta);
        //Добавляем на экран текст
        context.drawText(
                this.textRenderer,
                "Special Button",
                40,
                40 - this.textRenderer.fontHeight - 10,
                0xFFFFFF,
                true);
        context.drawTexture(Identifier.of(RaceEvolution.MOD_ID, "textures/gui/choose_origin.png"),
                0, 0, this.width, this.height, 0, 0, 16, 16, 16, 16);

    }
}
