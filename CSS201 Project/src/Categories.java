import java.util.ArrayList;
import java.util.List;

public class Categories {
    private String cateName;
    private String description;
    private int totalNumber;
    private List<Crafts> crafts;

    public Categories (String cateName, String description){
        this.cateName = cateName;
        this.description = description;
        this.totalNumber = totalNumber;
        crafts = new ArrayList<>();
    }

    public String getName(){
        return cateName;
    }

    public void setName(String cateName){
        this.cateName = cateName;
    }

    public String getDescription(){
        return description;
    }

    public void setDecription(String description) {
        this.description = description;
    }

    public int calTotalNumber(){
        Crafts craft = new Crafts(cateName, totalNumber, totalNumber, cateName, description);
        totalNumber = crafts.size();
        if (crafts.add(craft)){
            totalNumber ++;
        }else if (crafts.remove(craft)){
            totalNumber --;
        }

        return crafts.size();
    }
    
    public List<Crafts> getCrafts(){
        return crafts;
    }

}