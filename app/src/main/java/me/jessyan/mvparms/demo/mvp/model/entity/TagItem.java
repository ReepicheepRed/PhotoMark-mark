package me.jessyan.mvparms.demo.mvp.model.entity;



import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class TagItem implements Serializable {
    private static final long serialVersionUID = 2685507991821634905L;
    private long              id;
    private int               type;
    private String            name;
    private double            x                = -1;
    private double            y                = -1;

    private int recordCount;
    private boolean           left             = true;
    private Drawable labelBg;
    
    public boolean isLeft() {
        return left;
    }
    public void setLeft(boolean left) {
        this.left = left;
    }
    public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public TagItem() {

    }

    public TagItem(int type, String label) {
        this.type = type;
        this.name = label;
    }

    public TagItem(int type, String name ,Drawable labelBg) {
        this(type,name);
        this.labelBg = labelBg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Drawable getLabelBg() {
        return labelBg;
    }

    public void setLabelBg(Drawable labelBg) {
        this.labelBg = labelBg;
    }
}
