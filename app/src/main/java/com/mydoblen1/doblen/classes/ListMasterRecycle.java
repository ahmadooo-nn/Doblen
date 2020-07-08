package com.mydoblen1.doblen.classes;

public class ListMasterRecycle {

    private String name;
    private int pic;
    private int star;
    private  String phone;
    private String work;
    private String loc;

    public ListMasterRecycle(String name, int pic, int star, String phone, String work, String loc) {
        this.name = name;
        this.pic = pic;
        this.star = star;
        this.phone = phone;
        this.work = work;
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

}
