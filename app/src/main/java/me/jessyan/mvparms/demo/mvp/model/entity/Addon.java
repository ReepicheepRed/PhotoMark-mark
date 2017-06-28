package me.jessyan.mvparms.demo.mvp.model.entity;


import java.io.Serializable;

/**
 * 本地简单使用,实际项目中与贴纸相关的属性可以添加到此类中
 */
public class Addon implements Serializable{
    private int    id;
    private String content;
    private String path;


    //JSON用到
    public Addon() {}

    public Addon(int id) {
        this.id = id;
    }

    public Addon(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
