package com.kunminx.basicfacttesting.test_jetpack;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

/**
 * Create by KunMinX at 19/9/5
 */
public class TestData extends BaseObservable {
    private String name;
    private int age;
    private boolean visible;
    private String msg;

    public TestData(String name, int age, boolean visible) {
        this.name = name;
        this.age = age;
        this.visible = visible;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(com.kunminx.basicfacttesting.BR.name);
    }

    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(com.kunminx.basicfacttesting.BR.age);
    }

    @Bindable
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
        notifyPropertyChanged(com.kunminx.basicfacttesting.BR.visible);
    }

    @Bindable
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyPropertyChanged(com.kunminx.basicfacttesting.BR.msg);
    }

}
