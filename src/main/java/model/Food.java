package model;

/**
 * @Author: kong
 * @Descripton:
 * @Date: created in 15:39 2018/3/11/011
 */
public class Food {

    private  String foodName;
    private  String foodWork;
    private  String foodPopularity;
    private  String foodIcon;
    private  String foodMethod;

    public String getFoodMethod() {
        return foodMethod;
    }

    public void setFoodMethod(String foodMethod) {
        this.foodMethod = foodMethod;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodWork() {
        return foodWork;
    }

    public void setFoodWork(String foodWork) {
        this.foodWork = foodWork;
    }

    public String getFoodPopularity() {
        return foodPopularity;
    }

    public void setFoodPopularity(String foodPopularity) {
        this.foodPopularity = foodPopularity;
    }

    public String getFoodIcon() {
        return foodIcon;
    }

    public void setFoodIcon(String foodIcon) {
        this.foodIcon = foodIcon;
    }
}
