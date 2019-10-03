package example.com.blockgame_net;

import android.graphics.RectF;

public class Brick {

    private RectF rect;

    private boolean isVisible;
    private int count,type;

    public Brick(int row, int column, int width, int height,int count){

        isVisible = true;
        this.count=count;
        type=count;
        int padding = 1;

        rect = new RectF(column * width + padding,
                row * height + padding,
                column * width + width - padding,
                row * height + height - padding);
    }

    public RectF getRect(){
        return this.rect;
    }

    public void setInvisible(){
        isVisible = false;
    }

    public boolean getVisibility(){
        return isVisible;
    }
    public int getType(){ return type;}
    public int getCount(){ return count;}
    public void setCount(){count--;}
}
