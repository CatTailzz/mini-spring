package com.cattail.springframework.test.bean;

/**
 * @description:
 * @author：CatTail
 * @date: 2024/2/28
 * @Copyright: https://github.com/CatTailzz
 */
public class Wife {

    private Husband husband;

    private IMother mother;

    public String queryHusband() {
        return "Wife.husband、Mother.callMother:" + mother.callMother();
    }

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }

    public IMother getMother() {
        return mother;
    }

    public void setMother(IMother mother) {
        this.mother = mother;
    }
}
