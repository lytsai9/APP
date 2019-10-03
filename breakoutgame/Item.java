package example.com.blockgame_net;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class Item {
    private boolean fall=true;
    float x,y;
    Bitmap item;
    float left,right,top,bottom;
    float itemSpeed;
    int type; // which item
    private RectF rect;
    public Item(float right,float top,Bitmap item,int index,int screenX){
        this.x=right-screenX/16;
        this.y=top+item.getHeight()/2;
        this.item=item;
        left=x-screenX/16;
        this.right=left+item.getWidth();
        this.top=y-item.getHeight()/2;
        bottom=y+item.getHeight()/2;
        itemSpeed=350;
        type=index;
        rect = new RectF(left,this.top,this.right,bottom);
    }
    public void update(long fps){
        y+=itemSpeed/fps;
        top = y;
        bottom = y+item.getHeight();
        rect.top=top;
        rect.bottom=bottom;
    }
    public RectF getRect(){
        return rect;
    }
    public void changeState(boolean state){
        fall=state;
    }
    public boolean getState(){
        return fall;
    }
}
