package SpaceMarine;

import java.time.LocalDate;

public class SpaceMarine {
    private int id; //+Значение этого поля должно генерироваться автоматически, Значение этого поля должно быть уникальным, Значение поля должно быть больше 0
    private String name; //+Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //+Поле не может быть null
    private java.time.LocalDate creationDate; //+Значение этого поля должно генерироваться автоматически, Поле не может быть null
    private long health; //+Значение поля должно быть больше 0
    private String achievements; //+Поле не может быть null
    private int height;//+
    private AstartesCategory category; //+Поле может быть null
    private Chapter chapter; //+Поле не может быть null

    public SpaceMarine(int id, String nameMarine, float x, double y, long health,int height,String achievements,String name,String world, String category){
       this.id = id;

       this.achievements = achievements;

       this.name = nameMarine;

       coordinates = new Coordinates(x,y);

       this.health = health;

       this.height = height;

       chapter = new Chapter(name, world);

       this.category = AstartesCategory.valueOf(category.toUpperCase());

       creationDate = LocalDate.now();

    }

    public String getAllInfo(){
        return "id: " + this.id + "\nname: " + this.name + "\ncoord x: " + coordinates.getX() + "\ncord y: " + coordinates.getY() + "\nhealth: " + this.health + "\nheight: " + this.height + "\nкатегория: " + this.category.toString() +
                "\nПоследняя ачивка: " + this.achievements +"\nназвание главы: " + chapter.getName() + "\nназвание мира: " + chapter.getWorld() + "\nсоздан: " + creationDate;
    }

    public String getName(){
        return name;
    }

    public int getHeight(){
        return height;
    }

    public int getId(){
        return id;
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public long getHealth(){
        return health;
    }

    public AstartesCategory getCategory(){
        return category;
    }

    public String getAchievements(){
        return achievements;
    }

    public LocalDate getCreationDate(){
        return creationDate;
    }

    public void setCreationDate(String date){
        creationDate = LocalDate.parse(date);
    }

    public Chapter getChapter(){
        return chapter;
    }

    public void setHealth(long el){
        this.health = el;
    }

    public void setHeight(int el){
        this.height = el;
    }


}
