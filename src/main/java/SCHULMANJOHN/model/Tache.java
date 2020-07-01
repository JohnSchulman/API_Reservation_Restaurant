package SCHULMANJOHN.model;

public class Tache {

    private long id;
    private String name;
    private String description;
    private boolean validated;

    public Tache(long id, String name, String description, boolean validated) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.validated = validated;
    }

    public Tache() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
